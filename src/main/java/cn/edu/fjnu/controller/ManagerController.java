package cn.edu.fjnu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.fjnu.entity.Inquiry;
import cn.edu.fjnu.entity.Items;
import cn.edu.fjnu.entity.Itemsort;
import cn.edu.fjnu.entity.Outstock;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.entity.Supply;
import cn.edu.fjnu.service.CoreService;
import cn.edu.fjnu.service.ItemsortService;
import cn.edu.fjnu.service.impl.ManagerService;
import cn.edu.fjnu.validator.ValidGroup2;

@Controller
public class ManagerController {

	@Resource
	private ManagerService managerservice;
	
	@Resource
	private ItemsortService service;
	
	@RequestMapping("findManager")
	public String findManager(HttpServletRequest request,Integer pageNo) throws Exception{
		PageResult<Itemsort> pageList = service.findItemsort(pageNo,10);
		request.setAttribute("pageList", pageList);
		List<Itemsort> itemsortList=pageList.getDataList();
		request.setAttribute("itemsortList", itemsortList);
		return "manager/manager";
	}

}
