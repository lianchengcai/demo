package cn.edu.fjnu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;
import cn.edu.fjnu.entity.Inquiry;
import cn.edu.fjnu.entity.Items;
import cn.edu.fjnu.entity.Itemsort;
import cn.edu.fjnu.entity.Manager;
import cn.edu.fjnu.entity.Outstock;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.entity.Supply;
import cn.edu.fjnu.service.CoreService;
import cn.edu.fjnu.service.ItemsortService;
import cn.edu.fjnu.service.impl.ManagerService;
import cn.edu.fjnu.validator.ValidGroup2;

@Controller
public class ManagerController {
	private static Logger log=(Logger) LoggerFactory.getLogger(ManagerController.class);

	@Resource
	private ManagerService managerservice;

	
	@RequestMapping("findManager")
	@RequiresPermissions("6")
	public String findManager(HttpServletRequest request,Integer pageNo) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String id = manager.getId();
		log.info("账号："+id+"查看管理人员");
		
		
		PageResult<Manager> pageList = managerservice.findManager(pageNo,10);
		request.setAttribute("pageList", pageList);
		List<Manager> managerList=pageList.getDataList();
		request.setAttribute("managerList", managerList);
		return "manager/manager";
	}
	
	//修改后台管理人员
	@RequestMapping("updateManager")
	@RequiresPermissions("6")
	public String updateItemsort(HttpServletRequest request,String id,Integer pageNo) throws Exception{
		Manager manager=managerservice.findManagerById(id);
		request.setAttribute("manager", manager);
		return "manager/updateManager";
	}
	
	//修改提交
	@RequestMapping("updateManagerSubmit")
	@RequiresPermissions("6")
	public String updateManagerSubmit(HttpServletRequest request,Manager manager) throws Exception{
		Manager manager1 = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager1);
		String id = manager1.getId();
		log.info("账号："+id+"修改管理人员。修改前："+managerservice.findManagerById(manager.getId().toString())+"修改后："+manager.toString());
		
		
		managerservice.updateManager(manager);
		return "manager/success";
	}
	
	//添加
	@RequestMapping("addManager")
	@RequiresPermissions("6")
	public String addManager(HttpServletRequest request,Manager manager) throws Exception{
		return "manager/addManager";
	}
	
	//添加提交
	@RequestMapping("addManagerSubmit")
	@RequiresPermissions("6")
	public String addManagerSubmit(HttpServletRequest request,Manager manager) throws Exception{
		Manager manager1 = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager1);
		String id = manager1.getId();
		log.info("账号："+id+"添加管理人员:"+manager.toString());
		
		
		
		managerservice.addManager(manager);
		return "manager/success";
	}
	
	//删除
	@RequestMapping("deleteManager")
	@RequiresPermissions("6")
	public String deleteManager(HttpServletRequest request,String id) throws Exception{
		Manager manager1 = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager1);
		String managerid = manager1.getId();
		log.info("账号："+managerid+"删除管理人员:"+managerservice.findManagerById(id));
		
		
		managerservice.deleteManager(id);
		return "manager/success";
	}


}
