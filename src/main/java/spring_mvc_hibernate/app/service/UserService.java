package spring_mvc_hibernate.app.service;

import spring_mvc_hibernate.app.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    void save(User user);

    void delete(int id);
}
