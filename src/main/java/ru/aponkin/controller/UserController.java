package ru.aponkin.controller;

import ru.aponkin.model.Role;
import ru.aponkin.model.User;
import ru.aponkin.service.ValidateMemoryService;
import ru.aponkin.service.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Class UserController.
 *
 * @author Ponkin Aleksey
 * @version 1.0.0
 * @since 18.05.2018.
 */
public class UserController extends HttpServlet {
    /**
     * Validator.
     */
    private final ValidateService validate = ValidateMemoryService.getInstance();
    /**
     * Dispatch action.
     */
    private final Map<String, Function<User, Boolean>> dispatchAction = new HashMap<>();

    @Override
    public void init() throws ServletException {
        this.initDispatchAction();
        super.init();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User registeredUser = (User) req.getSession().getAttribute("registeredUser");
        List<User> users;
        if (registeredUser.getRole().getName().equals("admin")) {
            users = this.validate.findAll();
        } else {
            users = Arrays.asList(this.validate.findById(registeredUser.getId()));
        }
        req.setAttribute("users", users);
        req.getRequestDispatcher("/WEB-INF/view/Users.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String action = req.getParameter("action");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        String city = req.getParameter("city");
        String roleName = req.getParameter("roleName") == null ? "user" : req.getParameter("roleName");
        User user = new User();
        if (id != null) {
            user.setId(Long.parseLong(id));
        }
        if (action.equals("delete")) {
            this.dispatchAction.get(action).apply(user);
        } else {
            if (!name.equals("") && !login.equals("") && !email.equals("") && !country.equals("") && !city.equals("")) {
                user.setName(name);
                user.setLogin(login);
                user.setPassword(password);
                user.setEmail(email);
                user.setCountry(country);
                user.setCity(city);
                user.setRole(new Role(roleName));
                this.dispatchAction.get(action).apply(user);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/");
    }

    /**
     * Initialisation dispatch action.
     */
    private void initDispatchAction() {
        this.dispatchAction.put("add", this.addUser());
        this.dispatchAction.put("update", this.updateUser());
        this.dispatchAction.put("delete", this.deleteUser());
    }

    /**
     * Action add user.
     * @return action.
     */
    private Function<User, Boolean> addUser() {
        return this.validate::add;
    }

    /**
     * Action update user.
     * @return action.
     */
    private Function<User, Boolean> updateUser() {
        return this.validate::update;
    }

    /**
     * Action delete user.
     * @return action.
     */
    private Function<User, Boolean> deleteUser() {
        return this.validate::delete;
    }
}