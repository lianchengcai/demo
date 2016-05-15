package cn.edu.fjnu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.edu.fjnu.dao.ItemsortDao;
import cn.edu.fjnu.entity.Items;
import cn.edu.fjnu.entity.Itemsort;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.service.ItemsortService;
import cn.edu.fjnu.util.BeanUtil;

@Service
public class ItemsortServiceImpl implements ItemsortService{

	@Autowired
	private ItemsortDao dao;

	@Override
	public void addItemsort(Itemsort itemsort) throws Exception {
		dao.addItemsort(itemsort);
	}
	
	@Override
	public Itemsort findItemsortById(Integer id) throws Exception {
		return dao.findItemsortById(id);
	}

	@Override
	public void updateItemsortById(Itemsort itemsort) throws Exception {
		dao.updateItemsortById(itemsort);
	}

	@Override
	public void deleteItemsortById(Integer id) throws Exception {
		dao.deleteItemsortById(id);
	}

	@Override
	public Items findItemsById(Integer id) throws Exception {
		return dao.findItemsById(id);
	}

	@Override
	public void updateItemsById(Items items) throws Exception {
		dao.updateItemsById(items);
	}

	@Override
	public void addItems(Items items) throws Exception {
		dao.addItems(items);
	}

	@Override
	public void deleteItemsById(Integer id) throws Exception {
		dao.deleteItemsById(id);
	}

	@Override
	public PageResult<Items> queryByPage(Integer pageNo, Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize); 
	    return BeanUtil.toPagedResult(dao.findItems());//调用自定义工具转换类型
	}

	@Override
	public PageResult<Itemsort> findItemsort(Integer pageNo, Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findItemsort());
	}

	@Override
	public PageResult<Items> findItemsByItemsort(String name, Integer pageNo, Integer pageSize) throws Exception {
		BeanUtil.pageParam(pageNo, pageSize);
		return BeanUtil.toPagedResult(dao.findItemsByItemsort(name));
	}

	

	
}

