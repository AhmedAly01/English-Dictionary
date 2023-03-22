package org.DSLab2.MyApplication.AVLType;
class AVLNode<T> {//the node class which contains the data and the left and right node
    T data ;
    int balanceFactor = 0;
    int height = 1;
    AVLNode<T> left;
    AVLNode<T> right;

    AVLNode(T data) {//the constructor of the node class
        this.data = data;
        this.left = null;
        this.right = null;
    }
}