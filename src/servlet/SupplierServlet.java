package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SupplierDao;
import daoImpl.SupplierDaoImpl;
import entity.Supplier;

/**
 * Servlet implementation class SupplierServlet
 */
@WebServlet("/SupplierServlet")
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierServlet() {
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
		SupplierDao sd = new SupplierDaoImpl();
		if(option!=null&&"edit".equals(option)){
			Supplier s = new Supplier();
			try {
				s = sd.selectById(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("supplier", s);
			RequestDispatcher dis = request.getRequestDispatcher("editsupplier.jsp");
			dis.forward(request, response);

		}else if(option!=null&&"delete".equals(option)) {
			int d=0;
			try {
				d = sd.deleteSupplier(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(d>0) {
				request.getRequestDispatcher("showSupplierServlet").forward(request, response);
			}

		}else if(option!=null&&"update".equals(option)){
			Supplier s = new Supplier();
			s.setCode(Integer.parseInt(request.getParameter("code")));
			s.setName(request.getParameter("name"));
			s.setType(Integer.parseInt(request.getParameter("type")));
			s.setTel(request.getParameter("tel"));
			s.setAddress(request.getParameter("address"));
			s.setStatus(Integer.parseInt(request.getParameter("status")));
			s.setId(id);
			try {
				sd.updateSupplier(id, s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("showSupplierServlet").forward(request, response);
			
		}else if(option!=null&&"add".equals(option)){
			Supplier s = new Supplier();
			s.setCode(Integer.parseInt(request.getParameter("code")));
			s.setName(request.getParameter("name"));
			s.setType(Integer.parseInt(request.getParameter("type")));
			s.setTel(request.getParameter("tel"));
			s.setAddress(request.getParameter("address"));
			s.setStatus(Integer.parseInt(request.getParameter("status")));
			try {
				sd.addSupplier(s);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.getRequestDispatcher("showSupplierServlet").forward(request, response);
		}
	}

}
