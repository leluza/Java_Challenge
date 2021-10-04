package com.examplee.demoo.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.examplee.demoo.entities.User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;  // 2:08 

    @Override
    public List<User> getUsers() {
          String query = "FROM User";
          List<User> users = entityManager.createQuery(query).getResultList();
          return users;
    }
    
  


    @Override
    public void remove(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void register(User user) {
        entityManager.merge(user);
    }
}