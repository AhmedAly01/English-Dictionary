package org.DSLab2;

import java.util.Objects;

public class BSTree implements IBSTree {
    private Node root;// root of the tree
    private int size = 0;// size of the tree
    private boolean exist = false;

    BSTree() {
        this.root = null;// initialize the root
    }

    BSTree(String data) {
        data = data.toLowerCase();
        this.root = new Node(data);// initialize the root with value
    }

    public int size() {
        return this.size;// return the size of the tree
    }

    public boolean insert(String data) {// insert a node
        data = data.toLowerCase();
        if (search(root, data)) {// check if the node already exists
            System.out.println("Node already exists");
            return false;
        }
        this.size++;// increase the size of the tree
        this.root = insert(this.root, data);// insert the node
        return true;
    }

    private Node insert(Node node, String data) {
        if (node == null) {// if the node is null then create a new node
            return new Node(data);
        }
        if (data.compareTo(node.data) < 0) {// if the data is less than the node data then insert it to the left
            node.left = insert(node.left, data);
        } else if (data.compareTo(node.data) > 0) {// if the data is greater than the node data then insert it to the right
            node.right = insert(node.right, data);
        } else {
            return node;
        }
        return node;
    }

    public boolean search(String data) {// search a node if it exists or not
        data = data.toLowerCase();
        return search(this.root, data);
    }

    boolean search(Node node, String data) {
        if (node == null) {// if the node is null then return false
            return false;
        }
        if (Objects.equals(node.data, data)) {// if the node data is equal to the data then return true
            return true;
        }
        if (data.compareTo(node.data) < 0){// if the data is less than the node data then search the left
            return search(node.left, data);
        }
        return search(node.right, data);// if the data is greater than the node data then search the right
    }

    private String fidnMin() {// find the minimum value in the tree
        if (this.root == null) {// if the root is null then return -1
            return null;
        }
        Node node = FindMin(this.root);// find the minimum value in the tree
        return node.data;// return the minimum value
    }

    protected Node FindMin(Node node) {// find the minimum value in the tree
        if (node.left == null) {// if the left node is null then return the node data
            return node;
        }
        return FindMin(node.left);// else search the left node
    }

    private String FindMax() {// find the maximum value in the tree
        if(this.root==null) {// if the root is null then return -1
            return null;
        }
        Node max = FindMax(this.root);// find the maximum value in the tree
        return max.data;// return the maximum value
    }

    private Node FindMax(Node node) {
        if (node == null) {// if the node is null then return null
            return null;
        }
        if (node.right == null) {// if the right node is null then return the node which the node has the maximum
                                 // value
            return node;
        }
        return FindMax(node.right);// else search the right node as the value gets greater as we go to the write
    }

    public boolean delete(String data) {
        data = data.toLowerCase();
        if (!search(root, data)) {// if the result is null then the node is not found
            return false;
        } else {// else decrease the size of the tree
            size--;
            deleteNode(this.root, data);// delete the node
            return true;
        }
    }

    Node deleteNode(Node node, String data) {
        if (node == null) {
            return root;// if the node is null then return the root
        }
        if (data.compareTo(node.data) < 0) {// if the data is less than the node data then search the left
            node.left = deleteNode(node.left, data);// delete the node
        } else if (data.compareTo(node.data) > 0) {
            node.right = deleteNode(node.right, data);// go to the right node and check if the data is equal to the node
                                                      // data
        } else {// if the data is equal to the node data then delete the node
            if (node.left == null && node.right == null) {// if the node is a leaf node then delete the node
                node = null;
            } else if (node.left == null) {// if the node has only one child then delete the node
                node = node.right;
            } else if (node.right == null) {// if the node has only one child then delete the node
                node = node.left;
            } else {
                Node temp = FindMax(node.left);// if the node has two children then find the maximum value in the left
                                               // subtree
                node.data = temp.data;// replace the node data with the maximum value in the left subtree
                node.left = deleteNode(node.left, temp.data);// delete the node
            }
        }
        return node;
    }

    void preOrder() {// the pre order traversal
        preOrder(this.root);
    }
    void preOrder(Node node) {// pre order traversal
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }


    void postOrder() {//the post order traversal
        postOrder(this.root);
    }

    void postOrder(Node node) {// post order traversal
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public boolean isEmpty() {// check if the tree is empty or not
        return this.root == null;
    }

    public int height() {// find the height of the tree
        return height(this.root);
    }

    int height(Node node) {// find the height of the tree
        if (node == null) {// if the node is null then return 0 as there is no height in the null node
            //means we reach the end of the tree
            return 0;
        } else {
            return Math.max(height(node.left), height(node.right)) + 1;// return the maximum height of the tree from the
            // left and right subtree and add 1 to the height of the tree
        }

    }

//    public static void main(String[] args) {
//        BSTree BST = new BSTree();// create a new binary tree
//        //this insert and delete methods working poperly
//        //so this is a test for some methods
//        //i test the delete and it works fine
//        //have a good day
//        BST.insert(10);
//        BST.insert(5);
//        BST.insert(15);
//        BST.insert(3);
//        BST.insert(7);
//        BST.insert(12);
//        BST.insert(18);
//        System.out.println();
//        System.out.println(BST.height());
//        System.out.println(BST.FidnMin());
//        System.out.println(BST.FindMax());
//        System.out.println(BST.search(10));
//        System.out.println(BST.search(5));
//        System.out.println(BST.search(8));
//        System.out.println(BST.size());
//    }
}