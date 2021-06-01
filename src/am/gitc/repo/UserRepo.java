package am.gitc.repo;

import am.gitc.model.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserRepo {

    void save(User user) throws SQLException;
    boolean exist(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

}
