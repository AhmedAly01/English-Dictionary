package org.DSLab2.MyApplication;

public class FactoryProducer {
    public static AbstractFactory GetDictionaryTreeType(String TreeType){
        if(TreeType.equalsIgnoreCase("AVL")){
            return new DictionaryAVLType();
        }
        else if(TreeType.equalsIgnoreCase("Red Black")) {
            return new DictionaryRBType();
        }
        else {
            return null;
        }
    }
}
