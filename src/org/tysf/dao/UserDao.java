package org.tysf.dao;

import java.sql.SQLException;

import org.tysf.domain.User;

public interface UserDao {
	void save(User user)throws SQLException;

	boolean check(User user) throws SQLException;

	User find(String username, String password) throws SQLException;

	User findByusername(String username) throws SQLException;
}
