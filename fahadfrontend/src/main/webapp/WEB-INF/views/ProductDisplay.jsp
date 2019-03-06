<%@ page language="java" contentType="text/html"%>

<%@include file="Header.jsp" %>
  
<div class="row">
  <c:forEach items = "${productList}" var="product" >

    <div class = "col-sm-4 col-md-3">
      <a href = "<c:url value="/totalProductDisplay/${product.productId}" />" class = "thumbnail">
         <img src="<c:url value="/resources/images/${product.productId}.png" />" alt = "Generic placeholder thumbnail">
      </a>
      
      <p align="center"> ${product.productName} </p>
      <p align="center"> Price : INR ${product.price}/- </p>
      <p align="center"> Stock : ${product.stock} </p>
      
    </div>     
  </c:forEach>
</div>  