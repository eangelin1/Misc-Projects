// OrderedStudentManagerTest.java
// Jim Jerkofsky  11/03/19
// Test program for OrderedStudentManager class --
//   class that manages an ordered linked list of
//   LinkedSimpleStudent objects.
import java.util.Scanner;

public class OrderedStudentManagerTest
{
  public static void main(String[] args)
  {
    // Set up Scanner object for keyboard input.
    Scanner keyboard = new Scanner(System.in);
    
    // Set up OrderedStudentManager object.
    OrderedStudentManager students = new OrderedStudentManager();
    
    // Display menu and allow user to:
    //   1]  Add student to ordered linked list.
    //   2]  Print current contents of linked list.
    //   0]  Exit menu.
    int response = 1;
    
    while(response != 0)
    {
      // Print menu.
      System.out.println("Menu options:");
      System.out.println("1]  Add student to list.");
      System.out.println("2]  Print current contents of list.");
      System.out.println("3]  Remove student from list.");
      System.out.println("0]  Exit menu.");
      System.out.print("Menu choice:  ");
      response = keyboard.nextInt();
      
      switch(response)
      {
         // Add student to list.
         case(1):
           // Enter student to add to list.
           LinkedSimpleStudent student = LinkedSimpleStudent.enterStudent();
           
           // Add student to list.
           students.addStudent(student);
           break;
         
         // Print list.
         case(2):
           System.out.println("Current contents of list:");
           students.printList();
           System.out.println();
           break; 
           
         // removes student from list
         case(3):
           // enter student to remove from list
           student = LinkedSimpleStudent.enterStudent();
            
           // remove student from list
           if(students.remove(student))
           {
              System.out.println(student + " has been removed from list.");
           }
           else
           {
              System.out.println(student + " could not be found in list.");
           }
            
           System.out.println();
           break;
            
      
        // Exit menu.
        case(0):
          System.out.println("\nExiting menu!");
          break;
      
        // Incorrect menu choice.
        default:
          System.out.println("\nInvalid menu option!");
          break;
       }
    }
  }
}