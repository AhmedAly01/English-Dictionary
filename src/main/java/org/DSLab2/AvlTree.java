interface AvlTree {
    public int Getsize();

    public boolean isEmpty();

    public int balanceFactor(Node node);

    public int height(Node node);

    public Node rotateRight(Node node);

    public Node rotateLeft(Node node);

    public boolean searchNode(int data);

    public boolean search(Node node, int data);

    public int FindMin();

    public int FindMax();

    public Node FindMax(Node node);

    public Node FindMin(Node node);

    public void insert(int data);

    public Node insert(Node node, int data);

    public void delete(int data);

    public Node delete(Node node, int data);

    public void inorder();

    public void inorder(Node node);

    public void preorder();

    public void preorder(Node node);

    public void postorder();

    public void postorder(Node node);
    
}
