<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>My Wall of Blogs</title>
  
</head>
<body>
    
   <form action="new" method="post">
		<input id="title" name="blogTitle" placeholder="Title" type="text"/>
		<textarea id="msg" name="blogDescription" placeholder="Description"></textarea>
		<button id="post" type="submit" >POST</button>
	</form>
	
	<!-- Display part -->
	
	<td><c:out value="${id}"></c:out></td> 
	 
	 <a href="<%=request.getContextPath()%>/getallblog">Get all blogs</a>
<c:forEach items="${bloglist}" var="blogs">  
  <tr> 
    <td><c:out value="${blogs.getBlogId()}"></c:out></td> 
    <td><c:out value="${blogs.getBlogTitle()}"></c:out></td> 
  
</c:forEach>
     
</body>
</html>
