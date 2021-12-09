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

import dao.PurchaseDao;
import daoImpl.PurchaseDaoImpl;
import entity.Purchase;

/**
 * Servlet implementation class PurchaseServlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseServlet() {
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
		PurchaseDao pd = new PurchaseDaoImpl();
		if(option!=null&&"edit".equals(option)){
			Purchase p = new Purchase();
			try {
				p = pd.selectById(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("purchase", p);
			RequestDispatcher dis = request.getRequestDispatcher("editpurchase.jsp");
			dis.forward(request, response);

		}else if(option!=null&&"delete".equals(option)) {
			int d=0;
			try {
				d = pd.deletePurchase(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(d>0) {
				request.getRequestDispatcher("showPurchaseServlet").forward(request, response);
			}

		}else if(option!=null&&"update".equals(option)){
			Purchase p = new Purchase();
			p.setIn_time(Date.valueOf(request.getParameter("in_time")));
			p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			p.setIn_price(Double.parseDouble(request.getParameter("in_price")));
			p.setId(id);
			try {
				pd.updatePurchase(id, p);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("showPurchaseServlet").forward(request, response);
			
		}else if(option!=null&&"add".equals(option)){
			Purchase p = new Purchase();
			p.setMerchant_code(Integer.parseInt(request.getParameter("merchant_code")));
			p.setSupplier_code(Integer.parseInt(request.getParameter("supplier_code")));
			p.setMerchant_name(request.getParameter("merchant_name"));
			p.setSupplier_name(request.getParameter("supplier_name"));
			p.setIn_time(Date.valueOf(request.getParameter("date")));
			p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			p.setIn_price(Double.parseDouble(request.getParameter("in_price")));
			try {
				pd.addPurchase(p);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.getRequestDispatcher("showPurchaseServlet").forward(request, response);
		}
	}

}
