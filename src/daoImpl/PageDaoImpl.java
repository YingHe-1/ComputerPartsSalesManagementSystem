package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PageDao;
import dbc.ConnectMySql;
import entity.Users;

public class PageDaoImpl implements PageDao {
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	
	@Override
	public int maxPage(int rowsperpage) throws SQLException {
		int maxpage = 0;
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="select count(id) from users"; 
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			int maxrecord = 0;
			if(rs.next()){
				maxrecord=rs.getInt(1);
			}
			maxpage = (maxrecord+rowsperpage-1)/rowsperpage;
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxpage;
	}

	@Override
	public List<Users> getsearch(Users user, int rowsperpage, int nowpage) throws Exception {
		int page=rowsperpage*(nowpage-1); 
		List<Users> list=new ArrayList<Users>();
		try {
			st = ConnectMySql.getConnection().createStatement();
			String sql="select top "+rowsperpage+" * from users where id not in (select top "+page+" id from users) order by id asc"; 
			ps=ConnectMySql.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Users u = new Users();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setTel(rs.getString("tel"));
				u.setEmail(rs.getString("email"));
				u.setPermission_code(rs.getInt("permission_code"));
				list.add(u);
			}
			ConnectMySql.closeResultSet(rs);
			ConnectMySql.closeStatement(st);
			ConnectMySql.closeConnection(ConnectMySql.getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
