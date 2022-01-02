// AVLTree.java
// Ethan Angelini
// 11/21/21

// Structures tree nodes according to an AVL tree.
// Computes balance factors upon insertion and 
// balances tree accordingly, making use of right
// and left rotations as needed.
class AVLTree {
    AVLTreeNode root;
    
    void preorder(AVLTreeNode r)
    {
        // traverses tree recursively and prints keys before visiting children
        if(r==root) 
            System.out.print("pre-order: ");
        if(r!=null)
        {
            System.out.print(r.key + " ");

            preorder(r.left);
            preorder(r.right);
        }
    }

    void inorder(AVLTreeNode r)
    {
        // traverses tree recursively and prints keys after visiting left child
        if(r==root) 
            System.out.print("in-order: ");
        if(r!=null)
        {
            inorder(r.left);

            System.out.print(r.key + " ");

            inorder(r.right);
        }
    }

    int updateFactor(AVLTreeNode r)
    {
        // computes balance factor of a node (and all its children)
        // base case (null child) will return -1
        if(r==null) return -1;
        
        // recursively computes the height of each subtree
        int right_factor = updateFactor(r.right);
        int left_factor = updateFactor(r.left);

        // uses the difference of the heights to compute factor of current node
        r.factor = right_factor - left_factor;

        // returns height of longest path plus 1
        if(left_factor>right_factor) return left_factor+1;
        else return right_factor+1;
    }

    void rightRot(AVLTreeNode r)
    {
        // right rotation
        // r becomes parent of x and x becomes right child of r

        // x is the parent of r and tmp is the right subtree of r
        AVLTreeNode x = r.parent;
        AVLTreeNode tmp = r.right;

        // r will become the child of x's original parent
        // or if x was root (null parent) r will become the new root
        if(r.parent.parent==null)
            root=r;

        else if(r.parent.parent.left==x)
            r.parent.parent.left = r;

        else if(r.parent.parent.right==x)
            r.parent.parent.right = r;

        // x becomes right child of r and the right subtree of r becomes
        // the left subtree of x
        r.right = x;
        x.left = tmp;
        
        // parent of r will become the original parent of x
        // parent of x will become r
        r.parent = x.parent;
        x.parent = r;

        // need to update the factors of r and x since the structure
        // of the tree has changed
        updateFactor(r);
        updateFactor(x);
    }

    void leftRot(AVLTreeNode r)
    {
        // left rotation
        // essentially identical to  a right rotation except mirrored
        // r becomes parent of x and x becomes left child of r

        // x is the parent of r and tmp is the left subtree of r
        AVLTreeNode x = r.parent;
        AVLTreeNode tmp = r.left;

        // r will become the child of x's original parent
        // or if x was root (null parent) r will become the new root
        if(r.parent.parent==null)
            root=r;

        else if(r.parent.parent.left==x)
            r.parent.parent.left = r;

        else if(r.parent.parent.right==x)
            r.parent.parent.right = r;

        // x becomes left child of r and the left subtree of r (tmp) 
        // becomes the right subtree of x
        r.left = x;
        x.right = tmp;
        
        // parent of r will become the original parent of x
        // parent of x will become r
        r.parent = x.parent;
        x.parent = r;

        // update factors since structure of the tree has changed
        updateFactor(r);
        updateFactor(x);
    }

    void balance(AVLTreeNode r)
    {   
        // determine whether the tree needs rebalanced
        // if r is root, then no rotation is needed
        if(r.parent==null) return;

        // r's parent has 2 more levels on left
        // r has 1 more level on right
        // left right rotation is needed
        else if(r.factor==1 && r.parent.factor==-2)
        {
            leftRot(r.right);
            rightRot(r.parent);
        }
        // r's parent has 2 more levels on right
        // r has 1 more level on right
        // left rotation is needed
        else if(r.factor==1 && r.parent.factor==2)
        {
            leftRot(r);
        }
        // r's parent has 2 more levels on right
        // r has 1 more level on left
        // right left rotation is needed
        else if(r.factor==-1 && r.parent.factor==2)
        {
            rightRot(r.left);
            leftRot(r.parent);
        }
        // r's parent has 2 more levels on left
        // r has 1 more level on left
        // right rotation is needed
        else if(r.factor==-1 && r.parent.factor==-2)
        {
            rightRot(r);
        }
    }


    boolean insert(AVLTreeNode r, int v)
    {
        if(root==null)
        {
            root = new AVLTreeNode(v);
            return true;
        }
        // find where to insert the value
        // new value is equal to current node so cannot insert
        if(v==r.key) return false;

        // new value is greater than current node
        // so either new value should be inserted to the right
        // or a new iteration should be run on the right subtree
        else if(v>r.key)
        {
            // determine whether to reiterate or insert

            if(r.right==null)
            {
                // insertion step (base case)
                AVLTreeNode newNode = new AVLTreeNode(v);
                r.right = newNode;
                r.right.parent = r;
                updateFactor(r.parent);
                balance(r);
                return true; // eventually this WILL happen if v is unique key
            }
            else
            {   
                // once the key is inserted, the recursive call will balance
                // the tree at each step (bottom up)
                if(insert(r.right,v))
                {
                    updateFactor(r.parent);
                    balance(r);
                    return true;
                }
                return false;
            }
        }

        // new value is less than current node
        // so either new value should be inserted to the left
        // or a new iteration should be run on the left subtree
        else
        {
            if(r.left==null)
            {
                // no left subtree so must insert new node here
                // base case
                AVLTreeNode newNode = new AVLTreeNode(v);
                r.left = newNode;
                r.left.parent = r;
                updateFactor(r.parent);
                balance(r);
                return true;
            }
            else
            {   
                // reiteration if there is a left subtree
                if(insert(r.left,v))
                {
                    updateFactor(r.parent);
                    balance(r);
                    return true;
                }
                return false;
            }
        }
    }
}
