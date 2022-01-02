class min_heap
{
    int[] heap;
    int size;
    int max_size;

    min_heap(int arr_size)
    {
        max_size = arr_size;
        size = 0;
        heap = new int[arr_size+1];
        heap[0] = Integer.MIN_VALUE;
    }

    void insert(int num)
    {
        if(size >= max_size)
        {
            return;
        }

        heap[++size] = num;
        int pos = size;

        while (heap[pos] < heap[pos/2])
        {
            heap[pos] = heap[pos/2];
            heap[pos/2] = num;
            pos = pos/2;
        }
    }

    void heapify(int pos)
    {
        if (pos <= (size/2))
        {
            if(heap[pos]>heap[pos*2]||heap[pos]>heap[pos*2+1])
            {
                if(heap[pos*2]<heap[pos*2+1])
                {   
                    int tmp = heap[pos];
                    heap[pos]=heap[pos*2];
                    heap[pos*2]=tmp;
                    heapify(pos*2);
                }
                else
                {
                    int tmp = heap[pos];
                    heap[pos]=heap[pos*2+1];
                    heap[pos*2+1]=tmp;
                    heapify(pos*2+1);
                }
            }
        }
    }

    void deleteMin()
    {
        heap[1] = heap[size];
        size -= 1;
        heapify(1);
    }

    void print()
    {
        if(size==1)
        {
            System.out.println("parent : " + heap[1]);
        }

        for (int i = 1; i <= size / 2; i++) {
 
            // Printing the parent and both childrens
            System.out.println("parent : " + heap[i]);
            if(2*i<=size)
            {
                System.out.println("\tleft child : " + heap[2 * i]);
            }
            if(2*i+1<=size)
            {
                System.out.println("\tright child :" + heap[2 * i + 1]);
            }
        }
    }
}