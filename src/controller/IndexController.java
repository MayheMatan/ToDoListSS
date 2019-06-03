package controller;

import model.*;
import model.ToDoListTask;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class IndexController {

    private RequestDispatcher dispatcher;

    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ToDoListException {
        HibernateToDoListDAO hiber = HibernateToDoListDAO.getInstance();
        List<ToDoListTask> tasks = hiber.getTasks(request.getParameter("email"));
        request.getSession().setAttribute("tasks", tasks);
        dispatcher = request.getRequestDispatcher("/tasklist.jsp");
        dispatcher.forward(request, response);
    }
}