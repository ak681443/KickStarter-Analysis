package org.dbms.ks;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dbms.ks.util.SecurityUtil;

/**
 * Servlet implementation class Authentication
 */
@WebServlet("/login")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentication() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			SecurityUtil.authenticate(res, username, password);
			if(!res.isCommitted()) {
				res.sendRedirect("index.jsp");
			}
		} catch(Exception e) {
			
		}
	}
}
