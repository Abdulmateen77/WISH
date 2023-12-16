 import java.util.*;

/**This class implements the WISH interface
 *
 * @author 
 * @version 
 **/
/**
 * Represents a Resort that implements the WISH (World Interplanetary Space Hub) interface.
 */
public class Resort implements WISH {

    // Private fields to store the Resort location, permits, planets, and shuttles
    private String Resortlocation;
    private ArrayList<Permit> allpermits = new ArrayList<Permit>();
    private ArrayList<Planet> allplanets = new ArrayList<Planet>();
    private ArrayList<Shuttle> allshuttle = new ArrayList<Shuttle>();

    /**
     * Constructs a Resort with the specified location.
     *
     * @param loc The location of the Resort.
     */
    public Resort(String loc) {
        Resortlocation = loc;
        
        // Load planets, permits, and set up shuttles during the initialization of the Resort
        loadPlanets();
        loadPermits();
        setUpShuttles();
    }

    // Additional methods and functionalities can be implemented here
}

    /**
     * Returns all of the details of all planets including the permits
     * currently on each planet, on "No permits"
     * @return all of the details of all planets including location 
     * and all permits currently on each planet, or "No permits" 
     */
    public String toString()
    {
        for (Planet temp: allplanets)
        {
            return temp.toString();
        }
        return "";
    }
    
    /**Returns a String with details of a permit
     * @param permitId - id number of the permit
     * @return the details of the permit as a String, or "No such permit"
     */
    public String getPermitDetails(int permitId)
    {
        for (Permit temp: allpermits)
        {
            if (temp.getidnumber() == permitId)
            {
                return temp.toString();
            }
            
        }
        return "No Permit found";
    }

    
    /** Given the name of a planet, returns the planet id number
     * or -1 if planet does not exist
     * @param name of planet
     * @return id number of planet
     */
    public int getPlanetNumber(String ww)
    {
        for (Planet temp: allplanets)
        {
            if (temp.GetplanetName() == ww)
            {
                return temp.planetnumber();
            }
        }
        
        
        return -1;
    }
    
    /**Returns a String representation of all the permits on all planets
     * @return a String representation of all permits on all planets
     **/
    public String getAllPermitsOnEachPlanet()
    {
        String all = "";
        for (int i = 0; i < allpermits.size(); i++)
        {
            Permit temp = allpermits.get(i);
            all = all + "\n " + temp.toString();
        }
        
        return all;
    } 
 
    
    /**Returns the name of the planet which contains the specified permit or null
     * @param tr - the specified permit
     * @return the name of the Planet which contains the permit, or null
     **/
    public String getPermitLocation(int tr)
    {
        for (Planet temp: allplanets)
        {
            if (temp.findpermitattheplanet(tr) == findpermit(tr))
            {
                return temp.GetplanetName();
            }
        }
         
        return null;
    }
    
    /*finds a permit **/
    
    public Permit findpermit(int permitId)
    {
        for(int i = 0; i < allpermits.size(); i++)
        {
            Permit temp = allpermits.get(i);
            if(temp.getidnumber() == permitId)
            {
                return temp;
            }
        }
        return null;
    }
    
               
    /**Returns a String representation of all the permits on specified planet
     * @return a String representation of all permits on specified planet
     **/
    public String getAllPermitsOnOnePlanet(String planet)
    {
        for (Planet temp: allplanets)
        {if (temp.GetplanetName() == planet)
            {
                return temp.getpermitlist();
            }
        }
        return null;
    }
    
    //Planet details//
    public String getallplanet()
    {
        String p = "";
        for(int i = 0; i < allplanets.size(); i++)
        {
            Planet temp = allplanets.get(i);
            p = p + "\n " + temp.toString();
        }
        return p;
    }

    
     /**Returns true if a Permit is allowed to move using the shuttle, false otherwise
      * A move can be made if:  
      * the rating of the permit  >= the rating of the destination planet
      * AND the destination planet is not full
      * AND the permit has sufficient credits
      * AND the permit is currently on the source planet
      * AND the permit id is for a permit on the system
      * AND the shuttle code is the code for a shuttle on the system
      * @param pId is the id of the permit requesting the move
      * @param shtlCode is the code of the shuttle journey by which the permit wants to pPermitel
      * @return true if the permit is allowed on the shuttle journey, false otherwise 
      **/
  public boolean canTravel(int pId, String shtlCode) {
    // Other checks (if any) may be implemented here
    
    // Find the shuttle associated with the provided code
    Shuttle tr = findTravel(shtlCode);
    
    // Find the travel permit associated with the provided person ID
    Permit p = findPermit(pId);
    
    // If either the shuttle or the permit is not found, return false
    if (tr == null || p == null) {
        return false;
    } else {
        // Check if the person with the given permit can ride the specified shuttle
        return tr.canShuttleRide(p);
    }
}
    /**Returns the result of a permit requesting to move by Shuttle.
     * A move will be successful if:  
     * the luxury rating of the permit  >= the luxury rating of the destination planet
     * AND the destination planet is not full
     * AND the permit has sufficient credits
     * AND the permit is currently on the source planet
     * AND the permit id is for a permit on the system
     * AND the shuttle code is the code for a shuttle on the system
     * If the shuttle journey can be made, the permit information is removed from the source
     * planet, added to the destination planet and a suitable message returned.
     * If shuttle journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param ppId is the id of the permit requesting the move
     * @param shtlCode is the code of the shuttle journey by which the permit wants to pPermitel
     * @return a String giving the result of the request 
     **/
    public String travel(int ppId, String shtlCode )
    {   //other checks optional
        Shuttle tr = findtravel(shtlCode );
        Permit p = findpermit(ppId);
        
        if (tr == null)
        {
            return "no such Shuttle found ";
        }
        else if (p == null)
        {
            return "no such permit found ";
        }
        else
        {
            return tr.movepermit(p);
        }
    } 
         
    // These methods are for Task 6 only and not required for the Demonstration 
    // If you choose to implement them, uncomment the following code
    

    /** Allows a permit to top up their credits.This method is not concerned with 
     *  the cost of a credit as currency and prices may vary between resorts.
     *  @param id the id of the permit toping up their credits
     *  @param creds the number of credits purchased to be added to permits information
     */
    public void topUpCredits(int id, int creds)
    {
        for (Permit temp: allpermits)
        {
            if (temp.getidnumber() == id)
            {
                temp.addcredits(creds);
            }
        }
    }
   
    //***************private methods**************
  /**
 * This class represents a Resort implementing the WISH (World Interplanetary Space Hub) interface.
 * It manages planets, shuttles, and permits, providing methods for loading initial data and performing
 * searches within these entities.
 */
public class Resort implements WISH {

    // Private fields to store the Resort location, permits, planets, and shuttles
    private String Resortlocation;
    private ArrayList<Permit> allpermits = new ArrayList<Permit>();
    private ArrayList<Planet> allplanets = new ArrayList<Planet>();
    private ArrayList<Shuttle> allshuttle = new ArrayList<Shuttle>();

    /**
     * Constructs a Resort with the specified location. Loads initial data for planets, permits, and shuttles.
     *
     * @param loc The location of the Resort.
     */
    public Resort(String loc) {
        Resortlocation = loc;
        
        // Load initial data for planets, permits, and shuttles during the initialization of the Resort
        loadPlanets();
        loadPermits();
        setUpShuttles();
    }

    /**
     * Loads initial data for planets into the Resort.
     */
    private void loadPlanets() {
        // Create and add planets to the list
        Planet p1 = new Planet(0, "Home", 0, 1000);
        allplanets.add(p1);
        Planet p2 = new Planet(1, "Sprite", 1, 100);
        allplanets.add(p2);
        Planet p3 = new Planet(2, "Tropicana", 3, 10);
        allplanets.add(p3);
        Planet p4 = new Planet(3, "Fantasia", 5, 2);
        allplanets.add(p4);
        Planet p5 = new Planet(4, "Solo", 1, 1);
        allplanets.add(p5);
    }
    
    /**
     * Sets up shuttles connecting different planets.
     */
    private void setUpShuttles() {
        // Find planets by their numbers
        Planet p1 = findplanet(0);
        Planet p2 = findplanet(1);
        Planet p3 = findplanet(2);
        Planet p4 = findplanet(3);
        Planet p5 = findplanet(4);
        
        // Create and add shuttles to the list
        allshuttle.add(new Shuttle("A0", p1, p2));
        allshuttle.add(new Shuttle("B1", p2, p1));
        allshuttle.add(new Shuttle("C2", p2, p3));
        allshuttle.add(new Shuttle("D3", p2, p5));
        allshuttle.add(new Shuttle("E4", p3, p2));
        allshuttle.add(new Shuttle("F5", p3, p4));
        allshuttle.add(new Shuttle("G6", p4, p2));
        allshuttle.add(new Shuttle("H7", p5, p2));
    }
    
    /**
     * Loads initial data for permits into the Resort.
     */
    private void loadPermits() {
        // Create and add permits to the list
        allpermits.add(new Permit(1000, "Lynn", 5, 10));
        allpermits.add(new Permit(1001, "May", 3, 20));
        allpermits.add(new Permit(1002, "Nils", 10, 20));
        allpermits.add(new Permit(1003, "Olek", 2, 12));
        allpermits.add(new Permit(1004, "Pan", 3, 3));
        allpermits.add(new Permit(1005, "Quin", 1, 5));
        allpermits.add(new Permit(1006, "Raj", 10, 6));
        allpermits.add(new Permit(1007, "Sol", 7, 20));
        allpermits.add(new Permit(1008, "Tel", 6, 24));
    }

    /**
     * Finds and returns a shuttle with the specified ride code.
     *
     * @param shtlCode The ride code of the shuttle to find.
     * @return The found shuttle or null if not found.
     */
    public Shuttle findtravel(String shtlCode) {
        for (Shuttle temp : allshuttle) {
            System.out.println(temp.toString());
            String code = temp.ridecode();
            if (code.equals(shtlCode)) {
                System.out.println("Found");
                return temp;
            } else {
                System.out.println("Not found");
            }
        }
        return null;
    }

    /**
     * Finds and returns a planet with the specified planet number.
     *
     * @param pn The planet number to find.
     * @return The found planet or null if not found.
     */
    private Planet findplanet(int pn) {
        for (Planet temp : allplanets) {
            if (temp.planetnumber() == pn) {
                return temp;
            }
        }
        return null;
    }

    /**
     * Returns the permit with the specified ID.
     *
     * @param id The ID of the permit to find.
     * @return The found permit or null if not found.
     */
    public Permit getPermit(int id) {
        for (Permit temp : allpermits) {
            if (temp.getidnumber() == id) {
                return temp;
            }
        }
        return null;
    }

    /**
     * Returns the planet with the specified name.
     *
     * @param planetName The name of the planet to find.
     * @return The found planet or null if not found.
     */
    private Planet getPlanet(String planetName) {
        for (Planet temp : allplanets) {
            if (temp.GetplanetName().equals(planetName)) {
                return temp;
            }
        }
        return null;
    }

    /**
     * Returns the shuttle with the specified ride code.
     *
     * @param shut The ride code of the shuttle to find.
     * @return The found shuttle or null if not found.
     */
    private Shuttle getShuttle(String shut) {
        for (Shuttle temp : allshuttle) {
            if (temp.ridecode().equals(shut)) {
                return temp;
            }
        }
        return null;
    }
}
