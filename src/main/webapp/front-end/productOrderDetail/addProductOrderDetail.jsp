<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.productOrderDetail.model.*"%>

<!-- ��com.emp.controller.EmpServlet.java��238��s�Jreq��empVO���� (������J�榡�����~�ɪ�empVO����) -->
<% 
	ProductOrderDetailVO productOrderDetailVO = (ProductOrderDetailVO) request.getAttribute("productOrderDetailVO");
%>
<%-- <%= productOrderDetailVO==null %> --@{productOrderDetailVO.productOrderDetail_id}-- <!-- line 100 --> --%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>�q���Ʒs�W - addPProductOrderDetail.jsp</title>

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
		 <h3>�q���Ʒs�W - addProductOrderDetail.jsp</h3></td><td>
		 <h4><a href="/TIA102G2/front-end/productOrderDetail/select_productOrderDetailpage.jsp">�^����</a></h4>
		 
<!-- �ت��a	 http://localhost:8081/TIA102G2/front-end/productOrderDetail/select_productOrderDetailpage.jsp -->

<!-- ����e	 http://localhost:8081/TIA102G2/productOrderDetail/productOrderDetail.do -->

	</td></tr>
</table>

<h3>�q��s�W:</h3>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="/TIA102G2/productOrderDetail/productOrderDetail.do" name="form1">
<table>

	<tr>
		<td>�ӫ~�q��ID:</td>
		<td><input type="TEXT" name="productOrder_id" value="<%= (productOrderDetailVO==null)? "" : productOrderDetailVO.getProductOrder_id()%>" size="45"/></td>
	</tr>
	<tr>
		<td>�ӫ~ID:</td>
		<td><input type="TEXT" name="product_id" value="<%= (productOrderDetailVO==null)? "" : productOrderDetailVO.getproduct_id()%>" size="45"/></td>
	</tr>
	
	<tr>
		<td>�Ӱӫ~�U�q��:</td>
		<td><input type="TEXT" name="productOrderDetail_amount" value="<%= (productOrderDetailVO==null)? "" : productOrderDetailVO.getProductOrderDetail_amount()%>" size="45"/></td>
	</tr>
	<tr>
		<td>�p�p:</td>
		<td><input type="TEXT" name="productOrderDetail_price" value="<%= (productOrderDetailVO==null)? "" : productOrderDetailVO.getProductOrderDetail_price()%>" size="45"/></td>
	</tr>


</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="�e�X�s�W"></FORM>

</body>




        
   
<!--         // ----------------------------------------------------------�H�U�ΨӱƩw�L�k��ܪ����----------------------------------------------------------- -->

<!--         //      1.�H�U���Y�@�Ѥ��e������L�k��� -->
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

        
<!--         //      2.�H�U���Y�@�Ѥ��᪺����L�k��� -->
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


<!--         //      3.�H�U����Ӥ�����~������L�k��� (�]�i���ݭn������L���) -->
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