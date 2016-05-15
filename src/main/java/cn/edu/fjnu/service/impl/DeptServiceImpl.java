package cn.edu.fjnu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.mysql.jdbc.Buffer;

import cn.edu.fjnu.dao.DeptDao;
import cn.edu.fjnu.entity.Dept;
import cn.edu.fjnu.entity.Employee;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.service.DeptService;
import cn.edu.fjnu.util.BeanUtil;

@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptDao dao;

	@Override
	public PageResult<Dept> findDept(Integer pageNo,Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findDept());
	}

	@Override
	public Dept findDeptById(Integer id) throws Exception {
		return dao.findDeptById(id);
	}
	
	@Override
	public void addDept(Dept dept) throws Exception {
		dao.addDept(dept);
	}

	@Override
	public void updateDeptById(Dept dept) throws Exception {
		dao.updateDeptById(dept);
	}

	@Override
	public void deleteDeptById(Integer id) throws Exception {
		dao.deleteDeptById(id);
	}

	@Override
	public PageResult<Employee> findEmployeeByDeptName(String name,Integer pageNo,Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findEmployeeByDeptName(name));
	}
	
	@Override
	public PageResult<Employee> findEmployee(Integer pageNo,Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findEmployee());
	}

	@Override
	public Employee findEmployeeById(Integer id) throws Exception {
		return dao.findEmployeeById(id);
	}

	@Override
	public void updateEmployeeById(Employee employee) throws Exception {
		dao.updateEmployeeById(employee);
	}

	@Override
	public void addEmployee(Employee employee) throws Exception {
		dao.addEmployee(employee);
	}

	@Override
	public void deleteEmployeeById(Integer id) throws Exception {
		dao.deleteEmployeeById(id);
	}

	

	
}
