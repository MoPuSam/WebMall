package org.tysf.servlet;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tysf.domain.Product;
import org.tysf.service.ProductService;
import org.tysf.service.impl.ProductServiceImpl;
import org.tysf.servlet.base.BaseServlet;
@WebServlet("/indexServlet")
public class IndexServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String excute(HttpServletRequest req, HttpServletResponse resp){
		ProductService productService = new ProductServiceImpl();
		List<Product> newList=null;
		List<Product> hotList=null;
		try {
			newList = productService.findNew();
			req.setAttribute("newList",newList);
			hotList = productService.findHot();
			req.setAttribute("hotList",hotList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/jsp/index.jsp";
	}
}
