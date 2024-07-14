<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.productOrderDetail.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
// ProductOrderDetailService productOrderDetailService = new ProductOrderDetailService();
// List<ProductOrderDetailVO> list = productOrderDetailService.getByProductOrderId(); // 此行的list變數(物件)將提供page1.file的第11行取得查詢到的總筆數，再由page1.file進行分頁的需要
// pageContext.setAttribute("list", list); // 將上一行的list變數(物件)存入當前頁面pageContext，再由底下的第73行由JSTL的forEach列印出結果

	List<ProductOrderDetailVO> list = (List<ProductOrderDetailVO>) session.getAttribute("productOrderDetailList");
%>


<html>
<head>
<title>該筆訂單明細資料 - getProductOrderDetailByProductOrderID_byDAO.jsp</title>

<style>
table#table-1 {
	background-color: #f7f2a6;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 20px;
	text-align: center;
}
</style>

</head>
<body bgcolor='white'>

	<h4>此頁練習採用 EL 的寫法取值:</h4>
	<table id="table-1">
		<tr><td>
			<h3>所有訂單資料</h3> 
		 <h4><a href="/TIA102G2/front-end/productOrderDetail/select_productOrderDetailpage.jsp">回首頁</a></h4>
		</td></tr>
	</table>

	<table>
		<tr>
			<th>預訂商品資料ID(確認用)</th>
			<th>商品訂單ID</th>
			<th>商品ID</th>
			<th>該商品下訂數</th>
			<th>小計</th>
		</tr>
		<%@ include file="page1.file"%>
		<c:forEach var="productOrderDetailVO" items="${productOrderDetailList}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">
			<tr>
				<td>${productOrderDetailVO.productOrderDetail_id}</td>
				<td>${productOrderDetailVO.productOrder_id}</td>
				<td>${productOrderDetailVO.product_id}</td>
				<td>${productOrderDetailVO.productOrderDetail_amount}</td>
				<td>${productOrderDetailVO.productOrderDetail_price}</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>