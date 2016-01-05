
package Insurance;


/**
 * Ashley Moore - 22/3/2013
 * Name class which creates the name object for the client details
 * 
 * @author Ash
 */
public class Name {
    //Defining the class variables
    private String initials;
    private String title;
    private String surname;

    /**
     * Default constructor for the name object which takes 3 parameters
     * @param title the title of the name
     * @param initials initials of the name
     * @param surname the clients surname
     */
    public Name(String title,String initials, String surname) {
        //Setting the object fields to the values from the parameters
        this.initials = initials.toUpperCase();
        this.title = title.toUpperCase();
        this.surname = surname.toUpperCase();
    }
    /**
     * A Method to return the the initials of the name
     * @return initials
     */
    public String getInitials() {
        return initials;
    }

    /**
     * A method to set the initials of the name
     * @param initials the initials of the client
     */
    public void setInitials(String initials) {
        this.initials = initials.toUpperCase();
    }

    /**
     * A method to return the title of the client
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * A method to set the title of the client
     * @param title title of the client
     */
    public void setTitle(String title) {
        this.title = title.toUpperCase();
    }

    /**
     * A method to return the surname of the client
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * A method to set the surname of the client
     * @param surname surname of client
     */
    public void setSurname(String surname) {
        this.surname = surname.toUpperCase();
    }

    /**
     * toString method which returns the full name of the client
     * @return name
     */
    @Override
    public String toString() {
        String name = String.format("Full name: %s %s %s",title,initials,surname);
        return name;
    }
    
    
}
