package ru.aponkin.servlet;

import ru.aponkin.model.User;
import ru.aponkin.service.ValidateMemoryService;
import ru.aponkin.service.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class UsersServlet.
 *
 * @author Ponkin Aleksey
 * @version 1.0.0
 * @since 25.05.2018.
 */
public class UsersServlet extends HttpServlet {
    /**
     * Validator.
     */
    private final ValidateService validate = ValidateMemoryService.getInstance();

protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder table = new StringBuilder();
        table.append("<table>");
        table.append("<tr><td>Name</td><td>Login</td><td>Email</td></tr>");
        for (User user : this.validate.findAll()) {
            table.append("<tr>");
            table.append("<td>" + user.getName() + "</td><td>" + user.getLogin() + "</td><td>" + user.getEmail() + "</td>");
            table.append("<td>");
            table.append("<form action = '" + req.getContextPath() + "/edit' method = 'get'>");
            table.append("<button name = 'id' value = '" + user.getId() + "'>Edit</button>");
            table.append("</form>");
            table.append("</td>");
            table.append("<td>");
            table.append("<form action = '" + req.getContextPath() + "/users' method = 'post'>");
            table.append("<input type = 'hidden' name = 'id' value = '" + user.getId() + "'>");
            table.append("<button name = 'action' value = 'delete'>Delete</button>");
            table.append("</form>");
            table.append("</td>");
            table.append("</tr>");
        }
        table.append("</table>");
        resp.setContentType("text/html");
        PrintWriter pw = new PrintWriter(resp.getOutputStream());
        pw.append("<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>All users</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>All users</h1>"
                + "\n"
                + table
                + "<form>"
                + "<button formaction = '" + req.getContextPath() + "/create'>Add user</button>"
                + "</form>"
                + "</body>\n"
                + "</html>");
        pw.flush();
    }
}