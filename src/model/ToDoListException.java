package model;

/**
 * @author Kobi Korsia & John Raviv & Matan Fried
 * a dedicated exception for the ToDoList project, used for simply distinguish the exception thrown by the project
 */
public class ToDoListException extends Exception
{
    /**
     * Default serial id.
     */
    private static final long serialVersionUID = 1L;

    /**
     * ToDoListException - constructor excepting message only
     * @param message
     */
    public ToDoListException(String message) {
        super("ToDoList Exception: " + message);
    }

    /**
     * ToDoListException - an exception wrapper for the Hibernate framework
     * @param message
     * @param cause
     */
    public ToDoListException(String message, Throwable cause)
    {
        super("ToDoList Exception: " + message, cause);
    }
}