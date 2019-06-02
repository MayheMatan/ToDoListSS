package controller;

import model.HibernateToDoListDAO;
import model.TdlTask;
import model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController {

    RequestDispatcher dispatcher;

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Called login");
        HibernateToDoListDAO hiber = HibernateToDoListDAO.getInstance(); // TODO: this.hiber by extending BaseController which alreay does this
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (hiber.checkUserExistance(new Users(email, password))) {
            request.getSession().setAttribute("email", email);

        } else {
            dispatcher = request.getRequestDispatcher("/login.jsp"); // TODO: create function in base for this.redirect(String path)
            dispatcher.forward(request, response);
        }

        // TODO: move this to a helper function (DRY) also in base controller as a function, this.dispatch()/this.end()
        response.sendRedirect("/ToDoListSS_war_exploded/Servlet/task/list"); // TODO: minimum use as a constant the ss explodad shit

    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: after base class with session and shit, this should be 2 lines ~
        System.out.println("Called login");
        HibernateToDoListDAO hiber = HibernateToDoListDAO.getInstance(); // TODO: this.hiber by extending BaseController which alreay does this
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (!hiber.checkUserExistance(new Users(email, password))) {
            dispatcher = request.getRequestDispatcher("/register.jsp"); // TODO: create function in base for this.redirect(String path)
            dispatcher.forward(request, response);
        } else {
            this.login(request, response);
        }
    }
}
//    public void router(String action, RequestParameters parameters, HttpServletResponse response) throws ServletException, IOException {
//        HibernateToDoListDAO hiber = HibernateToDoListDAO.getInstance();
//
//        switch (action) {
//            case "login":
//                System.out.println("Called login");
//                break;
//        }
//        if (request.getParameter("updateBtn") != null) {
//            TdlTask task = getParameters(request);
//            hiber.updateTask(task);
//        } else if (request.getParameter("deleteBtn") != null) {
//            TdlTask task = getParameters(request);
//            hiber.deleteTask(task);
//        } else {
//            String email = request.getParameter("email");
//            String password = request.getParameter("password");
//            if (hiber.checkUserExistance(new Users(email, password))) {
//                request.getSession().setAttribute("email", email);
//
//            } else {
//                dispatcher = request.getRequestDispatcher("/register.jsp");
//                dispatcher.forward(request, response);
//            }
//        }
//        List<TdlTask> tasks = hiber.getTasks(request.getParameter("email"));
//        request.getSession().setAttribute("tasks", tasks);
//        dispatcher = request.getRequestDispatcher("/tasklist.jsp");
//        dispatcher.forward(request, response);
//    }
//}
//
//    public void about(HttpServletRequest request, HttpServletResponse response) {}
//
//    public void register(HttpServletRequest request, HttpServletResponse response) {
//    }
//    public void index(HttpServletRequest request, HttpServletResponse response) {}
//    public void login(HttpServletRequest request, HttpServletResponse response) {}
//
//    public void registerNewUser(HttpServletRequest request, HttpServletResponse response) {
//        HibernateToDoListDAO hiber = HibernateToDoListDAO.getInstance();
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        String userName = request.getParameter("userName");
//
//        try {
//            if (!hiber.checkUserExistance(new Users(email, password))) {
//                hiber.addNewUser(new Users(email, password, userName));
//                request.getSession().setAttribute("email", email);
//                dispatcher = request.getRequestDispatcher("/tasklist.jsp");
//                dispatcher.forward(request, response);
//            } else {
//                //TODO: Error file and massage, maybe JS alert to screen
//
//            }
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
