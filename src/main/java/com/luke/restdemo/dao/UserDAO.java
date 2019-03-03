package com.luke.restdemo.dao;

import com.luke.restdemo.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAO implements IUserDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public User getUser(String username) {
        return em.find(User.class, username);
    }


    @Override
    @Transactional
    public List<User> getUsers() {
        List<User> resultList = em.createQuery("FROM User", User.class).getResultList();
        return resultList;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        em.persist(user);

    }

    @Override
    @Transactional
    public void updateUser(User user) {
        em.merge(user);

    }

    @Override
    @Transactional
    public void deleteUser(String username) {
        User user = this.getUser(username);
        em.remove(user);
    }

}
