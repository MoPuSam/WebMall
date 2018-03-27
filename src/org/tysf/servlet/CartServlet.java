package org.tysf.servlet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tysf.domain.Product;

import org.tysf.service.ProductService;

import org.tysf.service.impl.ProductServiceImpl;
import org.tysf.servlet.base.BaseServlet;
import org.tysf.utils.CookUtils;

@WebServlet("/cartServlet")
public class CartServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  String addToCart(HttpServletRequest req,HttpServletResponse resp) throws SQLException{
		String cart = CookUtils.addCart(req, resp);
		System.out.println("----------");
		System.out.println(cart);
		if (cart != null) {
			List<Product> productList = new ArrayList();
			String pid = null;
			//获取购物车中的每件物品
			String[] s = cart.split("-");
			
			
			for (int i = 0; i < s.length; i++) {
				
				String[] s1 = s[i].split(",");
				/*System.out.println("++++++");
				System.out.println(s1[0]);
				System.out.println(s1[1]);
				System.out.println("++++++");*/
				
				pid = s1[0].substring(1);
				ProductService productService = new ProductServiceImpl();
				Product pro = productService.findByPid(pid);
				productList.add(pro);
			}
			/*System.out.println("------------");
			System.out.println(productList);
			System.out.println("------------");
			req.setAttribute("productList", productList);*/
			req.setAttribute("productList", productList);
			
		}
		
		/*System.out.println("------------------");
		String pid = req.getParameter("pid");
		ProductService productService = new ProductServiceImpl();
		Product pro = productService.findByPid(pid);
		System.out.println(pro);*/
		
		
		return "/jsp/cart.jsp";
	}
	public String deleteByPid(HttpServletRequest req,HttpServletResponse resp) throws SQLException{
		String cart = CookUtils.deleteCartBypid(req, resp);
		List<Product> productList = new ArrayList();
		String pid = null;
		//获取购物车中的每件物品
		String[] s = cart.split("-");
		for(int i=0;i<s.length;i++){
			String[] s1 = s[i].split(",");
			pid = s1[1].substring(1);
			ProductService productService = new ProductServiceImpl();
			Product pro = productService.findByPid(pid);
			productList.add(pro);
		}
		req.setAttribute("productList", productList);
		
		return "/jsp/cart.jsp";
	}
	
	//清空购物车
	public String empty(HttpServletRequest req,HttpServletResponse resp){
		CookUtils.empty(req, resp);
		return "/jsp/cart.jsp";
	}
	
	

}
