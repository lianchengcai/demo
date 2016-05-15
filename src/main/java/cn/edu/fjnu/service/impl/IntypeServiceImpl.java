package cn.edu.fjnu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.fjnu.dao.IntypeDao;
import cn.edu.fjnu.entity.Inquiry;
import cn.edu.fjnu.entity.Intype;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.service.IntypeService;
import cn.edu.fjnu.util.BeanUtil;

@Service
public class IntypeServiceImpl implements IntypeService{
	
	@Autowired
	private IntypeDao dao;

	@Override
	public PageResult<Intype> findIntype(Integer pageNo,Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findIntype());
	}

	@Override
	public Intype findIntypeById(Integer id) throws Exception {
		return dao.findIntypeById(id);
	}

	@Override
	public void addIntype(Intype intype) throws Exception {
		dao.addIntype(intype);
	}

	@Override
	public void updateIntypeById(Intype intype) throws Exception {
		dao.updateIntypeById(intype);
	}

	@Override
	public void deleteIntypeById(Integer id) throws Exception {
		dao.deleteIntypeById(id);
	}

	@Override
	public PageResult<Inquiry> findInquiryByIntype(String name,Integer pageNo,Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findInquiryByIntype(name));
	}

	@Override
	public PageResult<Inquiry> findInquiry(Integer pageNo,Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findInquiry());
	}

	@Override
	public Inquiry findInquiryById(Integer id) throws Exception {
		return dao.findInquiryById(id);
	}

	@Override
	public void updateInquiryById(Inquiry inquiry) throws Exception {
		dao.updateInquiryById(inquiry);
	}

	@Override
	public void addInquiry(Inquiry inquiry) throws Exception {
		dao.addInquiry(inquiry);
	}

	@Override
	public void deleteInquiryById(Integer id) throws Exception {
		dao.deleteInquiryById(id);
	}

}
