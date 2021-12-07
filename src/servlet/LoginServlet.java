package servlet;

import entity.LoginState;
import entity.Users;
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
        //super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        if (user == null) {
            String name = request.getParameter("name");
            String password = request.getParameter("pwd");
             LoginState loginState = new LoginState();
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
                            Users loginUser = new Users();
                            loginUser.setName(name);
                            loginState.setState("登录成功!");
                            session.setAttribute("user", loginUser);
                            response.sendRedirect("dashboard.jsp");
                            return;
                        } else {
                            loginState.setState("用户名/密码出错!");
                        }
                    } else {
                        loginState.setState("用户不存在!");
                    }
                    // 关闭数据库连接
                    ConnectMySql.closeResultSet(res);
                    ConnectMySql.closeStatement(preparedStatement);
                    ConnectMySql.closeConnection(con);
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("查询登录出错");
                }
                request.setAttribute("loginRes", loginState);
                RequestDispatcher dis = request.getRequestDispatcher("loginRes.jsp");
                dis.forward(request, response);
            }

        } else {
            response.sendRedirect("dashboard.jsp");
        }
    }
}
