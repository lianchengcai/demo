package cn.edu.fjnu.service;

import java.util.List;

import cn.edu.fjnu.entity.Dept;
import cn.edu.fjnu.entity.Employee;
import cn.edu.fjnu.entity.Inquiry;
import cn.edu.fjnu.entity.Intype;
import cn.edu.fjnu.entity.Outstock;
import cn.edu.fjnu.entity.Outtype;
import cn.edu.fjnu.entity.PageResult;

public interface OuttypeService {

	//查看出库类型
	public PageResult<Outtype> findOuttype(Integer pageNo,Integer pageSize) throws Exception;
	
	//根据id查询出库类型
	public Outtype findOuttypeById(Integer id) throws Exception;
	
	//增加出库类型
	public void addOuttype(Outtype outtype) throws Exception;
	
	//修改出库类型
	public void updateOuttypeById(Outtype outtype) throws Exception;
	
	//删除出库类型
	public void deleteOuttypeById(Integer id) throws Exception; 
	
	//通过出库类型查询出库信息
	public PageResult<Outstock> findOutstockByOuttype(String name,Integer pageNo,Integer pageSize) throws Exception;
	
	//查看所有出库信息
	public PageResult<Outstock> findOutstock(Integer pageNo,Integer pageSize) throws Exception;
	
	//根据id查询出库信息
	public Outstock findOutstockById(Integer id) throws Exception;
	
	//修改出库信息
	public void updateOutstockById(Outstock outstock) throws Exception;
	
	//增加出库信息
	public void addOutstock(Outstock outstock) throws Exception;
	
	//删除出库信息
	public void deleteOutstockById(Integer id) throws Exception;
}
