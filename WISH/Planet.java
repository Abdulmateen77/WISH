 
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
    private int planetnumber;
    private String Name;
    private int luxuryrating;
    private int capacity;
    private ArrayList<Permit> permitList;
    
    public Planet(int pn, String n, int lr, int c)
    {
        planetnumber = pn;
        Name = n;
        luxuryrating = lr;
        capacity = c;
        permitList = new ArrayList<Permit>();
    }
    
      public int planetnumber()
    {
        return planetnumber;
    }
    
    public String GetplanetName ()
    {
        return Name;
    }
    
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
