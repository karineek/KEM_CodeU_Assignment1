package codeu_assignement_2;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karine
 */
public class KemBinaryTreeTest {
    
    public KemBinaryTreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of isEmpty method, of class KemBinaryTree.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        KemBinaryTree instance = new KemBinaryTree();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals("New tree shall be empty", expResult, result);
    }

    /**
     * Test of getRoot method, of class KemBinaryTree.
     */
    @Test
    public void testGetRoot() {
        System.out.println("getRoot");
        KemBinaryTree instance = new KemBinaryTree();
        KemTreeNode expResult = null;
        KemTreeNode result = instance.getRoot();
        assertEquals("Empty tree doesn't have null root.", expResult, result);
    }

    /**
     * Test of printAncestors method, of class KemBinaryTree.
     */
    @Test
    public void testPrintAncestors() {
        System.out.println("printAncestors");
        KemTreeNode child = null;
        KemBinaryTree instance = new KemBinaryTree();
        instance.printAncestors(child);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLowestCommonAncestors method, of class KemBinaryTree.
     */
    @Test
    public void testGetLowestCommonAncestors() {
        System.out.println("getLowestCommonAncestors");
        KemTreeNode child1 = null;
        KemTreeNode child2 = null;
        KemBinaryTree instance = new KemBinaryTree();
        KemTreeNode expResult = null;
        KemTreeNode result = instance.getLowestCommonAncestors(child1, child2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exist method, of class KemBinaryTree.
     */
    @Test
    public void testExist() {
        System.out.println("exist");
        KemBinaryTree<Integer> instance = new KemBinaryTree();
        Integer data = 5;
        KemTreeNode<Integer> n = new KemTreeNode<>(data,null,null,null);
        instance.addAt(null, data, true, true);
        boolean expResult = true;
        boolean result = instance.exist(n);
        assertEquals("Node is added to the tree, thus exist is trues.", expResult, result);
    }
    
    /**
     * Test of exist method, of class KemBinaryTree.
     */
    @Test
    public void testInEmptyTreeExist() {
        System.out.println("exist");
        KemTreeNode n = null;
        KemBinaryTree instance = new KemBinaryTree();
        boolean expResult = false;
        boolean result = instance.exist(n);
        assertEquals("Node is not yet added to the tree, thus exist is false.", expResult, result);
    }

    /**
     * Test of printTree method, of class KemBinaryTree.
     */
    @Test
    public void testPrintTree() {
        System.out.println("printTree");
        KemBinaryTree<Integer> t1 = new KemBinaryTree();
        Integer[] temp = {1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8};
        ArrayList<Integer> arr1 = new ArrayList();
        arr1.addAll(Arrays.asList(temp));
        t1.addAll(arr1);
        t1.printTree();
    }

    /**
     * Test of addAt method, of class KemBinaryTree.
     */
    @Test
    public void testAddAt() {
        System.out.println("addAt");
        KemBinaryTree<Integer> t1 = new KemBinaryTree();
        t1.addAt(t1.getRoot(), 9, true, true);
        t1.addAt(t1.getRoot().getLeft(), 0, false, true);
    }

    /**
     * Test of addAll method, of class KemBinaryTree.
     */
    @Test
    public void testAddAll() {
        System.out.println("addAll");
        
        /* Case 1: add null colletion */
        KemBinaryTree instance = new KemBinaryTree();
        instance.addAll(null);

        /* Case 2: add empty colletion */
        KemBinaryTree<Integer> t1 = new KemBinaryTree();
        ArrayList<Integer> arr1 = new ArrayList();
        t1.addAll(arr1);
        
        /* Case 3: add a colletion with items */
        KemBinaryTree<Integer> t2 = new KemBinaryTree();
        Integer[] temp = {1,2,3,4,5,6,7,8};
        ArrayList<Integer> arr2 = new ArrayList();
        arr2.addAll(Arrays.asList(temp));
        
        t2.addAll(arr2);
    }
}
