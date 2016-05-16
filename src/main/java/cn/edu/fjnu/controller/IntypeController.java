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
import cn.edu.fjnu.entity.Intype;
import cn.edu.fjnu.entity.Manager;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.entity.Inquiry;
import cn.edu.fjnu.service.IntypeService;
import cn.edu.fjnu.validator.ValidGroup1;

@Controller
public class IntypeController {
	private static Logger log=(Logger) LoggerFactory.getLogger(IntypeController.class);

	@Autowired
	private IntypeService service;
	
	//查看入库类型
	@RequestMapping("findIntype")
	@RequiresPermissions("3")
	public String findIntype(HttpServletRequest request,Integer pageNo) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String id = manager.getId();
		log.info("账号："+id+"查看入库类型");
		
		PageResult<Intype> pageList=service.findIntype(pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Intype> intypeList = pageList.getDataList();
		request.setAttribute("intypeList", intypeList);
		return "intype/intypeList";
	}
	
	//修改入库类型
	@RequestMapping("updateIntype")
	@RequiresPermissions("3")
	public String updateIntype(HttpServletRequest request,Integer id) throws Exception{
		Intype intype=service.findIntypeById(id);
		request.setAttribute("intype", intype);
		return "intype/updateIntype";
	}
	
	//修改提交
	@RequestMapping("updateIntypeSubmit")
	@RequiresPermissions("3")
	public String updateIntypeSubmit(HttpServletRequest request,Intype Intype) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String id = manager.getId();
		log.info("账号："+id+"修改入库类型。修改前："+service.findIntypeById(Intype.getId()).toString()+";修改后："+Intype.toString());
		
		service.updateIntypeById(Intype);
		return "intype/success";
	}
	
	//增加入库类型
	@RequestMapping("addIntype")
	@RequiresPermissions("3")
	public String addIntype() throws Exception{
		return "intype/addIntype";
	}
	
	//增加提交
	@RequestMapping("addIntypeSubmit")
	@RequiresPermissions("3")
	public String addIntypeSubmit(HttpServletRequest request,Intype Intype) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String id = manager.getId();
		log.info("账号："+id+"增加入库类型。增加的信息为："+Intype.toString());
		
		
		service.addIntype(Intype);
		return "intype/success";
	}
	
	//删除入库类型
	@RequestMapping("deleteIntype")
	@RequiresPermissions("3")
	public String deleteIntype(HttpServletRequest request,Integer id) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"删除入库类型。删除的信息为："+service.findIntypeById(id).toString());
		
		service.deleteIntypeById(id);
		return "intype/success";
	}
	
	//查看所有入库信息
	@RequestMapping("findInquiry")
	@RequiresPermissions("3")
	public String findInquiry(HttpServletRequest request,Integer pageNo) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"查看所有入库信息");
		
		
		PageResult<Inquiry> pageList=service.findInquiry(pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Inquiry> inquiryList=pageList.getDataList();
		request.setAttribute("inquiryList", inquiryList);
		return "intype/inquiry";
	}

	//根据入库类型查看入库信息
	@RequestMapping("findInquiryByIntype")
	@RequiresPermissions("3")
	public String findInquiryByIntype(HttpServletRequest request,String name,Integer pageNo) throws Exception{
		try{
			name=new String(name.getBytes("ISO-8859-1"),"utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"查看"+name+"类型的入库信息");
		
		
		PageResult<Inquiry> pageList=service.findInquiryByIntype(name, pageNo, 10);
		request.setAttribute("pageList", pageList);
		request.setAttribute("name", name);
		List<Inquiry> inquiryList=pageList.getDataList();
		request.setAttribute("inquiryList", inquiryList);
		return "intype/inquiryByIntype";
	}
	
	//修改入库信息
	@RequestMapping("updateInquiry")
	@RequiresPermissions("3")
	public String updateInquiry(HttpServletRequest request,Integer id) throws Exception{
		Inquiry inquiry=service.findInquiryById(id);
		request.setAttribute("inquiry", inquiry);
		return "intype/updateInquiry";
	}
		
	//修改提交
	@RequestMapping("updateInquirySubmit")
	@RequiresPermissions("3")
	public String updateInquirySubmit(HttpServletRequest request,Inquiry Inquiry) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String id = manager.getId();
		log.info("账号："+id+"修改入库信息。修改前："+service.findInquiryById(Inquiry.getId()).toString()+";修改后："+Inquiry.toString());
		
		
		service.updateInquiryById(Inquiry);
		return "intype/success";
	}
	
	//增加入库信息
	@RequestMapping("addInquiry")
	@RequiresPermissions("3")
	public String addInquiry() throws Exception{
		return "intype/addInquiry";
	}
	
	//增加提交
	@RequestMapping("addInquirySubmit")
	@RequiresPermissions("3")
	public String addInquirySubmit(HttpServletRequest request,@Validated(ValidGroup1.class) Inquiry inquiry,BindingResult bindingResult) throws Exception{
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			request.setAttribute("allErrors", allErrors);
			request.setAttribute("inquiry", inquiry);
			return "intype/addInquiry";
		}
		
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"增加入库信息。"+inquiry.toString());
		
		service.addInquiry(inquiry);
		return "intype/success";
	}
	
	
	//删除入库信息
	@RequestMapping("deleteInquiry")
	@RequiresPermissions("3")
	public String deleteInquiry(HttpServletRequest request,Integer id) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"删除入库信息。"+service.findInquiryById(id).toString());
		
		service.deleteInquiryById(id);
		return "intype/success";
	}
	

		
	
	
	
}
