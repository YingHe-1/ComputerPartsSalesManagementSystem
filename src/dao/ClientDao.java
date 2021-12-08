package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Client;
import entity.Users;


public interface ClientDao {
	boolean checkLogin(Users user) throws Exception;    //登录验证
	int addClient(Client client)throws Exception;
	Client selectById(int id) throws SQLException;   //根据ID查找客户
	int deleteClient(int id) throws SQLException;    //删除客户
	int updateClient(int id,Client client) throws SQLException;   //修改客户信息
	ArrayList<Client> selectAll() throws SQLException;

}
