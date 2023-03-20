package org.DSLab2.MyApplication;

import org.DSLab2.Interfaces.DictionaryIF;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dictionary implements DictionaryIF {
    AVLDictionary AVL;
    Dictionary(){
        AVL = new AVLDictionary();
    }

    @Override
    public void insert(String str) {
        AVL.insert(str);
    }

    @Override
    public void delete(String str) {
        AVL.delete(str);
    }

    @Override
    public boolean search(String str) {
        boolean temp = AVL.searchNode(str);
        return temp;
    }

    public void BatchExecution(String str,int type){
        String[] words = str.split(" ");
        if(type==0) {
            for (String s : words) {
                AVL.insert(s);
            }
        }
        else{
            for (String s : words) {
                AVL.delete(s);
            }
        }
    }

    @Override
    public void BatchInsert(String file) {
        StringBuilder builder = new StringBuilder();
        try(BufferedReader Buffer = new BufferedReader(new FileReader(file))){
            String str;
            while((str = Buffer.readLine())!= null){
                builder.append(str).append(" ");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        BatchExecution(builder.toString(),0);
    }

    @Override
    public void BatchDelete(String file) {
        StringBuilder builder = new StringBuilder();
        try(BufferedReader Buffer = new BufferedReader(new FileReader(file))){
            String str;
            while((str = Buffer.readLine())!= null){
                builder.append(str).append(" ");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        BatchExecution(builder.toString(),1);
    }

    @Override
    public int Size() {
        return AVL.Getsize();
    }

    @Override
    public int Height() {
        return AVL.TreeHeight();
    }
    @Override
    public void inorder(){
        AVL.inorder();
    }
    @Override
    public void preorder(){
        AVL.preorder();
    }
    @Override
    public void postorder(){
        AVL.postorder();
    }

}
