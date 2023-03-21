package org.DSLab2.MyApplication;

import java.nio.file.Files;
import java.nio.file.Path;

public class MainDictionary {
    public static void main(String[] args) {
        AbstractFactory DI = FactoryProducer.GetDictionaryTreeType("AVLDictionary");
        DI.insert("abdallah");
        DI.insert("nemo");
        DI.insert("soso");
        DI.insert("yasser");
        DI.insert("hecham");
        DI.preorder();
        System.out.println("the height of the tree is " + DI.Height());
        System.out.println("the size of the tree is " + DI.Size());
        DI.delete("abdallah");
        System.out.println("the height of the tree is " + DI.Height());
        System.out.println("the size of the tree is " + DI.Size());
        DI.preorder();
        String filePath = "D:\\LEVEL 2 CSE (Semester 2)\\DataStructure\\test.txt";
        DI.BatchInsert(filePath);
        System.out.println("the height of the tree is " + DI.Height());
        System.out.println("the size of the tree is " + DI.Size());
        DI.preorder();
        System.out.println(DI.search("omar"));
        System.out.println(DI.search("ooo"));
        DI.BatchDelete(filePath);
        System.out.println("the height of the tree is " + DI.Height());
        System.out.println("the size of the tree is " + DI.Size());
        DI.preorder();


        /***********************************************************************************/

        System.out.println("/*********************************************************************/");
        AbstractFactory RB = FactoryProducer.GetDictionaryTreeType("RBDictionary");
        RB.insert("abdallah");
        RB.insert("nemo");
        RB.insert("soso");
        RB.insert("yasser");
        RB.insert("hecham");
        RB.preorder();
        System.out.println("the height of the tree is " + RB.Height());
        System.out.println("the size of the tree is " + RB.Size());
        RB.delete("abdallah");
        System.out.println("the height of the tree is " + RB.Height());
        System.out.println("the size of the tree is " + RB.Size());
        RB.preorder();
        RB.BatchInsert(filePath);
        System.out.println("the height of the tree is " + RB.Height());
        System.out.println("the size of the tree is " + RB.Size());
        RB.preorder();
        System.out.println(RB.search("omar"));
        System.out.println(RB.search("ooo"));
        RB.BatchDelete(filePath);
        System.out.println("the height of the tree is " + RB.Height());
        System.out.println("the size of the tree is " + RB.Size());
        RB.preorder();

    }
}
