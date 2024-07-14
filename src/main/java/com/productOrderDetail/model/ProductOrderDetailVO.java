package com.productOrderDetail.model;

import java.io.Serializable;

public class ProductOrderDetailVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer productOrderDetail_id;
	private Integer productOrder_id;
	private Integer product_id;
	private Integer productOrderDetail_amount;
	private Integer productOrderDetail_price;
	public ProductOrderDetailVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductOrderDetailVO(Integer productOrderDetail_id, Integer productOrder_id, Integer product_id,
			Integer productOrderDetail_amount, Integer productOrderDetail_price) {
		super();
		this.productOrderDetail_id = productOrderDetail_id;
		this.productOrder_id = productOrder_id;
		this.product_id = product_id;
		this.productOrderDetail_amount = productOrderDetail_amount;
		this.productOrderDetail_price = productOrderDetail_price;
	}
	public Integer getProductOrderDetail_id() {
		return productOrderDetail_id;
	}
	public void setProductOrderDetail_id(Integer productOrderDetail_id) {
		this.productOrderDetail_id = productOrderDetail_id;
	}
	public Integer getProductOrder_id() {
		return productOrder_id;
	}
	public void setProductOrder_id(Integer productOrder_id) {
		this.productOrder_id = productOrder_id;
	}
	public Integer getproduct_id() {
		return product_id;
	}
	public void setproduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getProductOrderDetail_amount() {
		return productOrderDetail_amount;
	}
	public void setProductOrderDetail_amount(Integer productOrderDetail_amount) {
		this.productOrderDetail_amount = productOrderDetail_amount;
	}
	public Integer getProductOrderDetail_price() {
		return productOrderDetail_price;
	}
	public void setProductOrderDetail_price(Integer productOrderDetail_price) {
		this.productOrderDetail_price = productOrderDetail_price;
	}

	@Override
	public String toString() {
		return "ProductOrderDetailVO [productOrderDetail_id=" + productOrderDetail_id + ", productOrder_id="
				+ productOrder_id + ", product_id=" + product_id + ", productOrderDetail_amount="
				+ productOrderDetail_amount + ", productOrderDetail_price=" + productOrderDetail_price + "]";
	}

	
	
	
}
