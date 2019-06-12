package com.shoppingCart.daoImpl;

import com.shoppingCart.dao.UserDao;
import com.shoppingCart.model.Login;
import com.shoppingCart.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void addUser(User user) {
     getSession().save(user);
    }



    @Override
    public void delete(int userId) {
      User user=findUserById(userId);
      getSession().delete(user);

    }

 @Override
    public List<User> getUser() {
        List<User> list=getSession().createCriteria(User.class).list();
        return list;
    }

   public User findUserById(int userId){
      User user=(User) getSession().get(User.class,userId);
      return  user;
    }
  public   User update(User user,int userId){
      User update=(User) getSession().get(User.class,userId);
      update.setFirstName(user.getFirstName());
      getSession().update(update);
      return update;
    }

    @Override
    public boolean findUser(Login login) {
        String email=login.getUserName();
        String password=login.getPassword();
        boolean userFound=false;
        String sql="from User u where u.email=:email and u.password=:password";
         Query query=getSession().createQuery(sql);
         query.setParameter("email",email);
         query.setParameter("password",password);
         List list=query.list();
        if(list!=null && list.size()>0){
            userFound=true;
        }
        return userFound;
    }

    public String findUserByName(User user) {
        User user1=(User) getSession().get(User.class,user.getEmail());
        return user1.getEmail();
    }


}
