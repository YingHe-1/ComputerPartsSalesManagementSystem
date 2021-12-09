package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Merchants;
import entity.Purchase;

public interface PurchaseDao {
	int addPurchase(Purchase purchase) throws Exception;     //添加进货信息
	Purchase selectById(int id) throws SQLException;   //根据ID查找进货信息
	int deletePurchase(int id) throws SQLException;    //删除进货信息
	int updatePurchase(int id,Purchase purchase) throws SQLException;   //修改进货信息
	ArrayList<Purchase> selectAll() throws SQLException;	//显示全部进货信息
}
