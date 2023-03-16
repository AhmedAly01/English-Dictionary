public class RBTree <T extends Comparable<T>> implements RBTreeIF<T> {
    private RBNode<T> root = null;
    private int size = 0;

    @Override
    public RBNode<T> insert(T key) {
        if(root == null ){
            RBNode<T> newNode = new RBNode<T>(key, null, false);
            root = newNode;
            return newNode;
        }
        RBNode<T> newNode = insert(key, root);
        if(newNode != null) solveInsertion(newNode);
        return newNode;
    }
    private RBNode<T> insert(T key, RBNode<T> node){
        if(node.getValue().compareTo(key) == 0) return null;
        else if(node.getValue().compareTo(key) > 0){
            if(node.getLeftChild() == null){
                RBNode<T> newNode = new RBNode<>(key, node, true);
                node.setLeftChild(newNode);
                newNode.setParent(node);
                return newNode;
            }
            else return insert(key, node.getLeftChild());
        }
        else{
            if(node.getRightChild() == null){
                RBNode<T> newNode = new RBNode<>(key, node, true);
                node.setRightChild(newNode);
                newNode.setParent(node);
                return newNode;
            }
            else return insert(key, node.getRightChild());
        }
    }

    private void solveInsertion(RBNode<T> node){
        if(node == null)return;
        RBNode<T> parentNode = node.getParent();
        if(parentNode == null) {
            node.setColor(false);
            return;
        }
        RBNode<T> grandparentNode = parentNode.getParent();
        RBNode<T> uncle = null;
        if(grandparentNode!=null){
            if(parentNode.getValue().compareTo(grandparentNode.getValue())>0) uncle = grandparentNode.getLeftChild();
            else uncle = grandparentNode.getRightChild();
        }

        if(!parentNode.isColor())return;// if the parent is black
        // while solving if the grand is the root
        // if parent red , uncle is red -> parent and uncle back grand red and solve grand
        else if(parentNode.isColor()&& (uncle != null &&uncle.isColor())){
            uncle.setColor(false);
            parentNode.setColor(false);
            grandparentNode.setColor(true);
            solveInsertion(grandparentNode);
        }
        //if parent red and uncle black -> rotate and recolor
        else if(parentNode.isColor() && (uncle == null || !uncle.isColor())){
            if(node.getValue().compareTo(parentNode.getValue())<0 &&
                    parentNode.getValue().compareTo(grandparentNode.getValue())<0){
                // ll
                parentNode.setColor(false);
                grandparentNode.setColor(true);
                rightSwap(parentNode);
            }
            else if(node.getValue().compareTo(parentNode.getValue())>0 &&
                    parentNode.getValue().compareTo(grandparentNode.getValue())>0){
                //rr
                parentNode.setColor(false);
                grandparentNode.setColor(true);
                leftSwap(parentNode);
            }
            else if(node.getValue().compareTo(parentNode.getValue())<0 &&
                    parentNode.getValue().compareTo(grandparentNode.getValue())>0){
                //rl
                node.setColor(false);
                grandparentNode.setColor(true);
                rightSwap(node);
                leftSwap(node);
            }
            else if(node.getValue().compareTo(parentNode.getValue())>0 &&
                    parentNode.getValue().compareTo(grandparentNode.getValue())<0){
                //lr
                node.setColor(false);
                grandparentNode.setColor(true);
                leftSwap(node);
                rightSwap(node);

            }
        }
    }
    private void leftSwap(RBNode<T> node){
        RBNode<T> temp = node.getLeftChild();
        RBNode<T> grandParent =  node.getParent().getParent();
        node.setLeftChild(node.getParent());
        node.getParent().setRightChild(temp);
        node.getLeftChild().setParent(node);
        if(grandParent!=null){
            if(grandParent.getValue().compareTo(node.getValue())>0) grandParent.setLeftChild(node);
            else grandParent.setRightChild(node);
        }
        else root = node;
        node.setParent(grandParent);
    }
    private void rightSwap(RBNode<T> node){
        RBNode<T> temp = node.getRightChild();
        RBNode<T> grandParent =  node.getParent().getParent();
        node.setRightChild(node.getParent());
        node.getParent().setLeftChild(temp);
        node.getRightChild().setParent(node);
        if(grandParent != null){
            if(grandParent.getValue().compareTo(node.getValue())>0) grandParent.setLeftChild(node);
            else grandParent.setRightChild(node);
        }
        else root = node;
        node.setParent(grandParent);
    }
    @Override
    public RBNode<T> delete(T key) {
        return null;
    }

    @Override
    public RBNode<T> find(T key) {
        return find(key, root);
    }
    private RBNode<T> find(T key, RBNode<T> node){
        if(node.getValue().compareTo(key)==0)return node;
        // TODO check this case
        else if(node == null)return null;
        else if(node.getValue().compareTo(key)>0)return find(key, node.getLeftChild());
        else return find(key, node.getRightChild());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        return 0;
    }
}
