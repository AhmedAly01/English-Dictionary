package org.DSLab2.MyApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static org.DSLab2.MyApplication.FactoryProducer.GetDictionaryTreeType;

public class MainDictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AbstractFactory tree;
        while (true) {
            System.out.print("Enter the type of the backend tree (Red Black - AVL): ");
            String treeType = sc.nextLine();
            tree = GetDictionaryTreeType(treeType);
            if (tree == null) System.out.println("Invalid Tree Type");
            else break;
        }
        System.out.println("Welcome To Simple Dictionary!");
        System.out.println("Supported Commands:");
        System.out.println("    • Insert <word>");
        System.out.println("    • Delete <word>");
        System.out.println("    • Search <word>");
        System.out.println("    • Batch Insert");
        System.out.println("    • Batch Delete");
        System.out.println("    • Size");
        System.out.println("    • Height");
        System.out.println("    • Exit");
        while (true) {
            System.out.print("Enter Command: ");
            String input = sc.nextLine();
            String[] in = input.split(" ");
            if (in.length == 0) {
                System.out.println("Invalid Command");
                continue;
            }
            if (in.length == 1) {
                if (in[0].equalsIgnoreCase("size")) {
                    System.out.println(tree.Size());
                } else if (in[0].equalsIgnoreCase("height")) {
                    System.out.println(tree.Height());
                } else if (in[0].equalsIgnoreCase("exit")) break;
                else {
                    System.out.println("Invalid Command");
                }
            }
            else {
                String command = in[0];
                String word = in[1];
                if (command.equalsIgnoreCase("insert")) {
                    if (tree.insert(word)) {
                        System.out.println("Inserted Successfully");
                    } else {
                        System.out.println("Word Already in Dictionary");
                    }
                } else if (command.equalsIgnoreCase("delete")) {
                    if (tree.delete(word)) {
                        System.out.println("Deleted Successfully");
                    } else {
                        System.out.println("Word Not in Dictionary");
                    }
                } else if (command.equalsIgnoreCase("search")) {
                    if (tree.search(word)) {
                        System.out.println("Found!");
                    } else {
                        System.out.println("Not Found!");
                    }
                } else if (command.equalsIgnoreCase("batch")) {
                    System.out.print("Enter File Path: ");
                    String file = sc.nextLine();
                    if (word.equalsIgnoreCase("insert")) {
                        tree.BatchInsert(file);
                    } else if (word.equalsIgnoreCase("delete")) {
                        tree.BatchDelete(file);
                    }
                }
            }
        }
    }
}
