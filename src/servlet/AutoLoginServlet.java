package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class AutoLogin
 */
public class AutoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		
		//为什么getInitParameter为空指针
		ServletConfig config = this.getServletConfig();
		String iname=config.getInitParameter("uname");
		String ipwd=config.getInitParameter("upwd");
		
		/**
		 *拿到init方法中的ServletConfig对象
		 *ServletConfig config = this.getServletConfig();  
		 *--获取当前Servlet中配置的初始化参数（只能获取一个）经常用到
		 *String value = config.getInitParameter("uname");       
			// --获取当前Servlet中配置的初始化参数（全部获取）经常用到
			Enumeration enumration = config.getInitParameterNames();         
			while(enumration.hasMoreElements()){
			      iname = (String) enumration.nextElement();
			      ipwd = config.getInitParameter(iname);
			      System.out.println(iname+":"+ipwd);
			 }*/

		 
		
		String isAutoLogin=request.getParameter("autoLogin");
		
		//System.out.println(username+" "+pwd);
		//System.out.println(iname+" "+ipwd);

		if(iname.equals(username) && ipwd.equals(pwd)){
			User user=new User(username, pwd);
			request.getSession().setAttribute("user", user);
			if("true".equals(isAutoLogin)){
				Cookie cookie=new Cookie("autoLogin", username+"#"+pwd);
				cookie.setMaxAge(60*60*24);
				response.addCookie(cookie);
			}
			request.getRequestDispatcher("jsp/main2.jsp").forward(request, response);
		}else{
			request.getSession().setAttribute("msg", "用户名或密码错误");
//			request.getRequestDispatcher("autoLogin.jsp").forward(request, response);
			response.sendRedirect("autoLogin.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
