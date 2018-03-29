package org.dbms.ks.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.dbms.ks.util.ConfigUtil;
import org.dbms.ks.util.QueryUtil;


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
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		arg2.doFilter(arg0, arg1);
	}
	
	@Override
	public void destroy() {
		
	}
}
