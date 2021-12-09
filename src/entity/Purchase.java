package entity;

public class Purchase {
	private int id;
	private String supplier_name;
	private String merchant_name;
	private int supplier_code;
	private int merchant_code;
	private java.sql.Date in_time;
	private int quantity;
	private double in_price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getMerchant_name() {
		return merchant_name;
	}
	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}
	public int getSupplier_code() {
		return supplier_code;
	}
	public void setSupplier_code(int supplier_code) {
		this.supplier_code = supplier_code;
	}
	public int getMerchant_code() {
		return merchant_code;
	}
	public void setMerchant_code(int merchant_code) {
		this.merchant_code = merchant_code;
	}
	public java.sql.Date getIn_time() {
		return in_time;
	}
	public void setIn_time(java.sql.Date in_time) {
		this.in_time = in_time;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getIn_price() {
		return in_price;
	}
	public void setIn_price(double in_price) {
		this.in_price = in_price;
	}

	
	
}
