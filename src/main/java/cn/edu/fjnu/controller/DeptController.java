package cn.edu.fjnu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;
import cn.edu.fjnu.entity.Dept;
import cn.edu.fjnu.entity.Employee;
import cn.edu.fjnu.entity.Manager;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.service.DeptService;

@Controller
public class DeptController {
	private static Logger log=(Logger) LoggerFactory.getLogger(DeptController.class);

	@Autowired
	private DeptService service;
	
	//查看部门
	@RequestMapping("findDept")
	@RequiresPermissions("1")
	public String findDept(HttpServletRequest request,Integer pageNo) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String id = manager.getId();
		log.info("账号："+id+"查看部门");
		
		PageResult<Dept> pageList=service.findDept(pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Dept> deptList = pageList.getDataList();
		request.setAttribute("deptList", deptList);
		return "dept/deptList";
	}
	
	//修改部门
	@RequestMapping("updateDept")
	@RequiresPermissions("1")
	public String updateDept(HttpServletRequest request,Integer id) throws Exception{
		Dept dept=service.findDeptById(id);
		request.setAttribute("dept", dept);
		return "dept/updateDept";
	}
	
	//修改提交
	@RequestMapping("updateDeptSubmit")
	@RequiresPermissions("1")
	public String updateDeptSubmit(HttpServletRequest request,Dept dept) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String id = manager.getId();
		log.info("账号："+id+"将部门ID为："+dept.getId()+"的信息修改为："+dept.toString()+"。修改前的信息为："+service.findDeptById(dept.getId()).toString());
		
		service.updateDeptById(dept);
		return "dept/success";
	}
	
	//增加部门
	@RequestMapping("addDept")
	@RequiresPermissions("1")
	public String addDept(HttpServletRequest request) throws Exception{
		return "dept/addDept";
	}
	
	//增加提交
	@RequestMapping("addDeptSubmit")
	@RequiresPermissions("1")
	public String addDeptSubmit(Dept dept,HttpServletRequest request) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String id = manager.getId();
		log.info("账号："+id+"增加部门。增加的部门信息为："+dept.toString());
		
		service.addDept(dept);
		return "dept/success";
	}
	
	//删除部门
	@RequestMapping("deleteDept")
	@RequiresPermissions("1")
	public String deleteDept(Integer id,HttpServletRequest request) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"删除部门。删除的部门信息为："+service.findDeptById(id));
		
		service.deleteDeptById(id);
		return "dept/success";
	}
	
	//查看所有员工信息
	@RequestMapping("findEmployee")
	@RequiresPermissions("1")
	public String findEmployee(HttpServletRequest request,Integer pageNo) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String id = manager.getId();
		log.info("账号："+id+"查看所有员工信息");
		
		PageResult<Employee> pageList=service.findEmployee(pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Employee> employeeList=pageList.getDataList();
		request.setAttribute("employeeList", employeeList);
		return "dept/employee";
	}

	//根据部门名称查看部门员工
	@RequestMapping("findEmployeeByDeptName")
	@RequiresPermissions("1")
	public String findEmployeeByDeptName(HttpServletRequest request,String name,Integer pageNo) throws Exception{
		try{
			name=new String(name.getBytes("ISO-8859-1"),"utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String id = manager.getId();
		log.info("账号："+id+"查看部门:"+name+"员工");
		
		
		PageResult<Employee> pageList=service.findEmployeeByDeptName(name, pageNo, 10);
		request.setAttribute("pageList", pageList);
		request.setAttribute("name", name);
		List<Employee> employeeList=pageList.getDataList();
		request.setAttribute("employeeList", employeeList);
		return "dept/employeeByDeptName";
	}
	
	//修改员工
	@RequestMapping("updateEmployee")
	@RequiresPermissions("1")
	public String updateEmployee(HttpServletRequest request,Integer id) throws Exception{
		
		Employee employee=service.findEmployeeById(id);
		request.setAttribute("employee", employee);
		return "dept/updateEmployee";
	}
		
	//修改提交
	@RequestMapping("updateEmployeeSubmit")
	@RequiresPermissions("1")
	public String updateEmployeeSubmit(HttpServletRequest request,Employee employee) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String id = manager.getId();
		log.info("账号："+id+"将员工ID为："+employee.getId()+"的信息修改为："+employee.toString()+"。修改前的信息为："+service.findEmployeeById(employee.getId()).toString());
		
		service.updateEmployeeById(employee);
		return "dept/success";
	}
	
	//增加员工
	@RequestMapping("addEmployee")
	@RequiresPermissions("1")
	public String addEmployee(HttpServletRequest request) throws Exception{
		
		return "dept/addEmployee";
	}
	
	//增加提交
	@RequestMapping("addEmployeeSubmit")
	@RequiresPermissions("1")
	public String addEmployeeSubmit(HttpServletRequest request,Employee employee) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String id = manager.getId();
		log.info("账号："+id+"增加员工。增加的员工信息为："+employee.toString());
		
		service.addEmployee(employee);
		return "dept/success";
	}
	
	
	//删除员工
	@RequestMapping("deleteEmployee")
	@RequiresPermissions("1")
	public String deleteEmployee(HttpServletRequest request,Integer id) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"删除员工。删除的员工信息为"+service.findEmployeeById(id).toString());
		
		service.deleteEmployeeById(id);
		return "dept/success";
	}
	

		
	
	
	
}
