// OrderedStudentManager.java
// Jim Jerkofsky  11/03/19
// Class manages an ordered linked list of 
//   LinkedSimpleStudent objects.

public class OrderedStudentManager
{
  // Constructor.
  public OrderedStudentManager()
  {
    head = null;
  }
  
  // Method to enter LinkedSimpleStudent object into an ordered
  //   linked list.
  public void addStudent(LinkedSimpleStudent student)
  {
    // Enter student into empty list.
    if(head == null)
    {
      head = student;
      return;
    }
    
    // List is not empty; determine if student goes before
    //   first student in list.
    if(student.compareTo(head) <= 0)
    {
      student.setPtr(head);
      head = student;
      return;
    }
    
    // Student does not go at beginning of list; 
    //   find student's location in list.
    LinkedSimpleStudent current = head;
    LinkedSimpleStudent previous = null;
    
    // Traverse list to find student's position in list.
    while((current.getPtr() != null) &&
          (student.compareTo(current) > 0))
    {
      // Student goes later in list.
      previous = current;
      current = current.getPtr();
    }
          
    // Determine if student goes between two students or at end of list.
    if(student.compareTo(current) <= 0)
    {
      // Student goes between two students.
      student.setPtr(current);
      previous.setPtr(student);
      return;
    }
    
    // Student goes at end of list.
    else
    {
      current.setPtr(student);
      return;
    }
  }
  
  // method to remove student from list
  public boolean remove(LinkedSimpleStudent student)
  {
    // if list is empty
    if(head == null)
    {
      return false;
    }
    
    // list not empty
    LinkedSimpleStudent current = head;

    // check if first == student
    if(current.compareTo(student) == 0)
    {
      // current same as student and first in list
      head = current.getPtr();
      return true;
    }
   
    // list not empty and student not equal to first in list
    LinkedSimpleStudent previous = current;
    current = current.getPtr();
    
    // transverse list until student is found in list
    // or reach end of list
    while(current != null)
    {
      // check if current equals student
      if(current.compareTo(student) == 0)
      {
        previous.setPtr(current.getPtr());
        return true;
      }
      // check if current is greater than student
      else if(current.compareTo(student) > 0)
      {
         // student comes before current
         // therefore student not in ordered list
         return false;
      }
      
      // set previous and current to next in list
      previous = current;
      current = current.getPtr();
    }
    
    // student not in list
    return false;
  }
  
  // Method to print current contents of ordered linked list
  //   of LinkedSimpleStudent objects.
  public void printList()
  {
    // Check if list is empty.
    if(head == null)
    {
      System.out.println("\nList is empty.\n");
      return;
    }
    
    // List is not empty; print contents.
    LinkedSimpleStudent current = head;
    
    while(current != null)
    {
      System.out.println(current);
      current = current.getPtr();
    }
  }
  
  // Instance variable.
  private LinkedSimpleStudent head;
}