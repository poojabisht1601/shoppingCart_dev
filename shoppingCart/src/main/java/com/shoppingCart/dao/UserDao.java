package com.shoppingCart.dao;

import com.shoppingCart.model.Login;
import com.shoppingCart.model.User;

import java.util.List;



public interface UserDao {
     void addUser(User user);
     User findUserById(int userId);
     void delete(int userId);
     List<User> getUser();
     User update(User user,int id);
     boolean findUser(Login login);
}
