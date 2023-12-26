/**
 * The Permit class represents a permit with an ID number, name, luxury rating, and number of credits.
 * 
 * This class provides methods to retrieve and manipulate permit information.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Permit 
{   
    // Fields to store permit information
    private int permitId;
    private String name;
    private int luxuryrating;
    private int noofcredits;
    
    /**
     * Constructor for creating a Permit object with specified values.
     * 
     * @param id The ID number of the permit.
     * @param n The name associated with the permit.
     * @param l The luxury rating of the permit.
     * @param c The initial number of credits associated with the permit.
     */
    public Permit( int id, String n, int l, int c )
    {
        permitId = id;
        name = n;
        luxuryrating = l;
        noofcredits = c;
    }
    
    /**
     * Get the ID number of the permit.
     * 
     * @return The permit's ID number.
     */
    public int getidnumber()
    { 
        return permitId;
    }
    
    /**
     * Get the name associated with the permit.
     * 
     * @return The name associated with the permit.
     */
    public String name()
    { 
        return name;
    }
    
    /**
     * Get the luxury rating of the permit.
     * 
     * @return The luxury rating of the permit.
     */
    public int getluxuryrating()
    { 
        return luxuryrating;
    }
    
    /**
     * Get the current number of credits associated with the permit.
     * 
     * @return The number of credits associated with the permit.
     */
    public int getcredits()
    { 
        return noofcredits;
    }
    
    /**
     * Add credits to the permit.
     * 
     * @param newcredits The number of credits to add.
     */
    
    public void addcredits(int newcredits)
    { 
        noofcredits = noofcredits + newcredits;
    }
    
    /**
     * Deduct credits from the permit.
     * 
     * @param subcredits The number of credits to deduct.
     */
     public void deductcredits(int subcredits)
    { 
        noofcredits = noofcredits - subcredits;
    }
    
    /**
     * Check if the permit has enough credits (at least 3 credits).
     * 
     * @return True if there are enough credits, false otherwise.
     */
    public boolean enoughcredit()
    {
        return (noofcredits >= 3);
    }
    
    /**
     * Provide a rating review based on the luxury rating.
     * 
     * @return A message indicating eligibility for a shuttle ride.
     */
    public String ratingreview()
    {
        String i = "\n You are eligible to make a shuttle ride";
        String n = "\n Sorry you cannot ride";
        return (luxuryrating >= 3) ? i : n;
    }
     
    /**
     * Get a string representation of the permit.
     * 
     * @return A string containing permit information.
     */
    public String toString()
    {
        return "\nPermit ID Number: " + permitId + "," + "   " + "Name "  + name +
               "  \n Luxury rating: " + luxuryrating + "  \nNumber of credits: " + noofcredits ;
    }
}
