package com.iiht.evaluation.coronokit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iiht.evaluation.coronokit.dao.KitDao;
import com.iiht.evaluation.coronokit.dao.ProductMasterDao;
import com.iiht.evaluation.coronokit.model.CoronaKit;
import com.iiht.evaluation.coronokit.model.KitDetail;
import com.iiht.evaluation.exception.CoronaException;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;





@WebServlet({"/newuser","/report","/showproductstoadd","/listproducts","/addnewitems","/deleteitem","/edititem","/saveitem","/ordersummary","/saveorder","/checkout"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KitDao kitDAO;
	private ProductMasterDao productMasterDao;
	
	
	@Override
	public void init() throws ServletException {

		kitDAO= new KitDao();
			
	}

	public void setKitDAO(KitDao kitDAO) {
		this.kitDAO = kitDAO;
	}

	public void setProductMasterDao(ProductMasterDao productMasterDao) {
		this.productMasterDao = productMasterDao;
	}

	/*
	 * public void init(ServletConfig config) { String jdbcURL =
	 * config.getServletContext().getInitParameter("jdbcUrl"); String jdbcUsername =
	 * config.getServletContext().getInitParameter("jdbcUsername"); String
	 * jdbcPassword = config. getServletContext().getInitParameter("jdbcPassword");
	 * 
	 * this.kitDAO = new KitDao(jdbcURL, jdbcUsername, jdbcPassword);
	 * this.productMasterDao = new ProductMasterDao(jdbcURL, jdbcUsername,
	 * jdbcPassword); }
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			
		String action = request.getServletPath();
		System.out.println(action);
		
		
		String viewName = "";
		try {
			switch (action) {
			case "/newuser":
				viewName = showNewUserForm(request, response);
				break;
			case "/addnewitems":
				viewName = addNewItemsToPortal(request, response);
				break;
			case "/edititem":
				viewName = editItemsInPortal(request, response);
				break;
			case "/saveitem":
				viewName = saveItemsInPortal(request, response);
				break;	
			case "/listproducts":
				viewName = listproducts(request, response);
				break;	
			case "/deleteitem":
				viewName = deleteItemFromPortal(request, response);
				break;
			case "/showproductstoadd":
				viewName = addNewItemToKit(request, response);
				break;
			case "/ordersummary":
				viewName = ordersummary(request, response);
				break;	
			case "/saveorder":
				viewName = saveorder(request, response);
				break;
		    
			case "/checkout":
				viewName = showreport(request, response);
				break;	
			default : viewName = "notfound.jsp"; break;	
			}
		} catch (Exception ex) {
			
			throw new ServletException(ex.getMessage());			
		}
			RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
			dispatch.forward(request, response);
	
	}

	
	

	private String addNewItemToKit(HttpServletRequest request, HttpServletResponse response) throws CoronaException {
		
		HttpSession session = request.getSession();	
		
		//kitDAO.deleteitemsfromDB();
		
		String view="";
		
		KitDetail kitdetail = null;
		List<KitDetail> kits = new ArrayList<>();
		/*
		 * List<String> itemnames = null; try { itemnames = kitDAO.getAllitemnames(); }
		 * catch (CoronaException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } request.setAttribute("items", itemnames);
		 */
	   //List<String> itemsselected  = (List<String>)request.getParameterValues("names");
		String[] item1=request.getParameterValues("names");
		List<String> itemsselected = Arrays.asList(item1);
	    System.out.println(itemsselected);
	    
	    for(String eachitem:itemsselected) {
	    kitdetail = new KitDetail();		
	    if(eachitem.equals("FaceMask")) {	
	    int quan = Integer.parseInt(request.getParameter("Quantity1"));
	    kitdetail.setQuantity(Integer.parseInt(request.getParameter("Quantity1")));
	
	    }
	    if(eachitem.equals("Sanitizer")) {	
		int quan = Integer.parseInt(request.getParameter("Quantity2"));
		kitdetail.setQuantity(Integer.parseInt(request.getParameter("Quantity2")));
		}
	    if(eachitem.equals("Medicines")) {	
		int quan = Integer.parseInt(request.getParameter("Quantity3"));
		kitdetail.setQuantity(Integer.parseInt(request.getParameter("Quantity3")));
		}
		
		kitdetail.setProductName(eachitem);
		System.out.println(kitdetail.getProductName());
		try {
			kitDAO.addItemToCart(kitdetail);
		if(eachitem.equals("FaceMask")) {
			session.setAttribute("price1", kitdetail.getTotalamount());	
		}
		if (eachitem.equals("Sanitizer")) {
			session.setAttribute("price2", kitdetail.getTotalamount());	
		}
		if (eachitem.equals("Medicines")) {
			session.setAttribute("price3", kitdetail.getTotalamount());	
		}
		} catch (CoronaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			kitDAO.saveitemstodb(kitdetail);
		} catch (CoronaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	   }
	    System.out.println(kits);
	    //session.setAttribute("kits", kits);
	    //session.setAttribute("price", kitdetail.getTotalamount());
		
		view = "showproductstoadd.jsp"; 
		

		
		
		return view;
	} 
	
	private String saveorder(HttpServletRequest request, HttpServletResponse response) {
	    
        HttpSession session = request.getSession();	
		
		String view="";
		
		List<KitDetail> kits = new ArrayList<>();
		String[] item1=request.getParameterValues("names");
		System.out.println(item1);
		List<String> itemsselected = Arrays.asList(item1);
	    System.out.println(itemsselected);
	    for(String eachitem:itemsselected) {
	    KitDetail kitdetail = new KitDetail();	
	    if(eachitem.equals("FaceMask")) {	
	    int quan = Integer.parseInt(request.getParameter("Quantity1"));
	    kitdetail.setQuantity(Integer.parseInt(request.getParameter("Quantity1")));
	    }
	    if(eachitem.equals("Sanitizer")) {	
		int quan = Integer.parseInt(request.getParameter("Quantity2"));
		kitdetail.setQuantity(Integer.parseInt(request.getParameter("Quantity2")));
		}
	    if(eachitem.equals("Medicines")) {	
		int quan = Integer.parseInt(request.getParameter("Quantity3"));
		kitdetail.setQuantity(Integer.parseInt(request.getParameter("Quantity3")));
		}
		
		kitdetail.setProductName(eachitem);
		
		
		System.out.println(kitdetail.getProductName());
		try {
			kitDAO.addItemToCart(kitdetail);
		if(eachitem.equals("FaceMask")) {
			session.setAttribute("price1", kitdetail.getTotalamount());	
		
		}
		if (eachitem.equals("Sanitizer")) {
			session.setAttribute("price2", kitdetail.getTotalamount());	
		}
		if (eachitem.equals("Medicines")) {
			session.setAttribute("price3", kitdetail.getTotalamount());	
		}
		} catch (CoronaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		kits.add(kitdetail);
		
	   }
	    view="showproductstoadd.jsp";
		return view;
	}

        private String ordersummary(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();	
		
		String view="";
		
		
		List<KitDetail> kits = null;
		try {
			kits = kitDAO.fetchItemsFromDB();
		} catch (CoronaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		request.setAttribute("kits", kits);
		view = "ordersummary.jsp"; 
		
		return view;
	}
	
	private String listproducts(HttpServletRequest request, HttpServletResponse response) {
	    
		
		  String view ="";
		  System.out.println("allproducts"); 
		  try { 
		  List<KitDetail> allproducts = kitDAO.getAllproducts();
		  System.out.println(allproducts); 
		  request.setAttribute("allproducts", allproducts);
		  view = "listproducts.jsp"; 
		  } catch (CoronaException e) {
		  request.setAttribute("errMsg", e.getMessage()); 
		  view="errorpage.jsp"; 
		  }
		  return view;
		  }
		 
	

	private String addNewItemsToPortal(HttpServletRequest request, HttpServletResponse response) {
	
        HttpSession session = request.getSession();	
		
		String view="";
		
		KitDetail kitdetail = new KitDetail();
		kitdetail.setProductName(request.getParameter("itemname"));
		kitdetail.setQuantity(Integer.parseInt(request.getParameter("quantity")));
	    kitdetail.setPrice(Integer.parseInt(request.getParameter("price")));
	    
	    if(kitdetail !=null) {
	    	try {
			kitDAO.additemstoportal(kitdetail);
			view = "addnewitems.jsp";
			} catch (CoronaException e) {
				// TODO Auto-generated catch block
			view = "errorPage.jsp";
			}	
	    }
	    	
	    return view;
	}
	
	private String editItemsInPortal(HttpServletRequest request, HttpServletResponse response) {
		
		String view = "";
		String item = request.getParameter("item");
		System.out.println(item);
		
		try {
			System.out.println("inside");
			KitDetail kit = kitDAO.getItem(item);
			request.setAttribute("kit", kit);
			view = "editproduct.jsp";
		} catch (CoronaException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}


		return view;
	}
	
private String saveItemsInPortal(HttpServletRequest request, HttpServletResponse response) {
		
		String view = "";
		
		KitDetail kit = new KitDetail();
		
		kit.setProductName(request.getParameter("item"));
		kit.setPrice(Integer.parseInt(request.getParameter("price")));
		kit.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		
		try {
			kitDAO.save(kit);
			request.setAttribute("msg", "Item Saved Successfully");
			view = "AdminPortal.jsp";
		} catch (CoronaException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errPage.jsp";
		}
		
		


		return view;
	}

	private String showNewUserForm(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();	
		
		String view ="";
		
		CoronaKit customer = new CoronaKit();
		
		customer.setPersonName(request.getParameter("fullname"));
		String name = customer.getPersonName();
		session.setAttribute("name", name);
		
		customer.setContactNumber(request.getParameter("Mobile"));
		String mobile = customer.getContactNumber();
		session.setAttribute("mobile", mobile);
		
		customer.setDeliveryAddress(request.getParameter("Address"));
		String address = customer.getDeliveryAddress();
		session.setAttribute("address", address);
		
	
		customer.setEmail(request.getParameter("EmailID"));
		String email = customer.getEmail();
		session.setAttribute("email", email);
		
		
		view = "showproductstoadd.jsp"; 
        return view;
	}
	
	private String deleteItemFromPortal(HttpServletRequest request, HttpServletResponse response) {
			
		String itemname = request.getParameter("item");
		String view = "";

		try {
			kitDAO.deleteitemsfromportal(itemname)	;	
			request.setAttribute("msg","Item deleted");
			view = "listproducts.jsp";
		} catch (CoronaException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}

		return view;
	}
	
private String showreport(HttpServletRequest request, HttpServletResponse response) {
	
	    HttpSession session = request.getSession();	
	
		String view ="";
		
		List<KitDetail> kits = null;
		try {
			kits = kitDAO.fetchItemsFromDB();
		} catch (CoronaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		request.setAttribute("kits", kits);
		
	

		String name = (String) session.getAttribute("name");
		String mobile = (String)session.getAttribute("mobile");
		String email = (String)session.getAttribute("email");;
		String address = (String)session.getAttribute("address");
		
	    try {
		int finalpayment = kitDAO.getAlltotalamts();
		request.setAttribute("finalpayment", finalpayment);
		} catch (CoronaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		view = "report.jsp";
		
        return view;
	}
}