package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SkuDao;
import daoImpl.SkuDaoImpl;
import entity.Sku;

/**
 * Servlet implementation class SkuServlet
 */
@WebServlet("/SkuServlet")
public class SkuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SkuServlet() {
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
		request.setCharacterEncoding("utf-8");
		String option = request.getParameter("option");
		int id = Integer.parseInt(request.getParameter("id"));
		SkuDao sd = new SkuDaoImpl();
		if(option!=null&&"edit".equals(option)){
			Sku s = new Sku();
			try {
				s = sd.selectById(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("sku", s);
			RequestDispatcher dis = request.getRequestDispatcher("editsku.jsp");
			dis.forward(request, response);

		}else if(option!=null&&"delete".equals(option)) {
			int d=0;
			try {
				d = sd.deleteSku(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(d>0) {
				request.getRequestDispatcher("showSkuServlet").forward(request, response);
			}

		}else if(option!=null&&"update".equals(option)){
			Sku s = new Sku();
			s.setType(Integer.parseInt(request.getParameter("type")));
			s.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			s.setId(id);
			try {
				sd.updateSku(id, s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("showSkuServlet").forward(request, response);
			
		} /*
			 * else if(option!=null&&"add".equals(option)){ Users u = new Users();
			 * u.setName(request.getParameter("name"));
			 * u.setPassword(request.getParameter("password"));
			 * u.setTel(request.getParameter("tel"));
			 * u.setEmail(request.getParameter("email"));
			 * u.setPermission_code(Integer.parseInt(request.getParameter("permission_code")
			 * )); try { ud.addUser(u); } catch (Exception e1) { // TODO Auto-generated
			 * catch block e1.printStackTrace(); }
			 * request.getRequestDispatcher("showSkuServlet").forward(request, response); }
			 */
	}

}
