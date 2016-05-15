package cn.edu.fjnu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.fjnu.dao.OuttypeDao;
import cn.edu.fjnu.entity.Outstock;
import cn.edu.fjnu.entity.Outtype;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.service.OuttypeService;
import cn.edu.fjnu.util.BeanUtil;

@Service
public class OuttypeServiceImpl implements OuttypeService{

	@Autowired
	private OuttypeDao dao;
	
	@Override
	public PageResult<Outtype> findOuttype(Integer pageNo,Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findOuttype());
	}

	@Override
	public Outtype findOuttypeById(Integer id) throws Exception {
		return dao.findOuttypeById(id);
	}

	@Override
	public void addOuttype(Outtype outtype) throws Exception {
		dao.addOuttype(outtype);
	}

	@Override
	public void updateOuttypeById(Outtype outtype) throws Exception {
		dao.updateOuttypeById(outtype);
	}

	@Override
	public void deleteOuttypeById(Integer id) throws Exception {
		dao.deleteOuttypeById(id);
	}

	@Override
	public PageResult<Outstock> findOutstockByOuttype(String name,Integer pageNo,Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findOutstockByOuttype(name));
	}

	@Override
	public PageResult<Outstock> findOutstock(Integer pageNo,Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findOutstock());
	}

	@Override
	public Outstock findOutstockById(Integer id) throws Exception {
		return dao.findOutstockById(id);
	}

	@Override
	public void updateOutstockById(Outstock outstock) throws Exception {
		dao.updateOutstockById(outstock);
	}

	@Override
	public void addOutstock(Outstock outstock) throws Exception {
		dao.addOutstock(outstock);
	}

	@Override
	public void deleteOutstockById(Integer id) throws Exception {
		dao.deleteOutstockById(id);
	}

}
