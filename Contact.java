
/**
 * This is the contact class which can keep track of a person's
 * first name, last name, and e-mail address.
 *
 * @author Dr. Salim Lakhani.
 * @version 20181124
 */
public class Contact
{
    private String firstName;
    private String lastName;
    private String emailAddress;
    
    /**
     * Constructor initializes an object of Contact class. All
     * fields are initialized using value passed through 
     * parameter.
     * @param fn First name of the contact
     * @param ln Last name of the contact
     * @param email Email address of the contact
     */
    public Contact (String fn, String ln, String email)
    {
        firstName = fn;
        lastName = ln;
        emailAddress = email;
    }
    
    /**
     * Returns first name of the contact
     * @return First name of the contact.
     */
    public String getFirstName ()
    {
        return firstName;
    }
    
    /**
     * Returns last name of the contact
     * @return Last name of the contact.
     */
    public String getLastName ()
    {
        return lastName;
    }
    
    /**
     * Returns email address of the contact
     * @return Email address of the contact.
     */
    public String getEmailAddress ()
    {
        return emailAddress;
    }
}
