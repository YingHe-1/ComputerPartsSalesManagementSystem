package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.UsersDao;
import entity.Users;
import dbc.ConnectMySql;

public class UsersDaoImpl implements UsersDao {
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;

	@Override
	public boolean checkLogin(Users user) throws Exception {
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="select * from users where name=? and password=?";
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			rs=ps.executeQuery();
			if(rs.next()){
				return true;
			}
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int addUser(Users user) throws Exception {
		int row = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="insert into students values(?,?,?,?,?)";
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getTel());
			ps.setString(4, user.getEmail());
			ps.setInt(2, user.getPermission_code());
			row =ps.executeUpdate();
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Users selectById(int id) throws SQLException {
		Users user = new Users();
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="select * from users where id="+id;
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setTel(rs.getString("tel"));
				user.setEmail(rs.getString("email"));
				user.setPermission_code(rs.getInt("permission_code"));
			}
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int deleteUser(int id) throws SQLException {
		int row = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="delete from users where id="+id;
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			row = ps.executeUpdate();
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateUser(int id, Users user) throws SQLException {
		int row = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="update users set name=?,password=?,tel=?,email=?,permission_code=? where id=?";
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getTel());
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getPermission_code());
			ps.setInt(6, id);
			row = ps.executeUpdate();
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public ArrayList<Users> selectAll() throws SQLException {
		ArrayList<Users> allUsers = null;
		ConnectMySql.getConnection();
		try {
			st = ConnectMySql.getConnection().createStatement();
			rs = st.executeQuery("select * from users ");
			allUsers = new ArrayList<Users>();
			while(rs.next()) { 
				Users s = new Users();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPassword(rs.getString("password"));
				s.setTel(rs.getString("tel"));
				s.setEmail(rs.getString("email"));
				s.setPermission_code(rs.getInt("permission_code"));
				allUsers.add(s);
			}
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allUsers;
	}

}
