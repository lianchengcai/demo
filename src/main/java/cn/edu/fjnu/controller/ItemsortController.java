package cn.edu.fjnu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.fjnu.entity.Dept;
import cn.edu.fjnu.entity.Employee;
import cn.edu.fjnu.entity.Items;
import cn.edu.fjnu.entity.Itemsort;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.service.DeptService;
import cn.edu.fjnu.service.ItemsortService;
import cn.edu.fjnu.validator.ValidGroup3;

@Controller

public class ItemsortController {
	
	@Autowired
	private ItemsortService service;
	
	//查看物品类型
	@RequestMapping("findItemsort")
	@RequiresPermissions("2")
	public String findItemsort(HttpServletRequest request,Integer pageNo) throws Exception{
		PageResult<Itemsort> pageList = service.findItemsort(pageNo,10);
		request.setAttribute("pageList", pageList);
		List<Itemsort> itemsortList=pageList.getDataList();
		request.setAttribute("itemsortList", itemsortList);
		return "itemsort/itemsortList";
	}
	
	//修改物品类型
	@RequestMapping("updateItemsort")
	public String updateItemsort(HttpServletRequest request,Integer id,Integer pageNo) throws Exception{
		Itemsort itemsort=service.findItemsortById(id);
		request.setAttribute("itemsort", itemsort);
		return "itemsort/updateItemsort";
	}
	
	//修改提交
	@RequestMapping("updateItemsortSubmit")
	public String updateItemsortSubmit(HttpServletRequest request,Itemsort itemsort) throws Exception{
		service.updateItemsortById(itemsort);
		return "dept/success";
	}
	
	//增加物品类型
	@RequestMapping("addItemsort")
	public String addItemsort() throws Exception{
		return "itemsort/addItemsort";
	}
	
	//增加提交
	@RequestMapping("addItemsortSubmit")
	public String addItemsortSubmit(Itemsort itemsort) throws Exception{
		service.addItemsort(itemsort);
		return "itemsort/success";
	}
	
	//删除物品类型
	@RequestMapping("deleteItemsort")
	public String deleteItemsort(Integer id) throws Exception{
		service.deleteItemsortById(id);
		return "itemsort/success";
	}
	
	//查看所有物品信息
	@RequestMapping("findItems")
	public String findItems(HttpServletRequest request,Integer pageNo) throws Exception{
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
	public String findItemsByItemsort(HttpServletRequest request,String name,Integer pageNo) throws Exception{
		try{
			name=new String(name.getBytes("ISO-8859-1"),"utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		PageResult<Items> pageList=service.findItemsByItemsort(name, pageNo, 10);
		request.setAttribute("pageList", pageList);
		request.setAttribute("name", name);
		List<Items> itemsList=pageList.getDataList();
		request.setAttribute("itemsList", itemsList);
		return "itemsort/itemsByItemsort";
	}
	
	//修改物品
	@RequestMapping("updateItems")
	public String updateItems(HttpServletRequest request,Integer id) throws Exception{
		Items items=service.findItemsById(id);
		request.setAttribute("items", items);
		return "itemsort/updateItems";
	}
		
	//修改提交
	@RequestMapping("updateItemsSubmit")
	public String updateItemsSubmit(HttpServletRequest request,Items items) throws Exception{
		System.err.println(items);
		service.updateItemsById(items);
		return "itemsort/success";
	}
	
	//增加物品
	@RequestMapping("addItems")
	public String addItems() throws Exception{
		return "itemsort/addItems";
	}
	
	//增加提交
	@RequestMapping("addItemsSubmit")
	public String addItemsSubmit(HttpServletRequest request,@Validated(value=ValidGroup3.class) Items items,BindingResult bindingResult) throws Exception{
		service.addItems(items);
		return "itemsort/success";
	}
	
	
	//删除物品
	@RequestMapping("deleteItems")
	public String deleteItems(Integer id) throws Exception{
		service.deleteItemsById(id);
		return "itemsort/success";
	}
	

		
	
	
	
}
