package cn.edu.fjnu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.fjnu.entity.Inquiry;
import cn.edu.fjnu.entity.Items;
import cn.edu.fjnu.entity.Outstock;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.entity.Supply;
import cn.edu.fjnu.service.CoreService;
import cn.edu.fjnu.validator.ValidGroup2;

@Controller
public class CoreController {

	@Autowired
	private CoreService service;
	
	//查询领用部门、领用人、出库情况
	@RequestMapping("findDeptByDate")
	private String findDeptByDate(HttpServletRequest request,@Validated(value=ValidGroup2.class) Outstock outstock,BindingResult bindingResult,Integer pageNo) throws Exception{
		PageResult<Outstock> pageList=service.findDeptByDate(outstock, pageNo, 10);
		request.setAttribute("pageList", pageList);//页面参数
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			request.setAttribute("allErrors", allErrors);
			return "core/deptList";
		}
		request.setAttribute("outstock", outstock);//查询条件
		List<Outstock> deptList=pageList.getDataList();
		request.setAttribute("deptList", deptList);
		return "core/deptList";
	}
	
	//查询领用人
	@RequestMapping("findReceiverByDate")
	private String findReceiverByDate(HttpServletRequest request,@Validated(value=ValidGroup2.class) Outstock outstock,BindingResult bindingResult,Integer pageNo) throws Exception{
		PageResult<Outstock> pageList=service.findDeptByDate(outstock, pageNo, 10);
		request.setAttribute("pageList", pageList);
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			request.setAttribute("allErrors", allErrors);
			return "core/receiverList";
		}
		request.setAttribute("outstock", outstock);//查询条件
		List<Outstock> receiverList=pageList.getDataList();
		request.setAttribute("receiverList", receiverList);
		return "core/receiverList";
	}
	
	//查询出库情况
	@RequestMapping("findOutstockByDate")
	private String findOutstockByDate(HttpServletRequest request,@Validated(value=ValidGroup2.class) Outstock outstock,BindingResult bindingResult,Integer pageNo) throws Exception{
		PageResult<Outstock> pageList=service.findDeptByDate(outstock, pageNo, 10);
		request.setAttribute("pageList", pageList);
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			request.setAttribute("allErrors", allErrors);
			return "core/outstockList";
		}
		request.setAttribute("outstock", outstock);//查询条件
		List<Outstock> outstockList=pageList.getDataList();
		request.setAttribute("outstockList", outstockList);
		return "core/outstockList";
	}
	
	//查询入库情况
	@RequestMapping("findInquiryByDate")
	private String findInquiryByDate(HttpServletRequest request,@Validated(value=ValidGroup2.class) Inquiry inquiry,BindingResult bindingResult,Integer pageNo) throws Exception{
		PageResult<Inquiry> pageList=service.findInquiryByDate(inquiry, pageNo, 10);
		request.setAttribute("pageList", pageList);
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			request.setAttribute("allErrors", allErrors);
			return "core/inquiryList";
		}
		request.setAttribute("inquiry", inquiry);//查询条件
		List<Inquiry> inquiryList=pageList.getDataList();
		request.setAttribute("inquiryList", inquiryList);
		return "core/inquiryList";
	}
	
	//查询超限
	@RequestMapping("findItemsByLimit")
	public String findItemsByLimit(HttpServletRequest request,Integer pageNo) throws Exception{
		PageResult<Items> pageList=service.findItemsByLimit(pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Items> itemsList = pageList.getDataList();
		request.setAttribute("itemsList", itemsList);
		return "core/itemsList";
	}
	
	//查询供货情况
	@RequestMapping("findSupplyByDate")
	public String findSupplyByDate(HttpServletRequest request,@Validated(value=ValidGroup2.class) Supply supply,BindingResult bindingResult,Integer pageNo) throws Exception{
		PageResult<Supply> pageList=service.findSupplyByDate(supply, pageNo, 10);
		request.setAttribute("pageList", pageList);
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			request.setAttribute("allErrors", allErrors);
			return "core/supplyList";
		}
		request.setAttribute("supply", supply);//查询条件
		List<Supply> supplyList=pageList.getDataList();
		request.setAttribute("supplyList", supplyList);
		return "core/supplyList";
	}
}
