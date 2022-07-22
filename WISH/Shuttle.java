 
/**
 * A shuttle provides a one-way connection between two planets. It
 * has a Shuttle code and information about both the source and
 * the destination planet
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shuttle
{
    private String shuttleride;
    private Planet fromPlanet;
    private Planet toPlanet;
    
    public Shuttle (String sh, Planet fromPnt, Planet toPnt)
    {
        shuttleride = sh;
        fromPlanet = fromPnt;
        toPlanet = toPnt;
        
    }
    
    public String ridecode()
    {
        return shuttleride;
    
    }

    
    public boolean canShuttleRide(Permit p) 
    {
        {
        int noofcredits = p.getcredits();
        int permitId = p.getidnumber();
        if (toPlanet.creditcheck(p.getcredits())&& !toPlanet.isfull() && fromPlanet.checkpermit(permitId))
        {
            return true;
        }
        else 
        {
            return false;
        }
        }
    }
    
    public String movepermit(Permit p)
    
    {
        int noofcredits = p.getcredits();
        int permitId = p.getidnumber();
        int luxuryraing = p.getluxuryrating();
        
        if (!toPlanet.creditcheck(p.getcredits()))
        {
           return "Not enough credit to make a ride"; 
        }
        else if (p.getluxuryrating() < toPlanet.luxuryrating())
        {
            return "Increse your luxury rating to make a ride";
        }
        else if (toPlanet.isfull())
        {
            return "Planet is full - Permit not added";
        }
        else if (!fromPlanet.checkpermit(permitId))
        {
            return "Permit not found on the sourse planet - Permit not added ";
        }
        else 
        {
            toPlanet.enter(p);
            fromPlanet.leave(permitId);
            return "Permit" + permitId + "added to planet" + toPlanet.GetplanetName(); 
        }
    }
    
    public String toString()
    {
        return "\nRide code: " + shuttleride + "\nFrom: " + fromPlanet +
        "\nTo : " + toPlanet.planetnumber() + "  " + toPlanet.GetplanetName();
    }
} 

