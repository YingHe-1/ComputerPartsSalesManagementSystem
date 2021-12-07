package servlet;

import dao.User;
import dbc.ConnectMySql;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author pisces
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        if (user == null) {
            String name = request.getParameter("name");
            String password = request.getParameter("pwd");
            String loginState = "failed";
            if (name == null || name.length() == 0) {
                response.sendRedirect("login.jsp");
            } else if (password == null || password.length() == 0) {
                response.sendRedirect("login.jsp");
            } else {
                Connection con = ConnectMySql.getConnection();
                PreparedStatement preparedStatement;
                ResultSet res;
                try{
                    preparedStatement = con.prepareStatement("SELECT password FROM users WHERE name = ?");
                    preparedStatement.setString(1, name);
                    res = preparedStatement.executeQuery();
                    // 返回结果是否为空
                    if (res.next()) {
                        if (password.equals(res.getString(1))) {
                            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Success.jsp");
                            requestDispatcher.forward(request, response);
                            loginState = "success";

                            session.setAttribute("User", user);
                        } else {
                            loginState = "登录出错！";
                        }

                    } else {
                        System.out.println("用户不存在");
                        response.sendRedirect("login.jsp");
                    }
                    ConnectMySql.closeResultSet(res);
                    ConnectMySql.closeStatement(preparedStatement);
                    ConnectMySql.closeConnection(con);
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("查询登录出错");
                }
            }
            request.setAttribute("loginRes", loginState);
            RequestDispatcher dis = request.getRequestDispatcher("showLoginRes.jsp");
            dis.forward(request, response);
        } else {
            response.sendRedirect("dashboard.jsp");
        }
    }
}
