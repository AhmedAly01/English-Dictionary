package org.DSLab2.MyApplication;

public abstract class AbstractFactory {
    abstract boolean insert(String str);

    abstract boolean delete(String str);

    abstract boolean search(String str) ;
    abstract int[] BatchInsert(String file);
    abstract int[] BatchDelete(String file);
    abstract int Size();
    abstract int Height();
    abstract void inorder();
    abstract void preorder();
    abstract void postorder();
}
