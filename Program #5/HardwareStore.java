// HardwareStore.java
// Ethan Angelini 4/12/19
// Class to model the inventory of a hardware store.
// Added: Method to sort inventory.


public class HardwareStore
{
  // Constructor.
  public HardwareStore(int nrItems)
  {
    inventory = new HardwareItem[nrItems];
  }
  
  // Method to fill inventory array.
  public void enterInventory()
  {
    for(int ctr = 0; ctr < inventory.length; ctr++)
    {
      System.out.println("Inventory Item #" + (ctr+1) + ":");
      inventory[ctr] = HardwareItem.enterHardwareItem();
      
      System.out.println();
    }
  }
  
  // Method to print current inventory.
  public void printInventory()
  {
    for(int ctr = 0; ctr < inventory.length; ctr++)
    {
      System.out.println("Inventory[" + ctr + "]:  " + inventory[ctr]);
    }
  }
  
  // Method to calculate current value of store's inventory.
  public double valueInventory()
  {
    double value = 0;
    
    for(int ctr = 0; ctr < inventory.length; ctr++)
    {
      value = value + inventory[ctr].inventoryValue();
    }
    
    return value;
  }
  
  // Method to sort inventory into ascending order.
  // Uses Bubble Sort.  
  public void sortInventory()
  {
   for(int ctr = 1; ctr < inventory.length; ctr++)
   {
      for(int ctr2 = 0; ctr2 < inventory.length-ctr; ctr2++)
      {
         // flag is pos/neg/zero depending on relationship of one object to the next in the array
         int flag = inventory[ctr2].compareTo(inventory[ctr2+1]);
         
         // inventory[ctr2] comes after inventory[ctr2+1]
         if(flag > 0)
         {
            // switch places with each other
            HardwareItem temp = inventory[ctr2+1];
            
            inventory[ctr2+1] = inventory[ctr2];
            inventory[ctr2] = temp;
         }
      }
   }
  }



  // Instance variables.
  private HardwareItem[] inventory;
}