package am.gitc.service;

import am.gitc.model.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserService {
    void save(User user) throws SQLException, ClassNotFoundException;
    boolean exist(String email);
    Optional<User> getByEmailAndPassword(String email, String password);
}
