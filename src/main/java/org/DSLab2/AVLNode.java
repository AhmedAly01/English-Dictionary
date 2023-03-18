package org.DSLab2;

class AVLNode extends Node{// the node class which contains the data and the left and right node
    int balanceFactor = 0;
    AVLNode left;
    AVLNode right;
    String data;
    int height;

    AVLNode(String data) {
        super(data);
        this.balanceFactor = 0;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}