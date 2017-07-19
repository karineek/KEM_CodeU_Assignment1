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
     *  and run the algorithms via command line
     * 
     * Input:
     * Tree data, path for Q1, path for Q2 first node, path for Q2 second node
     * Path is the letters: T,R,,L,P. Need to start with T
     * T = Get Root
     * P = Get parent
     * L = Get Left
     * R = Get Right
     */
    public static void main(String[] args) 
    {
        if (args.length == 0) /* run tests! */
        {
            run_tests();
            run_tests_Q1();
            run_tests_Q2();
            return;
        }
        /* Else run the code of Q1 and Q2 */
        if (args.length != 4)
        {
            System.out.println("Error: " + args.length 
                    + " parameters only. Expect somthing like: 1,2,3,4,5,6,7, TLL, T, TLL");      
            return;
        }
        
        /* Input tree */
        String[] tree_user = args[0].split(",");
        KemBinaryTree<String> tree = new KemBinaryTree();
        ArrayList<String> arr1 = new ArrayList();
        arr1.addAll(Arrays.asList(tree_user));
        tree.addAll(arr1);
        
        /* Print the input tree */
        System.out.println("The input tree is: ");
        tree.printTree();  
        
        /* Q1 */
        System.out.println("\n** Q1: Run Alg. **");
        KemTreeNode<String> node = getNode(args[1], tree);
        tree.printAncestors(node);
        
        /* Q2 */
        System.out.println("\n** Q2: Run Alg. **");
        KemTreeNode<String> node1 = getNode(args[2], tree);
        KemTreeNode<String> node2 = getNode(args[3], tree);
        System.out.println("Common is: " + tree.getLowestCommonAncestors(node1, node2).getData());
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

    static private KemTreeNode<String> getNode(String path, KemBinaryTree<String> tree)
    {
        KemTreeNode<String> node=null;
        if (path.length() > 0)
        {
            if (path.charAt(0) != 'T')
            {
                System.err.println("Any path shall start in root!. Return null node.");
                return null;
            }   
                
            for (int i = 0; i < path.length(); i ++)
            {
                if (path.charAt(i) == 'L')
                {
                    node = node.getLeft();
                }
                else if (path.charAt(i) == 'R')
                {
                    node = node.getRight();
                } 
                else if (path.charAt(i) == 'P')
                {
                    node = node.getParent();
                }
                else if (path.charAt(i) == 'T')
                {
                    node = tree.getRoot();
                } 
                /* ELSE: ignore */
            }
        }
        
        return node;
    }
}
