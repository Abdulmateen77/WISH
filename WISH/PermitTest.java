

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;  

/**
 * The test class PermitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PermitTest
{
    public static void main(String[] args)
    {  
        
        Permit P1 = new Permit(1000, "Lynn", 5, 10);
        
        String p = P1.toString();
        System.out.println(p);
        
        System.out.println("Does " + P1.name() + " have enough credits to make a shuttle ride: " + P1.enoughcredit());
        
        P1.addcredits(2);
        System.out.println("Adding some Credits" + "\nnew balance is: " + P1.getcredits());  
        
        P1.deductcredits(2);
        System.out.println("Deducting credits" + "\nnew balance after deduction is: " + P1.getcredits());

        
    
    }

}
