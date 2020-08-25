package com.iiht.evaluation.coronokit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iiht.evaluation.coronokit.model.CoronaKit;
import com.iiht.evaluation.coronokit.model.KitDetail;
import com.iiht.evaluation.exception.CoronaException;

import com.iiht.evaluation.coronokit.dao.ConnectionFactory;



    public class KitDao {
    	
    public static final String INSERT_ITEM_QRY="INSERT INTO items(item,price,quantity) VALUES(?,?,?)";	
    
    public static final String UPD_CONT_QRY = "UPDATE items set price=?,quantity=? WHERE item=?";

	public static final String ITEM_FETCH_QRY="SELECT price from items where item=?";
	
	public static final String ALLITEMS_FETCH_QRY="SELECT item,price,quantity from items";
	
	public static final String DEL_ITEM_QRY="DELETE from items WHERE item=?";
	
	public static final String GET_ALL_ROWS_COUNT= "SELECT item, count(*) FROM items";
	
	public static final String GET_ITEM_BY_NAME_QRY = "SELECT item,price,quantity from items WHERE item=?";
   
	public KitDetail addItemToCart(KitDetail kit) throws CoronaException {
	
	if(kit!=null) {
	try(Connection con = ConnectionFactory.getConnection();
		PreparedStatement pst = con.prepareStatement(ITEM_FETCH_QRY);
			){
		pst.setString(1, kit.getProductName());
		ResultSet rs = pst.executeQuery();
		rs.next();
		int price = rs.getInt("price");
		kit.setPrice(price);
		
	int totalamount = kit.getQuantity() * kit.getPrice();
	
	kit.setTotalamount(totalamount);
		
	}catch(SQLException exp) {
	throw new CoronaException("Unable to add the Item");	
	}
		
	}
	return kit;
		
	}
	
	public KitDetail getItem(String item) throws CoronaException {
		KitDetail kit = new KitDetail();
			try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_ITEM_BY_NAME_QRY);) {
				
				pst.setString(1, item);
				
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()) {
					kit.setProductName(rs.getString(1));
					kit.setPrice(rs.getInt(2));
					kit.setQuantity(rs.getInt(3));
			    }
			    
			} catch (SQLException exp) {
				throw new CoronaException("Saving Item Details failed!");
			}
		

		return kit;
	}
	
	public KitDetail save(KitDetail kit) throws CoronaException {
		if (kit != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_CONT_QRY);) {

				pst.setInt(1, kit.getPrice());
			    pst.setInt(2, kit.getQuantity());
			    pst.setString(3, kit.getProductName());
			

				pst.executeUpdate();
			} catch (SQLException exp) {
				throw new CoronaException("Saving Item Details failed!");
			}
		}

		return kit;
	}
	
	public KitDetail additemstoportal(KitDetail kit) throws CoronaException {
		
		if(kit!=null) {
		try(Connection con = ConnectionFactory.getConnection();
			PreparedStatement pst = con.prepareStatement(INSERT_ITEM_QRY);
				){
		
			
		pst.setString(1, kit.getProductName());	
		pst.setInt(2, kit.getPrice());
		pst.setInt(3, kit.getQuantity());
	    pst.executeUpdate();
			
		}catch(SQLException exp) {
		throw new CoronaException("Unable to add the Product");	
		}
			
		}
		return kit;
		}
	
public boolean deleteitemsfromportal(String itemname) throws CoronaException {
	
	boolean isDeleted = false;
		
	try(Connection con = ConnectionFactory.getConnection();
			PreparedStatement pst = con.prepareStatement(DEL_ITEM_QRY);
			PreparedStatement rows = con.prepareStatement(GET_ALL_ROWS_COUNT);
				){
		
		ResultSet rsbefore = rows.executeQuery();
		rsbefore.next();
		int Totalrowsbeforedelete = rsbefore.getInt("count(*)");
		
		if(Totalrowsbeforedelete>=1) {
		
		pst.setString(1, itemname);	
		pst.executeUpdate();
		}else {
		throw new CoronaException("Item Name is invalid");		
		}
		
		ResultSet rsafter = rows.executeQuery();
		rsafter.next();
		int Totalrowsafterdelete = rsafter.getInt("count(*)");
		
		if((Totalrowsbeforedelete-Totalrowsafterdelete) ==1) {
		isDeleted = true;		
		}	
		}catch(SQLException exp) {
		throw new CoronaException("Deleting Name Failed");	
		}
	return isDeleted;
}
	
	public List<KitDetail> getAllproducts() throws CoronaException {
		
		List<KitDetail> allproducts = new ArrayList<KitDetail>();
		try(Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(ALLITEMS_FETCH_QRY);
					){
			
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
			KitDetail kit = new KitDetail();
			kit.setProductName(rs.getString(1));
			kit.setPrice(rs.getInt(2));
			kit.setQuantity(rs.getInt(3));
			
			allproducts.add(kit);
			System.out.println(kit);
			
			}
			
			if(allproducts.isEmpty()) {
				allproducts=null;	
			}
				
			}catch(SQLException exp) {
				exp.printStackTrace();	
			throw new CoronaException("Fetching All products Failed");	
			}
		return allproducts;
		}

	
	
}