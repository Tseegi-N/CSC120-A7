import java.util.Collection;
import java.util.Hashtable;

/**
 * Extended class of Building where you can check-out and store books
 * @param attributes from inheritance AND 
 * collection of the library with title and their check-out status (hashtable)
 * @return parameters or informations of the building
 */
public class Library extends Building{
  /*Declaring the parameter: table of titles(string) and status(boolean)*/
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  /* Default Constructor */
  public Library(){
    this("Uknown name", "Unknown address", 1, false);
  }

  /* Full Constructor */
  public Library(String name, String address, int nFloors, boolean hasE) {
    super(name, address, nFloors);
    this.collection = new Hashtable<>();
    this.hasElevator = hasE;

    System.out.println("You have built a library: 📖");
  }

  /*Add books to the library */
  public void addTitle(String title){
    collection.put(title, true);
    System.out.println(title + " is added to the library");
  }

  /*Remove books from the library; doesn't exist in collection */
  public String removeTitle(String title){
    collection.remove(title);
    System.out.println(title + " is removed from the library");
    return (title);
  }

  /*Change check-out status of book from true to false */
  public void checkOut(String title){
    collection.replace(title, true, false);
    System.out.println(title + " is checked out from the library");
  }

  /*Change check-out status of books from false to true when they return */
  public void Return(String title){
    collection.replace(title, false, true);
    System.out.println(title + " is returned to the library");
  }

  /* Overload return method; return all books year-end inspection */
  public void Return(){
    collection.replaceAll((key, oldValue)
    -> true);
  }

  /*returns true if book exists in the Libary's collection, false otherwise */
  public boolean containsTitle(String title){
    if (collection.containsKey(title)){
      System.out.println(title + " is in the library collection");
      return true;
    }
    System.out.println(title + " is not in the library collection");
    return false;
  }

  /*returns true if book exists and is available in the Libary's collection, false otherwise; ready for check-out*/
  public boolean isAvailable(String title){
    if (collection.containsKey(title)){
      if (collection.get(title) == true){
        System.out.println(title + " is readily available");
        return true;
      }
      System.out.println(title + " is not readily available");
      return false;
    }

    throw new RuntimeException(title + " doesn't exist in the library. Check Collection!");
  } 

  /*prints out the entire collection in an easy-to-read way (including checkout status) */
  public void printCollection(){
    System.out.println(collection.toString());
  } 

  /*overrides showOptions of Building; tells users what options are available */
  @Override
  public void showOptions(){
      super.showOptions();
      System.out.println(" + addTitle(title)\n + removeTitle(title)\n + checkOut(title)\n + Return(title)\n + containsTitle(title)\n + isAvailable(title)\n + printCollection()");
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
    Library Neilson = new Library("Neilson", "10 Elm Street", 5, true);
    Neilson.addTitle("Brave New World by Aldous Huxley");
    Neilson.addTitle("Maybe the Moon by Armistead Maupin");
    Neilson.checkOut("Maybe the Moon by Armistead Maupin");
    Neilson.containsTitle("Maybe the Moon by Armistead Maupin");
    Neilson.isAvailable("Maybe the Moon by Armistead Maupin");
    Neilson.printCollection();
    Neilson.showOptions();
    Neilson.enter();
    Neilson.goToFloor(4);
  }
  
}