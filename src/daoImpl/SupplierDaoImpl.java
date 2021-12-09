package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.SupplierDao;
import dbc.ConnectMySql;
import entity.Supplier;

public class SupplierDaoImpl implements SupplierDao {
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	
	@Override
	public int addSupplier(Supplier supplier) throws Exception {
		int row = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="insert into supplier (code, name, type, tel, address, status) values(?,?,?,?,?,?)";
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			ps.setInt(1, supplier.getCode());
			ps.setString(2, supplier.getName());
			ps.setInt(3, supplier.getType());
			ps.setString(4, supplier.getTel());
			ps.setString(5, supplier.getAddress());
			ps.setInt(6, supplier.getStatus());
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
	public Supplier selectById(int id) throws SQLException {
		Supplier supplier = new Supplier();
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="select * from supplier where id="+id;
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				supplier.setId(rs.getInt("id"));
				supplier.setCode(rs.getInt("code"));
				supplier.setName(rs.getString("name"));
				supplier.setType(rs.getInt("type"));
				supplier.setTel(rs.getString("tel"));
				supplier.setAddress(rs.getString("address"));
				supplier.setStatus(rs.getInt("status"));
			}
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplier;
	}

	@Override
	public int deleteSupplier(int id) throws SQLException {
		int row = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="delete from supplier where id="+id;
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
	public int updateSupplier(int id, Supplier supplier) throws SQLException {
		int row = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="update supplier set code=?,name=?,type=?,tel=?,address=?,status=? where id=?";
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			ps.setInt(1, supplier.getCode());
			ps.setString(2, supplier.getName());
			ps.setInt(3, supplier.getType());
			ps.setString(4, supplier.getTel());
			ps.setString(5	, supplier.getAddress());
			ps.setInt(6	, supplier.getStatus());
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
	public ArrayList<Supplier> selectAll() throws SQLException {
		ArrayList<Supplier> allSuppliers = null;
		ConnectMySql.getConnection();
		try {
			st = ConnectMySql.getConnection().createStatement();
			rs = st.executeQuery("select * from supplier ");
			allSuppliers = new ArrayList<Supplier>();
			while(rs.next()) { 
				Supplier s = new Supplier();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setCode(rs.getInt("code"));
				s.setType(rs.getInt("type"));
				s.setTel(rs.getString("tel"));
				s.setAddress(rs.getString("address"));
				s.setStatus(rs.getInt("status"));
				allSuppliers.add(s);
			}
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allSuppliers;
	}

}
