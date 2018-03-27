package org.tysf.service;

import java.sql.SQLException;
import org.tysf.domain.User;

public interface UserService {
	void save(User user) throws SQLException;
	boolean check(User user) throws SQLException;
	User login(User user) throws SQLException;
	User findByusername(String username) throws SQLException;
}
