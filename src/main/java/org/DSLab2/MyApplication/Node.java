package org.DSLab2.MyApplication;
class Node {//the node class which contains the data and the left and right node
    String data ;
    int balanceFactor = 0;
    int height = 1;
    Node left;
    Node right;

    Node(String data) {//the constructor of the node class
        this.data = data;
        this.left = null;
        this.right = null;
        height = 1;
    }
}