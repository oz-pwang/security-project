package org.wang.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by Administrator on 2015/9/16.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  01/14/2016 17:57
 */
public class LoginFilter implements Filter {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Filter#destroy()
   */
  @Override public void destroy() { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Filter#doFilter(ServletRequest, ServletResponse,
   *       FilterChain)
   */
  @Override public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
    FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest  httpServletRequest  = (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
    HttpSession         session             = httpServletRequest.getSession();

    // 请求的URI
    String  path         = httpServletRequest.getRequestURI();
    Integer USERNAME_KEY = (Integer) session.getAttribute("LoggedInUserID");
    String  USERID_KEY   = (String) session.getAttribute("LoggedInUserName");

    // 如果请求路径为login  就继续让它执行  不进行拦截
    if (path.equals("/login") || path.endsWith(".css") || path.endsWith(".js") || path.equals("")
          || path.endsWith("/index")
          || path.endsWith("DownLoadExcel.jsp")) {
      filterChain.doFilter(servletRequest, servletResponse);
      // 如果session中有KEY的值则继续让其执行
    } else if ((USERID_KEY != null) && (USERNAME_KEY != null)) {
      filterChain.doFilter(servletRequest, servletResponse);
    } else {
      // 其余所有路径都重定向到login.jsp
      httpServletResponse.sendRedirect("/login");
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Filter#init(FilterConfig)
   */
  @Override public void init(FilterConfig filterConfig) throws ServletException { }
} // end class LoginFilter
