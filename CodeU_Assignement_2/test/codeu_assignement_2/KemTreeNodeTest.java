/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeu_assignement_2;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karine
 */
public class KemTreeNodeTest {
    
    public KemTreeNodeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setParent method, of class KemTreeNode.
     */
    @Test
    public void testSetParent() {
        System.out.println("setParent");
        KemTreeNode p = new KemTreeNode(1);
        KemTreeNode instance = new KemTreeNode(5);
        instance.setParent(p);
        assertEquals("Set parent p and then get parent shall return objrct p.", p, instance.getParent());    
    }

    /**
     * Test of setLeft method, of class KemTreeNode.
     */
    @Test
    public void testSetLeft() {
        System.out.println("setLeft");
        KemTreeNode l = new KemTreeNode(1);
        KemTreeNode instance = new KemTreeNode(5);
        instance.setLeft(l);
        assertEquals("Set Left l and then get left shall return objrct l.", l, instance.getLeft());
    }

    /**
     * Test of setRight method, of class KemTreeNode.
     */
    @Test
    public void testSetRight() {
        System.out.println("setRight");
        KemTreeNode r = new KemTreeNode(1);
        KemTreeNode instance = new KemTreeNode(5);
        instance.setRight(r);
        assertEquals("Set right r and then get right shall return objrct r.", r, instance.getRight());
    }

    /**
     * Test of setData method, of class KemTreeNode.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        KemTreeNode instance = new KemTreeNode(5);
        instance.setData(6);
        assertEquals("Init node with 5, then set to 6, thus get data is 6 now", 6, instance.getData());
        instance.setData(6);
        assertEquals("Re-set to 6, thus get data shall be 6 now", 6, instance.getData());
        instance.setData(99);
        assertEquals("Set to 99, thus get data shall be 99 now", 99, instance.getData());
        instance.setData(-1);
        assertEquals("Set to -1, thus get data shall be -1 now", -1, instance.getData());
        instance.setData(0);
        assertEquals("Set to 0, thus get data shall be 0 now", 0, instance.getData());
        instance.setData(null);
        assertEquals("Set to null, thus get data shall be null now", null, instance.getData());
    }

    /**
     * Test of getParent method, of class KemTreeNode.
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");
        KemTreeNode p = new KemTreeNode(0);
        KemTreeNode instance = new KemTreeNode(0,p,null,null);
        assertEquals("Get parent shall return objrct p.", p, instance.getParent()); 
    }

    /**
     * Test of getLeft method, of class KemTreeNode.
     */
    @Test
    public void testGetLeft() {
        System.out.println("getLeft");
        KemTreeNode l = new KemTreeNode(0);
        KemTreeNode instance = new KemTreeNode(0,null,l,null);
        assertEquals("Get Left shall return objrct l.", l, instance.getLeft());
    }

    /**
     * Test of getRight method, of class KemTreeNode.
     */
    @Test
    public void testGetRight() {
        System.out.println("getRight");
        KemTreeNode r = new KemTreeNode(0);
        KemTreeNode instance = new KemTreeNode(0,null,null,r);
        assertEquals("Get right shall return objrct r.", r, instance.getRight());
    }

    /**
     * Test of getData method, of class KemTreeNode.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        KemTreeNode instance = new KemTreeNode(0,null,null,null);
        assertEquals("Get data shall return 0, as setted in c'tor.", 0, instance.getData());
    }

    /**
     * Test of equals method, of class KemTreeNode.
     */
    @Test
    public void testEqualsNull() {
        System.out.println("equals null nodes");
        KemTreeNode n1 = new KemTreeNode(null);
        KemTreeNode n2 = null;
        assertEquals("Both objects are null", false, n1.equals(n2));
        
        n1 = new KemTreeNode(null);
        n2 = new KemTreeNode(null,null,null,null);
        assertEquals("Both objects are null", true, n1.equals(n2));
        assertEquals("Both objects are null", true, n2.equals(n1));
    }

    /**
     * Test of equals method, of class KemTreeNode.
     */
    @Test
    public void testEqualsDataOnly() {
        System.out.println("equals null nodes");
        KemTreeNode n1 = new KemTreeNode(5);
        KemTreeNode n2 = new KemTreeNode(5,null,null,null);
        assertEquals("Both objects are with data only and the same data", true, n1.equals(n2));
        assertEquals("Both objects are with data only and the same data", true, n2.equals(n1));
    }

    /**
     * Test of equals method, of class KemTreeNode.
     */
    @Test
    public void testEqualsDataDiff() {
        System.out.println("equals null nodes");
        KemTreeNode n1 = new KemTreeNode(5);
        KemTreeNode n2 = new KemTreeNode(-5,null,null,null);
        assertEquals("Both objects are with data only + not same data(5,-5)", false, n1.equals(n2));
        assertEquals("Both objects are with data only + not same data(5,-5)", false, n2.equals(n1));
    }
    
    /*
      General tests to test Equals
    */
    @Test
    public void testEquals() {
        System.out.println("equals null nodes");
        KemTreeNode n1 = new KemTreeNode(5);
        KemTreeNode n2 = new KemTreeNode(5,n1,null,null);
        assertEquals("Both objects are with the same data, obe is parent of the other.", false, n1.equals(n2));
        
        KemTreeNode n3 = new KemTreeNode(5,null,n1,null);
        KemTreeNode n4 = new KemTreeNode(5,n1,null,null);
        assertEquals("Sets n1 as parent or as left, shall be different", false, n3.equals(n4));
        
        KemTreeNode n5 = new KemTreeNode(5,null,null,n1);
        assertEquals("Sets n1 as parent or as right, shall be different", false, n5.equals(n4));
    }
}
