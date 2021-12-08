package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Sku;

public interface SkuDao {
	int addSku(Sku sku) throws Exception;     //添加库存
	Sku selectById(int id) throws SQLException;   //根据ID查找对应库存
	int deleteSku(int id) throws SQLException;    //删除库存
	int updateSku(int id,Sku sku) throws SQLException;   //修改库存信息
	ArrayList<Sku> selectAll() throws SQLException;	//显示全部库存信息
}
