package codeu_assignement_2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Karine
 */
public class main {
    /**
     * @param args the command line arguments
     * 
     * Gives a basic interface to do some partial testing to the code
     * 
     */
    public static void main(String[] args) 
    {
        run_tests();
        run_tests_Q1();
        run_tests_Q2();
        
    }
        
    private static void run_tests()
    {
        /* Test Tree! */
        System.out.println("** General Tests for Tree DS **");
        KemBinaryTree<Integer> t1 = new KemBinaryTree();
        Integer[] temp = {1,2,3,4,5,6,7,8};
        ArrayList<Integer> arr1 = new ArrayList();
        arr1.addAll(Arrays.asList(temp));
        
        t1.addAll(arr1);
        t1.printTree();
        
        System.out.println("Right Right Right exist? " + t1.exist(t1.getRoot().getRight().getRight().getRight()));
        System.out.println("Right Left Left exist? " + t1.exist(t1.getRoot().getRight().getLeft().getLeft()));
        
        t1.addAt(t1.getRoot().getRight(), 9, true, true);
        t1.addAt(t1.getRoot().getRight(), 0, false, true);
        t1.printTree();
        
        System.out.println("Right Right exist? " + t1.exist(t1.getRoot().getRight().getRight()));
        System.out.println("Right Left exist? " + t1.exist(t1.getRoot().getRight().getLeft()));
        System.out.println("Right Right Right exist? " + t1.exist(t1.getRoot().getRight().getRight().getRight()));
        System.out.println("Right Left Left exist? " + t1.exist(t1.getRoot().getRight().getLeft().getLeft()));
    }

    private static void run_tests_Q1()
    {
        System.out.println("\n** Q1: Tests for Alg. **");
        
        /* Create tree for testing */
        KemBinaryTree<Integer> t1 = new KemBinaryTree();
        Integer[] temp = {1,2,3,4,5,6,7,8,9,0,1,2,3,4,5};
        ArrayList<Integer> arr1 = new ArrayList();
        arr1.addAll(Arrays.asList(temp));
        
        t1.addAll(arr1);
        t1.printTree();  
        
        t1.printAncestors(t1.getRoot().getLeft().getLeft().getLeft());
        t1.printAncestors(t1.getRoot().getLeft().getLeft().getRight());
        t1.printAncestors(t1.getRoot().getLeft().getRight().getRight());
        t1.printAncestors(t1.getRoot().getRight().getRight().getRight());
        t1.printAncestors(t1.getRoot());
        t1.printAncestors(t1.getRoot().getRight().getRight().getRight().getRight());
    }

    private static void run_tests_Q2()
    {
        System.out.println("\n** Q2: Tests for Alg. **");
        
        /* Create tree for testing */
        KemBinaryTree<Integer> t1 = new KemBinaryTree();
        Integer[] temp = {1,2,3,4,5,6,7,8,9,0,1,2,3,4,5};
        ArrayList<Integer> arr1 = new ArrayList();
        arr1.addAll(Arrays.asList(temp));
        
        t1.addAll(arr1);
        t1.printTree();
        
        System.out.println("Common is: " + t1.getLowestCommonAncestors(t1.getRoot(), t1.getRoot()).getData());
        System.out.println("Common is: " + t1.getLowestCommonAncestors(t1.getRoot(), t1.getRoot().getLeft()).getData());
        System.out.println("Common is: " + t1.getLowestCommonAncestors(t1.getRoot().getRight(), t1.getRoot()).getData());
        System.out.println("Common is: " + t1.getLowestCommonAncestors(t1.getRoot().getRight(), t1.getRoot().getRight()).getData());
        System.out.println("Common is: " + t1.getLowestCommonAncestors(t1.getRoot().getRight(), t1.getRoot().getRight().getLeft().getRight().getLeft()));
        System.out.println("Common is: " + t1.getLowestCommonAncestors(t1.getRoot().getRight(), t1.getRoot().getLeft()).getData());
        System.out.println("Common is: " + t1.getLowestCommonAncestors(t1.getRoot().getLeft().getRight().getLeft(), t1.getRoot().getLeft().getLeft().getLeft()).getData());
    }    
}
