/**
 * Extended class of Building where you can order coffee and store coffee ingredients
 * @param attributes from inheritance AND 
 * ingredients of coffee in the inventory (all int)
 * @return parameters or informations of the building
 */
public class Cafe extends Building {
    /*Declaring parameters */
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /* Default Constructor */
    public Cafe(){
        this("Unknown name", "Unknown address", 1, 10, 5, 5, 5);
    }

    /* Full Constructor */
    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;
        System.out.println("You have built a cafe: ☕");
    }

    /*Reduces coffee ingredients according to the order; call restock method if ingredients run out */
    public void sellCoffee(int size, int sugar, int creams){
        //Check for inventory status and restock if necessary
        if (nCups < 1){
            System.out.println("Cups have ran out!");
            restock(10);
            System.out.println("Stocked inventory: " + nCoffeeOunces + " ounces of coffee, " +
            nSugarPackets + " sugar packets, " + nCreams + " splashes of cream, " + nCups + " cups");  
        }
        if (nCoffeeOunces < 1 || nCreams < 1 || nSugarPackets < 1 || nCups < 1){
            System.out.println("Please restock inventory!");
            restock(20, 10, 10, 5);
            System.out.println("Stocked inventory: " + nCoffeeOunces + " ounces of coffee, " +
            nSugarPackets + " sugar packets, " + nCreams + " splashes of cream, " + nCups + " cups");  
        }

        //when inventory is sufficient sell coffee with ingredients available
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= sugar;
        this.nCreams -= creams;
        this.nCups -= 1;
        System.out.println("Inventory after sale: " + nCoffeeOunces + " ounces of coffee, " +
            nSugarPackets + " sugar packets, " + nCreams + " splashes of cream, " + nCups + " cups");  
    }

    /*Restock shelves with new numbers of ingredients */
    private void restock(int nCoffee, int nSugar, int nCream, int nCup){
        this.nCoffeeOunces = nCoffee;
        this.nSugarPackets = nSugar;
        this.nCreams = nCream;
        this.nCups = nCup;
    }

    /*overloads restock method; only refills cups as it can be washed */
    private void restock(int nCup){
        this.nCups = nCup;
    }

    /*overrides showOptions of Building; tells users what options are available */
    @Override
    public void showOptions(){
        super.showOptions();
        System.out.println(" + sellCoffee(size, sugar, creams)");
    }
    
    public static void main(String[] args) {
        /*Main method (for testing) */
        Cafe Compass = new Cafe("Compass", "Smith College", 1, 5, 3, 2, 1);
        Compass.sellCoffee(2, 1, 1);
        Compass.sellCoffee(2, 1, 1);
        Compass.showOptions();
    }
    
}
