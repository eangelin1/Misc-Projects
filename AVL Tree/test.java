public class test {
    public static void main(String[] args)
    {
        AVLTree tree = new AVLTree();

        tree.insert(tree.root, 10);
        tree.insert(tree.root, 3);
        tree.insert(tree.root, 8);
        tree.insert(tree.root, 14);
        tree.insert(tree.root, 1);
        tree.insert(tree.root, 4);
        tree.insert(tree.root, 6);
        tree.insert(tree.root, 7);
        tree.insert(tree.root, 13);
        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();

        AVLTree tree2 = new AVLTree();
        tree2.insert(tree2.root, 8);
        tree2.insert(tree2.root, 7);
        tree2.insert(tree2.root, 6);
        tree2.insert(tree2.root, 10);
        tree2.insert(tree2.root, 12);
        tree2.insert(tree2.root, 9);
        tree2.insert(tree2.root, 5);
        tree2.preorder(tree2.root);
        System.out.println();
        tree2.inorder(tree2.root);

    }
}
