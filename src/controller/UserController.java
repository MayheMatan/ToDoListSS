package controller;

import model.HibernateToDoListDAO;
import model.ToDoListException;
import model.Users;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController {

    private RequestDispatcher dispatcher;
    private final String listByTaskController = "/ToDoListSS_war_exploded/Servlet/task/list";

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ToDoListException {
        System.out.println("Called login");
        HibernateToDoListDAO hiber = HibernateToDoListDAO.getInstance();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (hiber.checkUserExistance(new Users(email, password))) {
            request.getSession().setAttribute("email", email);

        } else {
            dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
        response.sendRedirect(listByTaskController);
    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            dispatcher = request.getRequestDispatcher("/register.jsp");
            dispatcher.forward(request, response);
    }

    public void registerNewUser(HttpServletRequest request, HttpServletResponse response) {
        HibernateToDoListDAO hiber = HibernateToDoListDAO.getInstance();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");

        try {
            if (!hiber.checkUserExistance(new Users(email, password))) {
                hiber.addNewUser(new Users(email, password, userName));
                request.getSession().setAttribute("email", email);
                dispatcher = request.getRequestDispatcher("/tasklist.jsp");
                dispatcher.forward(request, response);
            }
        } catch (ServletException | IOException | ToDoListException e) {
            e.printStackTrace();
        }
    }
}

