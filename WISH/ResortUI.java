import java.util.*;

/**
 * The ResortUI class represents a user interface for interacting with a resort system.
 * It allows users to perform various actions related to planets, permits, and travel.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class ResortUI {

    private Scanner reader = new Scanner(System.in);
    private WISH wayward = new Resort("Wayward Asteroids");

    /**
     * The main method to run the ResortUI, prompting the user for actions until they choose to quit.
     */
    private void runUI() {
        int choice = getOption();
        while (choice != 0) {
            // Process user choice
            if (choice == 1) {
                listAllPlanets();
            } else if (choice == 2) {
                listAllPermits();
            } else if (choice == 3) {
                listOnePlanet();
            } else if (choice == 4) {
                findPermitLocation();
            } else if (choice == 5) {
                tryTravel();
            } else if (choice == 6) {
                travelNow();
            } else if (choice == 7) {
                updateCredits();
            } else if (choice == 8) {
                getPermitInfo();
            }
            // Output menu & get choice again
            choice = getOption();
        }
        System.out.println("\nThank you");
    }

    /**
     * Display the menu options and get the user's choice.
     * 
     * @return The user's choice as an integer.
     */
    private int getOption() {
        System.out.println("What would you like to do?");
        System.out.println("0. Quit");
        System.out.println("1. List all planet details");
        System.out.println("2. List all permits on each planet");
        System.out.println("3. List all permits on one planet");
        System.out.println("4. Find permit location");
        System.out.println("5. Say if permit can move by shuttle");
        System.out.println("6. Move a permit by shuttle");
        System.out.println("7. Top up credits");
        System.out.println("8. Get permit details");

        System.out.println("Enter your choice:");
        // Read user's choice
        int option = reader.nextInt();
        reader.nextLine(); // Consume the newline character
        return option;
    }

    /**
     * Display details of all planets in the resort.
     */
    private void listAllPlanets() {
        System.out.println(wayward.toString());
    }

    /**
     * Display details of all permits on each planet in the resort.
     */
    private void listAllPermits() {
        System.out.println(wayward.getAllPermitsOnEachPlanet());
    }

    /**
     * Display details of permits on a specific planet entered by the user.
     */
    private void listOnePlanet() {
        System.out.println("Enter name of planet:");
        String planetName = reader.nextLine();
        System.out.println(wayward.getAllPermitsOnOnePlanet(planetName));
    }

    /**
     * Find and display the location of a permit based on the permit ID entered by the user.
     */
    private void findPermitLocation() {
        System.out.println("Enter Permit ID:");
        int permitId = reader.nextInt();
        reader.nextLine(); // Consume the newline character
        System.out.println(wayward.getPermitLocation(permitId));
    }

    /**
     * Check and display if a permit with a specific ID can travel using a shuttle with a given code.
     */
    private void tryTravel() {
        System.out.println("Enter permit ID:");
        int permitId = reader.nextInt();
        reader.nextLine(); // Consume the newline character
        System.out.println("Enter shuttle code:");
        String shuttleCode = reader.nextLine();
        System.out.println(wayward.canTravel(permitId, shuttleCode));
    }

    /**
     * Move a permit with a specified ID using a shuttle with a given code.
     */
    private void travelNow() {
        System.out.println("Enter Shuttle ride code:");
        String shuttleCode = reader.nextLine();
        System.out.println("Enter permit ID:");
        int permitId = reader.nextInt();
        reader.nextLine(); // Consume the newline character
        System.out.println(wayward.travel(permitId, shuttleCode));
    }

    /**
     * Update the credits of a permit with a specified ID.
     */
    private void updateCredits() {
        System.out.println("Enter permit ID:");
        int permitId = reader.nextInt();
        System.out.println("Enter credits to top up:");
        int credits = reader.nextInt();
        // TODO: Uncomment the following line after implementing the topUpCredits method in the Resort class
        // System.out.println(wayward.topUpCredits(credits, permitId));
    }

    /**
     * Display details of a permit with a specified ID.
     */
    private void getPermitInfo() {
        System.out.println("Enter permit ID:");
        int permitId = reader.nextInt();
        System.out.println(wayward.getPermitDetails(permitId));
    }

    /**
     * The main method to create a ResortUI object and run the user interface.
     */
    public static void main(String[] args) {
        ResortUI resortUI = new ResortUI();
        resortUI.runUI();
    }
}
