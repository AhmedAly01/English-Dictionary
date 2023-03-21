package org.DSLab2.MyApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class AbstractFactory {
    abstract void insert(String str);

    abstract void delete(String str);

    abstract boolean search(String str) ;
    abstract void BatchInsert(String file);
    abstract void BatchDelete(String file);
    abstract int Size();
    abstract int Height();
    abstract void inorder();
    abstract void preorder();
    abstract void postorder();
}
