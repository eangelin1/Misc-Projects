// HardwareItem.java
// Ethan Angelini 4/12/19
// Class -- object holds information about hardware item.
// Added .compareTo() method.
import java.util.Scanner;

public class HardwareItem
{
  // Constructor.
  public HardwareItem(String nme, double prce, int onHnd)
  {
    name = nme;
    price = prce;
    onHand = onHnd;
  }
  
  // HardwareItem .get() methods.
  public String getName()
  {
    return name;
  }
  
  public double getPrice()
  {
    return price;
  }
  
  public int getOnHand()
  {
    return onHand;
  }
  
  // HardwareItem .set() methods.
  public void setName(String nme)
  {
    name = nme;
  }
  
  public void setPrice(double prce)
  {
    price = prce;
  }
  
  public void setOnHand(int onHnd)
  {
    onHand = onHnd;
  }
  
  // HardwareItem .toString() method.
  public String toString()
  {
    return "[" + name + "; $" + price + "; " + onHand +"]";
  }
  
  // Method to determine value of objects currently on hand.
  public double inventoryValue()
  {
    return price * onHand;
  }

  // Method to set up a HardwareItem object.
  public static HardwareItem enterHardwareItem()
  {
    // Set up Scanner object for keyboard input.
    Scanner keyboard = new Scanner(System.in);
    
    // Input information for Hardware object.
    System.out.print("Name:           ");
    String name = keyboard.nextLine();
   
    System.out.print("Price:         $");
    double price = keyboard.nextDouble();
    
    System.out.print("Nr. in stock:   ");
    int nr = keyboard.nextInt();
    
    // Set up HardwareItem.
    HardwareItem obj1 = new HardwareItem(name, price, nr);    
    
    // Return object instantiated.
    return obj1;
  }
  
  // HardwareItem .compareTo() method.
  // Order of comparison:
  //   1)  Names
  //   2)  Prices
  //   3)  Number of hand
  public int compareTo(HardwareItem item2)
  {
   // variables to determine relationships of name, price, and number on hand of the object and the passed object
   int flag = name.compareTo(item2.name);
   int handFlag = onHand - item2.onHand;
   double prc = price - item2.price;
   
   // name is not the same as item2.name
   if(flag != 0)
   {
      return flag;
   }
   
   // price is > item2.price
   else if(prc > 0)
   {
      return 1;
   }   
   
   // price < item2.price
   else if(prc < 0)
   {
      return -1;
   }
   
   // onHand is not the same as item2.onHand
   else if(handFlag != 0)
   {
      return handFlag;
   }
   
   // the two objects are equal
   else
   {
      return 0;
   }
  }


  // Instance variables.
  private String name;
  private double price;
  private int onHand;
}