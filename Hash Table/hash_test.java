public class hash_test {
   public static void main(String[] args) {
    System.out.println("*******************\nSimple Hashing Test\n*******************\n\n");  
    ht_test();
    
    System.out.println("*******************\nLinear Probing Test\n*******************\n\n");
    lpht_test();

   }

   static void ht_test(){
        HashTable ht = new HashTable(11);

        System.out.println("********");
        ht.insert(96);
        ht.disp();
        System.out.println("********");

        ht.insert(81);
        ht.disp();
        System.out.println("********");

        ht.insert(22);
        ht.disp();
        System.out.println("********");

        ht.insert(35);
        ht.disp();
        System.out.println("********");

        ht.insert(4);
        ht.disp();
        System.out.println("********");

        ht.insert(15);
        ht.disp();
        System.out.println("********");

        ht.insert(57);
        ht.disp();
        System.out.println("********");

        ht.insert(46);
        ht.disp();
        System.out.println("********");

        ht.delete(81);
        ht.disp();
        System.out.println("********");

        if(ht.search(35))
            System.out.println("35 was found in the hash table");
        System.out.println("********");

        ht.disp();
        System.out.println("********");

        ht.insert(4);
        ht.disp();
        System.out.println("********");

   }

   static void lpht_test(){
    LPHash lpht = new LPHash(11);

    System.out.println("********");
    lpht.insert(96);
    lpht.disp();
    System.out.println("********");

    lpht.insert(81);
    lpht.disp();
    System.out.println("********");

    lpht.insert(22);
    lpht.disp();
    System.out.println("********");

    lpht.insert(35);
    lpht.disp();
    System.out.println("********");

    lpht.insert(4);
    lpht.disp();
    System.out.println("********");

    lpht.insert(15);
    lpht.disp();
    System.out.println("********");

    lpht.insert(57);
    lpht.disp();
    System.out.println("********");

    lpht.insert(46);
    lpht.disp();
    System.out.println("********");

    lpht.delete(81);
    lpht.disp();
    System.out.println("********");

    System.out.printf("%d was found at index %d\n", 35, lpht.search(35));
    System.out.println("********");

    lpht.disp();
    System.out.println("********");

    lpht.insert(4);
    lpht.disp();
    System.out.println("********");
   }
}
