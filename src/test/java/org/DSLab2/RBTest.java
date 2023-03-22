package org.DSLab2;

import org.DSLab2.MyApplication.RBType.RBNode;
import org.DSLab2.MyApplication.RBType.RBTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RBTest {
    // these methods to help in assertion
    List<List<Integer>> res = new ArrayList<>();
    void traverse (RBNode<Integer> root){
        res.clear();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        dfs(root);
    }
    void dfs(RBNode<Integer> node){
        // preOrder traversal
        if(node == null) return;
        save(node);
        dfs(node.getLeftChild());
        dfs(node.getRightChild());
    }
    void save(RBNode<Integer> node){
        int color = node.isColor()?1:0;// 1-> red, 0->black
        res.get(0).add(node.getValue());
        res.get(1).add(color);
    }
    // testing insertion

    @Test
    public void test() { // check the root always is black
        int[] toBeInserted = {85, 137, 167, 96, 97, 12, 98, 48, 94, 25, 160, 130, 73, 59, 142, 155, 82, 188, 5, 81,};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        Assertions.assertEquals(toBeInserted.length,rbt.size());
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(
                Arrays.asList(96,73,48,12,5,25,59,85,82,81,94,137,98,97,130,160,142,155,167,188)
                ,Arrays.asList(0,0,1,0,1,1,0,1,0,1,0,0,0,1,1,1,0,1,0,1));
        Assertions.assertEquals(res, correct);
    }

    @Test
    public void insertTheBlackRoot() { // check the root always is black
        int[] toBeInserted = {1};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(List.of(1), List.of(0));
        Assertions.assertEquals(res, correct);
    }

    @Test
    public void insertWithBlackParent() { // add a node to a parent black nothing to do
        int[] toBeInserted = {1,2};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(1,2),Arrays.asList(0, 1));
        Assertions.assertEquals(res, correct);
    }

    @Test
    public void insertWithUncleAndParentRed() {
        int[] toBeInserted = {5,3,6,2};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(5,3,2,6),Arrays.asList(0,0,1,0));
        Assertions.assertEquals(res, correct);
    }

    @Test
    public void insertWithParentRUncleB1() {//ll rotate
        int[] toBeInserted = {5,3,6,2,1};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(5,2,1,3,6),Arrays.asList(0,0,1,1,0));
        Assertions.assertEquals(res, correct);
    }

    @Test
    public void insertWithParentRUncleB2() {// rr rotate
        int[] toBeInserted = {5,3,6,2,1,4};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(5,2,1,3,4,6),Arrays.asList(0,1,0,0,1,0));
        Assertions.assertEquals(res, correct);
    }

    @Test
    public void insertWithParentRUncleB3() {// rl rotate
        int[] toBeInserted = {10,3,13,7,2,1,9,8};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(10,3,2,1,8,7,9,13),Arrays.asList(0,1,0,1,0,1,1,0));
        Assertions.assertEquals(res, correct);
    }
    @Test
    public void testInsertion1() {
        int[] toBeInserted = {1,2,3,4,5};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(2,1,4,3,5),Arrays.asList(0,0,0,1,1));
        Assertions.assertEquals(res, correct);
    }

    @Test
    public void testInsertion2() {
        int[] toBeInserted = {41, 38, 31, 12, 19, 8};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(38,19,12,8,31,41),Arrays.asList(0,1,0,1,0,0));
        Assertions.assertEquals(res, correct);
    }

    @Test
    public void testInsertDuplicate() {
        int[] toBeInserted = {41, 38, 31, 12, 12, 19, 8, 19};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(38,19,12,8,31,41),Arrays.asList(0,1,0,1,0,0));
        Assertions.assertEquals(res, correct);
    }
    // testing size after insertion and deletion
    //insertion size
    @Test
    public void testInsertionSize() {
        int[] toBeInserted = {1,2,3,4,5};
        Set<Integer> unique = new HashSet<>();
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
            unique.add(j);
        }
        int expected = unique.size();
        int actual = rbt.size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSizeWithDuplicates() {
        int[] toBeInserted = {41, 38, 31, 12, 12, 19, 8, 19};
        Set<Integer> unique = new HashSet<>();
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
            unique.add(j);
        }
        int expected = unique.size();
        int actual = rbt.size();
        Assertions.assertEquals(expected, actual);
    }
    //deletion size
    @Test
    public void testSizeDelete() {
        int[] toBeInserted = {1,2,3,4};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        rbt.delete(2);
        int expected = toBeInserted.length-1;
        int actual = rbt.size();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testSizeDeleteNull() {
        int[] toBeInserted = {1,2,3,4};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        rbt.delete(100);
        int expected = toBeInserted.length;
        int actual = rbt.size();
        Assertions.assertEquals(expected, actual);
    }

    // test deletion
    @Test
    public void deleteEasyCase1() {// delete leaf red node
        int[] toBeInserted = {10,3,13,7,2,1,9,8};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        rbt.delete(7);
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(10,3,2,1,8,9,13),Arrays.asList(0,1,0,1,0,1,0));
        Assertions.assertEquals(res, correct);
    }
    @Test
    public void deleteEasyCase2() {// delete internal red node
        int[] toBeInserted = {10,3,13,7,2,1,9,8};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        rbt.delete(3);
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(10,2,1,8,7,9,13),Arrays.asList(0,1,0,0,1,1,0));
        Assertions.assertEquals(correct, res);
    }
    @Test
    public void deleteHardCase1() {// delete internal red node
        int[] toBeInserted = {1,2,3,0};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        rbt.delete(0);
        rbt.delete(1);
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(2,3),Arrays.asList(0,1));
        Assertions.assertEquals(correct, res);
    }

    @Test
    public void deleteHardCase2() {// delete internal red node case sibling child is red lr
        int[] toBeInserted = {1,6,10,0,7};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        rbt.delete(0);
        rbt.delete(7);
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(6,1,10),Arrays.asList(0,0,0));
        Assertions.assertEquals(correct, res);
    }
    @Test
    public void deleteHardCase3() {// delete internal red node case sibling child is red rr
        int[] toBeInserted = {41, 38, 31, 12, 19, 8};
        int[] delete = {8,12,19,31,38};
        List<List<List<Integer>>> corrects = Arrays.asList(
                Arrays.asList(Arrays.asList(38,19,12,31,41),Arrays.asList(0,1,0,0,0)),
                Arrays.asList(Arrays.asList(38,19,31,41),Arrays.asList(0,0,1,0)),
                Arrays.asList(Arrays.asList(38,31,41),Arrays.asList(0,0,0)),
                Arrays.asList(Arrays.asList(38,41),Arrays.asList(0,1)),
                Arrays.asList(List.of(41), List.of(0)));
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        for(int i=0;i<delete.length;i++){
            rbt.delete(delete[i]);
            traverse(rbt.getRoot());
            Assertions.assertEquals(corrects.get(i), res);
        }
    }

    @Test
    public void deleteHardCase4() {// delete internal with sibling red and none of his children are red
        int[] toBeInserted = {10,8,15,3};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        rbt.delete(3);
        rbt.insert(13);
        rbt.insert(16);
        rbt.insert(20);
        rbt.delete(20);
        rbt.delete(8);
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(15,10,13,16),Arrays.asList(0,0,1,0));
        Assertions.assertEquals(correct, res);
    }
    @Test
    public void deleteHardCase5() {// delete internal red node case sibling child is red lr
        int[] toBeInserted = {1,6,10,0,7};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        rbt.delete(0);
        rbt.delete(7);
        rbt.delete(100);
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(6,1,10),Arrays.asList(0,0,0));
        Assertions.assertEquals(correct, res);
    }

    @Test
    public void deletionWithRedAlpha() {// delete internal red node case sibling child is red lr
        int[] toBeInserted = {150,100,200,50,120,130,110};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        rbt.delete(50);
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(150,120,100,110,130,200),Arrays.asList(0,1,0,1,0,0));
        Assertions.assertEquals(correct, res);
    }
    // test Height
    @Test
    public void testHeightForNullTree() {// check the height of null tree
        RBTree<Integer> rbt = new RBTree<>();
        Assertions.assertEquals(0, rbt.height());
    }
    @Test
    public void testHeight() {// delete internal red node case sibling child is red lr
        int[] toBeInserted = {1,2,3,4,5,6};
        RBTree<Integer> rbt = new RBTree<>();
        for (int j : toBeInserted) {
            rbt.insert(j);
        }
        Assertions.assertEquals(4, rbt.height());
    }

}
