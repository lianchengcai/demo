package cn.edu.fjnu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.fjnu.entity.Dept;
import cn.edu.fjnu.entity.Employee;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.service.DeptService;

@Controller
public class DeptController {
	
	@Autowired
	private DeptService service;
	
	//查看部门
	@RequestMapping("findDept")
	public String findDept(HttpServletRequest request,Integer pageNo) throws Exception{
		PageResult<Dept> pageList=service.findDept(pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Dept> deptList = pageList.getDataList();
		request.setAttribute("deptList", deptList);
		return "dept/deptList";
	}
	
	//修改部门
	@RequestMapping("updateDept")
	public String updateDept(HttpServletRequest request,Integer id) throws Exception{
		Dept dept=service.findDeptById(id);
		request.setAttribute("dept", dept);
		return "dept/updateDept";
	}
	
	//修改提交
	@RequestMapping("updateDeptSubmit")
	public String updateDeptSubmit(HttpServletRequest request,Dept dept) throws Exception{
		service.updateDeptById(dept);
		return "dept/success";
	}
	
	//增加部门
	@RequestMapping("addDept")
	public String addDept() throws Exception{
		return "dept/addDept";
	}
	
	//增加提交
	@RequestMapping("addDeptSubmit")
	public String addDeptSubmit(Dept dept) throws Exception{
		service.addDept(dept);
		return "dept/success";
	}
	
	//删除部门
	@RequestMapping("deleteDept")
	public String deleteDept(Integer id) throws Exception{
		service.deleteDeptById(id);
		return "dept/success";
	}
	
	//查看所有员工信息
	@RequestMapping("findEmployee")
	public String findEmployee(HttpServletRequest request,Integer pageNo) throws Exception{
		PageResult<Employee> pageList=service.findEmployee(pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Employee> employeeList=pageList.getDataList();
		request.setAttribute("employeeList", employeeList);
		return "dept/employee";
	}

	//根据部门名称查看部门员工
	@RequestMapping("findEmployeeByDeptName")
	public String findEmployeeByDeptName(HttpServletRequest request,String name,Integer pageNo) throws Exception{
		try{
			name=new String(name.getBytes("ISO-8859-1"),"utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		PageResult<Employee> pageList=service.findEmployeeByDeptName(name, pageNo, 10);
		request.setAttribute("pageList", pageList);
		request.setAttribute("name", name);
		List<Employee> employeeList=pageList.getDataList();
		request.setAttribute("employeeList", employeeList);
		return "dept/employeeByDeptName";
	}
	
	//修改员工
	@RequestMapping("updateEmployee")
	public String updateEmployee(HttpServletRequest request,Integer id) throws Exception{
		Employee employee=service.findEmployeeById(id);
		request.setAttribute("employee", employee);
		return "dept/updateEmployee";
	}
		
	//修改提交
	@RequestMapping("updateEmployeeSubmit")
	public String updateEmployeeSubmit(HttpServletRequest request,Employee employee) throws Exception{
		service.updateEmployeeById(employee);
		return "dept/success";
	}
	
	//增加员工
	@RequestMapping("addEmployee")
	public String addEmployee() throws Exception{
		return "dept/addEmployee";
	}
	
	//增加提交
	@RequestMapping("addEmployeeSubmit")
	public String addEmployeeSubmit(Employee employee) throws Exception{
		service.addEmployee(employee);
		return "dept/success";
	}
	
	
	//删除员工
	@RequestMapping("deleteEmployee")
	public String deleteEmployee(Integer id) throws Exception{
		service.deleteEmployeeById(id);
		return "dept/success";
	}
	

		
	
	
	
}
