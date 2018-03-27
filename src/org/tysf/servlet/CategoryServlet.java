package org.tysf.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tysf.domain.Category;
import org.tysf.service.CategoryService;
import org.tysf.service.impl.CategoryServiceImpl;
import org.tysf.servlet.base.BaseServlet;

import com.google.gson.Gson;
@WebServlet("/categoryServlet")
public class CategoryServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void findAll(HttpServletRequest req,HttpServletResponse resp) throws SQLException, IOException{
		CategoryService categoryService=new CategoryServiceImpl();
		List<Category> categoryList= categoryService.findAll();
		/*for(Category c:categoryList){
			System.out.println(c);
		}*/
		Gson gson=new Gson();
		String cateJson=gson.toJson(categoryList);
		//响应到前台
		//resp.setContentType("application/json;charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().print(cateJson);
	
		
	}
}
