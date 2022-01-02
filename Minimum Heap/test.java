public class test {
    public static void main(String[] args)
    {
        int[] arr = {34,-10,3,7,14,-3,12,0,34,1};
        min_heap hp = new min_heap(arr.length);


        for(int i = 0; i<arr.length; i++)
        {
            hp.insert(arr[i]);
        }
        System.out.println("Heap after insertion:");
        hp.print();

        for(int i = arr.length; i > 0; i--)
        {  
            System.out.println("Deletion #" + (arr.length+1-i));
            hp.deleteMin();
            hp.print();
        }
    }
}
