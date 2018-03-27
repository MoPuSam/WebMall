package org.tysf.admin.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tysf.admin.service.AdminDaoService;
import org.tysf.admin.service.Impl.AdminDaoServiceImpl;

public class AdminDaoServelt {
	public String Login(HttpServletRequest req,HttpServletResponse resp){
		AdminDaoService service=new AdminDaoServiceImpl();
		//封装数据
		//Admin form = .toBean(req.getParameterMap(), Admin.class);
		/*Admin admin = AdminDaoServiceImpl.login(form);
		if(admin == null) {
			req.setAttribute("msg", "用户名或密码错误！");
			return "/admin/index.jsp";
		}
		req.getSession().setAttribute("admin", admin);*/
		return "/admin/home.jsp";
		
	}
}
