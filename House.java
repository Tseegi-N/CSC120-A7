import java.util.ArrayList;

/**
 * Extended class of Building where students live and dine in. 
 * @param attributes from inheritance AND 
 * whether the house has dining halls (boolean) and number of residents in the house (arrayList)
 * @return parameters or informations of the building
 */
public class House extends Building {
  /*Declaring parameters*/
  private ArrayList<String> residents; 
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /* Default Constructor */
  public House(){
    this("Unknown name", "Unknown address", 1, false, false);
  }

  /* Full Constructor */
  public House(String name, String address, int nFloors, boolean hasDR, boolean hasE) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDR;
    this.hasElevator = hasE;

    System.out.println("You have built a house: 🏠");
  }

  /*Add student's name as a new resident when they move in */
  public void moveIn(String name){
    residents.add(name);
    System.out.println(name + " is now a resident");
  }

  /*Remove student's name when they move out */
  public String moveOut(String name){
    //Check if they are a resident
    if (residents.contains(name)){
      residents.remove(name);
      System.out.println(name + " has moved out from house");
      return (name);
    }
    System.out.println("No resident with that name exists in this house.");
    return("No resident with that name exists in this house.");
  }

  /* Overload moveOut method; all residents of the house move out because of summer break*/
  public String moveOut(){
    residents.clear();
    return("All houses are empty due to summer break.");
  }

  /*Check residents name list for test */
  public boolean isResident(String person){
    if (residents.contains(person)){
      System.out.println(person + " is a resident");
      return true;
    }
    System.out.println(person + " is not a resident");
    return false;
  }

  /*Whether there's a dining hall or no */
  public boolean hasDiningRoom(){
    if (hasDiningRoom == true){
      System.out.println("There's a dining hall at this house");
    }
    else{
      System.out.println("No dining hall at this house");
    }
    return hasDiningRoom;
  }

  /*If house has residents, print its number */
  public boolean nResidents(){
    if (residents.size() > 0){
      System.out.println("Number of residents: " + residents.size());
      return true;
    }
    System.out.println("No residents");
    return false;
  }

  /*overrides showOptions of Building; tells users what options are available */
  @Override
  public void showOptions(){
      super.showOptions();
      System.out.println(" + moveIn(name)\n + moveOut(name)\n + isResident(name)\n + hasDiningRoom()\n + nResidents()");
  }

  /*overrides goToFloor of Building; changes floor freely */
  @Override
  public void goToFloor(int floorNum){
    if (hasElevator == true){
      System.out.println("...Using elevator...");
      super.goToFloor(floorNum);
    }
    else{
      System.out.println("House doesn't have an elevater. Please use the stairs!");
    }
  }

  public static void main(String[] args) {
    /*Main method (for testing) */
    House newHouse = new House("Capen", "10 Elm Street", 4, false, true);
    
    System.out.println(newHouse);
    newHouse.moveIn("Tseegi");
    newHouse.moveIn("Nyamdorj");
    newHouse.hasDiningRoom();
    newHouse.nResidents();
    newHouse.isResident("Nyamdorj");
    newHouse.moveOut("Nyamdorj");
    newHouse.isResident("Nyamdorj");
    newHouse.nResidents();
    newHouse.showOptions();
    newHouse.enter();
    newHouse.goToFloor(3);
  }

}