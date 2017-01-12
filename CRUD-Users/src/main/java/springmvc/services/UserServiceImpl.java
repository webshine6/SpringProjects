package springmvc.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmvc.dao.UserDao;
import springmvc.model.User;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public User findUserByFirstName(String firstName) {
        return userDao.findUserByFirstName(firstName);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Override
    public User findUserByPhoneNumber(String phoneNumber) {
        return userDao.findUserByPhoneNumber(phoneNumber);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {

        User entity = findUserByFirstName(user.getFirstName());

        if (entity != null) {
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setDob(user.getDob());
            entity.setEmail(user.getEmail());
            entity.setPhoneNumber(user.getPhoneNumber());
        }


    }

    public boolean isUserEmailUnique(Integer id, String email) {
        User user = findUserByEmail(email); // check database user
        return (user == null ||
                ((id != null) && (user.getId().equals(id))));
    }


    public boolean isUserPhoneNumberUnique(Integer id, String phoneNumber) {
        User user = findUserByPhoneNumber(phoneNumber); // user from db
        return (user == null ||
                ((id != null) && (user.getId().equals(id))));
    }


}
