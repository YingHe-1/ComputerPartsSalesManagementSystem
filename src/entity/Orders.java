package entity;

public class Orders {
	private int id;
	private int client_id;
	private int merchant_code;
	private String client_name;
	private String merchant_name;
	private int quantity;
	private double discount;
	private int status;
	private java.sql.Date create_time;
	
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public int getMerchant_code() {
		return merchant_code;
	}
	public void setMerchant_code(int merchant_code) {
		this.merchant_code = merchant_code;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getMerchant_name() {
		return merchant_name;
	}
	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public java.sql.Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(java.sql.Date create_time) {
		this.create_time = create_time;
	}
	
	
}
