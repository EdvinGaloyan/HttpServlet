package am.gitc.repo.impl;

import am.gitc.model.User;
import am.gitc.repo.UserRepo;
import am.gitc.userdao.UserDao;
import am.gitc.userdao.impl.UserDaoImp;

import java.sql.SQLException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepoImpl implements UserRepo {

    Map<String,User> userMap = new ConcurrentHashMap<>();
    private UserDao userDao;

    public UserRepoImpl() throws SQLException, ClassNotFoundException {
        userDao = new UserDaoImp();
    }

    @Override
    public void save(User user) throws SQLException {

        if (!userMap.containsKey(user.getEmail())){
            userDao.add(user);
        }
        this.userMap.put(user.getEmail(),user);


    }

    @Override
    public boolean exist(String email) {
        return this.userMap.containsKey(email);
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        User user = userMap.get(email);
        return (user != null && Objects.equals(user.getEmail(),email)) ? Optional.of(user) : Optional.empty();
    }
}
