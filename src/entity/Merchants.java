package entity;

public class Merchants {
	private int id;
	private String name;
	private int code;
	private int type;
	private String description;
	private double cur_price;	
	private double in_price;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCur_price() {
		return cur_price;
	}
	public void setCur_price(double cur_price) {
		this.cur_price = cur_price;
	}
	public double getIn_price() {
		return in_price;
	}
	public void setIn_price(double in_price) {
		this.in_price = in_price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Merchants [id=" + id + ", name=" + name + ", code=" + code + ", type=" + type + ", description="
				+ description + ", cur_price=" + cur_price + ", in_price=" + in_price + ", status=" + status
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getCode()=" + getCode() + ", getType()="
				+ getType() + ", getDescription()=" + getDescription() + ", getCur_price()=" + getCur_price()
				+ ", getIn_price()=" + getIn_price() + ", getStatus()=" + getStatus() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
