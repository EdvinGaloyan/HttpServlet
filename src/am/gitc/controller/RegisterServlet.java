package am.gitc.controller;

import am.gitc.model.User;
import am.gitc.service.UserService;
import am.gitc.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class RegisterServlet extends HttpServlet {
    private List<HttpServletRequest> requestList = new CopyOnWriteArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            UserService userService = new UserServiceImpl();
            boolean ifExist = userService.exist(email);
            if (ifExist) {
                req.getRequestDispatcher("registration.jsp").forward(req, resp);
                req.setAttribute("errorEmail ", "User already exists");
            } else {
                User user = new User();
                user.setName(name);
                user.setSurname(surname);
                user.setEmail(email);
                user.setPassword(password);
                userService.save(user);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }

}
