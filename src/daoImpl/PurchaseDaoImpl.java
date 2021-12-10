package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import dao.PurchaseDao;
import dbc.ConnectMySql;
import entity.Purchase;

public class PurchaseDaoImpl implements PurchaseDao {
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;

	@Override
	public ArrayList<Purchase> selectAll() throws SQLException {
		ArrayList<Purchase> allPurchase = null;
		ConnectMySql.getConnection();
		try {
			st = ConnectMySql.getConnection().createStatement();
			rs = st.executeQuery("select * from purchase ORDER BY id DESC");
			allPurchase = new ArrayList<Purchase>();
			while (rs.next()) {
				Purchase p = new Purchase();
				p.setId(rs.getInt("id"));
				p.setMerchant_name(rs.getString("merchant_name"));
				p.setSupplier_name(rs.getString("supplier_name"));
				p.setMerchant_code(rs.getInt("merchant_code"));
				p.setSupplier_code(rs.getInt("supplier_code"));
				Date str = rs.getDate("in_time");// 数据库获得的是util.Date类型的日期，而java是sql.date
				p.setIn_time(new java.sql.Date(str.getTime()));
				p.setQuantity(rs.getInt("quantity"));
				p.setIn_price(rs.getDouble("in_price"));
				allPurchase.add(p);
			}
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allPurchase;
	}

	@Override
	public int addPurchase(Purchase purchase) throws Exception {
		int row = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql = "insert into purchase (supplier_name, 	merchant_name, supplier_code, merchant_code, in_time, quantity, in_price) values(?,?,?,?,?,?,?)";
			String sql2 = "update sku set quantity=quantity+? where merchant_code = ?";
			String sql3 = "select * from sku where merchant_code="+purchase.getMerchant_code();
			String sql4 = "insert into merchants (name, code) values(?,?)";
			String sql5 = "insert into sku (supplier_code, merchant_code) values(?,?)";
			rs = st.executeQuery(sql3);
			if(!rs.next()) {
				ps=ConnectMySql.getConnection().prepareStatement(sql4); 
				ps.setString(1,purchase.getMerchant_name());
				ps.setInt(2,purchase.getMerchant_code()); 
				row = ps.executeUpdate();
				ps=ConnectMySql.getConnection().prepareStatement(sql5); 
				ps.setInt(1,purchase.getSupplier_code());
				ps.setInt(2,purchase.getMerchant_code()); 
				row = ps.executeUpdate();
			}
			ps=ConnectMySql.getConnection().prepareStatement(sql); 
			ps.setString(1,purchase.getSupplier_name()); 
			ps.setString(2,purchase.getMerchant_name()); 
			ps.setInt(3,purchase.getSupplier_code());
			ps.setInt(4,purchase.getMerchant_code()); 
			ps.setDate(5, purchase.getIn_time());
			ps.setInt(6, purchase.getQuantity()); 
			ps.setDouble(7, purchase.getIn_price());
			row = ps.executeUpdate();
			ps=ConnectMySql.getConnection().prepareStatement(sql2); 
			ps.setInt(1, purchase.getQuantity()); 
			ps.setInt(2, purchase.getMerchant_code()); 
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
	public int updatePurchase(int id, Purchase purchase) throws SQLException {
		int row = 0;
		int temp = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql = "update purchase set in_time=?,quantity=?,in_price=? where id=?";
			String sql2 = "select quantity from purchase where id="+id;
			String sql3 = "update sku set quantity=quantity+? where merchant_code="+purchase.getMerchant_code();
			ps=ConnectMySql.getConnection().prepareStatement(sql2); 
			rs = ps.executeQuery();
			while(rs.next()) {
				temp  = rs.getInt("quantity");
			}
			temp = purchase.getQuantity() - temp;
			ps=ConnectMySql.getConnection().prepareStatement(sql); 
			ps.setDate(1, purchase.getIn_time());
			ps.setInt(2, purchase.getQuantity()); 
			ps.setDouble(3, purchase.getIn_price());
			ps.setInt(4, id);
			row = ps.executeUpdate();
			ps=ConnectMySql.getConnection().prepareStatement(sql3); 
			ps.setInt(1,temp);
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
	public int deletePurchase(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Purchase selectById(int id) throws SQLException {
		Purchase purchase = new Purchase();
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="select * from purchase where id="+id;
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				purchase.setId(rs.getInt("id"));
				purchase.setMerchant_name(rs.getString("merchant_name"));
				purchase.setSupplier_name(rs.getString("supplier_name"));
				purchase.setMerchant_code(rs.getInt("merchant_code"));
				purchase.setSupplier_code(rs.getInt("supplier_code"));
				purchase.setQuantity(rs.getInt("quantity"));
				purchase.setIn_price(rs.getDouble("in_price"));
				Date str=rs.getDate("in_time");//数据库获得的是util.Date类型的日期，而java是sql.date
				purchase.setIn_time(new java.sql.Date(str.getTime()));
			}
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return purchase;
	}

}
