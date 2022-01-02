class HashTable {
    int[] content;
    boolean[] bOccupied;

    HashTable(final int max_size){
        content = new int[max_size];
        bOccupied = new boolean[max_size];
    }

    boolean search(final int key){
        int index = key % content.length;

        if(bOccupied[index] && key == content[index]){
            return true;
        }

        return false;
    }

    boolean insert(final int key){
        int index = key % content.length;
        
        if(!bOccupied[index]){
            content[index] = key;
            bOccupied[index] = true;
            return true;
        }
        
        return false;
    }

    boolean delete(final int key){
        int index = key % content.length;
        
        if(bOccupied[index] && key == content[index]){
            bOccupied[index] = false;
            return true;
        }

        return false;
    }

    void disp(){
        for(int i = 0; i < content.length; i++){
            if(bOccupied[i]){
                System.out.printf("%d: %d\n", i, content[i]);
            }
        }
    }
}
