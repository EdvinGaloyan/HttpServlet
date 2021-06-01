package am.gitc.userdao.impl;

import am.gitc.model.User;
import am.gitc.service.UserService;
import am.gitc.service.impl.UserServiceImpl;
import am.gitc.userdao.UserDao;

import java.sql.*;

public class UserDaoImp implements UserDao {
    private String url = "jdbc:mysql://localhost:3306/user?user=root&password=Edvin%2B1995";
    private Connection connection;

    public UserDaoImp() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url);


    }


    @Override
    public void add(User user) throws SQLException {
        String query1 = "select email from users where email = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query1)) {
            preparedStatement.setString(1, user.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                String query = "insert into users(name, surname, email, password) values(?,?,?,?);";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, user.getName());
                    statement.setString(2, user.getSurname());
                    statement.setString(3, user.getEmail());
                    statement.setString(4, user.getPassword());
                    statement.execute();
                }
            }

        }
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }
}
