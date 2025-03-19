package hendrizzzz.network_app.service;

import hendrizzzz.network_app.dao.UserDao;
import hendrizzzz.network_app.model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDate;
import java.time.Period;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    public void addUser(String username, String firstName, String lastName, String password) {
        User newUser = new User(firstName, lastName, username, hashPassword(password));
        userDao.addUser(newUser);
    }


    public void addUser(String username, String firstName, String lastName, String password, LocalDate birthDate) {
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        User newUser = new User(firstName, lastName, username, hashPassword(password), (byte) age, birthDate);
        userDao.addUser(newUser);
    }


    public void addUser(String username, String firstName, String lastName, String password, char gender) {
        User newUser = new User(firstName, lastName, username, hashPassword(password), gender);
        userDao.addUser(newUser);
    }


    public void addUser(String username, String firstName, String lastName, String password, char gender, LocalDate birthDate) {
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        User newUser = new User(firstName, lastName, username, hashPassword(password), gender, (byte) age, birthDate);
        userDao.addUser(newUser);
    }


    // TODO: to be fixed
    public boolean removeUser(String username) {
        userDao.deleteUser(username);
        return true;
    }


    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }


}
