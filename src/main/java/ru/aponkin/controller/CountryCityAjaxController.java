package ru.aponkin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.aponkin.service.ValidateMemoryService;
import ru.aponkin.service.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Class CountryCityAjaxController.
 *
 * @author Ponkin Aleksey
 * @version 1.0.0
 * @since 18.11.2018.
 */
public class CountryCityAjaxController extends HttpServlet {
    /**
     * Validator.
     */
    private final ValidateService validate = ValidateMemoryService.getInstance();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String country = req.getParameter("country");
        List<String> city = validate.getAllCityByCountry(country);

        ObjectMapper objectMapper = new ObjectMapper();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(objectMapper.writeValueAsString(city));

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> country = validate.getAllCountry();
        ObjectMapper objectMapper = new ObjectMapper();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(objectMapper.writeValueAsString(country));
    }
}
