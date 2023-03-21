package org.DSLab2.MyApplication.AVLType;

public interface AVLDictionaryIF<T> {
    public int Getsize();

    public boolean isEmpty();

    public int balanceFactor(Node<T> node);

    public int height(Node<T> node);

    public Node<T> rotateRight(Node<T> node);

    public Node<T> rotateLeft(Node<T> node);

    public boolean searchNode(T data);

    public boolean search(Node<T> node, T data);

    public T FindMin();

    public T FindMax();

    public Node<T> FindMax(Node<T> node);

    public Node<T> FindMin(Node<T> node);

    public boolean insert(T data);

    public Node<T> insert(Node<T> node, T data);

    public boolean delete(T data);

    public Node<T> delete(Node<T> node, T data);

    public void inorder();


    public void preorder();

    public void postorder();
}
