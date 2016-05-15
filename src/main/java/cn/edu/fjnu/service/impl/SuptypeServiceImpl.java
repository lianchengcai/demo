package cn.edu.fjnu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.fjnu.dao.SuptypeDao;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.entity.Supplier;
import cn.edu.fjnu.entity.Suptype;
import cn.edu.fjnu.service.SuptypeService;
import cn.edu.fjnu.util.BeanUtil;

@Service
public class SuptypeServiceImpl implements SuptypeService{

	@Autowired
	private SuptypeDao dao;
	
	@Override
	public PageResult<Suptype> findSuptype(Integer pageNo,Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findSuptype());
	}

	@Override
	public Suptype findSuptypeById(Integer id) throws Exception {
		return dao.findSuptypeById(id);
	}

	@Override
	public void addSuptype(Suptype suptype) throws Exception {
		dao.addSuptype(suptype);
	}

	@Override
	public void updateSuptypeById(Suptype suptype) throws Exception {
		dao.updateSuptypeById(suptype);
	}

	@Override
	public void deleteSuptypeById(Integer id) throws Exception {
		dao.deleteSuptypeById(id);
	}

	@Override
	public PageResult<Supplier> findSupplierBySuptype(String name,Integer pageNo,Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findSupplierBySuptype(name));
	}

	@Override
	public PageResult<Supplier> findSupplier(Integer pageNo,Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findSupplier());
	}

	@Override
	public Supplier findSupplierById(Integer id) throws Exception {
		return dao.findSupplierById(id);
	}

	@Override
	public void updateSupplierById(Supplier supplier) throws Exception {
		dao.updateSupplierById(supplier);
	}

	@Override
	public void addSupplier(Supplier supplier) throws Exception {
		dao.addSupplier(supplier);
	}

	@Override
	public void deleteSupplierById(Integer id) throws Exception {
		dao.deleteSupplierById(id);
	}

}
