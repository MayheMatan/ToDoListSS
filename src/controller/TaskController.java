package controller;
import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class TaskController{

    private RequestDispatcher dispatcher;
    private final String taskListURL = "/ToDoListSS_war_exploded/Servlet/tasklist";
    private final String listByTaskController = "/ToDoListSS_war_exploded/Servlet/task/list";

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ToDoListException {
        HibernateToDoListDAO hiber = HibernateToDoListDAO.getInstance();
        String email = (String)request.getSession().getAttribute("email");
        List<ToDoListTask> tasks = hiber.getTasks(email);
        request.getSession().setAttribute("tasks", tasks);
        response.sendRedirect(taskListURL);
        }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ToDoListException {
        HibernateToDoListDAO hiber = HibernateToDoListDAO.getInstance();
        String email = request.getParameter("email");
        String taskTitle = request.getParameter("taskTitle");
        String description = request.getParameter("taskDescription");
        hiber.addTask(new ToDoListTask(taskTitle, description, email));
        System.out.println(email);
        response.sendRedirect(listByTaskController);
    }

    public void tasklist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ToDoListException {
        HibernateToDoListDAO hiber = HibernateToDoListDAO.getInstance();
        RequestParameters requestParameters = new RequestParameters(request);
        if (request.getParameter("updateBtn") != null) {
            ToDoListTask task = requestParameters.getParameters();
            System.out.println("update task:" + task);
            hiber.updateTask(task);
        }
        else if (request.getParameter("deleteBtn") != null) {
            ToDoListTask task = hiber.getItemById(Integer.parseInt(request.getParameter("id")));
            hiber.deleteTask(task);
        } else {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if (hiber.checkUserExistance(new Users(email, password))) {
                request.getSession().setAttribute("email", email);

            } else {
                dispatcher = request.getRequestDispatcher("/register.jsp");
                dispatcher.forward(request, response);
            }
        }
        List<ToDoListTask> tasks = hiber.getTasks(request.getParameter("email"));
        request.getSession().setAttribute("tasks", tasks);
        dispatcher = request.getRequestDispatcher("/tasklist.jsp");
        dispatcher.forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ToDoListException {
        HibernateToDoListDAO hiber = HibernateToDoListDAO.getInstance();
        int id = Integer.parseInt(request.getParameter("id"));
        ToDoListTask task = hiber.getItemById(id);
        request.getSession().setAttribute("task", task);
        dispatcher = request.getRequestDispatcher("/edit.jsp");
        dispatcher.forward(request, response);
    }
}
