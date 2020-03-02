package UserManager.repository.impl;

import UserManager.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import UserManager.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public User save(User user) {
        if (user.isNew()){
            entityManager.persist(user);
            return user;
        } else
            return entityManager.merge(user);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return entityManager.createNamedQuery(User.DELETE)
                .setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public User get(int id) {
        return entityManager.createNamedQuery(User.GET, User.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public List<User> getAll() {
        return entityManager.createNamedQuery(User.ALL, User.class).getResultList();
    }
}
