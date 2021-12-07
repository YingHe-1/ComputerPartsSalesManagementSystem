package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Users;

public interface PageDao {
	int maxPage(int rowsperpage) throws SQLException;  //总共页数
	List<Users> getsearch(Users user,int rowsperpage,int nowpage) throws Exception; //根据每页记录数，当前页码返回记录\
}
