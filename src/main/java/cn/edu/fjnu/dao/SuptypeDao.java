package cn.edu.fjnu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.fjnu.entity.Suptype;
import cn.edu.fjnu.entity.Supplier;

@Repository
public interface SuptypeDao {
	
	//查看供应商类型
	public List<Suptype> findSuptype() throws Exception;
	
	//根据id查询供应商类型
	public Suptype findSuptypeById(Integer id) throws Exception;
	
	//增加供应商类型
	public void addSuptype(Suptype suptype) throws Exception;
	
	//修改供应商类型
	public void updateSuptypeById(Suptype suptype) throws Exception;
	
	//删除供应商类型
	public void deleteSuptypeById(Integer id) throws Exception; 
	
	//通过供应商类型查询供应商信息
	public List<Supplier> findSupplierBySuptype(String name) throws Exception;
	
	//查看所有供应商信息
	public List<Supplier> findSupplier() throws Exception;
	
	//根据id查询供应商
	public Supplier findSupplierById(Integer id) throws Exception;
	
	//修改供应商
	public void updateSupplierById(Supplier supplier) throws Exception;
	
	//增加供应商
	public void addSupplier(Supplier supplier) throws Exception;
	
	//删除供应商
	public void deleteSupplierById(Integer id) throws Exception;
}
