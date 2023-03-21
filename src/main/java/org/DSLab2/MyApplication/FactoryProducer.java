package org.DSLab2.MyApplication;

public class FactoryProducer {
    public static AbstractFactory GetDictionaryTreeType(String TreeType){
        if(TreeType.equalsIgnoreCase("AVLDictionary")){
            return new DictionaryAVLType();
        }
        else{
            return new DictionaryRBType();
        }
    }
}
