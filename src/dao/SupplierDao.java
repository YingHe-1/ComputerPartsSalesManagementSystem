package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Supplier;


public interface SupplierDao {
	int addSupplier(Supplier supplier) throws Exception;     //添加供应商
	Supplier selectById(int id) throws SQLException;   //根据ID查找供应商
	int deleteSupplier(int id) throws SQLException;    //删除供应商
	int updateSupplier(int id,Supplier supplier) throws SQLException;   //修改供应商信息
	ArrayList<Supplier> selectAll() throws SQLException;	//显示全部供应商信息
}
