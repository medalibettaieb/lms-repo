package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;

@WebFilter("/pages/teacherHome/*")
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(" url = " + ((HttpServletRequest) servletRequest).getRequestURL());

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");

		if (userBean != null && userBean.getLoggedInAsTeacher() == true) {
			chain.doFilter(request, response);
		} else if (request.getRequestURL().toString().contains("login.jsf")) {
			chain.doFilter(request, response);

		} else {
			response.sendRedirect(request.getContextPath() + "/login.jsf");
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
