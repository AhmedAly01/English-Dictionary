
class Node {
    int data = 0;
    int balanceFactor = 0;
    int height = 1;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        height = 1;
    }
}

public class AVL_Tree implements AvlTree {
    Node root;
    int size = 0;

    AVL_Tree() {
        this.root = null;
    }

    public int Getsize() {
        return size;
    }

    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    public int balanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    public int TreeHeight() {
        if (root == null) {
            return -1;
        } else {
            return root.height;
        }
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.height;
        }
    }

    public Node rotateRight(Node A) {
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

    public Node rotateLeft(Node A) {
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

    public boolean searchNode(int data) {
        if (search(this.root, data)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean search(Node node, int data) {
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

    public int FindMax() {
        if (this.root == null) {
            return -1;
        }
        Node node = FindMax(this.root);
        return node.data;
    }

    public Node FindMax(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return FindMax(node.right);
        }
    }

    public int FindMin() {
        if (root == null) {
            return -1;
        }
        Node node = FindMin(root);
        return node.data;
    }

    public Node FindMin(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return FindMin(node.left);
        }
    }

    public void insert(int data) {
        if (search(root, data)) {
            System.out.println("the node is already exist");
        }
        size++;
        this.root = insert(this.root, data);
    }

    public Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        } else if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        node.balanceFactor = balanceFactor(node);
        if (node.balanceFactor > 1) {
            if (balanceFactor(node.left) >= 0) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        } else if (node.balanceFactor < -1) {
            if (balanceFactor(node.right) <= 0) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
        return node;
    }

    public void delete(int data) {
        if (!search(root, data)) {
            System.out.println("the node is not found");
        }
        size--;
        this.root = delete(this.root, data);
        System.out.println("the node is deleted successfully");

    }

    public Node delete(Node node, int data) {
        if (node == null) {
            return null;
        } else if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {
            if (node.right == null && node.left == null) {
                node = null;
            } else if (node.right == null) {
                node = node.left;
            } else if (node.left == null) {
                node = node.right;
            } else {
                Node temp = FindMin(node.right);
                node.data = temp.data;
                node.right = delete(node.right, temp.data);
            }
            node.height = Math.max(height(node.left), height(node.right)) + 1;
            node.balanceFactor = balanceFactor(node);
            if (node.balanceFactor > 1) {
                if (balanceFactor(node.left) >= 0) {
                    node = rotateRight(node);
                } else {
                    node.left = rotateLeft(node.left);
                    node = rotateRight(node);
                }
            } else if (node.balanceFactor < -1) {
                if (balanceFactor(node.right) <= 0) {
                    node = rotateLeft(node);
                } else {
                    node.right = rotateRight(node.right);
                    node = rotateLeft(node);
                }
            }
        }
        return node;
    }

    public void inorder() {
        inorder(this.root);
        System.out.println();
    }

    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public void preorder() {
        preorder(this.root);
        System.out.println();
    }

    public void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder() {
        postorder(this.root);
        System.out.println();
    }

    public void postorder(Node node) {
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
