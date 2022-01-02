public class test {
    public static void main(String[] args)
    {
        List list1 = new List();

        list1.append("Bob");
        list1.append("Jane");
        list1.append("Ann");
        list1.append("Tom");

        System.out.println("List1 contents:");
        list1.print();

        List list2 = new List(list1);
        list2.changeName("John", 2);

        System.out.println("*************");

        System.out.println("List1 contents:");
        list1.print();
        System.out.println("List2 contents:");
        list2.print();

        list1.delete();
        
        System.out.println("*************");

        System.out.println("List1 contents:");
        list1.print();
        System.out.println("List2 contents:");
        list2.print();
    }
}
