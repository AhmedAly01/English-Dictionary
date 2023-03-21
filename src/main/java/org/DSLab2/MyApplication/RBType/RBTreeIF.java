package org.DSLab2.MyApplication.RBType;


public interface RBTreeIF<T extends Comparable<T>> {
    RBNode<T> insert(T key);
    RBNode<T> delete(T key);
    RBNode<T> search(T key);
    int size();
    int height();
    void inorder();


    void preorder();


    void postorder();

}
