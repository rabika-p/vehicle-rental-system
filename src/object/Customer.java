package object;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable{
	private int id;
	private String name, address, phone, email, username, password;

	//constructor for customer class
	public Customer(int id, String name, String address, String phone, String email, String username, String password) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
//		this.hireWishList = new ArrayList<Vehicle>();
	}
	
	//accessors for attributes
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	//mutators for attributes
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String toString() {
	String details = "id: " + id + " name: " + name + " address: " + address + " phone: " + phone + " email: "+ email + " username: " + username + " password: " + password;
	return details;
	}

		

}
