<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>ProductOrderDetail : Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #f7f2a6;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>ProductOrderDetail : Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for ProductOrderDetail : Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li>
  	<form method="post" action="/TIA102G2/productOrderDetail/productOrderDetail.do">
  		<p> 輸入商品訂單ID:</p>
  		<input type="text" name="productOrder_id" >
  		<input type="hidden" name="action" value="getByProductOrderId">
  		<input type="submit" value="查詢">
  	</form>  
  </li>
</ul>


<h3>訂單管理</h3>

<ul>
  <li><a href='addProductOrderDetail.jsp'>Add</a> a new productOrderDetail.</li>
</ul>

</body>
</html>