package ru.aponkin.controller;

import ru.aponkin.service.ValidateMemoryService;
import ru.aponkin.service.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class UserCreateController.
 *
 * @author Ponkin Aleksey
 * @version 1.0.0
 * @since 25.05.2018.
 */
public class UserCreateController extends HttpServlet {
    /**
     * Validator.
     */
    private final ValidateService validate = ValidateMemoryService.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", this.validate.findAllRole());
        req.getRequestDispatcher("/WEB-INF/view/UserCreate.jsp").forward(req, resp);
    }
}