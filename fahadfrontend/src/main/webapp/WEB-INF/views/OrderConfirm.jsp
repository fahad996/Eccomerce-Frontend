<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp" %>

<div class="container">
<table class="table table-bordered">

<tr class="danger">

<td colspan="5"><center>your Cart</center></td>

</tr>
<tr>

			<td> Product ID</td>
			<td> Product Name </td>
			<td> Quantity </td>
			<td> Price</td>
			<td> SubTotal</td>
		
</tr>
<c:forEach items="${cartItemList }" var="cartItem">
<tr class="info">

<td>${ cartItem.productId}</td>
<td>${ cartItem.productName}</td>
<td>${cartItem.quantity}</td>
<td>${ cartItem.price}</td>
<td>${cartItem.price * cartItem.quantity}</td>
</td>

</tr>

</c:forEach>
<tr class="warning">
<td colspan="4">Totel Purchese Amount</td>
<td colspan="1">${grandTotal}</td>
</tr>

<tr class ="warning">
<td colspan="5">Shipping Address </td>

</tr>
<form action="<c:url value="/updateAddress"/>"method="post">

<tr class="info>

<td>
Address
</td>
<td colspan="3">
<textarea name="addr"cols="100" rows="3">${addr}</textarea>
</td>
<td>
<input typr="submit"value="Update Address" class="btn btn-success"/>
</tr> 
</td>
</form>
<tr> class ="warning">
<td colspan="5">Shipping Address </td>
<td></td>
</tr>

<tr class="info"> 
<td colspan="2">
<center><a href="<c:url value='/productDisplay'/>" class="btn btn-success">Modify Cart</a></center>
</td>  
<td colspan="3">
<center><a href="<c:url value="/checkout"/>"class="btn btn-success">OrderConfirm</a></center>
</td>
</tr>


</table>
</div>