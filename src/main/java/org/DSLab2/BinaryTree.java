
class Node {
    int data;
    Node left;
    Node right;
    int height;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    Node root;// root of the tree
    int size = 0;// size of the tree
    boolean exist = false;

    BinaryTree() {
        this.root = null;// initialize the root
    }

    BinaryTree(int data) {
        this.root = new Node(data);// initialize the root with value
    }

    int size() {
        return this.size;// return the size of the tree
    }

    public void insertNode(int data) {// insert a node
        if (search(root, data)) {// check if the node already exists
            System.out.println("Node already exists");
            return;
        }
        this.size++;// increase the size of the tree
        this.root = insert(this.root, data);// insert the node
    }

    private Node insert(Node node, int data) {
        if (node == null) {// if the node is null then create a new node
            return new Node(data);
        }
        if (data < node.data) {// if the data is less than the node data then insert it to the left
            node.left = insert(node.left, data);
        } else if (data > node.data) {// if the data is greater than the node data then insert it to the right
            node.right = insert(node.right, data);
        } else {
            return node;
        }
        return node;
    }

    boolean searchNode(int data) {// search a node if it exists or not
        return search(this.root, data);
    }

    boolean search(Node node, int data) {
        if (node == null) {// if the node is null then return false
            return false;
        }
        if (node.data == data) {// if the node data is equal to the data then return true
            return true;
        }
        if (data < node.data) {// if the data is less than the node data then search the left
            return search(node.left, data);
        }
        return search(node.right, data);// if the data is greater than the node data then search the right
    }

    public int FidnMin() {// find the minimum value in the tree
        if (this.root == null) {// if the root is null then return -1
            return -1;
        }
        Node node = FindMin(this.root);// find the minimum value in the tree
        return node.data;// return the minimum value
    }

    private Node FindMin(Node node) {// find the minimum value in the tree
        if (node.left == null) {// if the left node is null then return the node data
            return node;
        }
        return FindMin(node.left);// else search the left node
    }

    public int FindMax() {// find the maximum value in the tree
        if(this.root==null) {// if the root is null then return -1
            return -1;
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

    void delete(int data) {

        if (!search(root, data)) {// if the result is null then the node is not found
            System.out.println("Node not found");
        } else {// else decrease the size of the tree
            size--;
            deleteNode(this.root, data);// delete the node
            System.out.println("Node deleted");// print the node deleted
        }
    }

    Node deleteNode(Node node, int data) {
        if (node == null) {
            return root;// if the node is null then return the root
        }
        if (data < node.data) {// if the data is less than the node data then search the left
            node.left = deleteNode(node.left, data);// delete the node
        } else if (data > node.data) {
            node.right = deleteNode(node.right, data);// go to the right node and check if the data is equal to the node
                                                      // data
        } else {// if the data is equal to the node data then delete the node
            if (node.left == null && node.right == null) {// if the node is a leaf node then delete the node
                node = null;
            } else if (node.left == null && node.right != null) {// if the node has only one child then delete the node
                node = node.right;
            } else if (node.left != null && node.right == null) {// if the node has only one child then delete the node
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

    void isEmpty() {// check if the tree is empty or not
        if (this.root == null) {
            System.out.println("Tree is empty");
        } else {
            System.out.println("Tree is not empty");
        }
    }

    int height() {// find the height of the tree 
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

    public static void main(String[] args) {
        BinaryTree BST = new BinaryTree();// create a new binary tree 
        //this insert and delete methods working poperly
        //so this is a test for some methods 
        //i test the delete and it works fine
        //have a good day
        BST.insertNode(10);
        BST.insertNode(5);
        BST.insertNode(15);
        BST.insertNode(3);
        BST.insertNode(7);
        BST.insertNode(12);
        BST.insertNode(18);
        System.out.println();        
        System.out.println(BST.height());
        System.out.println(BST.FidnMin());
        System.out.println(BST.FindMax());
        System.out.println(BST.searchNode(10));
        System.out.println(BST.searchNode(5));
        System.out.println(BST.searchNode(8));
        System.out.println(BST.size());
    }
}