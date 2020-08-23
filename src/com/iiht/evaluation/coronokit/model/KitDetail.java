package com.iiht.evaluation.coronokit.model;

public class KitDetail {


	private String productName;
	private int quantity;
	

	private int price;
	private int totalamount;
	
	public KitDetail() {
		// TODO Auto-generated constructor stub
	}

	public KitDetail(String productName, int quantity, int price, int totalamount) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.totalamount = totalamount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}

	@Override
	public String toString() {
		return "KitDetail [productName=" + productName + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
