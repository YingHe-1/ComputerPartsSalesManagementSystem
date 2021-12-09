package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrdersDao;
import daoImpl.OrdersDaoImpl;
import entity.Orders;

/**
 * Servlet implementation class OrdersServlet
 */
@WebServlet("/OrdersServlet")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
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
		OrdersDao od = new OrdersDaoImpl();
		Orders o = new Orders();
		if(option!=null&&"edit".equals(option)){
			try {
				o = od.selectById(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("orders", o);
			RequestDispatcher dis = request.getRequestDispatcher("editorders.jsp");
			dis.forward(request, response);

		}else if(option!=null&&"delete".equals(option)) {
			int d=0;
			try {
				d = od.deleteOrder(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(d>0) {
				request.getRequestDispatcher("showOrdersServlet").forward(request, response);
			}

		}else if(option!=null&&"update".equals(option)){
			o.setCreate_time(Date.valueOf(request.getParameter("create_time")));
			o.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			o.setDiscount(Double.parseDouble(request.getParameter("discount")));
			o.setStatus(Integer.parseInt(request.getParameter("status")));
			o.setId(id);
			try {
				od.updateOrder(id, o);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("showOrdersServlet").forward(request, response);
			
		}else if(option!=null&&"add".equals(option)){
			o.setClient_id(Integer.parseInt(request.getParameter("client_id")));
			o.setMerchant_code(Integer.parseInt(request.getParameter("merchant_code")));
			o.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			o.setCreate_time(Date.valueOf(request.getParameter("date")));
			o.setStatus(Integer.parseInt(request.getParameter("status")));
			o.setDiscount(Double.parseDouble(request.getParameter("discount")));
			try {
				od.addOrder(o);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.getRequestDispatcher("showOrdersServlet").forward(request, response);
		}
	}

}
