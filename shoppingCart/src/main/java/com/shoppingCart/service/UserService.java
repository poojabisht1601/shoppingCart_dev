package com.shoppingCart.service;

import com.shoppingCart.model.Login;
import com.shoppingCart.model.User;

import java.util.List;


public interface UserService {
     void createUser(User user);
     User findUserById(int userId);
     void delete(int userId);
     List<User> getUser();
     User update(User user,int id);
     boolean validateUser(Login login);
}
