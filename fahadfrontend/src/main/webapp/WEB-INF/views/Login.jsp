<%@ page language="java" contentType="text/html"%>

<%@include file="Header.jsp" %>
  
<form action="perform_login" method="post">  
<table border="1" align="center">
<body style="background-color:grey;">
  
  <tr bgcolor="gray">
    <td colspan="2"> <center>Sign in </center> </td>
  </tr>
  
  <tr bgcolor="pink">
    <td> Login Name </td>
    <td> <input type="text" name="username" required/> </td>
  </tr>
   
  <tr bgcolor="pink">
    <td> Password </td>
    <td> <input type="password" name="password" required/></td>
  </tr>
  
  <tr bgcolor="gray">
    <td colspan="2"> <center><input type="submit" value="LOGIN"/></center> </td>
  </tr>
     </body>
</table>
</form>
  