package cn.edu.fjnu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.fjnu.entity.Manager;

@Repository
public interface IManagerDao {

	Manager getManagerById(String id);

	List<Manager> findManager();

	Manager findManagerById(String id);

	void updateManager(Manager manager);

	void addManager(Manager manager);

	void deleteManager(String id);

	

}
