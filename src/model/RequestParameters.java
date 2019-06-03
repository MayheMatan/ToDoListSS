package model;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Kobi Korsia & John Raviv & Matan Fried
 * RequestParameters class indicates the Task Parameters for the ToDoList app.
 */
public class RequestParameters {
    /**
     * the map parameters, is also the key to the other parameters for the task
     */
    private Map<String, String[]> parameters;

    /**
     * Default Constructor
     */
    public RequestParameters(HttpServletRequest request) {
        // Initialize the parameters
        this.setParameters(request);
    }

    /**
     * @param request the request's parameters
     */
    private void setParameters(HttpServletRequest request) {
       this.parameters = request.getParameterMap();
    }

    public String[] get(String key) {
        return this.parameters.get(key);

    }

    /**
     *
     * @return all the parameters for a task as a ToDoListTask
     */
    public ToDoListTask getParameters() {
        System.out.println(parameters.size());
        if (parameters.size() > 3) {
            String[] email = this.get("email");
            String[] idString =this.get("id");
            int idInt = Integer.parseInt(idString[0]);
            String[] description = this.get("taskDescription");
            String[] title = this.get("taskTitle");
            return new ToDoListTask(title[0],description[0],email[0],idInt);
        }
        return null;
    }
}
