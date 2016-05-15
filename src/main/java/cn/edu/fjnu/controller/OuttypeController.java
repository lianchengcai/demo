package cn.edu.fjnu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.fjnu.entity.Outtype;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.entity.Outstock;
import cn.edu.fjnu.service.OuttypeService;
import cn.edu.fjnu.validator.ValidGroup1;

@Controller
public class OuttypeController {
	
	@Autowired
	private OuttypeService service;
	
	//查看出库类型
	@RequestMapping("findOuttype")
	public String findOuttype(HttpServletRequest request,Integer pageNo) throws Exception{
		PageResult<Outtype> pageList=service.findOuttype(pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Outtype> outtypeList = pageList.getDataList();
		request.setAttribute("outtypeList", outtypeList);
		return "outtype/outtypeList";
	}
	
	//修改出库类型
	@RequestMapping("updateOuttype")
	public String updateOuttype(HttpServletRequest request,Integer id) throws Exception{
		Outtype outtype=service.findOuttypeById(id);
		request.setAttribute("outtype", outtype);
		return "outtype/updateOuttype";
	}
	
	//修改提交
	@RequestMapping("updateOuttypeSubmit")
	public String updateOuttypeSubmit(HttpServletRequest request,Outtype Outtype) throws Exception{
		service.updateOuttypeById(Outtype);
		return "outtype/success";
	}
	
	//增加出库类型
	@RequestMapping("addOuttype")
	public String addOuttype() throws Exception{
		return "outtype/addOuttype";
	}
	
	//增加提交
	@RequestMapping("addOuttypeSubmit")
	public String addOuttypeSubmit(HttpServletRequest request,@Validated(value=ValidGroup1.class) Outtype Outtype,BindingResult bindingResult) throws Exception{
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
	public String deleteOuttype(Integer id) throws Exception{
		service.deleteOuttypeById(id);
		return "outtype/success";
	}
	
	//查看所有出库信息
	@RequestMapping("findOutstock")
	public String findOutstock(HttpServletRequest request,Integer pageNo) throws Exception{
		PageResult<Outstock> pageList=service.findOutstock(pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Outstock> outstockList=pageList.getDataList();
		request.setAttribute("outstockList", outstockList);
		return "outtype/outstock";
	}

	//根据出库类型查看出库信息
	@RequestMapping("findOutstockByOuttype")
	public String findOutstockByOuttype(HttpServletRequest request,String name,Integer pageNo) throws Exception{
		try{
			name=new String(name.getBytes("ISO-8859-1"),"utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		PageResult<Outstock> pageList=service.findOutstockByOuttype(name, pageNo, 10);
		request.setAttribute("pageList", pageList);
		request.setAttribute("name", name);
		List<Outstock> outstockList=pageList.getDataList();
		request.setAttribute("outstockList", outstockList);
		return "outtype/outstockByOuttype";
	}
	
	//修改出库信息
	@RequestMapping("updateOutstock")
	public String updateOutstock(HttpServletRequest request,Integer id) throws Exception{
		Outstock outstock=service.findOutstockById(id);
		request.setAttribute("outstock", outstock);
		return "outtype/updateOutstock";
	}
		
	//修改提交
	@RequestMapping("updateOutstockSubmit")
	public String updateOutstockSubmit(HttpServletRequest request,Outstock outstock) throws Exception{
		service.updateOutstockById(outstock);
		return "outtype/success";
	}
	
	//增加出库信息
	@RequestMapping("addOutstock")
	public String addOutstock() throws Exception{
		return "outtype/addOutstock";
	}
	
	//增加提交
	@RequestMapping("addOutstockSubmit")
	public String addOutstockSubmit(Outstock Outstock) throws Exception{
		service.addOutstock(Outstock);
		return "outtype/success";
	}
	
	
	//删除出库信息
	@RequestMapping("deleteOutstock")
	public String deleteOutstock(Integer id) throws Exception{
		service.deleteOutstockById(id);
		return "outtype/success";
	}
	

		
	
	
	
}
