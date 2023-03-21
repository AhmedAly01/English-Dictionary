package org.DSLab2;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

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

        System.out.println();
        BST.preOrder();
        System.out.println();
        System.out.println(BST.height());
        System.out.println(BST.search("10"));
        System.out.println(BST.search("5"));
        System.out.println(BST.search("8"));
        System.out.println(BST.size());

        System.out.println();
        tree.preOrder();
        System.out.println();
        System.out.println(tree.height());
        System.out.println(tree.search("a"));
        System.out.println(tree.search("k"));
        System.out.println(tree.search("z"));
        System.out.println(tree.size());

        // to test the red black tree
//        RBTree<Integer> rbTree = new RBTree<>();
//        Integer[] input = {
//                85, 137, 167, 96, 97, 12, 98, 48, 94, 25, 160, 130, 73, 59, 168, 142, 155, 82, 188, 5, 81,
//                77, 27, 32, 116, 143, 145, 183, 65, 69, 71, 84, 109, 16, 127, 42, 177, 35, 55, 28, 93, 161,
//                21, 197, 148, 76, 123, 26, 11, 4, 30, 174, 147, 50, 175, 187, 115, 117, 199, 40, 49, 174,
//                60, 5, 186, 176, 27, 129, 113, 147, 53, 194, 45, 163, 83, 166, 188, 196, 159, 34, 91, 171,
//                149, 129, 153, 90, 77, 170, 174, 106, 28, 42, 57, 56, 118, 26, 143, 108, 109, 192, 78, 118,
//                95, 20, 29, 100, 49, 43, 128, 99, 92, 138, 140, 43, 28, 125, 43, 68, 142, 129, 116, 19, 153,
//                141, 77, 38, 97, 10, 194, 120, 73, 55, 130, 129, 38, 196, 50, 8, 108, 6, 46, 98, 156, 165, 122,
//                144, 51, 19, 97, 26, 141, 153, 56, 111, 28, 39, 26, 186, 106, 17, 179, 146, 66, 58, 79, 166, 116,
//                122, 102, 25, 42, 52, 22, 174, 135, 49, 188, 89, 180, 187, 131, 190, 46, 26, 192, 100, 78, 59, 118,
//                92, 41, 144, 150, 198, 132, 71, 16, 112, 67, 94, 193, 139, 33, 154, 56, 160, 62, 137, 63, 55, 50,
//                90, 84, 63, 39, 66, 41, 148, 24, 168, 151, 42, 16, 63, 78, 152, 129, 80, 52, 136, 22, 62, 23, 92,
//                17, 182, 95, 50, 69, 91, 119, 135, 136, 4, 66, 175, 167, 153, 56, 41, 39, 166
//        };
//        Set<Integer> sett = new HashSet<>();
//        for (int i = 0; i < input.length; i++) {
//            sett.add(input[i]);
//            rbTree.insert(input[i]);
//            if (sett.size() != rbTree.size()) {
//                System.out.println(i);
//            }
//        }
//        shuffleArray(input);
//        System.out.println(input[0]);
//        for(int i=0;i< input.length;i++){
//            rbTree.delete(input[i]);
//            if(i==input.length-3){
//                System.out.println("end");
//            }
//        }
//        System.out.println(rbTree.size());
////        System.out.println(sett.size());
//    }
//    private static void shuffleArray(Integer[] array) {
//        Random rand = new Random();
//        for (int i = array.length - 1; i > 0; i--) {
//            int index = rand.nextInt(i + 1);
//            // Swap the elements at i and index
//            int temp = array[i];
//            array[i] = array[index];
//            array[index] = temp;
//        }
    }
}

