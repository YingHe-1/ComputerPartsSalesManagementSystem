package servlet;

import dbc.ConnectMySql;
import entity.LoginState;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author pisces
 */
@WebServlet("/signinServlet")
public class SiginServlet  extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String password = req.getParameter("pwd");
        String tel = req.getParameter("tel");
        String email = req.getParameter("email");
        LoginState loginState = new LoginState();
        if (name.isEmpty() || password.isEmpty() || tel.isEmpty() || email.isEmpty()) {
            req.setAttribute("loginRes", loginState);
            loginState.setState("注册信息填写错误！");
        } else {
            Connection con = ConnectMySql.getConnection();
            PreparedStatement preState;

            try{
                preState = con.prepareStatement("INSERT INTO users(name,password,tel,email) VALUES (?,?,?,?)");
                preState.setString(1, name);
                preState.setString(2, password);
                preState.setString(3,tel);
                preState.setString(4, email);

                preState.executeUpdate();
                loginState.setState("注册成功！");
                // 关闭数据库连接

                ConnectMySql.closeStatement(preState);
                ConnectMySql.closeConnection(con);

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("新增用户出错");
            }
        }
        req.setAttribute("loginRes", loginState);
        RequestDispatcher dis = req.getRequestDispatcher("loginRes.jsp");
        dis.forward(req, resp);
    }
}
