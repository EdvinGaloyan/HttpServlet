package am.gitc.service.impl;

import am.gitc.model.User;
import am.gitc.repo.UserRepo;
import am.gitc.repo.impl.UserRepoImpl;
import am.gitc.service.UserService;

import java.sql.SQLException;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl() throws SQLException, ClassNotFoundException {
        userRepo = new UserRepoImpl();
    }


    @Override
    public void save(User user) throws SQLException{
        this.userRepo.save(user);
    }

    @Override
    public boolean exist(String email) {
        return this.userRepo.exist(email);
    }

    @Override
    public Optional<User> getByEmailAndPassword(String email, String password) {
        return this.userRepo.findByEmailAndPassword(email,password);
    }
}
