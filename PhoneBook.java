import java.util.Arrays;
import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.*;
/**
 * Phone book is a menu driven application. It can perform
 * following activities:
 * Add a new contact to the list
 * Display list of all contacts
 * Sort contacts by last name
 * Serach for a contact by last name
 *
 * @author (Derek Holsapple)
 * @version (20181130)
 */
public class PhoneBook
{
    private static Contact[] list;
    private static int count;
    private static Scanner kb;

    public static void main (String[] args)
    {
        list = new Contact[100];

        //Set count to 0.
        count = 0;

        //Create Scanner object to read data from keyboard
        kb = new Scanner(System.in);

        boolean quit = false;
        String choice;

        System.out.println ("Phone Book Application");
        System.out.println ("===============================");

        //Loop will iterate as long as quit is false
        while (!quit)
        {
            //Display the menu
            System.out.println ("A - Add a new contact to the list");
            System.out.println ("B - Display list of all contacts");
            System.out.println ("C - Sort contacts by last name");
            System.out.println ("D - Search for a contact by last name");
            System.out.println ("E - Exit");
            System.out.print ("Enter your selection (A, B, C, D, or E): ");
            choice = kb.nextLine();

            //Execute the selected command
            switch (choice)
            {
                case ("A"):
                case ("a"):
                addContact ();
                break;
                case ("B"):
                case ("b"):
                displayContact ();
                break;
                case ("C"):
                case ("c"):
                sortContact();
                break;
                case ("D"):
                case ("d"):
                searchContact();
                break;
                case ("E"):
                case ("e"):
                quit = true;
                break;
                default:
                System.out.println ("Error: Incorrect choice");
            }

            System.out.println ("===============================");
        }   
    }

    /**
     * addContact method will ask user for first name, last name
     * and email address of the contact, it will create the contact
     * object and add it to the array (list).
     * Note: Scanner (kb), Contact Array (list) and count have already
     * been created in main method.
     */
    private static void addContact ()
    {
        //Add code for addContact method. Add the new contact at the index position given by count. 
        //Make sure you update count after adding new contact to the list.

        System.out.println("Enter First Name");
        String firstName = kb.nextLine();
        System.out.println("Enter Last Name");
        String lastName = kb.nextLine();
        System.out.println("Enter your email");
        String email = kb.nextLine();

        //use the contact class to create a contact profile
        list[count] = new Contact(firstName, lastName, email);

        //add one to the counter
        count++;

        //see if the name exists in the array "list"
        System.out.println(Arrays.toString(list));

    }

    /**
     * displayContact method will display the list of all contacts.
     */
    private static void displayContact ()
    {

        //Add code for the displayContact method. 
        //Make sure that you use count in the test for the loop. 
        //You will have to use the getFirstName, getLastName, 
        //and getEmailAddress methods in the Contact class to get the first name,
        //last name and email address to display them.

        if(count>0)
        {
            for(int i=0; i < count; i++)
            {

                System.out.print("Contact Information #" + (i+1));
                System.out.println();
                System.out.println();

                //use the methods in Contact class to display all the current contacts
                System.out.println("First Name: " + list[i].getFirstName());
                System.out.println("Last Name: " + list[i].getLastName());
                System.out.println("email: " + list[i].getEmailAddress());
                System.out.println();

            }

        }
        else
        {
            System.out.println();
            System.out.print("Error: There are no Contacts in this List"); 
            System.out.println();
            System.out.println();

        }

    }

    /**
     * Sort contact list by last name.
     */
    private static void sortContact ()
    {
        //Add code for sortContact method. Sort contacts by last name only. 
        //You will have to use getLastName method in the Contact class.


        for(int i = 0; i < count; i++)
        {
            String matchLastName = list[i].getLastName();
            //Arrays.sort(list);
            //System.out.println(Collections.sort(matchLastName));

        }

    }

    /**
     * searchContact will ask the user for last name, search for contact
     * in the list, and display the first name, last name and email
     * address of the contact. If the contact is not found then it will
     * display an error message
     * 
     */
    private static void searchContact ()
    {
        //Add code for searchContact method. 
        //It searches for contact by last name only. 
        //It should find and display the first contact with the given last name. 
        //(Optional): Display all contacts with the given last name.

        System.out.println("What is the Last Name you are searching for?");
        String userInput = kb.nextLine();

        for(int i = 0; i < count; i++)
        {
            //create string matchLastName,  this equals an array set by the count and 
            //uses the method getLastName from class Contact to pull last name from newly created array
            String matchLastName = list[i].getLastName();

            //if the user input matches a lastName in the array then the program
            //will print all the users data
            if (matchLastName.equals(userInput))
            {
                System.out.print("Contact Information #" + (i+1));
                System.out.println();
                System.out.println();
                System.out.println("First Name: " + list[i].getFirstName());
                System.out.println("Last Name: " + list[i].getLastName());
                System.out.println("email: " + list[i].getEmailAddress());
                System.out.println();

                // if(!matchLastName.equals(userInput))
                // {
                // System.out.println();
                // System.out.print("Error: There is no Contact with that name in the list"); 
                // System.out.println();
                // System.out.println();
                // }
            }
            else if(i==(count-1))
            {
                System.out.println();
                System.out.print("Error: There is no Contact with that name in the list"); 
                System.out.println();
                System.out.println();  
                break;
                
            }
            

        }
    }
}

