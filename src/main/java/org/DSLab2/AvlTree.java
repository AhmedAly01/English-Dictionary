interface AvlTree {
    public int Getsize();

    public boolean isEmpty();

    public boolean searchNode(int data);

    public int FindMin();

    public int FindMax();

    public void insert(int data);

    public void delete(int data);

    public void inorder();

    public void preorder();

    public void postorder();

}
