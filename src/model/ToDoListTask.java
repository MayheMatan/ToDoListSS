package model;

/**
 * @author Kobi Korsia & John Raviv & Matan Fried
 * ToDoListTask class indicates the Task object for the ToDoList app.
 */

public class ToDoListTask {
    /**
     * the Task title, a Title for a single task
     */
    private String taskTitle;
    /**
     * the Task description, a description for a single task
     */
    private String taskDescription;
    /**
     * the user email this task belongs to. act also as the connection to the user in the data base
     */
    private String userEmail;
    /**
     * the item id, also the key for the data base
     */
    private int id;

    /**
     * Default Constructor
     */
    public ToDoListTask() {
    }

    /**
     * @param taskTitle
     * @param taskDescription
     * @param userEmail
     */
    public ToDoListTask(String taskTitle, String taskDescription, String userEmail) {
        setTaskTitle(taskTitle);
        setTaskDescription(taskDescription);
        setUserEmail(userEmail);
    }
    /**
     * @param taskTitle
     * @param taskDescription
     * @param userEmail
     * @param id
     */
    public ToDoListTask(String taskTitle, String taskDescription, String userEmail, int id) {
        setTaskTitle(taskTitle);
        setTaskDescription(taskDescription);
        setUserEmail(userEmail);
        setId(id);
    }
    /**
     * @return the user email
     */
    public String getUserEmail() {
        return userEmail;
    }
    /**
     * @param userEmail the User's email to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    /**
     * @return the task id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the task's id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the task title
     */
    public String getTaskTitle() {
        return taskTitle;
    }
    /**
     * @param taskTitle the task's title to set
     */
    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }
    /**
     * @return the task description
     */
    public String getTaskDescription() {
        return taskDescription;
    }
    /**
     * @param taskDescription the task's description to set
     */
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     * hashCode function to override the Java function.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
        result = prime * result + ((taskDescription == null) ? 0 : taskDescription.hashCode());
        result = prime * result + ((taskTitle == null) ? 0 : taskTitle.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     * equals function to override the Java function.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ToDoListTask)) {
            return false;
        }
        ToDoListTask other = (ToDoListTask) obj;
        if (userEmail == null) {
            if (other.userEmail != null) {
                return false;
            }
        } else if (!userEmail.equals(other.userEmail)) {
            return false;
        }
        if (taskTitle == null) {
            if (other.taskTitle != null) {
                return false;
            }
        } else if (!taskTitle.equals(other.taskTitle)) {
            return false;
        }
        if (taskDescription == null) {
            if (other.taskDescription != null) {
                return false;
            }
        } else if (!taskDescription.equals(other.taskDescription)) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     * toString function to override the Java function.
     */
    @Override
    public String toString() {
        return "ToDoListTask{" +
                "taskTitle='" + taskTitle + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", id=" + id +
                '}';
    }
}
