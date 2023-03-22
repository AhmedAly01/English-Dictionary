package org.DSLab2;

import org.DSLab2.AVL.AVL_Tree;
import org.DSLab2.MyApplication.AVLType.AVLDictionary;
import org.DSLab2.MyApplication.AVLType.AVLNode;
import org.DSLab2.MyApplication.RBType.RBTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map;

class Pair<T extends Comparable<T>, R extends Comparable<R>>{
    T key;
    R value;

    public Pair(T key, R value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public R getValue() {
        return value;
    }
}

public class AVLTest {

    List<List<Integer>> res = new ArrayList<>();
    void traverse (AVLNode<Integer> root){
        res.clear();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        dfs(root);
    }
    void dfs(AVLNode<Integer> node){
        // preOrder traversal
        if(node == null) return;
        save(node);
        dfs(node.getLeft());
        dfs(node.getRight());
    }
    void save(AVLNode<Integer> node){
        int height = node.getHeight();
        res.get(0).add(node.getData());
        res.get(1).add(height);
    }

    @Test
    public void testHeightForNullTree(){
        AVLDictionary<Integer> tree = new AVLDictionary<Integer>();
        Assertions.assertEquals(0, tree.TreeHeight());
    }

    @Test
    public void testHeightInInsertInEmptyTree() {
        int[] toBeInserted = {6};
        int[] expectedHeight = {1};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
    }

    @Test
    public void testHeightInInsertWithRootOnlyLeft() {
        int[] toBeInserted = {6, 2};
        int[] expectedHeight = {1, 2};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
    }

    @Test
    public void testHeightInInsertWithRootOnlyRight() {
        int[] toBeInserted = {6, 10};
        int[] expectedHeight = {1, 2};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
    }

    @Test
    public void testHeightInInsertLeftLeftWithPivotTheRoot() {
        int[] toBeInserted = {6,4,2};
        int[] expectedHeight = {1, 2, 2};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
    }

    @Test
    public void testHeightInInsertLeftRightWithPivotTheRoot() {
        int[] toBeInserted = {6,2,4};
        int[] expectedHeight = {1, 2, 2};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
    }

    @Test
    public void testHeightInInsertRightRightWithPivotTheRoot() {
        int[] toBeInserted = {6,10,20};
        int[] expectedHeight = {1, 2, 2};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
    }

    @Test
    public void testHeightInInsertRightLeftWithPivotTheRoot() {
        int[] toBeInserted = {6,10,8};
        int[] expectedHeight = {1, 2, 2};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
    }

    @Test
    public void testHeightInInsertLeftLeftWithPivotInternalNode() { //root's right child isn't null
        int[] toBeInserted =   {50,100,20,15,10};
        int[] expectedHeight = {1, 2, 2, 3, 3};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
    }

    @Test
    public void testHeightInInsertLeftRightWithPivotInternalNode() { //root's right child isn't null
        int[] toBeInserted =   {50,100,30,10,15};
        int[] expectedHeight = {1, 2, 2, 3, 3};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
    }

    @Test
    public void testHeightInInsertRightRightWithPivotInternalNode() { //root's right child isn't null
        int[] toBeInserted =   {50,10,100,150,200};
        int[] expectedHeight = {1, 2, 2, 3, 3};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
    }

    @Test
    public void testHeightInInsertRightLeftWithPivotInternalNode() { //root's right child isn't null
        int[] toBeInserted =   {50,10,100,150,125};
        int[] expectedHeight = {1, 2, 2, 3, 3};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
    }

    @Test
    public void testHeightInDeleteLeafNode() { //root's right child isn't null
        int[] toBeInserted =   {50,10,100,150,125};
        int[] expectedHeight = {1, 2, 2, 3, 3};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
        int[] deleteOrder = {100, 150, 10, 125, 50};
        expectedHeight = new int[]{3, 2, 2, 1, 0};
        for (int i=0;i < deleteOrder.length;i++) {
            avl.delete(deleteOrder[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
    }
    @Test
    public void testHeightInDeleteInternalNodeOnlyLeftChild() { //root's right child isn't null
        int[] toBeInserted =   {50,10,100,150};
        int[] expectedHeight = {1, 2, 2, 3, 3};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
        int[] deleteOrder = {100};
        expectedHeight = new int[]{2};
        for (int i=0;i < deleteOrder.length;i++) {
            avl.delete(deleteOrder[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
    }

    @Test
    public void testHeightInDeleteInternalNodeOnlyRightChild() { //root's right child isn't null
        int[] toBeInserted =   {50,10,100,80};
        int[] expectedHeight = {1, 2, 2, 3, 3};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
        int[] deleteOrder = {100};
        expectedHeight = new int[]{2};
        for (int i=0;i < deleteOrder.length;i++) {
            avl.delete(deleteOrder[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
    }

    @Test
    public void testHeightInDeleteInternalNodeWithTwoChildren() { //root's right child isn't null
        int[] toBeInserted =   {50,10,80,100, 60};
        int[] expectedHeight = {1, 2, 2, 3, 3};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
        int[] deleteOrder = {80};
        expectedHeight = new int[]{3};
        for (int i=0;i < deleteOrder.length;i++) {
            avl.delete(deleteOrder[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
    }

    @Test
    public void testHeightInConsecutiveInsertsAndDeletes() { //root's right child isn't null
        int[] toBeInserted =   {20,4,26,3,9,30,21,2,7,11};
        int[] expectedHeight = {1 ,2,2 ,3,3,3 ,3 ,4,4,4};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }


        int[] nums =              {15   , 8     , 20    , 9     ,  11   , 1     , 0};
        expectedHeight = new int[]{4    , 4     , 4     , 4     ,  4    , 4     , 4};
        boolean[] operation =     {true , true  , false , false ,false  , true  , true};//true:insert false:delete
        avl.inorder();
        for (int i=0;i < nums.length;i++) {
            if(operation[i])
                avl.insert(nums[i]);
            else
                avl.delete(nums[i]);

            avl.inorder();
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
    }

    @Test
    public void findTesting(){
        int[] toBeInserted =   {20,4,26,3,9,30,21,2,7,11};
        int[] expectedHeight = {1 ,2,2 ,3,3,3 ,3 ,4,4,4};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }

        List<Pair<Integer, Boolean>> toFind =  new ArrayList<>(Arrays.asList(new Pair<>(15, false) ,new Pair<>(4, true) ,new Pair<>(26, true),new Pair<>(20, true),new Pair<>(100, false),new Pair<>(5, false), new Pair<>(3, true), new Pair<>(0, false),new Pair<>(3, true)));

        for (int i=0;i < toFind.size();i++) {
            Assertions.assertEquals(toFind.get(i).value, avl.searchNode(toFind.get(i).key));
        }
    }

    @Test
    public void insertDublicates(){
        int[] toBeInserted =   {20,4,20,3,9,30,4,3,9,11};
        int[] expectedHeight = {1 ,2,2 ,2,3,3 ,3,3,3,3};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }
    }


    @Test
    public void deleteNonExistent(){
        int[] toBeInserted =   {20,4,26,3,9,30,21,2,7,11};
        int[] expectedHeight = {1 ,2,2 ,3,3,3 ,3 ,4,4,4};
        AVLDictionary<Integer> avl = new AVLDictionary<>();
        for (int i=0;i < toBeInserted.length;i++) {
            avl.insert(toBeInserted[i]);
            Assertions.assertEquals(expectedHeight[i], avl.TreeHeight());
        }

        int nums[] = {100, 50, 500};
        for (int i=0;i < nums.length;i++) {
            avl.delete(nums[i]);
            Assertions.assertEquals(4, avl.TreeHeight());
        }


    }
}
