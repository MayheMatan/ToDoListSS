package controller;
import model.HibernateToDoListDAO;
import model.RequestParameters;
import model.TdlTask;
import model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class TaskController{

    private RequestDispatcher dispatcher;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HibernateToDoListDAO hiber = HibernateToDoListDAO.getInstance();
        String email=(String)request.getSession().getAttribute("email"); // todo: make helper

        List<TdlTask> tasks = hiber.getTasks(email);
        System.out.println("e:" + email); // todo: make from session emi
        System.out.println("t:" + tasks);
        request.getSession().setAttribute("tasks", tasks);
        response.sendRedirect("/ToDoListSS_war_exploded/Servlet/tasklist"); // TODO: final string the ss Servlet...
//        request.getRequestDispatcher("/tasklist.jsp").forward(request, response);
//        response.sendRedirect("/ToDoListSS_war_exploded/Servlet/tasklist");
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HibernateToDoListDAO hiber = HibernateToDoListDAO.getInstance();
        String email = request.getParameter("email");
        String taskTitle = request.getParameter("taskTitle");
        String description = request.getParameter("taskDescription");

        hiber.addTask(new TdlTask(taskTitle, description, email));
        System.out.println(email);

        response.sendRedirect("/ToDoListSS_war_exploded/Servlet/task/list"); // TODO: minimum use as a constant the ss explodad shit

//        dispatcher = request.getRequestDispatcher("/tasklist.jsp");
//        dispatcher.forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void done(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Called done!");
    }

//
//
//
    public void tasklist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HibernateToDoListDAO hiber = HibernateToDoListDAO.getInstance();
        RequestParameters requestParameters = new RequestParameters(request);
        if (request.getParameter("updateBtn") != null) {
//            TdlTask task = hiber.getItemById(Integer.parseInt(request.getParameter("id")));
            TdlTask task = requestParameters.getParameters();
            System.out.println("update task:" + task);
            hiber.updateTask(task);
        }
        else if (request.getParameter("deleteBtn") != null) {
            TdlTask task = hiber.getItemById(Integer.parseInt(request.getParameter("id")));
//            TdlTask task = requestParameters.getParameters();
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
        List<TdlTask> tasks = hiber.getTasks(request.getParameter("email"));
        request.getSession().setAttribute("tasks", tasks);
        dispatcher = request.getRequestDispatcher("/tasklist.jsp");
        dispatcher.forward(request, response);
    }

////    public void addNewTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////
////        HibernateToDoListDAO hiber = HibernateToDoListDAO.getInstance();
////        String email = request.getParameter("email");
////        String taskTitle = request.getParameter("taskTitle");
////        String description = request.getParameter("taskDescription");
////
////        hiber.addTask(new TdlTask(taskTitle, description, email));
////        System.out.println(email);
////
////        dispatcher = request.getRequestDispatcher("/tasklist.jsp");
////        dispatcher.forward(request, response);
////
////        //TODO: Error file and massage, maybe JS alert to screen
////
////    }
////
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HibernateToDoListDAO hiber = HibernateToDoListDAO.getInstance();
        String email = request.getParameter("email");
        String taskTitle = request.getParameter("taskTitle");
        String description = request.getParameter("taskDescription");
        int id = Integer.parseInt(request.getParameter("id"));

        String task = request.getParameter("TdlTask");
        System.out.println(request.getSession().getAttribute("TdlTask"));
        System.out.println(request.getParameter("TdlTask"));

        request.getSession().setAttribute("task", new TdlTask(taskTitle,description,email,id));
        dispatcher = request.getRequestDispatcher("/edit.jsp");
        dispatcher.forward(request, response);


    }
}
////
////    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////
////        HibernateToDoListDAO hiber = HibernateToDoListDAO.getInstance();
////        String email = request.getParameter("email");
////        String taskTitle = request.getParameter("taskTitle");
////        String description = request.getParameter("taskDescription");
////        int id = Integer.parseInt(request.getParameter("id"));
////        System.out.println(taskTitle + description);
////
////        TdlTask task = (TdlTask) request.getSession().getAttribute("task");
////        System.out.println(" ");
////        hiber.updateTask(new TdlTask(taskTitle,description,email,id));
////
////        tasklist(request,response);
////
////        // dispatcher = request.getRequestDispatcher("/tasklist.jsp");
////        //  dispatcher.forward(request, response);
////    }
////
////}
