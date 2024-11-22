package spring_mvc_hibernate.app.dao;

import spring_mvc_hibernate.app.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findById(int id);

    void save(User user);

    void delete(int id);
}
