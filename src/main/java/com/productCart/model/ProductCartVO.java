package com.productCart.model;

import java.io.Serializable;

public class ProductCartVO implements Serializable{

	private Integer productCart_id;
	private Integer user_id;
	private Integer product_pid;
	private Integer productCart_amount;
	public ProductCartVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductCartVO(Integer productCart_id, Integer user_id, Integer product_pid, Integer productCart_amount) {
		super();
		this.productCart_id = productCart_id;
		this.user_id = user_id;
		this.product_pid = product_pid;
		this.productCart_amount = productCart_amount;
	}
	public Integer getProductCart_id() {
		return productCart_id;
	}
	public void setProductCart_id(Integer productCart_id) {
		this.productCart_id = productCart_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getProduct_pid() {
		return product_pid;
	}
	public void setProduct_pid(Integer product_pid) {
		this.product_pid = product_pid;
	}
	public Integer getProductCart_amount() {
		return productCart_amount;
	}
	public void setProductCart_amount(Integer productCart_amount) {
		this.productCart_amount = productCart_amount;
	}
	
	

	
	
	
}
