package cn.edu.fjnu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.fjnu.entity.Suptype;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.entity.Supplier;
import cn.edu.fjnu.service.SuptypeService;

@Controller
public class SuptypeController {
	
	@Autowired
	private SuptypeService service;
	
	//查看供应商类型
	@RequestMapping("findSuptype")
	public String findSuptype(HttpServletRequest request,Integer pageNo) throws Exception{
		PageResult<Suptype> pageList=service.findSuptype(pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Suptype> suptypeList = pageList.getDataList();
		request.setAttribute("suptypeList", suptypeList);
		return "suptype/suptypeList";
	}
	
	//修改供应商类型
	@RequestMapping("updateSuptype")
	public String updateSuptype(HttpServletRequest request,Integer id) throws Exception{
		Suptype suptype=service.findSuptypeById(id);
		request.setAttribute("suptype", suptype);
		return "suptype/updateSuptype";
	}
	
	//修改提交
	@RequestMapping("updateSuptypeSubmit")
	public String updateSuptypeSubmit(HttpServletRequest request,Suptype Suptype) throws Exception{
		service.updateSuptypeById(Suptype);
		return "suptype/success";
	}
	
	//增加供应商类型
	@RequestMapping("addSuptype")
	public String addSuptype() throws Exception{
		return "suptype/addSuptype";
	}
	
	//增加提交
	@RequestMapping("addSuptypeSubmit")
	public String addSuptypeSubmit(Suptype Suptype) throws Exception{
		service.addSuptype(Suptype);
		return "suptype/success";
	}
	
	//删除供应商类型
	@RequestMapping("deleteSuptype")
	public String deleteSuptype(Integer id) throws Exception{
		service.deleteSuptypeById(id);
		return "suptype/success";
	}
	
	//查看所有供应商信息
	@RequestMapping("findSupplier")
	public String findSupplier(HttpServletRequest request,Integer pageNo) throws Exception{
		PageResult<Supplier> pageList=service.findSupplier(pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Supplier> supplierList=pageList.getDataList();
		request.setAttribute("supplierList", supplierList);
		return "suptype/supplier";
	}

	//根据供应商类型查看供应商信息
	@RequestMapping("findSupplierBySuptype")
	public String findSupplierBySuptype(HttpServletRequest request,String name,Integer pageNo) throws Exception{
		try{
			name=new String(name.getBytes("ISO-8859-1"),"utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		PageResult<Supplier> pageList=service.findSupplierBySuptype(name, pageNo, 10);
		request.setAttribute("pageList", pageList);
		List<Supplier> supplierList=pageList.getDataList();
		request.setAttribute("supplierList", supplierList);
		return "suptype/supplierBySuptype";
	}
	
	//修改供应商
	@RequestMapping("updateSupplier")
	public String updateSupplier(HttpServletRequest request,Integer id) throws Exception{
		Supplier supplier=service.findSupplierById(id);
		request.setAttribute("supplier", supplier);
		return "suptype/updateSupplier";
	}
		
	//修改提交
	@RequestMapping("updateSupplierSubmit")
	public String updateSupplierSubmit(HttpServletRequest request,Supplier Supplier) throws Exception{
		service.updateSupplierById(Supplier);
		return "suptype/success";
	}
	
	//增加供应商
	@RequestMapping("addSupplier")
	public String addSupplier() throws Exception{
		return "suptype/addSupplier";
	}
	
	//增加提交
	@RequestMapping("addSupplierSubmit")
	public String addSupplierSubmit(Supplier Supplier) throws Exception{
		service.addSupplier(Supplier);
		return "suptype/success";
	}
	
	
	//删除供应商
	@RequestMapping("deleteSupplier")
	public String deleteSupplier(Integer id) throws Exception{
		service.deleteSupplierById(id);
		return "suptype/success";
	}
	

		
	
	
	
}
