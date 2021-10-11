package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDAO implements BlogDAOInterface {
	
	private static final String INSERT_BLOG_SQL = "INSERT INTO blog(blogId, blogTitle, blogDescription, postedOn)values(blog_seq.nextval,?,?,?)";
	private static final String GET_ALL_BLOGS = "SELECT * FROM blog";
	public void insertBlog(Blog blog) throws SQLException {
		System.out.println("Insert blog Invoked");
		try(Connection con=ConnectionManager.getConnection();
				PreparedStatement ps=con.prepareStatement(INSERT_BLOG_SQL)){
			ps.setString(1, blog.getBlogTitle());
			ps.setString(2,blog.getBlogDescription());
			ps.setDate(3, java.sql.Date.valueOf(blog.getPostedOn()));
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public List<Blog> getAllBlogs() {
		Blog blog=null;
		List<Blog> blogList = new ArrayList<Blog>();
		try(Connection con=ConnectionManager.getConnection();
				PreparedStatement ps=con.prepareStatement(GET_ALL_BLOGS);){
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				blog =  new Blog();
				blog.setBlogId(rs.getInt("blogId"));
				blog.setBlogTitle(rs.getString("blogTitle"));
				blog.setBlogDescription(rs.getString("blogDescription"));
				blog.setPostedOn(rs.getDate("postedOn").toLocalDate());
				blogList.add(blog);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return blogList;
	}



}
