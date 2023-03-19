package org.DSLab2;

class AVLNode<T> extends Node<T>{// the node class which contains the data and the left and right node
    int balanceFactor = 0;
    AVLNode<T> left;
    AVLNode<T> right;

    AVLNode(T data) {
        super(data);
        this.balanceFactor = 0;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}