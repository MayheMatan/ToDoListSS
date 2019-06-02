package model;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class RequestParameters {

    private Map<String, String[]> parameters;

    public RequestParameters(HttpServletRequest request) {
        // Initialize the parameters
        this.setParameters(request);
    }

    private void setParameters(HttpServletRequest request) {
       this.parameters = request.getParameterMap();
    }

    public String[] get(String key) {
        return this.parameters.get(key);

    }
    public TdlTask getParameters() {
        System.out.println(parameters.size());
        if (parameters.size() > 3) {
            String[] email = this.get("email");
            String[] idString =this.get("id");
            int idInt = Integer.parseInt(idString[0]);
            String[] description = this.get("taskDescription");
            String[] title = this.get("taskTitle");
            return new TdlTask(title[0],description[0],email[0],idInt);
        }
        return null;
    }
}
