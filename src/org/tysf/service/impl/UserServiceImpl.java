package org.tysf.service.impl;

import java.sql.SQLException;

import org.tysf.dao.UserDao;
import org.tysf.dao.impl.UserDaoImpl;
import org.tysf.domain.User;
import org.tysf.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao dao=new UserDaoImpl();
	@Override
	public void save(User user) throws SQLException{
		dao.save(user);
	}

	@Override
	public boolean check(User user) throws SQLException{
		return dao.check(user);
	}

	@Override
	public User login(User user) throws SQLException{
		return dao.find(user.getUsername(),user.getPassword());
	}

	@Override
	public User findByusername(String username) throws SQLException {
		return dao.findByusername(username);
	}

}
