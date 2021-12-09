package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import dao.OrdersDao;
import dbc.ConnectMySql;
import entity.Orders;
import entity.Purchase;

public class OrdersDaoImpl implements OrdersDao {
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;

	@Override
	public int addOrder(Orders orders) throws Exception {
		int row = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql = "insert into orders (client_id, merchant_code, quantity, discount, status, created_at) values(?,?,?,?,?,?)";
			String sql2 = "update sku set quantity=quantity-? where merchant_code = ?";
			ps=ConnectMySql.getConnection().prepareStatement(sql); 
			ps.setInt(1,orders.getClient_id()); 
			ps.setInt(2,orders.getMerchant_code()); 
			ps.setInt(3, orders.getQuantity()); 
			ps.setDouble(4, orders.getDiscount());
			ps.setInt(5, orders.getStatus()); 
			ps.setDate(6, orders.getCreate_time()); 
			row = ps.executeUpdate();
			ps=ConnectMySql.getConnection().prepareStatement(sql2); 
			ps.setInt(1, orders.getQuantity()); 
			ps.setInt(2, orders.getMerchant_code()); 
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
	public Orders selectById(int id) throws SQLException {
		Orders orders = new Orders();
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="select o.id, c.name as c_name, m.name as m_name, o.quantity, o.discount, o.status, o.created_at from orders o,client c,merchants m"
					+ " where o.client_id = c.id and o.merchant_code = m.code and o.id="+id;
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				orders.setId(rs.getInt("id"));
				orders.setMerchant_name(rs.getString("m_name"));
				orders.setClient_name(rs.getString("c_name"));
				orders.setQuantity(rs.getInt("quantity"));
				orders.setDiscount(rs.getDouble("discount"));
				Date str=rs.getDate("created_at");//数据库获得的是util.Date类型的日期，而java是sql.date
				orders.setCreate_time(new java.sql.Date(str.getTime()));
			}
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public int deleteOrder(int id) throws SQLException {
		int row = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="delete from orders where id="+id;
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
	public int updateOrder(int id, Orders orders) throws SQLException {
		int row = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="update orders set quantity=?,discount=?,status=?,created_at=? where id=?";
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			ps.setInt(1,orders.getQuantity());
			ps.setDouble(2, orders.getDiscount());
			ps.setInt(3, orders.getStatus());
			ps.setDate(4, orders.getCreate_time());
			ps.setInt(5, id);
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
	public ArrayList<Orders> selectAll() throws SQLException {
		ArrayList<Orders> allorders = null;
		try {
			st = ConnectMySql.getConnection().createStatement();
			rs = st.executeQuery("select o.id, c.name as c_name, m.name as m_name, o.quantity, o.discount, o.status, o.created_at from orders o,client c,merchants m"
					+ " where o.client_id = c.id and o.merchant_code = m.code");
			allorders = new ArrayList<Orders>();
			while(rs.next()) { 
				Orders o = new Orders();
				o.setId(rs.getInt("id"));
				o.setClient_name(rs.getString("c_name"));
				o.setMerchant_name(rs.getString("m_name"));
				o.setQuantity(rs.getInt("quantity"));
				o.setDiscount(rs.getDouble("discount"));
				o.setStatus(rs.getInt("status"));
				Date str=rs.getDate("created_at");//数据库获得的是util.Date类型的日期，而java是sql.date
				o.setCreate_time(new java.sql.Date(str.getTime()));
				allorders.add(o);
			}
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allorders;
	}

}
