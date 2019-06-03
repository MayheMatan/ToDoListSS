package model;


import java.util.List;
/**
 * @author Kobi Korsia & John Raviv & Matan Fried
 * The interface for applying connection and usage of the database for the ToDoList project
 */
public interface IToDoListDAO {
    /**
     *User API functions
     */

    /**
     * @param user
     * @throws ToDoListException
     */
    public void addNewUser(Users user) throws ToDoListException;
    /**
     * @param name
     * @return the user's name
     * @throws ToDoListException
     */
    public Users getUser(String name) throws ToDoListException;
    /**
     * @param user
     * @return true/false whether the user deleted or not
     * @throws ToDoListException
     */
    public boolean deleteUser(Users user) throws ToDoListException;


    /**
     * Taks API functions
     */

    /**
     * @param task
     * @throws ToDoListException
     */
    public void addTask(ToDoListTask task) throws ToDoListException;
    /**
     * @param task
     * @return true/false whether the task deleted or not
     * @throws ToDoListException
     */
    public boolean deleteTask(ToDoListTask task) throws ToDoListException;
    /**
     * @param task
     * @return true/false whether the task updated or not
     * @throws ToDoListException
     */
    public boolean updateTask(ToDoListTask task) throws ToDoListException;
    /**
     * @param userName
     * @return List of tasks belongs to a single userName
     * @throws ToDoListException
     */
    public List<ToDoListTask> getTasks(String userName) throws ToDoListException;
    /**
     * @param itemId
     * @return ToDoListTask parameters by a single Task's id
     * @throws ToDoListException
     */
    public ToDoListTask getItemById(int itemId) throws ToDoListException;


}
