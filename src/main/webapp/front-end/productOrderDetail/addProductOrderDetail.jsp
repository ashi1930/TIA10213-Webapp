<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.productOrderDetail.model.*"%>

<!-- 見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件) -->
<% 
	ProductOrderDetailVO productOrderDetailVO = (ProductOrderDetailVO) request.getAttribute("productOrderDetailVO");
%>
<%-- <%= productOrderDetailVO==null %> --@{productOrderDetailVO.productOrderDetail_id}-- <!-- line 100 --> --%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>訂單資料新增 - addPProductOrderDetail.jsp</title>

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
	width: 650px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>訂單資料新增 - addProductOrderDetail.jsp</h3></td><td>
		 <h4><a href="/TIA102G2/front-end/productOrderDetail/select_productOrderDetailpage.jsp">回首頁</a></h4>
		 
<!-- 目的地	 http://localhost:8081/TIA102G2/front-end/productOrderDetail/select_productOrderDetailpage.jsp -->

<!-- 跳轉前	 http://localhost:8081/TIA102G2/productOrderDetail/productOrderDetail.do -->

	</td></tr>
</table>

<h3>訂單新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="/TIA102G2/productOrderDetail/productOrderDetail.do" name="form1">
<table>

	<tr>
		<td>商品訂單ID:</td>
		<td><input type="TEXT" name="productOrder_id" value="<%= (productOrderDetailVO==null)? "" : productOrderDetailVO.getProductOrder_id()%>" size="45"/></td>
	</tr>
	<tr>
		<td>商品ID:</td>
		<td><input type="TEXT" name="product_id" value="<%= (productOrderDetailVO==null)? "" : productOrderDetailVO.getproduct_id()%>" size="45"/></td>
	</tr>
	
	<tr>
		<td>該商品下訂數:</td>
		<td><input type="TEXT" name="productOrderDetail_amount" value="<%= (productOrderDetailVO==null)? "" : productOrderDetailVO.getProductOrderDetail_amount()%>" size="45"/></td>
	</tr>
	<tr>
		<td>小計:</td>
		<td><input type="TEXT" name="productOrderDetail_price" value="<%= (productOrderDetailVO==null)? "" : productOrderDetailVO.getProductOrderDetail_price()%>" size="45"/></td>
	</tr>


</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>

</body>




        
   
<!--         // ----------------------------------------------------------以下用來排定無法選擇的日期----------------------------------------------------------- -->

<!--         //      1.以下為某一天之前的日期無法選擇 -->
<!--         //      var somedate1 = new Date('2017-06-15'); -->
<!--         //      $('#f_date1').datetimepicker({ -->
<!--         //          beforeShowDay: function(date) { -->
<!--         //        	  if (  date.getYear() <  somedate1.getYear() ||  -->
<!--         //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) ||  -->
<!--         //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate()) -->
<!--         //              ) { -->
<!--         //                   return [false, ""] -->
<!--         //              } -->
<!--         //              return [true, ""]; -->
<!--         //      }}); -->

        
<!--         //      2.以下為某一天之後的日期無法選擇 -->
<!--         //      var somedate2 = new Date('2017-06-15'); -->
<!--         //      $('#f_date1').datetimepicker({ -->
<!--         //          beforeShowDay: function(date) { -->
<!--         //        	  if (  date.getYear() >  somedate2.getYear() ||  -->
<!--         //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) ||  -->
<!--         //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate()) -->
<!--         //              ) { -->
<!--         //                   return [false, ""] -->
<!--         //              } -->
<!--         //              return [true, ""]; -->
<!--         //      }}); -->


<!--         //      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期) -->
<!--         //      var somedate1 = new Date('2017-06-15'); -->
<!--         //      var somedate2 = new Date('2017-06-25'); -->
<!--         //      $('#f_date1').datetimepicker({ -->
<!--         //          beforeShowDay: function(date) { -->
<!--         //        	  if (  date.getYear() <  somedate1.getYear() ||  -->
<!--         //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) ||  -->
<!--         //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate()) -->
<!--         //		             || -->
<!--         //		            date.getYear() >  somedate2.getYear() ||  -->
<!--         //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) ||  -->
<!--         //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate()) -->
<!--         //              ) { -->
<!--         //                   return [false, ""] -->
<!--         //              } -->
<!--         //              return [true, ""]; -->
<!--         //      }}); -->
        
</script>
</html>