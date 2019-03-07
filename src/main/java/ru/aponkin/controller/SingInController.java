package ru.aponkin.controller;

import ru.aponkin.model.User;
import ru.aponkin.service.ValidateMemoryService;
import ru.aponkin.service.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class SingInController.
 *
 * @author Ponkin Aleksey
 * @version 1.0.0
 * @since 22.06.2018.
 */
public class SingInController extends HttpServlet {
    /**
     * Validator.
     */
    private final ValidateService validate = ValidateMemoryService.getInstance();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (!login.equals("") && !password.equals("")) {
            User user = validate.findByLoginPassword(login, password);
            if (user.getId() != 0) {
                session.setAttribute("registeredUser", user);
                resp.sendRedirect(String.format("%s/", req.getContextPath()));
                return;
            }
        }
        req.setAttribute("error", "Incorrect login and/or password!");
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          req.getRequestDispatcher("/WEB-INF/view/SingIn.jsp").forward(req, resp);
    }
}
