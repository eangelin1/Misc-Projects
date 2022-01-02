public class LPHash {
    int[] content;
    int[] bOccupied; // 0 - empty
                     // 1 - full
                     // 2 - marked

    LPHash(final int max_size){
        content = new int[max_size];
        bOccupied = new int[max_size];
    }
                     
    int search(final int key){
        int index = (key % content.length);

        while(bOccupied[index]!=0){
            if(content[index]==key)
                return index;
            
            index = (index + 1) % content.length;

            if(index == key % content.length)
                return -1;
        }

        return -1;
    }

    boolean insert(final int key){
        int index = (key % content.length);

        // need to check if cluster is not full
        // i.e. either marked or empty
        if(bOccupied[index]!=1){
            content[index] = key;
            bOccupied[index] = 1;
            return true;
        }
        // cluster is not empty

        // loop runs while the current cell is full
        while(bOccupied[index]==1){
            // check if we are outside the cluster assoc w/ the key
            if(content[index] % content.length != key % content.length)
                return false;

            // probing index
            index = (index + 1) % content.length;
            
            // ensures that duplicate keys cannot be inserted
            if(content[index]==key)
                return false;

            // if the cell assoc w the probing index is not full
            if(bOccupied[index]!=1){
                // set content equal to key and mark cell as full
                content[index] = key;
                bOccupied[index] = 1;
                return true;
            }
        }

        return false;
    }

    boolean delete(final int key){
        int index = key % content.length;

        // loop while current cell is full
        while(bOccupied[index]==1){

            // check if cell contains key
            if(content[index]==key){
                // switch cell with last cell in cluster
                // start at current index
                int ind = index;

                // loop while current cell is full
                while(bOccupied[ind]==1){
                    // if next cell is empty or marked
                    if(bOccupied[(ind+1) % content.length]!=1){
                        // set current cell as marked and overwrite deleted cell contents
                        bOccupied[ind] = 2;
                        content[index] = content[ind];

                        return true;
                    }

                    ind = (ind + 1) % content.length;
                }
            }

            index = (index+1) % content.length;
        }

        return false;
    }

    void disp(){
        for(int i = 0; i < content.length; i++){
            if(bOccupied[i]==1){
                System.out.printf("%d: %d\n", i, content[i]);
            }
        }
    }
}
