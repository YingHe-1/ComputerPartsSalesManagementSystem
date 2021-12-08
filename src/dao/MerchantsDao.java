package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Merchants;

public interface MerchantsDao {
	int addMerchants(Merchants merchants) throws Exception;     //添加商品
	Merchants selectById(int id) throws SQLException;   //根据ID查找商品
	int deleteMerchants(int id) throws SQLException;    //删除商品
	int updateMerchants(int id,Merchants merchants) throws SQLException;   //修改商品信息
	ArrayList<Merchants> selectAll() throws SQLException;	//显示全部商品信息
}
