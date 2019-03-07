package ru.aponkin.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.aponkin.model.User;
import ru.aponkin.service.ValidateMemoryService;
import ru.aponkin.service.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class UserControllerTest.
 *
 * @author Ponkin Aleksey
 * @version 1.0.0
 * @since 21.10.2018.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ValidateMemoryService.class)
public class UserControllerTest {

    /**
     * Test when add user then check user in store.
     * @throws ServletException
     * @throws IOException
     */
    @Ignore
    @Test
    public void whenAddUserThenStoreIt() throws ServletException, IOException {
        ValidateService validate = new ValidateStub();
        PowerMockito.mockStatic(ValidateMemoryService.class);
        when(ValidateMemoryService.getInstance()).thenReturn(validate);
        HttpServletRequest req = mock(HttpServletRequest.class);
        UserController userController = new UserController();
        userController.init();
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("action")).thenReturn("add");
        when(req.getParameter("name")).thenReturn("Ponkin Aleksey");
        when(req.getParameter("login")).thenReturn("ponkin");
        when(req.getParameter("password")).thenReturn("ponkin");
        when(req.getParameter("email")).thenReturn("ponkin@gmail.com");
        userController.doPost(req, resp);
        assertThat(validate.findAll().iterator().next().getName(), is("Ponkin Aleksey"));
    }

    /**
     * Test when add user then update user in store.
     * @throws ServletException
     * @throws IOException
     */
    @Ignore
    @Test
    public void whenAddUserThenUpdateUserInStore() throws ServletException, IOException {
        ValidateService validate = new ValidateStub();
        PowerMockito.mockStatic(ValidateMemoryService.class);
        when(ValidateMemoryService.getInstance()).thenReturn(validate);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        UserController userController = new UserController();
        userController.init();
        when(req.getParameter("action")).thenReturn("add");
        when(req.getParameter("name")).thenReturn("Ponkin Aleksey");
        when(req.getParameter("login")).thenReturn("ponkin");
        when(req.getParameter("password")).thenReturn("ponkin");
        when(req.getParameter("email")).thenReturn("ponkin@gmail.com");
        userController.doPost(req, resp);
        when(req.getParameter("action")).thenReturn("update");
        when(req.getParameter("name")).thenReturn("Aleksey Ponkin");
        when(req.getParameter("login")).thenReturn("ponkin");
        when(req.getParameter("password")).thenReturn("ponkin");
        when(req.getParameter("email")).thenReturn("ponkin@gmail.com");
        userController.doPost(req, resp);
        assertThat(validate.findAll().iterator().next().getName(), is("Aleksey Ponkin"));
    }

    /**
     * Test when add user then delete user from store.
     * @throws ServletException
     * @throws IOException
     */
    @Ignore
    @Test
    public void whenAddUserThenDeleteUserFromStore() throws ServletException, IOException {
        ValidateService validate = new ValidateStub();
        PowerMockito.mockStatic(ValidateMemoryService.class);
        when(ValidateMemoryService.getInstance()).thenReturn(validate);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        UserController userController = new UserController();
        userController.init();
        when(req.getParameter("action")).thenReturn("add");
        when(req.getParameter("name")).thenReturn("Ponkin Aleksey");
        when(req.getParameter("login")).thenReturn("ponkin");
        when(req.getParameter("password")).thenReturn("ponkin");
        when(req.getParameter("email")).thenReturn("ponkin@gmail.com");
        userController.doPost(req, resp);
        assertThat(validate.findAll().iterator().next().getName(), is("Ponkin Aleksey"));
        when(req.getParameter("action")).thenReturn("delete");
        when(req.getParameter("id")).thenReturn("0");
        userController.doPost(req, resp);
        assertFalse(validate.findAll().iterator().hasNext());
    }

    /**
     * Test when add users in store and get all users from store.
     * @throws ServletException
     * @throws IOException
     */
    @Ignore
    @Test
    public void whenAddUsersThenGetAllUsersFromStore() throws ServletException, IOException {
        ValidateService validate = new ValidateStub();
        PowerMockito.mockStatic(ValidateMemoryService.class);
        when(ValidateMemoryService.getInstance()).thenReturn(validate);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        UserController userController = new UserController();
        userController.init();
        when(req.getParameter("action")).thenReturn("add");
        when(req.getParameter("name")).thenReturn("Ponkin Aleksey");
        when(req.getParameter("login")).thenReturn("ponkin");
        when(req.getParameter("password")).thenReturn("ponkin");
        when(req.getParameter("email")).thenReturn("ponkin@gmail.com");
        userController.doPost(req, resp);
        when(req.getParameter("action")).thenReturn("add");
        when(req.getParameter("name")).thenReturn("Petr Arsentev");
        when(req.getParameter("login")).thenReturn("arsentev");
        when(req.getParameter("password")).thenReturn("arsentev");
        when(req.getParameter("email")).thenReturn("arsentev@gmail.com");
        userController.doPost(req, resp);
        Iterator<User> allUsersIterator = validate.findAll().iterator();
        assertThat(allUsersIterator.next().getName(), is("Ponkin Aleksey"));
        assertThat(allUsersIterator.next().getName(), is("Petr Arsentev"));
    }
}