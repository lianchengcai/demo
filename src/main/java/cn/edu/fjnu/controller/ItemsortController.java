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
import cn.edu.fjnu.entity.Dept;
import cn.edu.fjnu.entity.Employee;
import cn.edu.fjnu.entity.Items;
import cn.edu.fjnu.entity.Itemsort;
import cn.edu.fjnu.entity.Manager;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.service.DeptService;
import cn.edu.fjnu.service.ItemsortService;
import cn.edu.fjnu.validator.ValidGroup3;

@Controller

public class ItemsortController {
	private static Logger log=(Logger) LoggerFactory.getLogger(ItemsortController.class);

	@Autowired
	private ItemsortService service;
	
	//查看物品类型
	@RequestMapping("findItemsort")
	@RequiresPermissions("2")
	public String findItemsort(HttpServletRequest request,Integer pageNo) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"查看物品类型");
		
		
		PageResult<Itemsort> pageList = service.findItemsort(pageNo,10);
		request.setAttribute("pageList", pageList);
		List<Itemsort> itemsortList=pageList.getDataList();
		request.setAttribute("itemsortList", itemsortList);
		return "itemsort/itemsortList";
	}
	
	//修改物品类型
	@RequestMapping("updateItemsort")
	@RequiresPermissions("2")
	public String updateItemsort(HttpServletRequest request,Integer id,Integer pageNo) throws Exception{
		Itemsort itemsort=service.findItemsortById(id);
		request.setAttribute("itemsort", itemsort);
		return "itemsort/updateItemsort";
	}
	
	//修改提交
	@RequestMapping("updateItemsortSubmit")
	@RequiresPermissions("2")
	public String updateItemsortSubmit(HttpServletRequest request,Itemsort itemsort) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"修改物品类型。修改前："+service.findItemsortById(itemsort.getId()).toString()+"修改后："+itemsort.toString());
		
		
		service.updateItemsortById(itemsort);
		return "dept/success";
	}
	
	//增加物品类型
	@RequestMapping("addItemsort")
	@RequiresPermissions("2")
	public String addItemsort() throws Exception{
		return "itemsort/addItemsort";
	}
	
	//增加提交
	@RequestMapping("addItemsortSubmit")
	@RequiresPermissions("2")
	public String addItemsortSubmit(HttpServletRequest request,Itemsort itemsort) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"增加物品类型。增加的信息为："+itemsort.toString());
		
		
		service.addItemsort(itemsort);
		return "itemsort/success";
	}
	
	//删除物品类型
	@RequestMapping("deleteItemsort")
	@RequiresPermissions("2")
	public String deleteItemsort(HttpServletRequest request,Integer id) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"删除物品类型。删除的信息："+service.findItemsortById(id).toString());
		
		
		service.deleteItemsortById(id);
		return "itemsort/success";
	}
	
	//查看所有物品信息
	@RequestMapping("findItems")
	@RequiresPermissions("2")
	public String findItems(HttpServletRequest request,Integer pageNo) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"查看所有物品信息");
		
		
		//查询页号对应的物品信息
		PageResult<Items> pageList=service.queryByPage(pageNo, 10);
		request.setAttribute("pageList", pageList);
		//得到Items
		List<Items> itemsList=pageList.getDataList();
		request.setAttribute("itemsList", itemsList);
		return "itemsort/items";
	}
	
	

	//根据物品类型查看物品
	@RequestMapping("findItemsByItemsort")
	@RequiresPermissions("2")
	public String findItemsByItemsort(HttpServletRequest request,String name,Integer pageNo) throws Exception{
		try{
			name=new String(name.getBytes("ISO-8859-1"),"utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"根据"+name+"类型查看物品。");
		
		
		PageResult<Items> pageList=service.findItemsByItemsort(name, pageNo, 10);
		request.setAttribute("pageList", pageList);
		request.setAttribute("name", name);
		List<Items> itemsList=pageList.getDataList();
		request.setAttribute("itemsList", itemsList);
		return "itemsort/itemsByItemsort";
	}
	
	//修改物品
	@RequestMapping("updateItems")
	@RequiresPermissions("2")
	public String updateItems(HttpServletRequest request,Integer id) throws Exception{
		Items items=service.findItemsById(id);
		request.setAttribute("items", items);
		return "itemsort/updateItems";
	}
		
	//修改提交
	@RequestMapping("updateItemsSubmit")
	@RequiresPermissions("2")
	public String updateItemsSubmit(HttpServletRequest request,Items items) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"修改物品。修改前："+service.findItemsById(items.getId()).toString()+"修改后："+items.toString());
		
		
		System.err.println(items);
		service.updateItemsById(items);
		return "itemsort/success";
	}
	
	//增加物品
	@RequestMapping("addItems")
	@RequiresPermissions("2")
	public String addItems() throws Exception{
		return "itemsort/addItems";
	}
	
	//增加提交
	@RequestMapping("addItemsSubmit")
	@RequiresPermissions("2")
	public String addItemsSubmit(HttpServletRequest request,@Validated(value=ValidGroup3.class) Items items,BindingResult bindingResult) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"增加物品。"+items.toString());
		
		
		service.addItems(items);
		return "itemsort/success";
	}
	
	
	//删除物品
	@RequestMapping("deleteItems")
	@RequiresPermissions("2")
	public String deleteItems(HttpServletRequest request,Integer id) throws Exception{
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		System.out.println(manager);
		String managerId = manager.getId();
		log.info("账号："+managerId+"删除物品。"+service.findItemsById(id).toString());
		
		
		service.deleteItemsById(id);
		return "itemsort/success";
	}
	

		
	
	
	
}
