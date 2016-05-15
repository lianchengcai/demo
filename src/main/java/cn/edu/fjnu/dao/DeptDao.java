package cn.edu.fjnu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.fjnu.entity.Dept;
import cn.edu.fjnu.entity.Employee;

@Repository
public interface DeptDao {
	
	//查看部门
	public List<Dept> findDept() throws Exception;
	
	//根据id查询部门
	public Dept findDeptById(Integer id) throws Exception;
	
	//增加部门
	public void addDept(Dept dept) throws Exception;
	
	//修改部门
	public void updateDeptById(Dept dept) throws Exception;
	
	//删除部门
	public void deleteDeptById(Integer id) throws Exception; 
	
	//通过部门名称查询部门员工
	public List<Employee> findEmployeeByDeptName(String name) throws Exception;
	
	//查看所有员工信息
	public List<Employee> findEmployee() throws Exception;
	
	//根据id查询员工
	public Employee findEmployeeById(Integer id) throws Exception;
	
	//修改员工
	public void updateEmployeeById(Employee employee) throws Exception;
	
	//增加员工
	public void addEmployee(Employee employee) throws Exception;
	
	//删除员工
	public void deleteEmployeeById(Integer id) throws Exception;
}
