package org.DSLab2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        RBTree<Integer> rbTree = new RBTree<>();
        int n = scn.nextInt();
        for(int i=0;i<n;i++){
            rbTree.insert(scn.nextInt());
        }
        for(int i=0;i<n;i++){
            if (rbTree.find(scn.nextInt()) != null) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

