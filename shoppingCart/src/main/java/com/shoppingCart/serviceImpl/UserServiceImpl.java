package com.shoppingCart.serviceImpl;

import com.shoppingCart.dao.UserDao;
import com.shoppingCart.model.User;
import com.shoppingCart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    public UserDao userDao;

    public void createUser(User user){
         userDao.addUser(user);
    }
    public  User findUserById(int userId){
        return  userDao.findUserById(userId);
    }
    public void delete(int userId){
         userDao.delete(userId);
    }
    public  List<User> getUser(){
        return  userDao.getUser();
    }
    public  User update(User user,int id){
        return  userDao.update(user,id);
    }

}
