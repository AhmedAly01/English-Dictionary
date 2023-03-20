package org.DSLab2.AVL;


import java.util.Objects;

public class AVLTree<T extends Comparable <? super T>> extends BSTree<T> {// the AVLTree class which implements the AvlTree interface
    AVLNode<T> root;// the root node
    int size = 0;// the size of the tree(number of nodes)

    public AVLTree() {// the constructor of the tree class
        this.root = null;
    }

    public int size() {// the method to get the size of the tree
        return size;
    }


    public int balanceFactor(AVLNode<T> node) {// the method to get the balance factor of a node
        return height(node.left) - height(node.right);
    }

    public int TreeHeight() {// the method to get the height of the tree
        if (root == null) {
            return -1;
        } else {
            return root.height;
        }
    }

    public AVLNode<T> rotateRight(AVLNode<T> A) {// the method to rotate the tree to the right
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

    public AVLNode<T> rotateLeft(AVLNode<T> A) {// the method to rotate the tree to the left
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
    public void preOrder() {// the preorder traversal
        preOrder(this.root);
    }
    void preOrder(AVLNode<T> node) {// pre order traversal
        if (node == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public boolean insert(T data) {// the method that the user call to insert a node in the tree
        if (search(root, data)) {
            return false;
        }
        size++;
        this.root = insert(this.root, data);
        return true;
    }

    public AVLNode<T> insert(AVLNode<T> node, T data) {// the method to insert a node in the tree
        if (node == null) {// if we reach beyond the leaf node then create a new node
            node = new AVLNode<>(data);
            return node;
        } else if (data.compareTo(node.data) < 0) {// if the data is less than the node data then go to the left
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);// if the data is greater than the node data then go to the right
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;// update the height of the node
        node.balanceFactor = balanceFactor(node);// update the balance factor of the node
        if (node.balanceFactor > 1) {// if the balance factor is greater than 1 then we need to rotate the tree
            if (balanceFactor(node.left) >= 0) {// if the balance factor of the left child is greater than or equal to 0
                // then we need to rotate the tree to the right
                node = rotateRight(node);
            } else {// if the balance factor of the left child is less than 0 then we need to rotate
                // the tree to the left then rotate the tree to the right
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        } else if (node.balanceFactor < -1) {// if the balance factor is less than -1 then we need to rotate the tree
            if (balanceFactor(node.right) <= 0) {// if the balance factor of the right child is less than or equal to 0
                // then we need to rotate the tree to the left
                node = rotateLeft(node);// rotate the tree to the left
            } else {// if the balance factor of the right child is greater than 0 then we need to
                // rotate the tree to the right then rotate the tree to the left
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
        return node;
    }

    @Override
    public boolean delete(T data) {// the method that the user call to delete a node in the tree
        if (!search(root, data)) {// if the node is not found then print a message
            return false;
        }
        size--;// decrease the size of the tree
        this.root = delete(this.root, data);// call the method to delete the node
        return true;

    }

    public AVLNode<T> delete(AVLNode<T> node, T data) {
        if (node == null) {// if the node is not found then return null
            return null;
        } else if (data.compareTo(node.data) < 0) {// if the data is less than the node data then go to the left
            node.left = delete(node.left, data);// if the data is equal to the node data then delete the node
        } else if (data.compareTo(node.data) > 0) {// if the data is greater than the node data then go to the right
            node.right = delete(node.right, data);// if the data is equal to the node data then delete the node
        } else {
            if (node.right == null && node.left == null) {// if the node is the leaf node then set it with null
                node = null;
            } else if (node.right == null) {// if the node has only one left child then replace the node with its child
                node = node.left;
            } else if (node.left == null) {// if the node has only one right child then replace the node with its child
                node = node.right;
            } else {
                AVLNode<T> temp = (AVLNode<T>) findMin(node.right);// if the node has two children then find the minimum node in the right
                // subtree
                node.data = temp.data;// replace the node data with the minimum node data
                node.right = delete(node.right, temp.data);// delete the minimum node
            }
            assert node != null;
            node.height = Math.max(height(node.left), height(node.right)) + 1;// update the height of the node
            node.balanceFactor = balanceFactor(node);// update the balance factor of the node
            if (node.balanceFactor > 1) {// if the balance factor is greater than 1 then we need to rotate the tree
                if (balanceFactor(node.left) >= 0) {// (Left )if the balance factor of the left child is greater
                    // than or equal to 0 then we need to rotate the tree to the right
                    node = rotateRight(node);
                } else {// (left right)if the balance factor of the left child is less than 0 then we
                    // need to rotate the tree to the left then rotate the tree to the right
                    node.left = rotateLeft(node.left);// if the balance factor of the left child is less than 0 then we
                    // need to rotate the tree to the left then rotate the tree to the
                    // right
                    node = rotateRight(node);// rotate the tree to the right
                }
            } else if (node.balanceFactor < -1) {// if the balance factor is less than -1 then we need to rotate the
                // tree
                if (balanceFactor(node.right) <= 0) {// (Right) if the balance factor of the right child is less
                    // than or equal to 0 then we need to rotate the tree to the left
                    node = rotateLeft(node);
                } else {// (Right Left)if the balance factor of the right child is greater than 0 then
                    // we need to rotate the tree to the right then rotate the tree to the left
                    node.right = rotateRight(node.right);
                    node = rotateLeft(node);
                }
            }
        }
        return node;
    }

    public boolean search(T data) {// search a node if it exists or not
        return search(this.root, data);
    }

    boolean search(AVLNode<T> node, T data) {
        if (node == null) {// if the node is null then return false
            return false;
        }
        if (Objects.equals(node.data, data)) {// if the node data is equal to the data then return true
            return true;
        }
        if (data.compareTo(node.data) < 0){// if the data is less than the node data then search the left
            if (node.left != null)
                return search(node.left, data);
        }
        if (node.right != null)
            return search(node.right, data);// if the data is greater than the node data then search the right
        return false;
    }

    public int height() {// find the height of the tree
        return height(this.root);
    }

    int height(AVLNode<T> node) {// find the height of the tree
        if (node == null) {// if the node is null then return 0 as there is no height in the null node
            //means we reach the end of the tree
            return 0;
        } else {
            return Math.max(height(node.left), height(node.right)) + 1;// return the maximum height of the tree from the
            // left and right subtree and add 1 to the height of the tree
        }

    }
}




