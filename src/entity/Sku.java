package entity;

public class Sku {
	private int id;
	private int type;
	private int quantity;
	private String supplier_name;
	private String merchant_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	@Override
	public String toString() {
		return "Sku [id=" + id + ", type=" + type + ", quantity=" + quantity + ", supplier_name=" + supplier_name
				+ ", merchant_name=" + merchant_name + ", getId()=" + getId() + ", getType()=" + getType()
				+ ", getQuantity()=" + getQuantity() + ", getSupplier_name()=" + getSupplier_name()
				+ ", getMerchant_name()=" + getMerchant_name() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
