import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

/**
 * The test class PermitTest.
 * This class contains a main method for testing the Permit class functionality.
 * Replace (your name) and (a version number or a date) with appropriate values.
 * 
 * Note: It's a good practice to use JUnit tests for unit testing instead of a main method in the production code.
 *       This main method is used here for demonstration purposes only.
 */
public class PermitTest
{
    public static void main(String[] args)
    {  
        // Create a Permit object with an initial balance of 1000 credits, owned by "Lynn", valid for 5 shuttle rides, and expiration in 10 days.
        Permit P1 = new Permit(1000, "Lynn", 5, 10);
        
        // Display the string representation of the Permit object using the toString() method.
        String p = P1.toString();
        System.out.println(p);
        
        // Check if "Lynn" has enough credits to make a shuttle ride and print the result.
        System.out.println("Does " + P1.name() + " have enough credits to make a shuttle ride: " + P1.enoughcredit());
        
        // Add 2 credits to the Permit object and display the new credit balance.
        P1.addcredits(2);
        System.out.println("Adding some Credits" + "\nnew balance is: " + P1.getcredits());  
        
        // Deduct 2 credits from the Permit object and display the new credit balance.
        P1.deductcredits(2);
        System.out.println("Deducting credits" + "\nnew balance after deduction is: " + P1.getcredits());
    }
}
