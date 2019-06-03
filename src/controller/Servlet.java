package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Kobi Korsia & John Raviv & Matan Fried
 * Servlet implementation class AppRouter
 */
@WebServlet(name = "/Servlet/*")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static String pkg = "controller";

    /**
     * Default Constructor
     */
    public Servlet() {
        super();
    }

    private void dispatch(String controllerClassName, String action, HttpServletRequest request, HttpServletResponse response ) {
        try {
            Class cls = Class.forName(pkg + "." + controllerClassName);
            Object object = cls.newInstance();
            Method method = cls.getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(object, request, response);

        } catch ( ClassNotFoundException | InstantiationException |
                IllegalAccessException | NoSuchMethodException | SecurityException |
                IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void invokeController(HttpServletRequest request, HttpServletResponse response)  {
        String str = request.getPathInfo();
        String paths[] = str.split("/");

        // Check if we are in the index of the site
        if (paths.length == 0) {
            this.dispatch("IndexController", "show", request, response);
            return;
        }

        if (paths.length == 2) {
            String view = paths[1];
            try {
                getServletContext().getRequestDispatcher("/" + view + ".jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
            return;
        }

        String controller = paths[1];
        String action = paths[2];
        String controllerClassName = controller.substring(0, 1).toUpperCase() + controller.substring(1) + "Controller";
        this.dispatch(controllerClassName, action, request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        this.invokeController(request, response);
    }

    /**
     * This method act like the router routing all post and get requests to be handles acordingly
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        this.invokeController(request, response);
    }
}
