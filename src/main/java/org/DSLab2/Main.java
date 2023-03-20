package org.DSLab2;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        AVLTree<String> tree = new AVLTree<>();
//        BSTree<String> BST = new BSTree<>();// create a new binary tree
//        BST.insert("10");
//        BST.insert("5");
//        BST.insert("15");
//        BST.insert("3");
//        BST.insert("7");
//        BST.insert("12");
//        BST.insert("18");
//
//        tree.insert("a");
//        tree.insert("d");
//        tree.insert("v");
//        tree.insert("c");
//        tree.insert("w");
//        tree.insert("o");
//        tree.insert("k");
//
//        System.out.println();
//        BST.preOrder();
//        System.out.println();
//        System.out.println(BST.height());
//        System.out.println(BST.search("10"));
//        System.out.println(BST.search("5"));
//        System.out.println(BST.search("8"));
//        System.out.println(BST.size());
//
//        System.out.println();
//        tree.preOrder();
//        System.out.println();
//        System.out.println(tree.height());
//        System.out.println(tree.search("a"));
//        System.out.println(tree.search("k"));
//        System.out.println(tree.search("z"));
//        System.out.println(tree.size());
        RBTree<String> rbTree = new RBTree<>();
        String[] input = {
                "grzwv",
                "eyehz",
                "nfhvq",
                "dnzha",
                "qympj",
                "dwxmq",
                "vymvf",
                "ojksu",
                "sbrdr",
                "cvmxo",
                "elutw",
                "fvwjt",
                "ckjwi",
                "bvcst",
                "qmjha",
                "aqtpx",
                "mawzv",
                "ckyjs",
                "cnuiz",
                "pfxdc",
                "clzlx",
                "xplvl",
                "xncif",
                "xjxox",
                "bofos",
                "yvbsv",
                "yskka",
                "kzycd",
                "phdtl",
                "bndkn",
                "oojmu",
                "emepc",
                "seksu",
                "nztuw",
                "hbbcl",
                "rlbuk",
                "tkbow",
                "aazsu",
                "ednmo",
                "qrsqg",
                "fsfri",
                "sbmyn",
                "wpkwc",
                "dyjkr",
                "tlgog",
                "pqcyi",
                "mdifm",
                "icxdl",
                "cmtam",
                "elvha",
                "bqbfe",
                "oxwpg",
                "gkxuy",
                "prnyr",
                "ruzhk",
                "ekhfm",
                "slgrl",
                "lhudk",
                "ktwqk",
                "qbekd",
                "tzwdr",
                "tjykf",
                "xubtb",
                "lqvnm",
                "gbmfb",
                "mdxxg",
                "nolrv",
                "kqeze",
                "reycr",
                "xxrbb",
                "hoyuc",
                "wwyjt",
                "vzweh",
                "dgqmr",
                "ugqfz",
                "omvao",
                "kotxn",
                "hckyk",
                "xqpzj",
                "asvpl",
                "kbzrt",
                "kwiam",
                "ozdqq",
                "rtthb",
                "kmjlx",
                "cgaqg",
                "qwmsp",
                "pgzvy",
                "djuif",
                "dvzjw",
                "hhwkt",
                "ebfxz",
                "shyln",
                "kyekd",
                "txvho",
                "wezjf",
                "lqlfa",
                "tzinw",
                "wvool",
                "xjuvd",
                "pijox",
                "ylpzk",
                "qzpzo",
                "grtbm",
                "fpwdm",
                "sjrfw",
                "gdxce",
                "pqyll",
                "yyslv",
                "gqndx",
                "zqiaq",
                "qnjip",
                "scbxn",
                "kkiak",
                "thwtt",
                "lbyov",
                "yjktc",
                "mnvgl",
                "nwgaz",
                "bmupd",
                "epphq",
                "fhkik",
                "wagki",
                "zwobh",
                "ttquh",
                "dzluj",
                "dttch",
                "jmuyu",
                "ggzbg",
                "fjbjg",
                "wxlgs",
                "pxydt",
                "jozqi",
                "fvurs",
                "rgjdj",
                "rjsug",
                "vwotq",
                "tfxvy",
                "qwdjl",
                "kkfln",
                "tqcez",
                "whvax",
                "bohfu",
                "ftgvl",
                "fcgwj",
                "bmylh",
                "woxmc",
                "hfszi",
                "lgfji",
                "htjic",
                "cdtet",
                "gmczr",
                "lpjfe",
                "cqwto",
                "dwdaa",
                "pzopk",
                "owmgl",
                "rmvqo",
                "buoli",
                "zsczo",
                "mdkyy",
                "dmsad",
                "hwyvx",
                "yzsiv",
                "xnvcj",
                "fxdci",
                "xtjvc",
                "udaiy",
                "jtyod",
                "kjwvu",
                "sxkxj",
                "fnxdk",
                "olbrf",
                "kzbbv",
                "evkzu",
                "zjhyh",
                "juftw",
                "yikbn",
                "jntks",
                "szecp",
                "kqgyv",
                "nhznl",
                "khksc",
                "gwiup",
                "nrbrw"
        };
        for (int i = 0; i < input.length; i++) {
            rbTree.insert(input[i]);
        }
        shuffleArray(input);
        for(int i=0;i< input.length;i++){
            rbTree.delete(input[i]);
        }
        System.out.println(rbTree.size());
    }
    private static void shuffleArray(String[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            // Swap the elements at i and index
            String temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }
}

