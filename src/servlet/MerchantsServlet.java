package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MerchantsDao;
import daoImpl.MerchantsDaoImpl;
import entity.Merchants;

/**
 * Servlet implementation class MerchantsServlet
 */
@WebServlet("/MerchantsServlet")
public class MerchantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MerchantsServlet() {
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
		MerchantsDao md = new MerchantsDaoImpl();
		if(option!=null&&"edit".equals(option)){
			Merchants m = new Merchants();
			try {
				m = md.selectById(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("merchants", m);
			RequestDispatcher dis = request.getRequestDispatcher("editgoods.jsp");
			dis.forward(request, response);

		}else if(option!=null&&"delete".equals(option)) {
			int d=0;
			try {
				d = md.deleteMerchants(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(d>0) {
				request.getRequestDispatcher("showMerchantsServlet").forward(request, response);
			}

		}else if(option!=null&&"update".equals(option)){
			Merchants m = new Merchants();
			m.setCode(Integer.parseInt(request.getParameter("code")));
			m.setName(request.getParameter("name"));
			m.setType(Integer.parseInt(request.getParameter("type")));
			m.setDescription(request.getParameter("description"));
			m.setCur_price(Double.parseDouble(request.getParameter("cur_price")));
			m.setIn_price(Double.parseDouble(request.getParameter("in_price")));
			m.setStatus(Integer.parseInt(request.getParameter("status")));
			m.setId(id);
			try {
				md.updateMerchants(id, m);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("showMerchantsServlet").forward(request, response);
			
		}else if(option!=null&&"add".equals(option)){
			Merchants m = new Merchants();
			m.setCode(Integer.parseInt(request.getParameter("code")));
			m.setName(request.getParameter("name"));
			m.setType(Integer.parseInt(request.getParameter("type")));
			m.setDescription(request.getParameter("description"));
			m.setCur_price(Double.parseDouble(request.getParameter("cur_price")));
			m.setIn_price(Double.parseDouble(request.getParameter("in_price")));
			m.setStatus(Integer.parseInt(request.getParameter("status")));
			try {
				md.addMerchants(m);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.getRequestDispatcher("showMerchantsServlet").forward(request, response);
		}
	
	}

}
