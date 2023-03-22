package org.DSLab2.MyApplication.AVLType;

public class AVLDictionary<T extends Comparable<T>> implements AVLDictionaryIF<T>{
    AVLNode<T> root;//the root node
    int size = 0;//the size of the tree(number of nodes)

    public AVLDictionary() {//the constructor of the tree class
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

    public int balanceFactor(AVLNode<T> AVLNode) {//the method to get the balance factor of a node
        return height(AVLNode.left) - height(AVLNode.right);
    }

    public int TreeHeight() {//the method to get the height of the tree
        if (root == null) {
            return -1;
        } else {
            return root.height;
        }
    }

    public int height(AVLNode<T> AVLNode) {//the method to get the height of a node
        if (AVLNode == null) {
            return 0;
        } else {
            return AVLNode.height;
        }
    }

    public AVLNode<T> rotateRight(AVLNode<T> A) {//the method to rotate the tree to the right
        AVLNode<T> B = A.left;
        AVLNode<T> C = B.right;
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

    public AVLNode<T> rotateLeft(AVLNode<T> A) {//the method to rotate the tree to the left
        AVLNode<T> B = A.right;
        AVLNode<T> C = B.left;
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

    public boolean searchNode(T data) {//the method to search for a node in the tree
        if (search(this.root, data)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean search(AVLNode<T> AVLNode, T data) {//the method to search for a node in the tree
        if (AVLNode == null) {
            return false;
        }
        if (AVLNode.data.compareTo(data) == 0) {
            return true;
        } else if (data.compareTo(AVLNode.data) < 0) {
            return search(AVLNode.left, data);
        } else {
            return search(AVLNode.right, data);
        }
    }

    public T FindMax() {//the method the user call to find the maximum node in the tree
        if (this.root == null) {
            return null;
        }
        AVLNode<T> AVLNode = FindMax(this.root);
        return AVLNode.data;
    }

    public AVLNode<T> FindMax(AVLNode<T> AVLNode) {//the method to find the maximum node in the tree
        if (AVLNode.right == null) {
            return AVLNode;
        } else {
            return FindMax(AVLNode.right);
        }
    }

    public T FindMin() {//the method that the user call to find the minimum node in the tree
        if (root == null) {
            return null;
        }
        AVLNode<T> AVLNode = FindMin(root);
        return AVLNode.data;
    }

    public AVLNode<T> FindMin(AVLNode<T> AVLNode) {//the method tha to find the minimum node in the tree
        if (AVLNode.left == null) {
            return AVLNode;
        } else {
            return FindMin(AVLNode.left);
        }
    }

    public boolean insert(T data) {//the method that the user call to insert a node in the tree
        if (search(root, data)) {
            return false;
        }
        size++;
        this.root = insert(this.root, data);
        return true;
    }

    public AVLNode<T> insert(AVLNode<T> AVLNode, T data) {//the method to insert a node in the tree
        if (AVLNode == null) {//if we reach beyond the leaf node then create a new node
            AVLNode = new AVLNode<>(data);
            return AVLNode;
        } else if (data.compareTo(AVLNode.data) < 0) {//if the data is less than the node data then go to the left
            AVLNode.left = insert(AVLNode.left, data);
        } else {
            AVLNode.right = insert(AVLNode.right, data);//if the data is greater than the node data then go to the right
        }
        AVLNode.height = Math.max(height(AVLNode.left), height(AVLNode.right)) + 1;//update the height of the node
        AVLNode.balanceFactor = balanceFactor(AVLNode);//update the balance factor of the node
        if (AVLNode.balanceFactor > 1) {//if the balance factor is greater than 1 then we need to rotate the tree
            if (balanceFactor(AVLNode.left) >= 0) {//if the balance factor of the left child is greater than or equal to 0 then we need to rotate the tree to the right
                AVLNode = rotateRight(AVLNode);
            } else {//if the balance factor of the left child is less than 0 then we need to rotate the tree to the left then rotate the tree to the right
                AVLNode.left = rotateLeft(AVLNode.left);
                AVLNode = rotateRight(AVLNode);
            }
        } else if (AVLNode.balanceFactor < -1) {//if the balance factor is less than -1 then we need to rotate the tree
            if (balanceFactor(AVLNode.right) <= 0) {//if the balance factor of the right child is less than or equal to 0 then we need to rotate the tree to the left
                AVLNode = rotateLeft(AVLNode);//rotate the tree to the left
            } else {//if the balance factor of the right child is greater than 0 then we need to rotate the tree to the right then rotate the tree to the left
                AVLNode.right = rotateRight(AVLNode.right);
                AVLNode = rotateLeft(AVLNode);
            }
        }
        return AVLNode;
    }

    public boolean delete(T data) {//the method that the user call to delete a node in the tree
        if (!search(root, data)) {//if the node is not found then print a message
            return false;
        }
        else {
            size--;//decrease the size of the tree
            this.root = delete(this.root, data);//call the method to delete the node
            if (this.root != null) this.root.height = Math.max(height(this.root.left), height(this.root.right)) + 1;
            return true;
        }
    }

    public AVLNode<T> delete(AVLNode<T> AVLNode, T data) {
        if (AVLNode == null) {//if the node is not found then return null
            return null;
        } else if (data.compareTo(AVLNode.data) < 0) {//if the data is less than the node data then go to the left
            AVLNode.left = delete(AVLNode.left, data);//if the data is equal to the node data then delete the node
        } else if (data.compareTo(AVLNode.data) > 0) {//if the data is greater than the node data then go to the right
            AVLNode.right = delete(AVLNode.right, data);//if the data is equal to the node data then delete the node
        } else {
            if (AVLNode.right == null && AVLNode.left == null) {//if the node is the leaf node then set it with null
                AVLNode = null;
                return AVLNode;
            } else if (AVLNode.right == null) {//if the node has only one left child then replace the node with its child
                AVLNode = AVLNode.left;
            } else if (AVLNode.left == null) {//if the node has only one right child then replace the node with its child
                AVLNode = AVLNode.right;
            } else {
                AVLNode<T> temp = FindMin(AVLNode.right);//if the node has two children then find the minimum node in the right subtree
                AVLNode.data = temp.data;//replace the node data with the minimum node data
                AVLNode.right = delete(AVLNode.right, temp.data);//delete the minimum node
            }
            AVLNode.height = Math.max(height(AVLNode.left), height(AVLNode.right)) + 1;//update the height of the node
            AVLNode.balanceFactor = balanceFactor(AVLNode);//update the balance factor of the node
            if (AVLNode.balanceFactor > 1) {//if the balance factor is greater than 1 then we need to rotate the tree
                if (balanceFactor(AVLNode.left) >= 0) {//(left)if the balance factor of the left child is greater than or equal to 0 then we need to rotate the tree to the right
                    AVLNode = rotateRight(AVLNode);
                } else {//(left right)if the balance factor of the left child is less than 0 then we need to rotate the tree to the left then rotate the tree to the right
                    AVLNode.left = rotateLeft(AVLNode.left);//if the balance factor of the left child is less than 0 then we need to rotate the tree to the left then rotate the tree to the right
                    AVLNode = rotateRight(AVLNode);//rotate the tree to the right
                }
            } else if (AVLNode.balanceFactor < -1) {//if the balance factor is less than -1 then we need to rotate the tree
                if (balanceFactor(AVLNode.right) <= 0) {//(Right)if the balance factor of the right child is less than or equal to 0 then we need to rotate the tree to the left
                    AVLNode = rotateLeft(AVLNode);
                } else {//(Right Left)if the balance factor of the right child is greater than 0 then we need to rotate the tree to the right then rotate the tree to the left
                    AVLNode.right = rotateRight(AVLNode.right);
                    AVLNode = rotateLeft(AVLNode);
                }
            }
        }
        AVLNode.height = Math.max(height(AVLNode.left), height(AVLNode.right)) + 1;
        return AVLNode;
    }

    public void inorder() {//the method that the user call to print the tree in inorder traversal
        inorder(this.root);
        System.out.println();
    }

    private void inorder(AVLNode<T> AVLNode) {//the method that print the tree in inorder traversal
        if (AVLNode == null) {
            return;
        }
        inorder(AVLNode.left);
        System.out.print(AVLNode.data + " ");
        inorder(AVLNode.right);
    }

    public void preorder() {//the method that the user call to print the tree in preorder traversal
        preorder(this.root);
        System.out.println();
    }

    private void preorder(AVLNode<T> AVLNode) {//the method that print the tree in preorder traversal
        if (AVLNode == null) {
            return;
        }
        System.out.print(AVLNode.data + " ");
        preorder(AVLNode.left);
        preorder(AVLNode.right);
    }

    public void postorder() {//the method that the user call to print the tree in postorder traversal
        postorder(this.root);
        System.out.println();
    }

    private void postorder(AVLNode<T> AVLNode) {//the method that print the tree in postorder traversal
        if (AVLNode == null) {
            return;
        }
        postorder(AVLNode.left);
        postorder(AVLNode.right);
        System.out.print(AVLNode.data + " ");
    }
}
