package spring_mvc_hibernate.app.dao;

import org.springframework.stereotype.Repository;
import spring_mvc_hibernate.app.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        return em.createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void save(User user) {
        em.merge(user);
    }

    @Override
    public void delete(int id) {
        em.createQuery("delete from User where id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
