package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.ClientDao;
import dbc.ConnectMySql;
import entity.Client;
import entity.Users;

public class ClientDaoImpl implements ClientDao {
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;

	@Override
	public boolean checkLogin(Users user) throws Exception {
		// TODO Auto-generated method stub
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
	public int addClient(Client client) throws Exception {
		// TODO Auto-generated method stub
		int row =0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="insert into client (name, tel, email, age, gender) values(?,?,?,?,?)";
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			ps.setString(1, client.getName());
			ps.setString(2, client.getTel());
			ps.setString(3, client.getEmail());
			ps.setString(4, client.getAge());
			ps.setString(5, client.getGender());
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
	public Client selectById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Client client = new Client();
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="select * from client where id="+id;
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				client.setId(rs.getInt("id"));
				client.setName(rs.getString("name"));
				client.setTel(rs.getString("tel"));
				client.setEmail(rs.getString("email"));
				client.setAge(rs.getString("age"));
				client.setGender(rs.getString("gender"));
			}
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public int deleteClient(int id) throws SQLException {
		// TODO Auto-generated method stub
		int row = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="delete from client where id="+id;
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
	public int updateClient(int id, Client client) throws SQLException {
		// TODO Auto-generated method stub
		int row = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="update client set name=?,tel=?,email=?,age=?,gender=? where id=?";
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			ps.setString(1, client.getName());
			ps.setString(2, client.getTel());
			ps.setString(3, client.getEmail());
			ps.setString(4, client.getAge());
			ps.setString(5, client.getGender());
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
	public ArrayList<Client> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Client> allClient = null;
		ConnectMySql.getConnection();
		try {
			st = ConnectMySql.getConnection().createStatement();
			rs = st.executeQuery("select * from client ");
			allClient = new ArrayList<Client>();
			while(rs.next()) { 
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setTel(rs.getString("tel"));
				c.setEmail(rs.getString("email"));
				c.setAge(rs.getString("age"));
				c.setGender(rs.getString("gender"));
				allClient.add(c);
			}
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allClient;
	}

	

}
