package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Client;
import entity.Users;
import dao.ClientDao;
import daoImpl.ClientDaoImpl;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String option = request.getParameter("option");
		int id = Integer.valueOf(request.getParameter("id"));
		ClientDao cd = new ClientDaoImpl();
		if(option !=null && "edit".equals(option)) {
			Client c = new Client();
			try {
				c = cd.selectById(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("client", c);
			RequestDispatcher dis = request.getRequestDispatcher("editcustomer.jsp");
			dis.forward(request, response);
		}else if (option !=null && "delete".equals(option)) {
			Client c = new Client();
			try {
				cd.deleteClient(id);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.getRequestDispatcher("showClientServlet").forward(request, response);
		}else if(option !=null && "update".equals(option)){
			Client c = new Client();
			c.setName(request.getParameter("name"));
			c.setTel(request.getParameter("tel"));
			c.setEmail(request.getParameter("email"));
			c.setAge(request.getParameter("age"));
			c.setGender(request.getParameter("gender"));
			c.setId(id);
			try {
				cd.updateClient(id, c);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.getRequestDispatcher("showClientServlet").forward(request, response);
		}else if(option !=null && "add".equals(option)){
			Client c = new Client();
			c.setName(request.getParameter("name"));
			c.setTel(request.getParameter("tel"));
			c.setEmail(request.getParameter("email"));
			c.setAge(request.getParameter("age"));
			c.setGender(request.getParameter("gender"));
			try {
				cd.addClient(c);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.getRequestDispatcher("showClientServlet").forward(request, response);
		}
	}

}
