package cn.edu.fjnu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.fjnu.entity.Inquiry;
import cn.edu.fjnu.entity.Intype;

@Repository
public interface IntypeDao {
	
	//查看入库类型
	public List<Intype> findIntype() throws Exception;
	
	//根据id查询入库类型
	public Intype findIntypeById(Integer id) throws Exception;
	
	//增加入库类型
	public void addIntype(Intype intype) throws Exception;
	
	//修改入库类型
	public void updateIntypeById(Intype intype) throws Exception;
	
	//删除入库类型
	public void deleteIntypeById(Integer id) throws Exception; 
	
	//通过入库类型查询入库信息
	public List<Inquiry> findInquiryByIntype(String name) throws Exception;
	
	//查看所有入库信息
	public List<Inquiry> findInquiry() throws Exception;
	
	//根据id查询入库信息
	public Inquiry findInquiryById(Integer id) throws Exception;
	
	//修改入库信息
	public void updateInquiryById(Inquiry inquiry) throws Exception;
	
	//增加入库信息
	public void addInquiry(Inquiry inquiry) throws Exception;
	
	//删除入库信息
	public void deleteInquiryById(Integer id) throws Exception;
}
