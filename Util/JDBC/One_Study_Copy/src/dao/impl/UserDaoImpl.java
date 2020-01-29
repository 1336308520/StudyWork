package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;


import dao.UserDao;
import module.User;
import util.JDBC_util;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = JDBC_util.getConnection();
		String sql = "insert into user(id,name,password) values(?,?,?);";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setInt(1, user.getId());
			pst.setString(2, user.getName());
			pst.setString(3,user.getPassword());
			pst.execute();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBC_util.close(conn,pst,null);
		}
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = JDBC_util.getConnection();
		String sql = "delete from user where id = ?";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setInt(1, user.getId());
			pst.execute();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBC_util.close(conn,pst,null);
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = JDBC_util.getConnection();
		String sql = "update user set name = ?,password = ? where id = ?";
		PreparedStatement pst = null;
		try {
		    pst = conn.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2,user.getPassword());
			pst.setInt(3,user.getId());
			pst.executeUpdate();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBC_util.close(conn,pst,null);
		}
		return false;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		Connection conn = JDBC_util.getConnection();
		String sql = "select * from user where id = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = new User();
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setInt(1,id);
			rs = pst.executeQuery();
			rs.next();
			String name = rs.getString(2);
			String password = rs.getString(3);
			user.setId(id);
			user.setName(name);
			user.setPassword(password);
			return user;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBC_util.close(conn,pst,null);
		}
		return null;
	}

	@Override
	public LinkedList<User> findByName(String name) {
		// TODO Auto-generated method stub
		Connection conn = JDBC_util.getConnection();
		String sql = "select * from user where name = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		LinkedList<User>  users = new LinkedList<User>();
		try {
			pst = (PreparedStatement)conn.prepareStatement(sql);
			pst.setString(1,name);
			rs = pst.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				users.add(user);
			}
			return users;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBC_util.close(conn,pst,rs);
		}
		return null;
	}

}
