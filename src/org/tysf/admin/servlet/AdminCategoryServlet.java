package org.tysf.admin.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tysf.admin.service.AdminCategoryService;
import org.tysf.admin.service.Impl.AdminCategoryServiceImpl;
import org.tysf.domain.Category;
import org.tysf.servlet.base.BaseServlet;
import org.tysf.utils.BeanTools;
import org.tysf.utils.UUIDUtils;


@WebServlet("/adminCategoryServlet")
public class AdminCategoryServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	AdminCategoryService adminCategoryService  = new AdminCategoryServiceImpl();
	
	public void  findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
		List<Category> categoryList = adminCategoryService.findAll();
		req.setAttribute("categoryList", categoryList);
		//请求转发，跳转到页面
		req.getRequestDispatcher("/admin/category/list.jsp").forward(req, resp);
		return;	
		
	}
	/*
	 * 跳转到添加页面
	 */
	public void add(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
		req.getRequestDispatcher("/admin/category/add.jsp").forward(req, resp);
		return;
	}
	/*
	 * 添加分类
	 */
	public void addMsg(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
		Category category = BeanTools.populate(Category.class, req.getParameterMap());
		category.setCid(UUIDUtils.getId());
		adminCategoryService.add(category);
		findAll(req, resp);
	}
	/*
	 * 通过编号查找分类
	 */
	public void queryById(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException{
		String cid= req.getParameter("cid");
		Category category = adminCategoryService.queryById(cid);
		req.setAttribute("category", category);
		HttpSession session=req.getSession();
		session.setAttribute("cid", cid);
		req.getRequestDispatcher("/admin/category/edit.jsp").forward(req, resp);
	}
	/*
	 * 修改分类
	 */
	public void update(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
		
		Category category = BeanTools.populate(Category.class, req.getParameterMap());
		String cid = req.getParameter("cid");
		category.setCid(cid);
		adminCategoryService.update(category);
		findAll(req, resp);
		
	}
	/*
	 * 删除分类
	 */
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
		String cid = req.getParameter("cid");
		adminCategoryService.delete(cid);
		findAll(req, resp);
		
	}
	

}
