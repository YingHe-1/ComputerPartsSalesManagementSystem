package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.MerchantsDao;
import dbc.ConnectMySql;
import entity.Merchants;

public class MerchantsDaoImpl implements MerchantsDao {
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;

	@Override
	public int addMerchants(Merchants merchants) throws Exception {
		int row = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="insert into merchants (name, code, type, description, cur_price, status) values(?,?,?,?,?,?)";
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			ps.setString(1, merchants.getName());
			ps.setInt(2, merchants.getCode());
			ps.setInt(3, merchants.getType());
			ps.setString(4, merchants.getDescription());
			ps.setDouble(5, merchants.getCur_price());
			ps.setInt(6, merchants.getStatus());
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
	public Merchants selectById(int id) throws SQLException {
		Merchants merchants = new Merchants();
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="select m.id, m.name, m.code, m.type, m.description, m.cur_price, p.in_price, m.status from merchants m,purchase p"
					+ " where m.code = p.merchant_code and m.id="+id;
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				merchants.setId(rs.getInt("id"));
				merchants.setCode(rs.getInt("code"));
				merchants.setName(rs.getString("name"));
				merchants.setType(rs.getInt("type"));
				merchants.setDescription(rs.getString("description"));
				merchants.setCur_price(rs.getDouble("cur_price"));
				merchants.setIn_price(rs.getDouble("in_price"));
				merchants.setStatus(rs.getInt("status"));
			}
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return merchants;
	}

	@Override
	public int deleteMerchants(int id) throws SQLException {
		int row = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="delete from merchants where id="+id;
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
	public int updateMerchants(int id, Merchants merchants) throws SQLException {
		int row = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="update merchants set name=?,code=?,type=?,description=?,cur_price=?,status=? where id=?";
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			ps.setString(1, merchants.getName());
			ps.setInt(2, merchants.getCode());
			ps.setInt(3, merchants.getType());
			ps.setString(4, merchants.getDescription());
			ps.setDouble(5, merchants.getCur_price());
			ps.setInt(6	, merchants.getStatus());
			ps.setInt(7, id);
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
	public ArrayList<Merchants> selectAll() throws SQLException {
		ArrayList<Merchants> allMerchants = null;
		ConnectMySql.getConnection();
		try {
			st = ConnectMySql.getConnection().createStatement();
			rs = st.executeQuery("select distinct m.id, m.name, m.code, m.type, m.description, m.cur_price, p.in_price, m.status from merchants m,purchase p"
					+ " where m.code = p.merchant_code GROUP BY m.code");
			allMerchants = new ArrayList<Merchants>();
			while(rs.next()) { 
				Merchants m = new Merchants();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setCode(rs.getInt("code"));
				m.setType(rs.getInt("type"));
				m.setDescription(rs.getString("description"));
				m.setCur_price(rs.getDouble("cur_price"));
				m.setIn_price(rs.getDouble("in_price"));
				m.setStatus(rs.getInt("status"));
				allMerchants.add(m);
			}
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allMerchants;
	}

}
