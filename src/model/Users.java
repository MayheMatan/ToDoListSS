package model;

import java.io.Serializable;
import java.util.ArrayList;

    /**
    * @author Kobi Korsia & John Raviv & Matan Fried
    * User class indicates the User object for the ToDoList app.
    */

public class Users implements Serializable {

    private static final long serialVersionUID = 56037785502L;

    ArrayList<ToDoListTask> taskList = new ArrayList<>();

    /**
     * the user's email
     */
    private String email;

    /**
     * the user's password
     */
    private String password;

    /**
     * the user's name
     */
    private String name;

    /**
     * the user's id
     */
    private int id;

    /**
     * Default constructor
     */
    public Users() {
    }
    /**
     * @param email
     * @param password
     */
    public Users(String email, String password) {
        setEmail(email);
        setPassword(password);
    }
    /**
     * @param email
     * @param password
     * @param name
     */
    public Users(String email, String password, String name) {
        setEmail(email);
        setPassword(password);
        setName(name);
    }

    /**
     * @return the user's name
     */

    public String getName() {
        return name;
    }

    /**
     * @param name the user's name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the user's id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

        /* (non-Javadoc)
         * @see java.lang.Object#hashCode()
         * hashCode function to override the Java function.
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + ((email == null) ? 0 : email.hashCode());
            result = prime * result + ((password == null) ? 0 : password.hashCode());
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
            if (!(obj instanceof Users)) {
                return false;
            }
            Users other = (Users) obj;
            if (name == null) {
                if (other.name != null) {
                    return false;
                }
            } else if (!name.equals(other.name)) {
                return false;
            }
            if (password == null) {
                if (other.password != null) {
                    return false;
                }
            } else if (!password.equals(other.password)) {
                return false;
            }
            if (email != other.email) {
                return false;
            }
            if (email == null) {
                if (other.email != null) {
                    return false;
                }
            } else if (!email.equals(other.email)) {
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
        return "Users{" +
                "taskList=" + taskList +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
