package cn.edu.fjnu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.edu.fjnu.dao.CoreDao;
import cn.edu.fjnu.entity.Inquiry;
import cn.edu.fjnu.entity.Items;
import cn.edu.fjnu.entity.Outstock;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.entity.Supply;
import cn.edu.fjnu.service.CoreService;
import cn.edu.fjnu.util.BeanUtil;

@Service
public class CoreServiceImpl implements CoreService{

	@Autowired
	private CoreDao dao;
	
	@Override
	public PageResult<Outstock> findDeptByDate(Outstock outstock,Integer pageNo,Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findDeptByDate(outstock));
	}

	@Override
	public PageResult<Inquiry> findInquiryByDate(Inquiry inquiry,Integer pageNo,Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findInquiryByDate(inquiry));
	}

	@Override
	public PageResult<Items> findItemsByLimit(Integer pageNo,Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findItemsByLimit());
	}

	@Override
	public PageResult<Supply> findSupplyByDate(Supply supply,Integer pageNo,Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findSupplyByDate(supply));
	}

	

}
