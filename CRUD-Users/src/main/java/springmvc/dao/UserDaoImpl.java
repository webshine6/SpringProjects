package springmvc.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import springmvc.model.User;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    @Override
    public User findUserById(int id) {
        return getByKey(id);
    }

    @Override
    public User findUserByFirstName(String firstName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("firstName", firstName));

        return (User) criteria.uniqueResult();
    }

    @Override
    public User findUserByEmail(String email) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("email", email));

        return (User) criteria.uniqueResult();
    }

    @Override
    public User findUserByPhoneNumber(String phoneNumber) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("phoneNumber", phoneNumber));

        return (User) criteria.uniqueResult();
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }


    @Override
    public void saveUser(User user) {
        persist(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        Query query = getSession().createSQLQuery("DELETE FROM user WHERE id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
}
