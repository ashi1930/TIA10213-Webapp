package com.productOrderDetail.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.productOrderDetail.model.*;

public class ProductOrderDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

////////////////////////////get by product order id (fk)   >>>  List ////////////////////////////

		if ("getByProductOrderId".equals(action)) {

			HttpSession session = req.getSession();
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/

			String str = req.getParameter("productOrder_id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入訂單編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/productOrderDetail/select_productOrderDetailpage.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer productOrder_id = null;
			try {
				productOrder_id = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("訂單編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/productOrderDetail/select_productOrderDetailpage.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/

			ProductOrderDetailService productOrderDetailSvc = new ProductOrderDetailService();
			List<ProductOrderDetailVO> productOrderDetailList = productOrderDetailSvc
					.getByProductOrderId(productOrder_id); //

			if (productOrderDetailList == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/productOrderDetail/select_productOrderDetailpage.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			session.setAttribute("productOrderDetailList", productOrderDetailList); // 存結果到req裡面，準備轉交給下個程式

			String url = "/front-end/productOrderDetail/getProductOrderDetailByProductOrderID_byDAO.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 把URL設定到req裡面， 成功轉交 listOneEmp.jsp
			successView.forward(req, res);

		}

//////////////////////////// add(所有屬性without PK  ) ////////////////////////////

		if ("insert".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

//			Integer productOrder_id= null;
//			try {
//				productOrder_id = Integer.valueOf(req.getParameter("productOrder_id").trim());
//			}catch(NumberFormatException e) {
//				productOrder_id=0;
//			errorMsgs.add("商品訂單ID輸入錯誤");	
//			}

			String productOrder_id = req.getParameter("productOrder_id").trim();
			

			String productOrder_idReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]$";
			if (productOrder_id == null || productOrder_id.trim().length() == 0) {
				errorMsgs.add("商品訂單: 請勿空白??????????????");
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/productOrderDetail/addProductOrderDetail.jsp");
					failureView.forward(req, res);
					return;
				}
			} else if (!productOrder_id.trim().matches(productOrder_idReg)) {
				errorMsgs.add("商品訂單: 只能是中、英文字母、數字");
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/productOrderDetail/addProductOrderDetail.jsp");
					failureView.forward(req, res);
					return;
				}
			} else {
				Integer productOrderId = null;
				try {
					productOrderId = Integer.valueOf(productOrder_id);
				} catch (NumberFormatException e) {
					errorMsgs.add("商品訂單: 提供的產品編號格式不正確");
				}

				Integer product_id = null;
				try {
					product_id = Integer.valueOf(req.getParameter("product_id").trim());
				} catch (NumberFormatException e) {
					product_id = 0;
					errorMsgs.add("商品ID輸入錯誤");
				}
				//
				Integer productOrderDetail_amount = null;
				try {
					productOrderDetail_amount = Integer.valueOf(req.getParameter("productOrderDetail_amount").trim());
				} catch (NumberFormatException e) {
					productOrderDetail_amount = 0;
					errorMsgs.add("商品下訂數輸入錯誤");
				}
				//
				Integer productOrderDetail_price = null;
				try {
					productOrderDetail_price = Integer.valueOf(req.getParameter("productOrderDetail_price").trim());
				} catch (NumberFormatException e) {
					productOrderDetail_price = 0;
					errorMsgs.add("訂單小計輸入錯誤");
				}

				//// 從這開始
				System.out.println(productOrderId);
				System.out.println(product_id);
				System.out.println(productOrderDetail_amount);
				System.out.println(productOrderDetail_price);
				
				ProductOrderDetailVO productOrderDetailVO = new ProductOrderDetailVO();
				productOrderDetailVO.setProductOrder_id(productOrderId);
				productOrderDetailVO.setproduct_id(product_id);
				productOrderDetailVO.setProductOrderDetail_amount(productOrderDetail_amount);
				productOrderDetailVO.setProductOrderDetail_price(productOrderDetail_price);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("productOrderDetailVO", productOrderDetailVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/productOrderDetail/addProductOrderDetail.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.開始新增資料 ***************************************/
				ProductOrderDetailService productOrderDetailSvc = new ProductOrderDetailService();
				productOrderDetailSvc.addProductOrderDetai(productOrderId, product_id,
						productOrderDetail_amount, productOrderDetail_price);

				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
				String url = "/productOrderDetail/productOrderDetail.do?productOrder_id=" + productOrderId
						+ "&action=getByProductOrderId";
//				String url = "productOrderDetail.do?action=getByProductOrderId&productOrder_id=" + product_id;
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

			}

//////////////////////////// update(所有屬性 (含pk))  ////////////////////////////

		}
	}
}
