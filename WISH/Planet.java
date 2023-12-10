 
import java.util.ArrayList;
import java.util.*;
/**
 * An planet is part of a STAR resort.Each planet has a name,  a luxury rating
 * and a capacity which represents the maximum number of people(permits) who can be on the  
 * planet at any one time. Each planet must maintain a list of all people (permits)
 * currently on the planet. These lists are updated whenever permits enter or leave 
 * an planet,so that it is always possible to say how many people (permits) are on the planet 
 * and who they are.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Planet 
{
    // Fields to store planet information
    private int planetnumber;
    private String Name;
    private int luxuryrating;
    private int capacity;
    private ArrayList<Permit> permitList;
    
    /**
     * Constructor for creating a Planet object with specified values.
     * Initializes the permitList as an empty ArrayList.
     * 
     * @param pn The unique number of the planet.
     * @param n The name of the planet.
     * @param lr The luxury rating of the planet.
     * @param c The capacity of the planet.
     */
    public Planet(int pn, String n, int lr, int c)
    {
        planetnumber = pn;
        Name = n;
        luxuryrating = lr;
        capacity = c;
        permitList = new ArrayList<Permit>();
    }
    
    /**
     * Get the unique number of the planet.
     * 
     * @return The planet's unique number.
     */
    public int planetnumber()
    {
        return planetnumber;
    }
    
    /**
     * Get the name of the planet.
     * 
     * @return The name of the planet.
     */
    public String GetplanetName ()
    {
        return Name;
    }
    
    /**
     * Get the luxury rating of the planet.
     * 
     * @return The luxury rating of the planet.
     */
    public int luxuryrating ()
    {
        return luxuryrating;
    }
    
    public int noofpermit()
    {
        return permitList.size();
    
    }
    
    public void enter(Permit p)
    {
        permitList.add(p);
    }
    
    public void leave(int permitId)
    {
        Permit temp = findpermitattheplanet(permitId);
        if (temp != null)
        {
            permitList.remove(temp);
        }
    
    }
            
    public Permit findpermitattheplanet (int permitId)
    {
        for(int indx=0; indx<permitList.size(); indx++)
        {   
            Permit temp = permitList.get(indx);
            if (temp.getidnumber() == permitId)
            {
                return temp;
            }
        
        }  
        return null;
    }
    
    public boolean isfull()
    {   
        if (permitList.size() >= capacity)
        { 
            return true;
        }
        else
        {
            return false;
        }
    
    }
    
    public String getpermitlist()
    {
        String ls = "";
        if (permitList.size() >0)
        {
            for (Permit temp: permitList)
            {
            ls = ls + "\n" + temp.toString();
            }
            return ls + "\n*******************************";
        }
        return "\nNo Permits" + "\n*******************************";
    }
    
    public boolean checkpermit(int permitId)
    {
        for (int indx = 0; indx<permitList.size(); indx++)
        {
        Permit temp = permitList.get(indx);
        if (temp.getidnumber() == permitId)
        { 
            return true;
        }
        }
        return false;
    }
    
    public boolean creditcheck(int c)
    {
        if ( c >= 3)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    public String toString()
    {
        String pl;
        pl = "\n Planet number: " + planetnumber +  " " + Name 
              + "\n luxury rating: " + luxuryrating + "\n capacity: " + capacity 
              + "\nPermit List" + getpermitlist();
        return pl;
    }
}
