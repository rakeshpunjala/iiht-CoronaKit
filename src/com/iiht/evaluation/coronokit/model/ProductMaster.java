package com.iiht.evaluation.coronokit.model;

public class ProductMaster {
	
	private String productName;
	private String cost;
	private String productDescription;
	
	public ProductMaster() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductMaster(String productName, String cost, String productDescription) {
		super();
		
		this.productName = productName;
		this.cost = cost;
		this.productDescription = productDescription;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	}

	


