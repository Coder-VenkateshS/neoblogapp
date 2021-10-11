package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogDAO;
import model.Blog;

@WebServlet("/new")
public class AddNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddNewServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String blogTitle =  request.getParameter("blogTitle");
		String blogDescription =  request.getParameter("blogDescription");
		LocalDate postedOn = LocalDate.now();
		System.out.println(blogTitle);
		System.out.println(blogDescription);
		System.out.println(postedOn);
		
		Blog blog= new Blog();
		blog.setBlogTitle(blogTitle);
		blog.setBlogDescription(blogDescription);
		blog.setPostedOn(postedOn);
		
		BlogDAO blogdao= new BlogDAO();
		try {
			blogdao.insertBlog(blog);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		
	}

}
