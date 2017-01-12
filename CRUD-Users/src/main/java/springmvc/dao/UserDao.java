package springmvc.dao;

import springmvc.model.User;

import java.util.List;

/**
 * Created by admin on 22.12.2016 г..
 */
public interface UserDao {

    User findUserById(int id);

    User findUserByFirstName(String firstName);

    User findUserByEmail(String email);

    User findUserByPhoneNumber(String phoneNumber);

    List<User> findAllUsers();

    void saveUser(User user);

    void deleteUserById(Integer id);


}
