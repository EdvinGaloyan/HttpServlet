package am.gitc.userdao;

import am.gitc.model.User;

import java.sql.SQLException;

public interface UserDao {

    void add(User user) throws SQLException;

    User findByEmail(String email);
}
