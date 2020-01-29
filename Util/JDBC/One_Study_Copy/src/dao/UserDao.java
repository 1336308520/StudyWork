package dao;

import java.util.LinkedList;

import module.User;

public interface UserDao {
public boolean addUser(User user);
public boolean deleteUser(User user);
public boolean updateUser(User user);
public User findById(int id);
public LinkedList<User> findByName(String name);
}
