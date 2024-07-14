package com.productOrderDetail.model;

import java.util.List;

public class ProductOrderDetailService {

	private ProductOrderDetailDAO_interface dao;
	
	public ProductOrderDetailService() {
		dao = new productOrderDetailDAO();
	}
	
///////////////////	新增：auto_increment所以不用pk
	public ProductOrderDetailVO addProductOrderDetai(Integer productOrder_id, Integer product_id, Integer productOrderDetail_amount, Integer productOrderDetail_price) {
	
	ProductOrderDetailVO productOrderDetailVO = new ProductOrderDetailVO();
	
	productOrderDetailVO.setProductOrder_id(productOrder_id);
	productOrderDetailVO.setproduct_id(product_id);
	productOrderDetailVO.setProductOrderDetail_amount(productOrderDetail_amount);
	productOrderDetailVO.setProductOrderDetail_price(productOrderDetail_price);
	dao.add(productOrderDetailVO);
		
	return productOrderDetailVO;
	}
	
///////////////////	Update：要放pk
	public ProductOrderDetailVO updateProductOrderDetai(Integer productOrderDetail_id, Integer productOrder_id, Integer product_id, Integer productOrderDetail_amount, Integer productOrderDetail_price) {
		
		ProductOrderDetailVO productOrderDetailVO = new ProductOrderDetailVO();
		
		productOrderDetailVO.setProductOrderDetail_id(productOrderDetail_id);
		productOrderDetailVO.setProductOrder_id(productOrder_id);
		productOrderDetailVO.setproduct_id(product_id);
		productOrderDetailVO.setProductOrderDetail_amount(productOrderDetail_amount);
		productOrderDetailVO.setProductOrderDetail_price(productOrderDetail_price);
		dao.update(productOrderDetailVO);	
		
		return productOrderDetailVO;
		}
	
///////////////////	findByProductOrderId	
	public List<ProductOrderDetailVO> getByProductOrderId(Integer productOrder_id) {
		return dao.findByProductOrderId(productOrder_id);	
	}
	
///////////////////	getAll	
	public List<ProductOrderDetailVO> getAll() {
		return dao.getAll();
	}		
}
