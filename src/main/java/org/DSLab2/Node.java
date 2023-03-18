package org.DSLab2;

class Node {
    String data;
    Node left;
    Node right;
    int height;

    Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}
