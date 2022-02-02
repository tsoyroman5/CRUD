package crudApp.dao;

import crudApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "getEntityManager")
    private EntityManager entityManager;

    @Override
    public List<User> userList() {
        return (entityManager.createQuery("select e from User e").getResultList());
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(Long id, User user) {
        User userToBeUpdated = entityManager.find(User.class, id);
        entityManager.detach(userToBeUpdated);
        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setSurname(user.getSurname());
        userToBeUpdated.setAge(user.getAge());
        entityManager.merge(userToBeUpdated);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
