package org.tysf.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.tysf.dao.UserDao;
import org.tysf.domain.User;
import org.tysf.utils.JdbcUtils;

public class UserDaoImpl implements UserDao{
	@Override
	public void save(User user) throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="insert into user(uid,username,password,name,email,telephone,birthday,sex,state)"
				+"values(?,?,?,?,?,?,?,?,?)";
		qr.update(sql,user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState());		
	}
	@Override
	public boolean check(User user) throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from user where username="+user.getUsername()+" and password="+user.getPassword();
		User checkuser=qr.query(sql,new BeanHandler<>(User.class));
		if(checkuser!=null){
			return true;
		}
		return false;
	}

	@Override
	public User find(String username, String password) throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from user where username=? and password=?";
		User existUser=qr.query(sql, new BeanHandler<User>(User.class),username,password);
		return existUser;
	}

	@Override
	public User findByusername(String username) throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from user where username=?";
		User checkUser=qr.query(sql, new BeanHandler<User>(User.class),username);
		return checkUser;
	}
}
