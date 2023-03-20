package org.DSLab2.Interfaces;

import java.io.File;

public interface DictionaryIF {
    public void insert(String str);
    public void delete(String str);
    public boolean search(String str);
    public void BatchInsert(String file);
    public void BatchDelete(String file);
    public int Size();
    public int Height();
    public void inorder();
    public void preorder();
    public void postorder();
}