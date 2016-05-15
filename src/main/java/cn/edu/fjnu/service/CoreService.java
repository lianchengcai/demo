package cn.edu.fjnu.service;

import java.util.List;

import cn.edu.fjnu.entity.Inquiry;
import cn.edu.fjnu.entity.Items;
import cn.edu.fjnu.entity.Outstock;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.entity.Supply;

public interface CoreService {

	//通过日期查询领用部门、领用人、出库情况
	public PageResult<Outstock> findDeptByDate(Outstock outstock,Integer pageNo,Integer pageSize) throws Exception;
	
	//通过日期查询入库情况
	public PageResult<Inquiry> findInquiryByDate(Inquiry inquiry,Integer pageNo,Integer pageSize) throws Exception;
	
	//查询超限
	public PageResult<Items> findItemsByLimit(Integer pageNo,Integer pageSize) throws Exception;

	//查询供货情况
	public PageResult<Supply> findSupplyByDate(Supply supply,Integer pageNo,Integer pageSize) throws Exception;
}
