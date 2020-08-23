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

	public static void main(String[] args) throws CoronaException, SQLException{
		// TODO Auto-generated method stub

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coronakit", "root", "admin");
		
		PreparedStatement pst = con.prepareStatement(ALLITEMS_FETCH_QRY);
		
		List<KitDetail> allproducts = new ArrayList<KitDetail>();
		
		
			
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
			KitDetail kit = new KitDetail();
			kit.setProductName(rs.getString(1));
			kit.setPrice(rs.getInt(2));
			kit.setQuantity(rs.getInt(3));
			
			allproducts.add(kit);
		
			
			}
			System.out.println(allproducts);
			if(allproducts.isEmpty()) {
				allproducts=null;	
			}
		

		}


}
