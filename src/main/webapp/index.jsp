<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page import="model.Blog"%>
    <%@page import="java.util.ArrayList"%>
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
	
	
	 
<a href="<%=request.getContextPath()%>/getallblog">Get all blogs</a>

     <%ArrayList<Blog> bloglist = (ArrayList<Blog>)request.getAttribute("bloglist");
        for(Blog blog:bloglist){%>
        <%-- Arranging data in tabular form
        --%>
           <ul>
                <li><%=blog.getBlogId()%></li>
                <li><%=blog.getBlogTitle()%></li>
                <li><%=blog.getBlogDescription()%></li>
            </ul>
            <%}%>
</body>
</html>
