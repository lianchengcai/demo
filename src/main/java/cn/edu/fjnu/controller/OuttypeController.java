package cn.edu.fjnu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;
import cn.edu.fjnu.entity.Outtype;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.entity.Manager;
import cn.edu.fjnu.entity.Outstock;
import cn.edu.fjnu.service.OuttypeService;
import cn.edu.fjnu.validator.ValidGroup1;

@Controller
public class OuttypeController {
	private static Logger log=(Logger) LoggerFactory.getLogger(OuttypeController.class);

	@Autowired
	private OuttypeService service;
	
	//查看出库类型
	@RequestMapping("findOuttype")
	@RequiresPermissions("4")
	public String findOuttype(HttpServletRequest request,Integer pageNo) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"查看出库类型");
		
		
		PageResult<Outtype> pageList=service.findOuttype(pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Outtype> outtypeList = pageList.getDataList();
		request.setAttribute("outtypeList", outtypeList);
		return "outtype/outtypeList";
	}
	
	//修改出库类型
	@RequestMapping("updateOuttype")
	@RequiresPermissions("4")
	public String updateOuttype(HttpServletRequest request,Integer id) throws Exception{
		
		
		Outtype outtype=service.findOuttypeById(id);
		request.setAttribute("outtype", outtype);
		return "outtype/updateOuttype";
	}
	
	//修改提交
	@RequestMapping("updateOuttypeSubmit")
	@RequiresPermissions("4")
	public String updateOuttypeSubmit(HttpServletRequest request,Outtype Outtype) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"修改出库类型。修改前："+service.findOuttypeById(Outtype.getId()).toString()+"修改后："+Outtype.toString());
		
		
		service.updateOuttypeById(Outtype);
		return "outtype/success";
	}
	
	//增加出库类型
	@RequestMapping("addOuttype")
	@RequiresPermissions("4")
	public String addOuttype() throws Exception{
		return "outtype/addOuttype";
	}
	
	//增加提交
	@RequestMapping("addOuttypeSubmit")
	@RequiresPermissions("4")
	public String addOuttypeSubmit(HttpServletRequest request,@Validated(value=ValidGroup1.class) Outtype Outtype,BindingResult bindingResult) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"增加出库类型:"+Outtype.toString());
		
		
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			request.setAttribute("allErrors", allErrors);
			return "core/inquiryList";
		}
		service.addOuttype(Outtype);
		return "outtype/success";
	}
	
	//删除出库类型
	@RequestMapping("deleteOuttype")
	@RequiresPermissions("4")
	public String deleteOuttype(HttpServletRequest request,Integer id) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"删除出库类型："+service.findOuttypeById(id).toString());
		
		
		service.deleteOuttypeById(id);
		return "outtype/success";
	}
	
	//查看所有出库信息
	@RequestMapping("findOutstock")
	@RequiresPermissions("4")
	public String findOutstock(HttpServletRequest request,Integer pageNo) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"查看所有出库信息");
		
		
		PageResult<Outstock> pageList=service.findOutstock(pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Outstock> outstockList=pageList.getDataList();
		request.setAttribute("outstockList", outstockList);
		return "outtype/outstock";
	}

	//根据出库类型查看出库信息
	@RequestMapping("findOutstockByOuttype")
	@RequiresPermissions("4")
	public String findOutstockByOuttype(HttpServletRequest request,String name,Integer pageNo) throws Exception{
		try{
			name=new String(name.getBytes("ISO-8859-1"),"utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"根据"+name+"出库类型查看出库信息");
		
		
		PageResult<Outstock> pageList=service.findOutstockByOuttype(name, pageNo, 10);
		request.setAttribute("pageList", pageList);
		request.setAttribute("name", name);
		List<Outstock> outstockList=pageList.getDataList();
		request.setAttribute("outstockList", outstockList);
		return "outtype/outstockByOuttype";
	}
	
	//修改出库信息
	@RequestMapping("updateOutstock")
	@RequiresPermissions("4")
	public String updateOutstock(HttpServletRequest request,Integer id) throws Exception{
		Outstock outstock=service.findOutstockById(id);
		request.setAttribute("outstock", outstock);
		return "outtype/updateOutstock";
	}
		
	//修改提交
	@RequestMapping("updateOutstockSubmit")
	@RequiresPermissions("4")
	public String updateOutstockSubmit(HttpServletRequest request,Outstock outstock) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"修改出库信息。修改前："+service.findOutstockById(outstock.getId()).toString()+"修改后："+outstock.toString());
		
		
		service.updateOutstockById(outstock);
		return "outtype/success";
	}
	
	//增加出库信息
	@RequestMapping("addOutstock")
	@RequiresPermissions("4")
	public String addOutstock() throws Exception{
		
		
		return "outtype/addOutstock";
	}
	
	//增加提交
	@RequestMapping("addOutstockSubmit")
	@RequiresPermissions("4")
	public String addOutstockSubmit(HttpServletRequest request,Outstock Outstock) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"增加出库信息:"+Outstock.toString());
		
		
		service.addOutstock(Outstock);
		return "outtype/success";
	}
	
	
	//删除出库信息
	@RequestMapping("deleteOutstock")
	@RequiresPermissions("4")
	public String deleteOutstock(HttpServletRequest request,Integer id) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"删除出库信息："+service.findOutstockById(id).toString());
		
		
		service.deleteOutstockById(id);
		return "outtype/success";
	}
	

		
	
	
	
}
