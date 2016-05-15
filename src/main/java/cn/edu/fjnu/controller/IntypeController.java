package cn.edu.fjnu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.fjnu.entity.Intype;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.entity.Inquiry;
import cn.edu.fjnu.service.IntypeService;
import cn.edu.fjnu.validator.ValidGroup1;

@Controller
public class IntypeController {
	
	@Autowired
	private IntypeService service;
	
	//查看入库类型
	@RequestMapping("findIntype")
	public String findIntype(HttpServletRequest request,Integer pageNo) throws Exception{
		PageResult<Intype> pageList=service.findIntype(pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Intype> intypeList = pageList.getDataList();
		request.setAttribute("intypeList", intypeList);
		return "intype/intypeList";
	}
	
	//修改入库类型
	@RequestMapping("updateIntype")
	public String updateIntype(HttpServletRequest request,Integer id) throws Exception{
		Intype intype=service.findIntypeById(id);
		request.setAttribute("intype", intype);
		return "intype/updateIntype";
	}
	
	//修改提交
	@RequestMapping("updateIntypeSubmit")
	public String updateIntypeSubmit(HttpServletRequest request,Intype Intype) throws Exception{
		service.updateIntypeById(Intype);
		return "intype/success";
	}
	
	//增加入库类型
	@RequestMapping("addIntype")
	public String addIntype() throws Exception{
		return "intype/addIntype";
	}
	
	//增加提交
	@RequestMapping("addIntypeSubmit")
	public String addIntypeSubmit(Intype Intype) throws Exception{
		service.addIntype(Intype);
		return "intype/success";
	}
	
	//删除入库类型
	@RequestMapping("deleteIntype")
	public String deleteIntype(Integer id) throws Exception{
		service.deleteIntypeById(id);
		return "intype/success";
	}
	
	//查看所有入库信息
	@RequestMapping("findInquiry")
	public String findInquiry(HttpServletRequest request,Integer pageNo) throws Exception{
		PageResult<Inquiry> pageList=service.findInquiry(pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Inquiry> inquiryList=pageList.getDataList();
		request.setAttribute("inquiryList", inquiryList);
		return "intype/inquiry";
	}

	//根据入库类型查看入库信息
	@RequestMapping("findInquiryByIntype")
	public String findInquiryByIntype(HttpServletRequest request,String name,Integer pageNo) throws Exception{
		try{
			name=new String(name.getBytes("ISO-8859-1"),"utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		PageResult<Inquiry> pageList=service.findInquiryByIntype(name, pageNo, 10);
		request.setAttribute("pageList", pageList);
		request.setAttribute("name", name);
		List<Inquiry> inquiryList=pageList.getDataList();
		request.setAttribute("inquiryList", inquiryList);
		return "intype/inquiryByIntype";
	}
	
	//修改入库信息
	@RequestMapping("updateInquiry")
	public String updateInquiry(HttpServletRequest request,Integer id) throws Exception{
		Inquiry inquiry=service.findInquiryById(id);
		request.setAttribute("inquiry", inquiry);
		return "intype/updateInquiry";
	}
		
	//修改提交
	@RequestMapping("updateInquirySubmit")
	public String updateInquirySubmit(HttpServletRequest request,Inquiry Inquiry) throws Exception{
		service.updateInquiryById(Inquiry);
		return "intype/success";
	}
	
	//增加入库信息
	@RequestMapping("addInquiry")
	public String addInquiry() throws Exception{
		return "intype/addInquiry";
	}
	
	//增加提交
	@RequestMapping("addInquirySubmit")
	public String addInquirySubmit(HttpServletRequest request,@Validated(ValidGroup1.class) Inquiry inquiry,BindingResult bindingResult) throws Exception{
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			request.setAttribute("allErrors", allErrors);
			request.setAttribute("inquiry", inquiry);
			return "intype/addInquiry";
		}
		service.addInquiry(inquiry);
		return "intype/success";
	}
	
	
	//删除入库信息
	@RequestMapping("deleteInquiry")
	public String deleteInquiry(Integer id) throws Exception{
		service.deleteInquiryById(id);
		return "intype/success";
	}
	

		
	
	
	
}
