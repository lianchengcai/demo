package cn.edu.fjnu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.fjnu.dao.IManagerDao;
import cn.edu.fjnu.entity.Manager;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.util.BeanUtil;
import cn.edu.fjnu.util.SaltUtils;

@Service
public class ManagerService {

	@Resource
	private IManagerDao dao;
	
	public PageResult<Manager> findManager(Integer pageNo, Integer pageSize) {
		BeanUtil.pageParam(pageNo, pageSize); 
	    return BeanUtil.toPagedResult(dao.findManager());//调用自定义工具转换类型
	}

	public Manager findManagerById(String id) {
		return dao.findManagerById(id);
	}

	public void updateManager(Manager manager) {
		dao.updateManager(manager);
	}

	public void addManager(Manager manager) {
		String salt = SaltUtils.getRandomSalt();
		String password = SaltUtils.getMd5Password("123456", salt);
		manager.setSalt(salt);
		manager.setMd5Password(password);
		manager.setState(1);
		dao.addManager(manager);
		
	}

	public void deleteManager(String id) {
		dao.deleteManager(id);
	}

}
