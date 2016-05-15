package cn.edu.fjnu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.fjnu.entity.Outstock;
import cn.edu.fjnu.entity.Outtype;


@Repository
public interface OuttypeDao {
	
	//查看出库类型
	public List<Outtype> findOuttype() throws Exception;
	
	//根据id查询出库类型
	public Outtype findOuttypeById(Integer id) throws Exception;
	
	//增加出库类型
	public void addOuttype(Outtype outtype) throws Exception;
	
	//修改出库类型
	public void updateOuttypeById(Outtype outtype) throws Exception;
	
	//删除出库类型
	public void deleteOuttypeById(Integer id) throws Exception; 
	
	//通过出库类型查询出库信息
	public List<Outstock> findOutstockByOuttype(String name) throws Exception;
	
	//查看所有出库信息
	public List<Outstock> findOutstock() throws Exception;
	
	//根据id查询出库信息
	public Outstock findOutstockById(Integer id) throws Exception;
	
	//修改出库信息
	public void updateOutstockById(Outstock outstock) throws Exception;
	
	//增加出库信息
	public void addOutstock(Outstock outstock) throws Exception;
	
	//删除出库信息
	public void deleteOutstockById(Integer id) throws Exception;
}
