package ru.aponkin.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class EchoServlet.
 *
 * @author Ponkin Aleksey
 * @version 1.0.0
 * @since 15.05.2018.
 */
public class EchoServlet extends HttpServlet {
    /**
     * Logger.
     */
    private static Logger logger = LogManager.getLogger(EchoServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        printWriter.append("hello word.");
        printWriter.flush();
    }
}