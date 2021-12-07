package dao;

import java.sql.SQLException;

import entity.Users;

public interface UsersDao {
	boolean checkLogin(Users user) throws Exception;    //登录验证
	int addUser(Users user) throws Exception;     //添加用户
	Users selectById(int id) throws SQLException;   //根据ID查找用户
	int deleteUser(int id) throws SQLException;    //删除用户
	int updateUser(int id,Users user) throws SQLException;   //修改用户信息

}
