package model;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import java.util.List;



/**
 * @author Kobi Korsia & John Raviv & Matan Fried
 * The class to connect and use the database for the ToDoList project
 */
public class HibernateToDoListDAO implements IToDoListDAO {

    /**
     * the singleton instance of this class
     */
    public static final HibernateToDoListDAO INSTANCE = new HibernateToDoListDAO();

    private static SessionFactory myFactory = new AnnotationConfiguration().configure().buildSessionFactory();

    /**
     * the interface for using the HibernateToDoListDAO class
     *
     * @return the class instance
     */
    public static HibernateToDoListDAO getInstance() {
        return INSTANCE;
    }

    /**
     * private default constructor to prevent instances of this class
     */
    private HibernateToDoListDAO() {
    }

    /* (non-Javadoc)
     * @see model.IToDoListDAO#addUser(model.User)
     */
    @Override
    public void addNewUser(Users user) throws ToDoListException {
        Session session = myFactory.openSession();
        if (!checkUserExistance(user)) {
            try {
                //Insert user
                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
            } catch (HibernateException exception) {
                if (session.getTransaction() != null) {
                    session.getTransaction().rollback();
                    throw new ToDoListException(exception.getMessage(), exception.getCause());
                }

            } finally {
                if (session != null)
                    session.close();
            }
        }
    }

    /* (non-Javadoc)
     * @see model.IToDoListDAO#addUser(model.User)
     */
    @Override
    public Users getUser(String name) throws ToDoListException {
        Session session = myFactory.openSession();
        try {
            Query query = session.createQuery("from Users u where u.name='" + name + "'");
            List queryList = query.list();
            if (queryList != null && queryList.isEmpty())
                return null;
            else
                return (Users) queryList.get(0);
        } catch (HibernateException exception) {
            throw new ToDoListException(exception.getMessage(), exception.getCause());

        } finally {
            if (session != null)
                session.close();
        }
    }

    /* (non-Javadoc)
     * @see model.IToDoListDAO#addUser(model.User)
     */
    @Override
    public boolean deleteUser(Users user) throws ToDoListException {
        Session session = myFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException exception) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw new ToDoListException(exception.getMessage(), exception.getCause());

            }
        } finally {
            if (session != null)
                session.close();
        }
        return false;

    }

    /* (non-Javadoc)
     * @see model.IToDoListDAO#addUser(model.User)
     */
    @Override
    public void addTask(ToDoListTask task) throws ToDoListException {
        Session session = myFactory.openSession();

        try {
            session.beginTransaction();
            session.save(task);
            session.getTransaction().commit();
        } catch (HibernateException exception) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw new ToDoListException(exception.getMessage(), exception.getCause());
            }
        } finally {
            if (session != null)
                session.close();
        }

    }

    /* (non-Javadoc)
     * @see model.IToDoListDAO#addUser(model.User)
     */
    @Override
    public boolean deleteTask(ToDoListTask task) throws ToDoListException {
        Session session = myFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(task);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException exception) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw new ToDoListException(exception.getMessage(), exception.getCause());
            }
        } finally {
            if (session != null)
                session.close();
        }
        return false;

    }

    /* (non-Javadoc)
     * @see model.IToDoListDAO#addUser(model.User)
     */
    @Override
    public ToDoListTask getItemById(int itemId) throws ToDoListException {
        Session session = myFactory.openSession();
        ToDoListTask task = null;
        try {
            session.beginTransaction();
            if ((session.get(ToDoListTask.class, itemId) != null)) {
                session.getTransaction().commit();
                task = (ToDoListTask) session.get(ToDoListTask.class, itemId);
            }
        } catch (HibernateException exception) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw new ToDoListException(exception.getMessage(), exception.getCause());
            }
        } finally {
            session.close();
        }
        return task;
    }
    /* (non-Javadoc)
     * @see model.IToDoListDAO#addUser(model.User)
     */
    @Override
    public boolean updateTask(ToDoListTask task) throws ToDoListException {
        Session session = myFactory.openSession();
        try {
            session.beginTransaction();
            session.update(task);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException exception) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw new ToDoListException(exception.getMessage(), exception.getCause());

            }
        } finally {
            if (session != null)
                session.close();
        }
        return false;

    }
    /* (non-Javadoc)
     * @see model.IToDoListDAO#addUser(model.User)
     */
    @Override
    public List<ToDoListTask> getTasks(String userEmail) throws ToDoListException {
        Session session = myFactory.openSession();
        try {
            Query query = session.createQuery("from ToDoListTask i WHERE i.userEmail='" + userEmail + "'");
            List queryList = query.list();
            if (queryList != null && queryList.isEmpty())
                return null;
            else
                return (List<ToDoListTask>) queryList;
        } catch (HibernateException exception) {
            throw new ToDoListException(exception.getMessage(), exception.getCause());
        } finally {
            if (session != null)
                session.close();
        }
    }

    public boolean checkUserExistance(Users user) throws ToDoListException {
        Session session = myFactory.openSession();
        try {
        Query query = session.createQuery("from Users where email=?");
        Users users = (Users) query.setString(0, user.getEmail()).uniqueResult();
        if (users != null)
            return true;
        return false;
        } catch (HibernateException exception) {
            throw new ToDoListException(exception.getMessage(), exception.getCause());
        }
        finally {
            if (session != null)
                session.close();
        }
    }
}
