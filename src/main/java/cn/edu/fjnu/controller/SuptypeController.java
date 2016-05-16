package cn.edu.fjnu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;
import cn.edu.fjnu.entity.Suptype;
import cn.edu.fjnu.entity.Manager;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.entity.Supplier;
import cn.edu.fjnu.service.SuptypeService;

@Controller
public class SuptypeController {
	private static Logger log=(Logger) LoggerFactory.getLogger(SuptypeController.class);

	@Autowired
	private SuptypeService service;
	
	//查看供应商类型
	@RequestMapping("findSuptype")
	@RequiresPermissions("5")
	public String findSuptype(HttpServletRequest request,Integer pageNo) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"查看供应商类型");
		
		
		PageResult<Suptype> pageList=service.findSuptype(pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Suptype> suptypeList = pageList.getDataList();
		request.setAttribute("suptypeList", suptypeList);
		return "suptype/suptypeList";
	}
	
	//修改供应商类型
	@RequestMapping("updateSuptype")
	@RequiresPermissions("5")
	public String updateSuptype(HttpServletRequest request,Integer id) throws Exception{
		Suptype suptype=service.findSuptypeById(id);
		request.setAttribute("suptype", suptype);
		return "suptype/updateSuptype";
	}
	
	//修改提交
	@RequestMapping("updateSuptypeSubmit")
	@RequiresPermissions("5")
	public String updateSuptypeSubmit(HttpServletRequest request,Suptype Suptype) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"修改供应商类型。修改前："+service.findSuptypeById(Suptype.getId()).toString()+"修改后："+Suptype.toString());
		
		
		service.updateSuptypeById(Suptype);
		return "suptype/success";
	}
	
	//增加供应商类型
	@RequestMapping("addSuptype")
	@RequiresPermissions("5")
	public String addSuptype() throws Exception{
		return "suptype/addSuptype";
	}
	
	//增加提交
	@RequestMapping("addSuptypeSubmit")
	@RequiresPermissions("5")
	public String addSuptypeSubmit(HttpServletRequest request,Suptype Suptype) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"增加供应商类型。"+Suptype.toString());
		
		
		service.addSuptype(Suptype);
		return "suptype/success";
	}
	
	//删除供应商类型
	@RequestMapping("deleteSuptype")
	@RequiresPermissions("5")
	public String deleteSuptype(HttpServletRequest request,Integer id) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"删除供应商类型。："+service.findSuptypeById(id));
		
		
		service.deleteSuptypeById(id);
		return "suptype/success";
	}
	
	//查看所有供应商信息
	@RequestMapping("findSupplier")
	@RequiresPermissions("5")
	public String findSupplier(HttpServletRequest request,Integer pageNo) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"查看所有供应商信息");
		
		
		PageResult<Supplier> pageList=service.findSupplier(pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Supplier> supplierList=pageList.getDataList();
		request.setAttribute("supplierList", supplierList);
		return "suptype/supplier";
	}

	//根据供应商类型查看供应商信息
	@RequestMapping("findSupplierBySuptype")
	@RequiresPermissions("5")
	public String findSupplierBySuptype(HttpServletRequest request,String name,Integer pageNo) throws Exception{
		try{
			name=new String(name.getBytes("ISO-8859-1"),"utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"根据供应商类型"+name+"查看供应商信息");
		
		
		PageResult<Supplier> pageList=service.findSupplierBySuptype(name, pageNo, 10);
		request.setAttribute("pageList", pageList);
		request.setAttribute("name", name);
		List<Supplier> supplierList=pageList.getDataList();
		request.setAttribute("supplierList", supplierList);
		return "suptype/supplierBySuptype";
	}
	
	//修改供应商
	@RequestMapping("updateSupplier")
	@RequiresPermissions("5")
	public String updateSupplier(HttpServletRequest request,Integer id) throws Exception{
		Supplier supplier=service.findSupplierById(id);
		request.setAttribute("supplier", supplier);
		return "suptype/updateSupplier";
	}
		
	//修改提交
	@RequestMapping("updateSupplierSubmit")
	@RequiresPermissions("5")
	public String updateSupplierSubmit(HttpServletRequest request,Supplier Supplier) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"修改供应商。修改前："+service.findSupplierById(Supplier.getId()).toString()+"修改后："+Supplier.toString());
		
		
		service.updateSupplierById(Supplier);
		return "suptype/success";
	}
	
	//增加供应商
	@RequestMapping("addSupplier")
	@RequiresPermissions("5")
	public String addSupplier() throws Exception{
		return "suptype/addSupplier";
	}
	
	//增加提交
	@RequestMapping("addSupplierSubmit")
	@RequiresPermissions("5")
	public String addSupplierSubmit(HttpServletRequest request,Supplier Supplier) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"增加供应商："+Supplier.toString());
		
		
		service.addSupplier(Supplier);
		return "suptype/success";
	}
	
	
	//删除供应商
	@RequestMapping("deleteSupplier")
	@RequiresPermissions("5")
	public String deleteSupplier(HttpServletRequest request,Integer id) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"删除供应商："+service.findSupplierById(id));
		
		
		service.deleteSupplierById(id);
		return "suptype/success";
	}
	

		
	
	
	
}
