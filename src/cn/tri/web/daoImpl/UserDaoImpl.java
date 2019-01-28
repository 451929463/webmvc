package cn.tri.web.daoImpl;


import java.util.ArrayList;
import java.util.List;

import cn.tri.web.dao.UserDao;
import cn.tri.web.pojo.User;

public class UserDaoImpl implements UserDao{

	@Override
	public List<User> find() {
		User user1 = new User("zhangsan", "123456");
		User user2 = new User("lisi", "000000");
		ArrayList list = new ArrayList<User>();
		list.add(user1);
		list.add(user2);
		return list;
	}

}
