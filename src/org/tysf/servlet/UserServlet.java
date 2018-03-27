package org.tysf.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.tysf.domain.User;
import org.tysf.service.UserService;
import org.tysf.service.impl.UserServiceImpl;
import org.tysf.servlet.base.BaseServlet;
import org.tysf.utils.BeanTools;
import org.tysf.utils.UUIDUtils;
@WebServlet("/userServlet")
public class UserServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String login(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException{
		/*User user = BeanTools.populate(User.class, req.getParameterMap());
		UserService userService = new UserServiceImpl();
		try {
			if(userService.check(user)){
				return "/jsp/login.jsp";	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/jsp/index.jsp";*/
		User user = BeanTools.populate(User.class, req.getParameterMap());
		UserService userService = new UserServiceImpl();
		User loginUser = userService.login(user);
		if(loginUser!=null){
			//是否勾选自动登录
			String autoLogin = req.getParameter("autoLogin");
			if("1".equals(autoLogin)){
				Cookie autoLoginCookie = new Cookie("autoLoginCookie", user.getUsername()+"@"+user.getPassword());
				autoLoginCookie.setPath("/");
				autoLoginCookie.setMaxAge(60*60*24*7);
				resp.addCookie(autoLoginCookie);
			}else{
				//自动的登录
				Cookie autoLoginCookie = new Cookie("autoLoginCookie","");
				autoLoginCookie.setPath("/");
				autoLoginCookie.setMaxAge(0);
				resp.addCookie(autoLoginCookie);
			}
			//记住用户名
			String rememberme = req.getParameter("rememberme");
			if("1".equals(autoLogin)){
				Cookie remembermeCookie = new Cookie("remembermeCookie", user.getUsername()+"@"+user.getPassword());
				remembermeCookie.setPath("/");
				remembermeCookie.setMaxAge(60*60*24*7);
				resp.addCookie(remembermeCookie);
			}
			//session作用域记录登录状态
			req.getSession().setAttribute("loginUser", loginUser);
			
			
			
			
			//重定向到首页
			resp.sendRedirect(req.getContextPath()+"/");
			//避免baseServlect转发
			return null;
		}
		//设置msg信息;
		//通过baseservlet转发到登录界面
		//使用Request域记录错误信息
		req.setAttribute("msg","用户名或密码不匹配或未激活");
		//请求转发到登录页
		return "/jsp/login.jsp";
		
	}
	public String registUI(HttpServletRequest req, HttpServletResponse resp){
		return "/jsp/register.jsp";
	}
	public String loginUI(HttpServletRequest req, HttpServletResponse resp){
		return "/jsp/login.jsp";
	}
	public String regist(HttpServletRequest req, HttpServletResponse resp){
		//TODO get User object , SetUid  SetState 
		User user = BeanTools.populate(User.class, req.getParameterMap());
		user.setUid(UUIDUtils.getId());
		user.setState(1);
		System.out.println(user);
		UserService userService = new UserServiceImpl();
		try {
			userService.save(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("msg", "注册成功,请登录");
		return "/jsp/login.jsp";
	}
	public String logout(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		req.getSession().removeAttribute("loginUser");
		//重定向到登录界面
		resp.sendRedirect(req.getContextPath()+"/userServlet?method=loginUI");
		return null;
	}
	/*
	 * 异步检查用户名是否被使用
	 */
	public void checkUsername(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException{
		String username = req.getParameter("username");
		UserService userService = new UserServiceImpl();
		User existUser = userService.findByusername(username);
		if (username!=null&&!username.equals("")) {
			if (existUser==null) {
				resp.getWriter().print(1);
			}else{
				resp.getWriter().print(2);
			}
		}else{
			resp.getWriter().print(3);
		}
	}
}
