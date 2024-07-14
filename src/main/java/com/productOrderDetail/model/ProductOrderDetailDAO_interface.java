package com.productOrderDetail.model;

import java.util.List;

public interface ProductOrderDetailDAO_interface {

	public void add(ProductOrderDetailVO productOrderDetailVO);
//	public void delete(Integer productOrder_id);
	public void update(ProductOrderDetailVO productOrderDetailVO);
//	public ProductOrderDetailVO findByProductOrderDetailId(Integer productOrderDetail_id); //用不到
	public List<ProductOrderDetailVO> findByProductOrderId(Integer productOrder_id); //這才是找該訂單明細
	public List<ProductOrderDetailVO> getAll();
	
}
