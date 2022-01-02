// AVLTreeNode.java
// Ethan Angelini
// 11/21/21

// This file defines nodes for an AVL tree.
// Nodes must therefore have a balance factor
// in addition to a key.
// Further, nodes will have an explicitly defined parent node
// in addition to a right and left child.
class AVLTreeNode
{
    int key;
    int factor;
    AVLTreeNode left;
    AVLTreeNode right;
    AVLTreeNode parent;

    AVLTreeNode()
    {
        key = 0;
        factor = 0;
        left = right = parent = null;
    }

    AVLTreeNode(int v)
    {
        key = v;
        factor = 0;
        left = right = parent = null;
    }
}