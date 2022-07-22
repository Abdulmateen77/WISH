 
/**
 * A Permit has an id number, name, a luxury rating and number of credits.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Permit 
{   private int permitId;
    private String name;
    private int luxuryrating;
    private int noofcredits;
    
    public Permit( int id, String n, int l, int c )
    {
        permitId = id;
        name = n;
        luxuryrating = l;
        noofcredits = c;
    }
    
    public int getidnumber()
    { 
        return permitId;
    
    }
    
    public String name()
    { 
        return name;
    
    }
    
    public int getluxuryrating()
    { 
        return luxuryrating;
    
    }
    
    public int getcredits()
    { 
        return noofcredits;
    
    }
    
    public void addcredits(int newcredits)
    { 
        noofcredits = noofcredits + newcredits;
    }
    
     public void deductcredits(int subcredits)
    { 
        noofcredits = noofcredits - subcredits;
    }
    
    public boolean enoughcredit()
    {
        if (noofcredits >= 3 )
        {
        return true;
        }
        else return false;
    }
    
    public String ratingreview()
    {
        String i = "\n You are eligible to make a shuttle ride";
        String n = "\n Sorry you cannot ride";
        if (luxuryrating >= 3 )
        {
        return i;
        }
        else return n;
    }
     
    public String toString()
    {
        String p;
        p = "\nPermit ID Number: " + permitId + ","+ "   " + "Name "  + name + "  \n Luxury rating: "
                                + luxuryrating + "  \nNumber of credits: " + noofcredits ;
        return p;
    }
}
