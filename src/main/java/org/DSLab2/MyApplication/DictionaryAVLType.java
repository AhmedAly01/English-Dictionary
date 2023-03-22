package org.DSLab2.MyApplication;

import org.DSLab2.MyApplication.AVLType.AVLDictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryAVLType extends AbstractFactory{
    AVLDictionary<String> AVL;
    DictionaryAVLType(){
        this.AVL = new AVLDictionary<String>();
    }

    @Override
    public boolean insert(String str) {
        return AVL.insert(str);
    }

    @Override
    public boolean delete(String str) {
        return AVL.delete(str);
    }

    @Override
    public boolean search(String str) {
        return AVL.searchNode(str);
    }

    private int[] BatchExecution(String str,int type){
        int success = 0, fail = 0;
        String[] words = str.split(" ");
        if(type==0) {
            for (String s : words) {
                if (AVL.insert(s)) {
                    success++;
                }
                else {
                    fail++;
                }
            }
        }
        else{
            for (String s : words) {
                if (AVL.delete(s)) {
                    success++;
                }
                else {
                    fail++;
                }
            }
        }
        return new int[]{success, fail};
    }

    @Override
    public int[] BatchInsert(String file) {
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
        return BatchExecution(builder.toString(),0);
    }

    @Override
    public int[] BatchDelete(String file) {
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
        return BatchExecution(builder.toString(),1);
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
