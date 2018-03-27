package org.tysf.admin.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.tysf.admin.domain.OrderItem;
import org.tysf.admin.domain.Orders;
import org.tysf.admin.service.AdminOrdersService;
import org.tysf.admin.service.Impl.AdminOrdersServiceImpl;
import org.tysf.servlet.base.BaseServlet;
import org.tysf.utils.JdbcUtils;

import com.google.gson.Gson;
@WebServlet("/adminOrdersServlet")
public class AdminOrdersServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AdminOrdersService adminOrderService=new AdminOrdersServiceImpl();	
	public String findAll(HttpServletRequest req,HttpServletResponse resp) throws SQLException, ServletException, IOException{
		System.out.println("Servlet...........");
		List<Orders> ordersList= adminOrderService.findAll();
		req.setAttribute("orderList",ordersList );
		//将获取的内容转换格式
		Gson gson=new Gson();
		String cateJson=gson.toJson(ordersList);
		//指定格式
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().print(cateJson);
	/*	for(Orders oi:ordersList){
			System.out.println(oi);
		}*/
		return "/admin/order/list.jsp";
	}
	//通过order的ID找到orderitem的信息
	public List<OrderItem> findByOrderID(Orders order) throws SQLException{
		String sql="select * from orderitem oi,orders o where o.oid=oi.oid";
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<>(OrderItem.class),order.getOid());
	}
}
