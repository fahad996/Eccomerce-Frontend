<%@ page language="java" contentType="text/html"%>

<%@include file="Header.jsp" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<form action="<c:url value="/AddCategory"/>" method="post">  
<table align="center" class="table">
  
  <tr>
    <td colspan="2"> <h3><center>Category </center></h3> </td>
  </tr>
  
  <tr>
    <td> Category Name </td>
    <td> <input type="text" name="catgName"/></td>
  </tr>
   
  <tr>
    <td> Category Description </td>
    <td> <input type="text" name="catgDesc"/></td>
  </tr>
  
  <tr>
    <td colspan="2"> <center><input type="submit" value="ADD category"/></center> </td>
  </tr>
     
</table>
</form>


<table class="table-bordered">
    <tr>
      <td> Category Id </td>
      <td> Category Name </td>
      <td> Category Description </td>
      <td> Operations </td>
    </tr>
    
   <c:forEach items = "${listCategories}" var="category" >
     <tr>
       <td> <center> ${category.categoryID}  </center> </td>
       <td> <center>  ${category.categoryName} </center> </td>
       <td>  <center> ${category.categoryDesc} </center> </td>
       
       <td> <a href="<c:url value="/editCategory/${category.categoryID}"/>" class="btn btn-success"> EDIT </a> </td>
       <td> <a href="<c:url value="/deleteCategory/${category.categoryID}"/>" class="btn btn-danger"> DELETE </a> </td>
     </tr>
   </c:forEach>
</table>  