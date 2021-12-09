package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.SkuDao;
import dbc.ConnectMySql;
import entity.Sku;

public class SkuDaoImpl implements SkuDao {
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;

	@Override
	public int addSku(Sku sku) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Sku selectById(int id) throws SQLException {
		Sku sku = new Sku();
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="select s.id, m.name as m_name, sup.name as sup_name, s.type, s.quantity from sku s,merchants m,supplier sup "
					+ "where s.merchant_code = m.code and s.supplier_code = sup.code and s.id="+id;
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				sku.setId(rs.getInt("id"));
				sku.setMerchant_name(rs.getString("m_name"));
				sku.setSupplier_name(rs.getString("sup_name"));
				sku.setType(rs.getInt("type"));
				sku.setQuantity(rs.getInt("quantity"));
			}
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sku;
	}

	@Override
	public int deleteSku(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSku(int id, Sku sku) throws SQLException {
		int row = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="update sku set type=?,quantity=? where id=?";
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			ps.setInt(1, sku.getType());
			ps.setInt(2	, sku.getQuantity());
			ps.setInt(3, id);
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
	public ArrayList<Sku> selectAll() throws SQLException {
		ArrayList<Sku> allSku = null;
		ConnectMySql.getConnection();
		try {
			st = ConnectMySql.getConnection().createStatement();
			rs = st.executeQuery("select s.id, m.name as m_name, sup.name as sup_name, s.type, s.quantity from sku s,merchants m,supplier sup"
					+ " where s.merchant_code = m.code and s.supplier_code = sup.code");
			allSku = new ArrayList<Sku>();
			while(rs.next()) { 
				Sku s = new Sku();
				s.setId(rs.getInt("id"));
				s.setMerchant_name(rs.getString("m_name"));
				s.setSupplier_name(rs.getString("sup_name"));
				s.setType(rs.getInt("type"));
				s.setQuantity(rs.getInt("quantity"));
				allSku.add(s);
			}
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allSku;
	}

}
