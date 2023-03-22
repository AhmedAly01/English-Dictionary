package org.DSLab2.AVL;

interface AvlTree {
    public int size();

    public boolean isEmpty();

    public boolean search(int data);

    public int FindMin();

    public int FindMax();

    public void insert(int data);

    public void delete(int data);

    public void inorder();

    public void preorder();

    public void postorder();

}
