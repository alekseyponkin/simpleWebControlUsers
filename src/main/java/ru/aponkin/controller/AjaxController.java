package ru.aponkin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.aponkin.model.UserTable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class AjaxController.
 *
 * @author Ponkin Aleksey
 * @version 1.0.0
 * @since 29.10.2018.
 */
public class AjaxController extends HttpServlet {

    /**
     * Storage for Users.
     */
    private ConcurrentHashMap<Integer, UserTable> storageUsers = new ConcurrentHashMap<>();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        String str;
        while ((str = reader.readLine()) != null) {
            sb.append(str);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        UserTable userTable = objectMapper.readValue(sb.toString(), UserTable.class);
        storageUsers.put(userTable.hashCode(), userTable);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(objectMapper.writeValueAsString(storageUsers));
    }
}