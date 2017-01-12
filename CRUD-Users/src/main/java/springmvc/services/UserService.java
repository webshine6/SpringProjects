package springmvc.services;

import springmvc.model.User;

import java.util.List;


public interface UserService {

    User findUserById(int id);

    User findUserByFirstName(String firstName);

    User findUserByEmail(String email);

    User findUserByPhoneNumber(String phoneNumber);

    List<User> findAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Integer id);

    boolean isUserEmailUnique(Integer id, String email);

    boolean isUserPhoneNumberUnique(Integer id, String phoneNumber);

}
