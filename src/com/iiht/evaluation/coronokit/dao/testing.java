package com.iiht.evaluation.coronokit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.iiht.evaluation.coronokit.model.KitDetail;
import com.iiht.evaluation.exception.CoronaException;

public class testing {
	
	public static final String ALLITEMS_FETCH_QRY="SELECT * from items";
	
	public static final String GET_ITEM_BY_NAME_QRY = "SELECT item,price,quantity from items WHERE item=?";

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coronakit", "root", "admin");
		
		PreparedStatement pst = con.prepareStatement(GET_ITEM_BY_NAME_QRY);
		KitDetail kit = new KitDetail();
		pst.setString(1, "Sanitizer");
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()) {
			kit.setProductName(rs.getString(1));
			kit.setPrice(rs.getInt(2));
			kit.setQuantity(rs.getInt(3));
	    
		}
		
		String name = kit.getProductName();		
		int price = kit.getPrice();		
		int quantity = kit.getQuantity();	
		System.out.println(name);
		System.out.println(price);
		System.out.println(quantity);
	    
	} catch (SQLException exp) {
		System.out.println(exp);
	}
		

		}


}
