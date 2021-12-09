package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Orders;

public interface OrdersDao {
	int addOrder(Orders orders) throws Exception;     //添加订单
	Orders selectById(int id) throws SQLException;   //根据ID查找对应订单
	int deleteOrder(int id) throws SQLException;    //删除订单
	int updateOrder(int id,Orders orders) throws SQLException;   //修改订单信息
	ArrayList<Orders> selectAll() throws SQLException;	//显示全部订单信息
}
