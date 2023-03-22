package org.DSLab2.MyApplication.AVLType;
class Node<T> {//the node class which contains the data and the left and right node
    T data ;
    int balanceFactor = 0;
    int height = 1;
    Node<T> left;
    Node<T> right;

    Node(T data) {//the constructor of the node class
        this.data = data;
        this.left = null;
        this.right = null;
    }
}