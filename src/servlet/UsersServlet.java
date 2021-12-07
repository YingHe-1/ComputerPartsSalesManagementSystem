package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Users;
import dbc.ConnectMySql;

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
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Users> allUsers = null;
		ConnectMySql.getConnection();
		try {
			st = ConnectMySql.getConnection().createStatement();
			request.setCharacterEncoding("utf-8");
			rs = st.executeQuery("select * from users ");
			allUsers = new ArrayList<Users>();
			while(rs.next()) { 
				Users s = new Users();
				s.setName(rs.getString(1));
				s.setPassword(rs.getString(2));
				s.setTel(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setPermission_code(rs.getInt(5));
				allUsers.add(s);
			}
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("allUsers", allUsers);
		RequestDispatcher dis = request.getRequestDispatcher("userlist.jsp");
		dis.forward(request, response);
	}

}
