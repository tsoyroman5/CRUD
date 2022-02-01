package crudApp.dao;

import crudApp.model.User;

import java.util.List;

public interface UserDao {
    List<User> userList();
    void addUser(User user);
    User findUser(Long id);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}
