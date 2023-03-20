package org.DSLab2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AVLTree<String> tree = new AVLTree<>();
        BSTree<String> BST = new BSTree<>();// create a new binary tree
        BST.insert("10");
        BST.insert("5");
        BST.insert("15");
        BST.insert("3");
        BST.insert("7");
        BST.insert("12");
        BST.insert("18");

        tree.insert("a");
        tree.insert("d");
        tree.insert("v");
        tree.insert("c");
        tree.insert("w");
        tree.insert("o");
        tree.insert("k");

//        System.out.println();
//        BST.preOrder();
//        System.out.println();
//        System.out.println(BST.height());
//        System.out.println(BST.search("10"));
//        System.out.println(BST.search("5"));
//        System.out.println(BST.search("8"));
//        System.out.println(BST.size());

        System.out.println();
        tree.preOrder();
        System.out.println();
        System.out.println(tree.height());
        System.out.println(tree.search("a"));
        System.out.println(tree.search("k"));
        System.out.println(tree.search("z"));
        System.out.println(tree.size());
    }
}

