import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        RBTree<Integer> rbTree = new RBTree<>();
        int n = scn.nextInt();
        for(int i=0;i<n;i++){
            rbTree.insert(scn.nextInt());
        }
    }
}
