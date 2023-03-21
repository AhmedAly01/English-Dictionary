package org.DSLab2.MyApplication.RBType;

import lombok.Getter;

import static java.lang.Math.max;

@Getter
public class RBTree <T extends Comparable<T>> implements RBTreeIF<T> {
    private RBNode<T> root = null;
    private int size = 0;

    @Override
    public boolean insert(T key) {
        if(root == null ){
            RBNode<T> newNode = new RBNode<T>(key, null, false);
            root = newNode;
            size++;
            return true;
        }
        RBNode<T> newNode = insert(key, root);
        if(newNode == null)
            return false;
        solveInsertion(newNode);
        return true;
    }
    private RBNode<T> insert(T key, RBNode<T> node){
        if(node.getValue().compareTo(key) == 0) {
            return null;
        }
        else if(node.getValue().compareTo(key) > 0){
            if(node.getLeftChild() == null){
                size++;
                RBNode<T> newNode = new RBNode<>(key, node, true);
                node.setLeftChild(newNode);
                newNode.setParent(node);
                return newNode;
            }
            else return insert(key, node.getLeftChild());
        }
        else{
            if(node.getRightChild() == null){
                size++;
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
            // todo check this -- checked
            root = node;
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
        //todo not sure
        if(temp!=null)
            temp.setParent(node.getParent());
        node.getLeftChild().setParent(node);
        if(grandParent!=null){
            if(grandParent.getValue().compareTo(node.getValue())>0) grandParent.setLeftChild(node);
            else grandParent.setRightChild(node);
        }
        else {
            root = node;
            node.setParent(null);
        }
        node.setParent(grandParent);
    }
    private void rightSwap(RBNode<T> node){
        RBNode<T> temp = node.getRightChild();
        RBNode<T> grandParent =  node.getParent().getParent();
        node.setRightChild(node.getParent());
        node.getParent().setLeftChild(temp);
        //todo not sure
        if(temp!=null)
            temp.setParent(node.getParent());
        node.getRightChild().setParent(node);
        if(grandParent != null){
            if(grandParent.getValue().compareTo(node.getValue())>0) grandParent.setLeftChild(node);
            else grandParent.setRightChild(node);
        }
        else {
            root = node;
            node.setParent(null);
        }
        node.setParent(grandParent);
    }
    @Override
    public boolean delete(T key) {
        if(root == null) return false;
        RBNode<T> deletedNode = delete(find(key, root));
//        solveDeletion(deletedNode);
        return deletedNode != null;
    }

    private void solveDeletion(RBNode<T> deletedNode){
        if(deletedNode.isColor()||
                (deletedNode.getRightChild()!=null &&deletedNode.getRightChild().isColor())||
                (deletedNode.getLeftChild()!=null &&deletedNode.getLeftChild().isColor())){
            if(!deletedNode.isColor()){
                // in this case just one of the children is null and the other isn't or both of them are null
                //TODO retest this case
                if(deletedNode.getLeftChild()!=null)
                    deletedNode.getLeftChild().setColor(false);
                if(deletedNode.getRightChild()!=null)
                    deletedNode.getRightChild().setColor(false);
            }
            else if(deletedNode.getRightChild()!=null &&deletedNode.getRightChild().isColor())
                deletedNode.getRightChild().setColor(false);
            else if(deletedNode.getLeftChild()!=null &&deletedNode.getLeftChild().isColor())
                deletedNode.getLeftChild().setColor(false);
        }
        else{
            solveDoubleBlack(deletedNode);
        }
    }
    private void solveDoubleBlack(RBNode<T> dbNode) {
        if(dbNode.getParent()==null)return;
        if(dbNode.isColor()) {
            dbNode.setColor(false);
            return;
        }

        RBNode<T>sibling = getSibling(dbNode);
        if(sibling == null ||(!sibling.isColor()&&(sibling.getRightChild()==null||!sibling.getRightChild().isColor())
                &&(sibling.getLeftChild()==null||!sibling.getLeftChild().isColor()))){
            if(sibling!=null)
                sibling.setColor(true);
            solveDoubleBlack(dbNode.getParent());
        }
        else if(!sibling.isColor()&&((sibling.getRightChild()!=null&&sibling.getRightChild().isColor())
                ||(sibling.getLeftChild()!=null&&sibling.getLeftChild().isColor()))){ // sibling black one of his children red
            if(sibling.getValue().compareTo(sibling.getParent().getValue())>0&& sibling.getRightChild()!=null && sibling.getRightChild().isColor()){
                //rr
                RBNode<T> parent = sibling.getParent();
                if(!parent.isColor())
                    sibling.getRightChild().setColor(false);
                else if(parent.isColor()&&sibling.getLeftChild()!=null&&sibling.getLeftChild().isColor()){
                    sibling.setColor(true);
                    sibling.getParent().setColor(false);
                    sibling.getRightChild().setColor(false);
                }
                leftSwap(sibling);
            }
            else if(sibling.getValue().compareTo(sibling.getParent().getValue())<0&& sibling.getLeftChild()!=null && sibling.getLeftChild().isColor()){
                //ll
                RBNode<T> parent = sibling.getParent();
                if(!parent.isColor())
                    sibling.getLeftChild().setColor(false);
                else if(parent.isColor()&&sibling.getRightChild()!=null&&sibling.getRightChild().isColor()){
                    sibling.setColor(true);
                    sibling.getParent().setColor(false);
                    sibling.getLeftChild().setColor(false);
                }
                rightSwap(sibling);
            }
            else if(sibling.getValue().compareTo(sibling.getParent().getValue())>0&& sibling.getLeftChild()!=null && sibling.getLeftChild().isColor()){
                //rl
                sibling.getLeftChild().setColor(false);
                rightSwap(sibling.getLeftChild());
                // todo not sure
//                leftSwap(dbNode.getRightChild());
                leftSwap(dbNode.getParent().getRightChild());
            }
            else if(sibling.getValue().compareTo(sibling.getParent().getValue())<0&& sibling.getRightChild()!=null && sibling.getRightChild().isColor()){
                //lr
                sibling.getRightChild().setColor(false);
                leftSwap(sibling.getRightChild());
//                rightSwap(dbNode.getLeftChild());
                rightSwap(dbNode.getParent().getLeftChild());
            }
        }
        else if(sibling.isColor()){
            sibling.setColor(false);
            dbNode.getParent().setColor(true);
            if(sibling.getParent().getValue().compareTo(sibling.getValue())>0){//ll case
                rightSwap(sibling);
            }
            else{
                //rr case
                leftSwap(sibling);
            }
//            if(dbNode.getLeftChild()!=null)
//                solveDoubleBlack(dbNode.getLeftChild());//solve(u)
//            else if(dbNode.getRightChild()!=null)
//                solveDoubleBlack(dbNode.getRightChild());
            solveDoubleBlack(dbNode);
        }

    }

    private RBNode<T> delete(RBNode<T> node) {
        if (node == null) return null;
        if (node.getRightChild() == null && node.getLeftChild() == null) {
            size--;
            solveDeletion(node);
            if(node.getParent() == null) {
                root = null;
            }
            // check this case if you are deleting the root and the code enter to this section
            else if (node.getParent().getValue().compareTo(node.getValue()) > 0) node.getParent().setLeftChild(null);
            else node.getParent().setRightChild(null);
        } else if (node.getRightChild() != null && node.getLeftChild() == null) {
            size--;
            solveDeletion(node);
            if (node.getParent() == null) {
                root = node.getRightChild();
                node.getRightChild().setParent(null);
            } else if (node.getParent().getValue().compareTo(node.getValue()) > 0) {
                node.getParent().setLeftChild(node.getRightChild());
                node.getRightChild().setParent(node.getParent());
            } else {
                node.getParent().setRightChild(node.getRightChild());
                node.getRightChild().setParent(node.getParent());
            }
        } else if (node.getRightChild() == null && node.getLeftChild() != null) {
            size--;
            solveDeletion(node);
            if (node.getParent() == null) {
                root = node.getLeftChild();
                node.getLeftChild().setParent(null);
            }
            // todo not sure added else
            else if (node.getParent().getValue().compareTo(node.getValue()) > 0) {
                node.getParent().setLeftChild(node.getLeftChild());
                node.getLeftChild().setParent(node.getParent());
            } else {
                node.getParent().setRightChild(node.getLeftChild());
                node.getLeftChild().setParent(node.getParent());
            }
        } else {
            RBNode<T> successorNode = successor(node);
            T successorVal = successorNode.getValue();
            delete(successorNode);
            node.setValue(successorVal);
        }
//        size--;
        return node;
    }

    private RBNode<T> getSibling(RBNode<T>node){
        if(node.getParent()==null)return null;
        if(node.getValue().compareTo(node.getParent().getValue())>0)return node.getParent().getLeftChild();
        else return node.getParent().getRightChild();
    }

    private RBNode<T> successor(RBNode<T> node) {
        if(node.getLeftChild()!=null){
            return rightTillEnd(node.getLeftChild());
        }
        else if(node.getRightChild()!=null){
            return leftTillEnd(node.getRightChild());
        }
        else return null;
    }
    private RBNode<T> leftTillEnd(RBNode<T> node){
        if(node.getLeftChild()==null)return node;
        else return leftTillEnd(node.getLeftChild());
    }
    private RBNode<T> rightTillEnd(RBNode<T> node){
        if(node.getRightChild()==null)return node;
        else return rightTillEnd(node.getRightChild());
    }

    @Override
    public boolean search(T key) {
        return find(key, root) != null;
    }
    private RBNode<T> find(T key, RBNode<T> node){
        if(node == null)return null;
        if(node.getValue().compareTo(key)==0)return node;
        else if(node.getValue().compareTo(key)>0)return find(key, node.getLeftChild());
        else return find(key, node.getRightChild());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return !(size == 0);
    }

    @Override
    public int height() {
        return getHeight(root);
    }

    private int getHeight(RBNode<T> node) {
        if(node == null)return 0;
        return 1+max(getHeight(node.getLeftChild()),getHeight(node.getRightChild()));
    }

    @Override
    public void inorder() {
        inorder(this.root);
        System.out.println();
    }

    private void inorder(RBNode<T> node) {
        if (node == null) {
            return;
        }
        inorder(node.getLeftChild());
        System.out.print(node.getValue()+ " ");
        inorder(node.getRightChild());
    }

    @Override
    public void preorder() {
        preorder(this.root);
        System.out.println();
    }

    private void preorder(RBNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        preorder(node.getLeftChild());
        preorder(node.getRightChild());
    }

    @Override
    public void postorder() {
        postorder(this.root);
        System.out.println();
    }

    private void postorder(RBNode<T> node) {
        if (node == null) {
            return;
        }
        postorder(node.getLeftChild());
        postorder(node.getRightChild());
        System.out.print(node.getValue() + " ");
    }
}
