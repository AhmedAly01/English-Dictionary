package org.DSLab2.MyApplication;

import org.DSLab2.MyApplication.RBType.RBTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryRBType extends AbstractFactory{
    RBTree<String> RB ;
    DictionaryRBType(){
        RB = new RBTree<>();
    }
    @Override
    boolean insert(String str) {
        return RB.insert(str);
    }

    @Override
    boolean delete(String str) {
        return RB.delete(str);
    }

    @Override
    boolean search(String key) {
        return RB.search(key);
    }

    private void BatchExecution(String str, int type) {
        String[] words = str.split(" ");
        if(type==0) {
            for (String s : words) {
                RB.insert(s);
            }
        }
        else{
            for (String s : words) {
                RB.delete(s);
            }
        }
    }

    @Override
    void BatchInsert(String file) {
        StringBuilder builder = new StringBuilder();
        try(BufferedReader Buffer = new BufferedReader(new FileReader(file))){
            String str;
            while((str = Buffer.readLine())!=null){
                builder.append(str);
                builder.append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BatchExecution(builder.toString(),0);
    }

    @Override
    void BatchDelete(String file) {
        StringBuilder builder=new StringBuilder();
        try (BufferedReader Buffer=new BufferedReader(new FileReader(file))){
            String str;
            while((str = Buffer.readLine())!=null){
                builder.append(str).append(" ");
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        BatchExecution(builder.toString(),1);
    }

    @Override
    int Size() {
        return RB.size();
    }

    @Override
    int Height() {
        return RB.height();
    }

    @Override
    void inorder() {
        RB.inorder();
    }

    @Override
    void preorder() {
        RB.preorder();
    }

    @Override
    void postorder() {
        RB.postorder();
    }
}
