package org.DSLab2.MyApplication.RBType;


public interface RBTreeIF<T extends Comparable<T>> {
    public int size();

    public boolean isEmpty();

    public boolean search(T data);

    public boolean insert(T data);

    public boolean delete(T data);

    public int height();
    void inorder();


    void preorder();


    void postorder();

}
