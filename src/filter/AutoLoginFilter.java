package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

public class AutoLoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("========doFilter===========");
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		if(session.getAttribute("user")!=null){
			//故意参数填错会有什么影响吗
			chain.doFilter(request, response);
		}
		Cookie[] cookies=req.getCookies();
		String cookValue=null;
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("autoLogin")){
					cookValue=cookie.getValue();
					break;
				}
			}
		}
		if(cookValue!=null){
			User user=new User(cookValue.split("#")[0], cookValue.split("#")[1]);
			session.setAttribute("user", user);
			chain.doFilter(req, response);
		}else{
			//req.getRequestDispatcher("autoLogin.jsp").forward(request, response);
			//为什么重定向的路径得是../
			((HttpServletResponse)response).sendRedirect("../autoLogin.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
