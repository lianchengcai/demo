package cn.edu.fjnu.service;

import java.util.List;

import cn.edu.fjnu.entity.Dept;
import cn.edu.fjnu.entity.Employee;
import cn.edu.fjnu.entity.PageResult;

public interface DeptService {

	//查看部门
	PageResult<Dept> findDept(Integer pageNo,Integer pageSize) throws Exception;
	
	//根据id查询部门
	public Dept findDeptById(Integer id) throws Exception;
		
	//增加部门
	public void addDept(Dept dept) throws Exception;
		
	//修改部门
	public void updateDeptById(Dept dept) throws Exception;
		
	//删除部门
	public void deleteDeptById(Integer id) throws Exception; 
	
	//通过部门名称查询部门员工
	public PageResult<Employee> findEmployeeByDeptName(String name,Integer pageNo,Integer pageSize) throws Exception;
	
	//查看所有员工信息
	public PageResult<Employee> findEmployee(Integer pageNo,Integer pageSize) throws Exception;
	
	//根据id查询员工
	public Employee findEmployeeById(Integer id) throws Exception;
	
	//修改员工
	public void updateEmployeeById(Employee employee) throws Exception;
	
	//增加员工
	public void addEmployee(Employee employee) throws Exception;
	
	//删除员工
	public void deleteEmployeeById(Integer id) throws Exception;
}
