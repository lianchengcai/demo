package cn.edu.fjnu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.fjnu.entity.Items;
import cn.edu.fjnu.entity.Itemsort;

@Repository
public interface ItemsortDao {
	
	//查看物品类型
	public List<Itemsort> findItemsort() throws Exception;
	
	//根据id查询物品类型
	public Itemsort findItemsortById(Integer id) throws Exception;
	
	//增加物品类型
	public void addItemsort(Itemsort itemsort) throws Exception;
	
	//修改物品类型
	public void updateItemsortById(Itemsort itemsort) throws Exception;
	
	//删除物品类型
	public void deleteItemsortById(Integer id) throws Exception; 
	
	//通过物品类型查询物品信息
	public List<Items> findItemsByItemsort(String name) throws Exception;
	
	//查看所有物品信息
	public List<Items> findItems() throws Exception;
	
	//查看所有物品信息之分页
	public List<Items> findItemsPage(Items items) throws Exception;
	
	//根据id查询物品
	public Items findItemsById(Integer id) throws Exception;
	
	//修改物品
	public void updateItemsById(Items items) throws Exception;
	
	//增加物品
	public void addItems(Items items) throws Exception;
	
	//删除物品
	public void deleteItemsById(Integer id) throws Exception;
}
