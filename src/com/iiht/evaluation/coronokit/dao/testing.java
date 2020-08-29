package com.iiht.evaluation.coronokit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;

import com.iiht.evaluation.coronokit.model.KitDetail;
import com.iiht.evaluation.exception.CoronaException;

public class testing {
	
	public static final String ALLITEMS_FETCH_QRY="SELECT * from items";
	
	public static final String GET_ITEM_BY_NAME_QRY = "SELECT item,price,quantity from items WHERE item=?";
	public static final String GET_ALL_ITEMNAMES_QRY = "SELECT item FROM items";

	public static void main(String[] args) throws SQLException, CoronaException{
		// TODO Auto-generated method stub
		
	

		
				
	
		List<String> allitemnames = new ArrayList<String>();
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coronakit", "root", "admin");
				PreparedStatement pst = con.prepareStatement(GET_ALL_ITEMNAMES_QRY);
					){
			
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
			
			String itemname = rs.getString(1);
	        allitemnames.add(itemname);
		
			
			}
			
			if(allitemnames.isEmpty()) {
				allitemnames=null;	
			}
				
			}catch(SQLException exp) {
				exp.printStackTrace();	
			
			}
		System.out.println(allitemnames);
		}


}
