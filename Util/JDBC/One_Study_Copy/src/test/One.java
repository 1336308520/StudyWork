package test;

import java.util.Iterator;
import java.util.LinkedList;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import module.User;

public class One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
       LinkedList<User> users =  userDao.findByName("¡ı—”Íª");
       Iterator iterator = users.iterator();
       while(iterator.hasNext()) {
    	   User user_1 = (User)iterator.next();
    	   user_1.User_view();
       }
       User user_3 = new User(2,"¡ı","34d56");
       System.out.println(userDao.updateUser(user_3));
	}
}
