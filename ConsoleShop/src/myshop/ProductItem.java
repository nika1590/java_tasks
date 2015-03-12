package myshop;

public class ProductItem { 
	
	private int productId;
	private String productName;
	private int unitsInStock;
	private double unitPrice;
	
	public ProductItem(int productId, String productName, int unitsInStock, double unitPrice) {
		this.productId = productId;
		this.productName = productName;
		this.unitsInStock = unitsInStock;
		this.unitPrice = unitPrice;
	}	
	
	public int getProductId(){
		return this.productId;
	}

	public String getProductName(){
		return this.productName;
	}
	
	public int getUnitsInstock(){
		return this.unitsInStock;
	}
	
	public double getUnitPrice(){
		return this.unitPrice;		
	}
	
	public void setProductId(int newProductId){
		this.productId = newProductId;
	}

	public void setProductName(String newProductName){
		this.productName = newProductName;
	}
	
	public void setUnitsInstock(int newUnitsInStock){
		this.unitsInStock = newUnitsInStock;
	}
	
	public void setUnitPrice(double newUnitPrice){
		this.unitPrice = newUnitPrice;		
	}			
}
