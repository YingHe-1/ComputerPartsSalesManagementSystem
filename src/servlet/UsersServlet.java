package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import daoImpl.UsersDaoImpl;
import entity.Users;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet("/UsersServlet")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String option = request.getParameter("option");
		int id = Integer.parseInt(request.getParameter("id"));
		UsersDao ud = new UsersDaoImpl();
		if(option!=null&&"edit".equals(option)){
			Users u = new Users();
			try {
				u = ud.selectById(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("user", u);
			RequestDispatcher dis = request.getRequestDispatcher("edituser.jsp");
			dis.forward(request, response);

		}else if(option!=null&&"delete".equals(option)) {
			int d=0;
			try {
				d = ud.deleteUser(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(d>0) {
				request.getRequestDispatcher("showUsersServlet").forward(request, response);
			}

		}else if(option!=null&&"update".equals(option)){
			Users u = new Users();
			u.setName(request.getParameter("name"));
			u.setPassword(request.getParameter("password"));
			u.setTel(request.getParameter("tel"));
			u.setEmail(request.getParameter("email"));
			u.setPermission_code(Integer.parseInt(request.getParameter("permission_code")));
			u.setId(id);
			try {
				ud.updateUser(id, u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("showUsersServlet").forward(request, response);
			
		}else if(option!=null&&"add".equals(option)){
			Users u = new Users();
			u.setName(request.getParameter("name"));
			u.setPassword(request.getParameter("password"));
			u.setTel(request.getParameter("tel"));
			u.setEmail(request.getParameter("email"));
			u.setPermission_code(Integer.parseInt(request.getParameter("permission_code")));
			try {
				ud.addUser(u);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.getRequestDispatcher("showUsersServlet").forward(request, response);
		}

	}

}
