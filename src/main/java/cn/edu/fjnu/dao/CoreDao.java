package cn.edu.fjnu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.fjnu.entity.Inquiry;
import cn.edu.fjnu.entity.Items;
import cn.edu.fjnu.entity.Outstock;
import cn.edu.fjnu.entity.Supply;

@Repository
public interface CoreDao {
	
	//通过日期查询领用部门、领用人、出库情况
	public List<Outstock> findDeptByDate(Outstock outstock) throws Exception;
	
	//通过日期查询入库情况
	public List<Inquiry> findInquiryByDate(Inquiry inquiry) throws Exception;
	
	//查询超限
	public List<Items> findItemsByLimit() throws Exception;
	
	//查询供货情况
	public List<Supply> findSupplyByDate(Supply supply) throws Exception;
}
