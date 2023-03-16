
class Node {//the node class which contains the data and the left and right node
    int data = 0;
    int balanceFactor = 0;
    int height = 1;
    Node left;
    Node right;

    Node(int data) {//the constructor of the node class
        this.data = data;
        this.left = null;
        this.right = null;
        height = 1;
    }
}

public class AVL_Tree implements AvlTree {//the AVL_Tree class which implements the AvlTree interface
    Node root;//the root node
    int size = 0;//the size of the tree(number of nodes)

    AVL_Tree() {//the constructor of the tree class
        this.root = null;
    }

    public int Getsize() {//the method to get the size of the tree
        return size;
    }

    public boolean isEmpty() {//the method to check if the tree is empty or not
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    public int balanceFactor(Node node) {//the method to get the balance factor of a node
        return height(node.left) - height(node.right);
    }

    public int TreeHeight() {//the method to get the height of the tree
        if (root == null) {
            return -1;
        } else {
            return root.height;
        }
    }

    public int height(Node node) {//the method to get the height of a node
        if (node == null) {
            return 0;
        } else {
            return node.height;
        }
    }

    public Node rotateRight(Node A) {//the method to rotate the tree to the right
        Node B = A.left;
        Node C = B.right;
        B.right = A;
        A.left = C;
        if (C != null) {
            C.height = Math.max(height(C.left), height(C.right)) + 1;
        }
        A.height = Math.max(height(A.left), height(A.right)) + 1;
        B.height = Math.max(height(B.left), height(B.right)) + 1;
        if (root == A) {
            this.root = B;
        }
        return B;
    }

    public Node rotateLeft(Node A) {//the method to rotate the tree to the left
        Node B = A.right;
        Node C = B.left;
        if (A == root) {
            this.root = B;
        }
        B.left = A;
        A.right = C;
        if (C != null) {
            C.height = Math.max(height(C.left), height(C.right)) + 1;
        }
        A.height = Math.max(height(A.left), height(A.right)) + 1;
        B.height = Math.max(height(B.left), height(B.right)) + 1;
        return B;
    }

    public boolean searchNode(int data) {//the method to search for a node in the tree
        if (search(this.root, data)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean search(Node node, int data) {//the method to search for a node in the tree
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        } else if (data < node.data) {
            return search(node.left, data);
        } else {
            return search(node.right, data);
        }
    }

    public int FindMax() {//the method the user call to find the maximum node in the tree
        if (this.root == null) {
            return -1;
        }
        Node node = FindMax(this.root);
        return node.data;
    }

    public Node FindMax(Node node) {//the method to find the maximum node in the tree
        if (node.right == null) {
            return node;
        } else {
            return FindMax(node.right);
        }
    }

    public int FindMin() {//the method that the user call to find the minimum node in the tree
        if (root == null) {
            return -1;
        }
        Node node = FindMin(root);
        return node.data;
    }

    public Node FindMin(Node node) {//the method tha to find the minimum node in the tree
        if (node.left == null) {
            return node;
        } else {
            return FindMin(node.left);
        }
    }

    public void insert(int data) {//the method that the user call to insert a node in the tree
        if (search(root, data)) {
            System.out.println("the node is already exist");
        }
        size++;
        this.root = insert(this.root, data);
    }

    public Node insert(Node node, int data) {//the method to insert a node in the tree
        if (node == null) {//if we reach beyond the leaf node then create a new node
            node = new Node(data);
            return node;
        } else if (data < node.data) {//if the data is less than the node data then go to the left
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);//if the data is greater than the node data then go to the right
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;//update the height of the node
        node.balanceFactor = balanceFactor(node);//update the balance factor of the node
        if (node.balanceFactor > 1) {//if the balance factor is greater than 1 then we need to rotate the tree
            if (balanceFactor(node.left) >= 0) {//if the balance factor of the left child is greater than or equal to 0 then we need to rotate the tree to the right
                node = rotateRight(node);
            } else {//if the balance factor of the left child is less than 0 then we need to rotate the tree to the left then rotate the tree to the right
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        } else if (node.balanceFactor < -1) {//if the balance factor is less than -1 then we need to rotate the tree
            if (balanceFactor(node.right) <= 0) {//if the balance factor of the right child is less than or equal to 0 then we need to rotate the tree to the left
                node = rotateLeft(node);//rotate the tree to the left
            } else {//if the balance factor of the right child is greater than 0 then we need to rotate the tree to the right then rotate the tree to the left
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
        return node;
    }

    public void delete(int data) {//the method that the user call to delete a node in the tree
        if (!search(root, data)) {//if the node is not found then print a message
            System.out.println("the node is not found");
        }
        size--;//decrease the size of the tree
        this.root = delete(this.root, data);//call the method to delete the node
        System.out.println("the node is deleted successfully");

    }

    public Node delete(Node node, int data) {
        if (node == null) {//if the node is not found then return null
            return null;
        } else if (data < node.data) {//if the data is less than the node data then go to the left
            node.left = delete(node.left, data);//if the data is equal to the node data then delete the node
        } else if (data > node.data) {//if the data is greater than the node data then go to the right
            node.right = delete(node.right, data);//if the data is equal to the node data then delete the node
        } else {
            if (node.right == null && node.left == null) {//if the node is the leaf node then set it with null
                node = null;
            } else if (node.right == null) {//if the node has only one left child then replace the node with its child
                node = node.left;
            } else if (node.left == null) {//if the node has only one right child then replace the node with its child
                node = node.right;
            } else {
                Node temp = FindMin(node.right);//if the node has two children then find the minimum node in the right subtree
                node.data = temp.data;//replace the node data with the minimum node data
                node.right = delete(node.right, temp.data);//delete the minimum node
            }
            node.height = Math.max(height(node.left), height(node.right)) + 1;//update the height of the node
            node.balanceFactor = balanceFactor(node);//update the balance factor of the node
            if (node.balanceFactor > 1) {//if the balance factor is greater than 1 then we need to rotate the tree
                if (balanceFactor(node.left) >= 0) {//(left Left )if the balance factor of the left child is greater than or equal to 0 then we need to rotate the tree to the right
                    node = rotateRight(node);
                } else {//(left right)if the balance factor of the left child is less than 0 then we need to rotate the tree to the left then rotate the tree to the right
                    node.left = rotateLeft(node.left);//if the balance factor of the left child is less than 0 then we need to rotate the tree to the left then rotate the tree to the right
                    node = rotateRight(node);//rotate the tree to the right
                }
            } else if (node.balanceFactor < -1) {//if the balance factor is less than -1 then we need to rotate the tree
                if (balanceFactor(node.right) <= 0) {//(Right Right)if the balance factor of the right child is less than or equal to 0 then we need to rotate the tree to the left
                    node = rotateLeft(node);
                } else {//(Right Left)if the balance factor of the right child is greater than 0 then we need to rotate the tree to the right then rotate the tree to the left
                    node.right = rotateRight(node.right);
                    node = rotateLeft(node);
                }
            }
        }
        return node;
    }

    public void inorder() {//the method that the user call to print the tree in inorder traversal 
        inorder(this.root);
        System.out.println();
    }

    public void inorder(Node node) {//the method that print the tree in inorder traversal
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public void preorder() {//the method that the user call to print the tree in preorder traversal
        preorder(this.root);
        System.out.println();
    }

    public void preorder(Node node) {//the method that print the tree in preorder traversal
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder() {//the method that the user call to print the tree in postorder traversal
        postorder(this.root);
        System.out.println();
    }

    public void postorder(Node node) {//the method that print the tree in postorder traversal
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        AVL_Tree tree = new AVL_Tree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);
        tree.preorder();
        System.out.println("the height of the tree is " + tree.TreeHeight());
        System.out.println("the size of the tree is " + tree.Getsize());
        System.out.println("the max value in the tree is " + tree.FindMax());
        System.out.println("the min value in the tree is " + tree.FindMin());
        tree.delete(30);
        tree.preorder();
    }
}
