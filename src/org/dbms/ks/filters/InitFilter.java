package org.dbms.ks.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.dbms.ks.util.ConfigUtil;
import org.dbms.ks.util.QueryUtil;
import org.dbms.ks.util.SecurityUtil;


public class InitFilter implements Filter{

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		try {
			// registers oracle driver to the sql interface
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// loads conf.props
			ConfigUtil.loadConfig(arg0.getServletContext());
			// loads queries.props
			QueryUtil.loadQueries(arg0.getServletContext());
		} catch(Exception e) {
			//TODO log
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		if(SecurityUtil.isAuthenticated(req)) {
			chain.doFilter(req, res);
		} else {
			((HttpServletResponse) res).sendRedirect("login.jsp");
		}
	}
	
	@Override
	public void destroy() {
		
	}
}
