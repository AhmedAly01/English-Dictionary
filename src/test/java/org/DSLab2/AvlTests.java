package org.DSLab2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AvlTests {
    private AVLTree avl;

    void setUp() {
        avl = new AVLTree();
    }

    @Test
    void testISEmpty() {
        setUp();
        Assertions.assertTrue(avl.isEmpty());
        avl.insert(1);
        avl.insert(3);
        Assertions.assertFalse(avl.isEmpty());
        avl.delete(1);
        Assertions.assertFalse(avl.isEmpty());
        avl.delete(3);
        Assertions.assertTrue(avl.isEmpty());
    }

    @Test
    void TestSize() {
        setUp();
        Assertions.assertEquals(0, avl.size());
        avl.insert(1);
        avl.insert(3);
        Assertions.assertEquals(2, avl.size());
        avl.delete(1);
        Assertions.assertEquals(1, avl.size());
        avl.delete(3);
        Assertions.assertEquals(0, avl.size());
    }

    @Test
    void TestSearch() {
        setUp();
        avl.insert("1");
        avl.insert("3");
        Assertions.assertTrue(avl.search("1"));
        Assertions.assertTrue(avl.search("3"));
        Assertions.assertFalse(avl.search("2"));
        Assertions.assertFalse(avl.search("4"));
        Assertions.assertFalse(avl.search("0"));
        avl.delete("1");
        Assertions.assertFalse(avl.search("1"));
        Assertions.assertTrue(avl.search("3"));
    }

    @Test
    void TestFindMin() {
        setUp();
        avl.insert(11);
        avl.insert(3);
        avl.insert(10);
        avl.insert(5);
        avl.insert(7);
        avl.insert(8);
        avl.insert(9);
        avl.insert(6);
        avl.insert(4);
        avl.insert(2);
        Assertions.assertEquals(2, avl.FindMin());
        avl.delete(2);
        Assertions.assertEquals(3, avl.FindMin());
        avl.delete(3);
        Assertions.assertEquals(4, avl.FindMin());
        avl.delete(4);
        Assertions.assertEquals(5, avl.FindMin());
        avl.delete(5);
        Assertions.assertEquals(6, avl.FindMin());
        avl.delete(6);
        Assertions.assertEquals(7, avl.FindMin());
        avl.delete(7);
        Assertions.assertEquals(8, avl.FindMin());
        avl.delete(8);
        Assertions.assertEquals(9, avl.FindMin());
        avl.delete(9);
        Assertions.assertEquals(10, avl.FindMin());
        avl.delete(10);
        Assertions.assertEquals(11, avl.FindMin());
        avl.delete(11);
        Assertions.assertFalse(avl.isEmpty());
        Assertions.assertEquals(-1, avl.FindMin());
    }

    @Test
    void TestFindMax() {
        setUp();
        avl.insert(11);
        avl.insert(3);
        avl.insert(10);
        avl.insert(5);
        avl.insert(7);
        avl.insert(8);
        avl.insert(9);
        avl.insert(6);
        avl.insert(4);
        avl.insert(2);
        Assertions.assertEquals(11, avl.FindMax());
        avl.delete(11);
        Assertions.assertEquals(10, avl.FindMax());
        avl.delete(10);
        Assertions.assertEquals(9, avl.FindMax());
        avl.delete(9);
        Assertions.assertEquals(8, avl.FindMax());
        avl.delete(8);
        Assertions.assertEquals(7, avl.FindMax());
        avl.delete(7);
        Assertions.assertEquals(6, avl.FindMax());
        avl.delete(6);
        Assertions.assertEquals(5, avl.FindMax());
        avl.delete(5);
        Assertions.assertEquals(4, avl.FindMax());
        avl.delete(4);
        Assertions.assertEquals(3, avl.FindMax());
        avl.delete(3);
        Assertions.assertEquals(2, avl.FindMax());
        avl.delete(2);
        Assertions.assertFalse(avl.isEmpty());
        Assertions.assertEquals(-1, avl.FindMax());
    }

    @Test
    void testSearchNode() {
        setUp();
        Assertions.assertFalse(avl.searchNode(5));
        avl.insert(5);
        Assertions.assertTrue(avl.searchNode(5));
        Assertions.assertFalse(avl.searchNode(3));
        avl.insert(3);
        Assertions.assertTrue(avl.searchNode(3));
    }

    @Test
    void testInsert() {
        setUp();
        Assertions.assertTrue(avl.isEmpty());
        avl.insert(5);
        Assertions.assertFalse(avl.isEmpty());
        Assertions.assertEquals(1, avl.size());
        avl.insert(3);
        Assertions.assertEquals(2, avl.size());
        avl.insert(7);
        Assertions.assertEquals(3, avl.size());
        avl.insert(1);
        Assertions.assertEquals(4, avl.size());
        avl.insert(4);
        Assertions.assertEquals(5, avl.size());
        avl.insert(6);
        Assertions.assertEquals(6, avl.size());
        avl.insert(8);
    }

    @Test
    void testDelete() {
        setUp();
        Assertions.assertTrue(avl.isEmpty());
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(1);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        Assertions.assertEquals(7, avl.size());
        avl.delete(5);
        Assertions.assertEquals(6, avl.size());
        avl.delete(3);
        Assertions.assertEquals(5, avl.size());
        avl.delete(7);
        Assertions.assertEquals(4, avl.size());
        avl.delete(1);
        Assertions.assertEquals(3, avl.size());
        avl.delete(4);
        Assertions.assertEquals(2, avl.size());
        avl.delete(6);
        Assertions.assertEquals(1, avl.size());
        avl.delete(8);
        Assertions.assertEquals(0, avl.size());
    }
}
