package cn.edu.fjnu.dao;

import org.springframework.stereotype.Repository;

import cn.edu.fjnu.entity.Manager;

@Repository
public interface IManagerDao {

	Manager getManagerById(String id);
	

}
