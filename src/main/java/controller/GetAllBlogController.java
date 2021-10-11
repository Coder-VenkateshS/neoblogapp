package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogDAO;
import model.Blog;

@WebServlet("/getallblog")
public class GetAllBlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public GetAllBlogController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get all blogs");
		BlogDAO blogdao = new BlogDAO();
		Blog blog= new Blog();
		List<Blog> bloglist = blogdao.getAllBlogs();
		for(Blog bloglists:bloglist) {
			System.out.println(bloglists.getBlogId());
			
		}
		request.setAttribute("bloglist", bloglist);
//		request.setAttribute("id", blog.getBlogId());
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
