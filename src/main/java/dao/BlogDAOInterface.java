package dao;

import java.sql.SQLException;
import java.util.List;

import model.Blog;

public interface BlogDAOInterface {

	void insertBlog(Blog blog) throws SQLException;
	List<Blog> getAllBlogs();
}
