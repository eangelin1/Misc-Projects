// LinkedSimpleStudent.java
// Jim Jerkofsky  10/09/19
// Class to hold student's last name and age.
import java.util.Scanner;


public class LinkedSimpleStudent
{
  // Constructor.
  public LinkedSimpleStudent(String last, int years)
  {
    lastName = last;
	 age = years;
    ptr = null;
  }
  
  // LinkedSimpleStudent's get() methods.
  public String getLastName()
  {
    return lastName;
  }
  
  public int getAge()
  {
    return age;
  }
  
  public LinkedSimpleStudent getPtr()
  {
    return ptr;
  }
  
  // LinkedSimpleStudent's set() methods.
  public void setLastName(String last)
  {
    lastName = last;
  }
  
  public void setAge(int years)
  {
    age = years;
  }
  
  public void setPtr(LinkedSimpleStudent p)
  {
    ptr = p;
  }
    
  // LinkedSimpleStudent's toString() method.
  public String toString()
  {
    String stdt = "";
    
    stdt = "[" + lastName + "; " + age + "]";
    
    return stdt;
  }
  
     
  // Method to input data and set up SimpleStudent object.
   public static LinkedSimpleStudent enterStudent()
   {
    // Set up Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
    
    // Enter student information.
      System.out.print("Last name:   ");
      String lastName = keyboard.nextLine();
    
      System.out.print("ID#:         ");
      int age = keyboard.nextInt();
   
    
    // Set up LinkedSimpleStudent object.
      LinkedSimpleStudent student = 
         new LinkedSimpleStudent(lastName, age);
    
    // Return reference to LinkedSimpleStudent object to calling method.
      return student;
   }
  
  // LinkedSimpleStudent's equals() method.
  // Compares both name and age.
  // Modified so that it works with ArrayList's remove().
  public boolean equals(Object obj)
  {
    LinkedSimpleStudent s2 = (LinkedSimpleStudent)obj;
  
    boolean flag = (lastName.equals(s2.lastName)) &&
	                (age == s2.age);
	 
	 return flag;
  }
  
  // LinkedSimpleStudent's compareTo() method.
  // First compares names.
  // If names are the same, then compares ages.
  // Returns -1 if implicit parameter comes before explicit parameter.
  // Returns 0 if implicit parameter and explicit parameter the same.
  // Returns 1 if implicit parameter comes after explicit parameter.
  public int compareTo(LinkedSimpleStudent st2)
  {
    // Compare names.
    int flag = lastName.compareTo(st2.lastName);
    
    if(flag < 0)
    {
      // implicit < explicit.
      return -1;
    }
    else if(flag > 0)
    {
      // implicit > explicit.
      return 1;
    }
    
    // Names are the same; compare ages.
    if(age < st2.age)
    {
      // implicit < explicit.
      return -1;
    }
    
    else if(age > st2.age)
    {
      // implicit > explicit.
      return 1;
    }
    
    else
    {
      // implicit, explicit same.
      return 0;
    }
  }
    
  // Instance variables.
  private String lastName;
  private int age;
  private LinkedSimpleStudent ptr;
}