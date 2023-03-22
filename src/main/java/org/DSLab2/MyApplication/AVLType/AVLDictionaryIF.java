package org.DSLab2.MyApplication.AVLType;

public interface AVLDictionaryIF<T> {
    public int Getsize();

    public boolean isEmpty();

    public int balanceFactor(AVLNode<T> AVLNode);

    public int height(AVLNode<T> AVLNode);

    public AVLNode<T> rotateRight(AVLNode<T> AVLNode);

    public AVLNode<T> rotateLeft(AVLNode<T> AVLNode);

    public boolean searchNode(T data);

    public boolean search(AVLNode<T> AVLNode, T data);

    public T FindMin();

    public T FindMax();

    public AVLNode<T> FindMax(AVLNode<T> AVLNode);

    public AVLNode<T> FindMin(AVLNode<T> AVLNode);

    public boolean insert(T data);

    public AVLNode<T> insert(AVLNode<T> AVLNode, T data);

    public boolean delete(T data);

    public AVLNode<T> delete(AVLNode<T> AVLNode, T data);

    public void inorder();


    public void preorder();

    public void postorder();
}
