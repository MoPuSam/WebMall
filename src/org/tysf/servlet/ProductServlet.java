package org.tysf.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tysf.domain.Category;
import org.tysf.domain.Product;
import org.tysf.service.CategoryService;
import org.tysf.service.ProductService;
import org.tysf.service.impl.CategoryServiceImpl;
import org.tysf.service.impl.ProductServiceImpl;
import org.tysf.servlet.base.BaseServlet;
import org.tysf.utils.CookUtils;

import com.google.gson.Gson;

@WebServlet("/productServlet")
public class ProductServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String findAll(HttpServletRequest req, HttpServletResponse resp) throws SQLException{
		HttpSession session = req.getSession();
		int page=Integer.parseInt(req.getParameter("page"));
		String cid=req.getParameter("cid");
		String cname=req.getParameter("cname");
		req.setAttribute("cid", cid);
		ProductService productService = new ProductServiceImpl();
		List<Product> productList = productService.findAll(cid);
		int count=productList.size()/12+1;
		int []pages=new int[count];
		for(int i=0;i<count;i++){
			pages[i]=i+1;
		}
		req.setAttribute("page", page);
		req.setAttribute("pages", pages);
		session.setAttribute("cname", cname);
		List<Product> list = new ArrayList<Product>();
		if(page*12<productList.size()){
			for(int i=(page-1)*12;i<page*12;i++){
				list.add(productList.get(i));
			}
		}else{
			for(int i=(page-1)*12;i<productList.size();i++){
				list.add(productList.get(i));
			}
		}
		req.setAttribute("productList",list);
		
		//历史记录
		String history =CookUtils.queryHistory(req, resp);
		if(history!=null&&"".equals(history)){
		String[] his = history.split("-");
		List hlist = new ArrayList<Product>();
		if (his.length>=6) {
			for (int i = 0; i < 6; i++) {
				String id = his[i];
				hlist.add(productService.findByPid(id));
			}
		}else if(his.length<6){
			for (int i = 0; i < his.length; i++) {
				String id = his[i];
				hlist.add(productService.findByPid(id));
			}
		}
			req.setAttribute("his", hlist);
		}
		return "/jsp/product_list.jsp";
	}
	
	public String findByName(HttpServletRequest req, HttpServletResponse resp) throws SQLException,Exception{
		HttpSession session = req.getSession();
		System.out.println(req.getCharacterEncoding());
		String pname  = req.getParameter("pname");
		pname = new String(pname.getBytes("ISO-8859-1"),"utf-8");
		System.out.println(pname);
		ProductService productService = new ProductServiceImpl();
		Product pro = productService.findByName(pname);
		String cid = pro.getCid();
		CategoryService categoryService=new CategoryServiceImpl();
		Category category = categoryService.findById(cid);
		session .setAttribute("cname", category.getCname());
		req.setAttribute("pname", pname);
		System.out.println(pro);
		req.setAttribute("product", pro);
		return "/jsp/product_info.jsp";
		
	}
	
	public String findByPid(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException{
		HttpSession session = req.getSession();
		String pid = req.getParameter("pid");
		ProductService productService = new ProductServiceImpl();
		Product pro = productService.findByPid(pid);
		req.setAttribute("pname", pro.getPname());
		req.setAttribute("product", pro);
		String cid = pro.getCid();
		CategoryService categoryService=new CategoryServiceImpl();
		Category category = categoryService.findById(cid);
		session .setAttribute("cname", category.getCname());
		
		//历史记录
		String history =CookUtils.addHistory(req, resp);
		if(history!=null){
		String[] his=history.split("-");
		List hlist = (List)req.getAttribute("his");
		if(hlist==null){
			hlist = new ArrayList<Product>();
		}
		if (his.length>=6) {
			for (int i = 0; i < 6; i++) {
				String id = his[i];
				pro = productService.findByPid(id);
				if (pro != null) {
					hlist.add(pro);
				}
			} 
		}else{
			for (int i = 0; i < his.length; i++) {
				String id = his[i];
				pro = productService.findByPid(id);
				if (pro != null) {
					hlist.add(pro);
				}
			} 
		}
		req.setAttribute("his", hlist);
		}
		return "/jsp/product_info.jsp";
	}
	public String findHitory(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		return "/jsp/product_list.jsp";
	}
}
