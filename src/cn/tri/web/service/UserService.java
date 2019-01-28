package cn.tri.web.service;

import java.util.List;

import cn.tri.web.dao.UserDao;
import cn.tri.web.daoImpl.UserDaoImpl;
import cn.tri.web.pojo.User;

public class UserService {
	UserDao userDao = new UserDaoImpl();
	//查询所有用户
	public List<User> find() {
		return userDao.find();
	}
}
