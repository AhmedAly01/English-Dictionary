package org.DSLab2.MyApplication.AVLType;

import org.DSLab2.MyApplication.AVLType.Node;

public interface AVLDictionaryIF {
    public int Getsize();

    public boolean isEmpty();

    public int balanceFactor(Node node);

    public int height(Node node);

    public Node rotateRight(Node node);

    public Node rotateLeft(Node node);

    public boolean searchNode(String data);

    public boolean search(Node node, String data);

    public String FindMin();

    public String FindMax();

    public Node FindMax(Node node);

    public Node FindMin(Node node);

    public void insert(String data);

    public Node insert(Node node, String data);

    public void delete(String data);

    public Node delete(Node node, String data);

    public void inorder();


    public void preorder();

    public void postorder();
}
