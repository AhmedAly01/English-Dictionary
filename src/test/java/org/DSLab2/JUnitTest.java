package org.DSLab2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JUnitTest {
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
    public void testInsertion1() {
        int[] nums = {1,2,3,4,5};
        RBTree<Integer> rbt = new RBTree<>();
        for(int i=0;i<nums.length;i++){
            rbt.insert(nums[i]);
        }
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(2,1,4,3,5),Arrays.asList(0,0,0,1,1));
        Assertions.assertEquals(res, correct);
    }

    @Test
    public void testInsertion2() {
        int[] nums = {41, 38, 31, 12, 19, 8};
        RBTree<Integer> rbt = new RBTree<>();
        for(int i=0;i<nums.length;i++){
            rbt.insert(nums[i]);
        }
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(38,19,12,8,31,41),Arrays.asList(0,1,0,1,0,0));
        Assertions.assertEquals(res, correct);
    }

    @Test
    public void testInsertDuplicate() {
        int[] nums = {41, 38, 31, 12, 12, 19, 8, 19};
        RBTree<Integer> rbt = new RBTree<>();
        for(int i=0;i<nums.length;i++){
            rbt.insert(nums[i]);
        }
        traverse(rbt.getRoot());
        List<List<Integer>> correct = Arrays.asList(Arrays.asList(38,19,12,8,31,41),Arrays.asList(0,1,0,1,0,0));
        Assertions.assertEquals(res, correct);
    }
    // testing size after insertion and deletion
    @Test
    public void testInsertionSize() {
        int[] nums = {1,2,3,4,5};
        Set<Integer> unique = new HashSet<>();
        RBTree<Integer> rbt = new RBTree<>();
        for(int i=0;i<nums.length;i++){
            rbt.insert(nums[i]);
            unique.add(nums[i]);
        }
        int expected = unique.size();
        int actual = rbt.size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSizeWithDuplicates() {
        int[] nums = {41, 38, 31, 12, 12, 19, 8, 19};
        Set<Integer> unique = new HashSet<>();
        RBTree<Integer> rbt = new RBTree<>();
        for(int i=0;i<nums.length;i++){
            rbt.insert(nums[i]);
            unique.add(nums[i]);
        }
        int expected = unique.size();
        int actual = rbt.size();
        Assertions.assertEquals(expected, actual);
    }

}
