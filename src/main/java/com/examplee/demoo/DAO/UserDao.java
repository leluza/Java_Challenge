package com.examplee.demoo.DAO;

import java.util.List;

import com.examplee.demoo.entities.User;

public interface UserDao {
    
  List<User> getUsers();

  void remove(Long id);

  void register(User user);

  

}