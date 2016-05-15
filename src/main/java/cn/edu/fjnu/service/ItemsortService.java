package cn.edu.fjnu.service;

import java.util.List;

import com.github.pagehelper.Page;

import cn.edu.fjnu.entity.Items;
import cn.edu.fjnu.entity.Itemsort;
import cn.edu.fjnu.entity.PageResult;

public interface ItemsortService {

	//查看物品类型
	public PageResult<Itemsort> findItemsort(Integer pageNo,Integer pageSize) throws Exception;
	
	//根据id查询物品类型
	public Itemsort findItemsortById(Integer id) throws Exception;
	
	//增加物品类型
	public void addItemsort(Itemsort itemsort) throws Exception;
		
	//修改物品类型
	public void updateItemsortById(Itemsort itemsort) throws Exception;
		
	//删除物品类型
	public void deleteItemsortById(Integer id) throws Exception; 
		
	//通过物品类型查询部门物品信息
	public PageResult<Items> findItemsByItemsort(String name,Integer pageNo,Integer pageSize) throws Exception;

	//查询所有物品
	public PageResult<Items> queryByPage(Integer pageNo,Integer pageSize) throws Exception;
	
	//根据id查询物品
	public Items findItemsById(Integer id) throws Exception;
		
	//修改物品
	public void updateItemsById(Items items) throws Exception;
		
	//增加物品
	public void addItems(Items items) throws Exception;
		
	//删除物品
	public void deleteItemsById(Integer id) throws Exception;
	

	

}
