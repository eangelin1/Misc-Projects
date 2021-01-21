// HardwareInventorySortTest.java
// Jim Jerkofsky  04/07/19
// Test of HardwareStore's .sortInventory() method.
import java.util.Scanner;


public class HardwareInventorySortTest
{
  public static void main(String[] args)
  {
    // Set up Scanner object for keyboard input.
    Scanner keyboard = new Scanner(System.in);
    
    // Input number of inventory items.
    System.out.print("Number of inventory items:  ");
    int nrItems = keyboard.nextInt();
    
    // Set up HardwareStore object.
    HardwareStore myStore = new HardwareStore(nrItems);
    
    // Allow user to input store's inventory.
    System.out.println("\nEnter store's inventory:");
    myStore.enterInventory();
    
    // Print current contents of store's inventory  (unsorted).
    System.out.println("\nStore's inventory (unsorted):");
    myStore.printInventory();
    
    // Sort store's inventory.
    myStore.sortInventory();
    
    // Print current contents of store's inventory  (sorted).
    System.out.println("\nStore's inventory (sorted):");
    myStore.printInventory();
  }
}