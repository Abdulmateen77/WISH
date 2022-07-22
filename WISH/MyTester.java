 
import java.util.*;
/**
 * Write a description of class OTester here.
 * 
 * @author 
 * @version 
 */
public class MyTester 
{   

    private void doTest()
    {
        Resort wayward = new Resort("Wayward Asteroids");
    
        // write your tests here by invoking Resort methods on the Resort object called wayward
        System.out.print("********** Permits *******");
        System.out.println(wayward.getAllPermitsOnEachPlanet());
    
        System.out.print("********** Planets *******");
        System.out.println(wayward.getallplanet());
        
        System.out.println("\n**** Get permit details ");
        String pp = wayward.getPermitDetails(1002);
        System.out.println(pp);
        
        
        System.out.println("\n**** Get permit Location");
        String lp = wayward.getPermitLocation(1001);
        System.out.println(lp);
        
        System.out.println("\n**** Adding permit to other planet***");
        
        String trv = wayward.travel(1001,"ABC1");
        System.out.println(trv);
        trv = wayward.travel(1001,"CDE3");
        System.out.println(trv);
        
        
    }
     
    
    public static void main(String[] args)
    {
        MyTester xx = new MyTester();
        xx.doTest();
    }
}
