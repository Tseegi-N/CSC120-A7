import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Cushing House", "32 Paradise Rd Northampton, MA 01060", 4));
        myMap.addBuilding(new Building("Emerson House", "24 Paradise Rd Northampton, MA 01060", 4));
        myMap.addBuilding(new Building("Neilson Library", "Neilson Drive Northampton, MA 01063", 5));
        myMap.addBuilding(new Building("Smith College Museum of Art", "39 Elm Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Smith College Conference Center", "51 College Ln Northampton, MA 01060", 2));
        myMap.addBuilding(new Building("Olin Fitness Center", "102 Lower College Ln Northampton, MA 01060", 4));
        myMap.addBuilding(new Building("Campus Center", "100 Elm Street Northampton, MA 01063", 2));
        myMap.addBuilding(new Building("Helen Hills Hills Chapel", "8-6 Round Hill Rd Northampton, MA 01060", 2));
        myMap.addBuilding(new Building("Capen House", "21 Prospect St Northampton, MA 01060", 4));
        myMap.addBuilding(new Building("Sage Hall", "1 Berenson PI Northampton, MA 01060", 2));
        
        
        System.out.println(myMap);
    }
    
}
