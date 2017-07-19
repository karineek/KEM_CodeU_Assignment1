package codeu_assignement_1;

import java.util.Arrays;
import java.util.Collection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karine
 */
public class SinglyLinkedListTest {  
    public SinglyLinkedListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * Test of isEmpty method, of class SinglyLinkedList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        SinglyLinkedList instance = new SinglyLinkedList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals("Newly created Linked list is not empty.", expResult, result);
    }

    /**
     * Test of getSize method, of class SinglyLinkedList.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        SinglyLinkedList instance = new SinglyLinkedList();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals("Size of empty linked list is not 0.", expResult, result);
    }

    /**
     * Test of addFirst method, of class SinglyLinkedList.
     */
    @Test
    public void testAddFirst() {
        System.out.println("addFirst");
        Object e = null;
        SinglyLinkedList instance = new SinglyLinkedList();
        instance.addFirst(e); // Can add an element to the begining of the list
    }

    /**
     * Test of addLast method, of class SinglyLinkedList.
     */
    @Test
    public void testAddLast() {
        System.out.println("addLast");
        Object e = null;
        SinglyLinkedList instance = new SinglyLinkedList();
        instance.addLast(e); // Can add element to the end of the list
    }

    /**
     * Test of addAt method, of class SinglyLinkedList.
     */
    @Test
    public void testAddAt() {
        System.out.println("addAt");
        int index = 0;
        Object e = null;
        SinglyLinkedList instance = new SinglyLinkedList();
        instance.addAt(index, e); // Can add element to the list at location
    }

    /**
     * Test of addAll method, of class SinglyLinkedList.
     */
    @Test
    public void testAddAll() {
        System.out.println("addAll");
        String[] intput_list = "1,2,3,4,5".split(",");
        Collection c = Arrays.asList(intput_list);
        SinglyLinkedList instance = new SinglyLinkedList();
        boolean expResult = true;
        boolean result = instance.addAll(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeFirst method, of class SinglyLinkedList.
     */
    @Test
    public void testRemoveFirst() {
        System.out.println("removeFirst");
        String[] intput_list = "1,2,3,4,5".split(",");
        
        SinglyLinkedList<String> my_list 
                           = new SinglyLinkedList<>(Arrays.asList(intput_list));
        
        String expResult = "1";
        String result = my_list.removeFirst();
        assertEquals(expResult, result);
        
        expResult = "2";
        result = my_list.removeFirst();
        assertEquals(expResult, result);
        
        expResult = "3";
        result = my_list.removeFirst();
        assertEquals(expResult, result);
        
        expResult = "4";
        result = my_list.removeFirst();
        assertEquals(expResult, result);
        
        expResult = "5";
        result = my_list.removeFirst();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeLast method, of class SinglyLinkedList.
     */
    @Test
    public void testRemoveLast() {
        System.out.println("removeFirst");
        String[] intput_list = "1,2,3,4,5".split(",");
        
        SinglyLinkedList<String> my_list 
                           = new SinglyLinkedList<>(Arrays.asList(intput_list));
        
        String expResult = "5";
        String result = my_list.removeLast();
        assertEquals(expResult, result);
        
        expResult = "4";
        result = my_list.removeLast();
        assertEquals(expResult, result);
        
        expResult = "3";
        result = my_list.removeLast();
        assertEquals(expResult, result);
        
        expResult = "2";
        result = my_list.removeLast();
        assertEquals(expResult, result);

        expResult = "1";
        result = my_list.removeLast();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeAt method, of class SinglyLinkedList.
     */
    @Test
    public void testRemoveAt() {
        System.out.println("removeAt");
        String[] intput_list = "1,2,3,4,5".split(",");
        
        SinglyLinkedList<String> my_list 
                           = new SinglyLinkedList<>(Arrays.asList(intput_list));
        
        String expResult = "5";
        String result = my_list.removeAt(4);
        assertEquals(expResult, result);
        
        expResult = "1";
        result = my_list.removeAt(0);
        assertEquals(expResult, result);
        
        expResult = "3";
        result = my_list.removeAt(1);
        assertEquals(expResult, result);
        
        expResult = "2";
        result = my_list.removeAt(0);
        assertEquals(expResult, result);

        expResult = "4";
        result = my_list.removeAt(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class SinglyLinkedList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        SinglyLinkedList<Integer> my_list = new SinglyLinkedList<>();
        
        int index = 0;
        Integer elem = 1;
        my_list.addFirst(elem);
        assertEquals("Basic get: list with one item, get doesn't work well.", 
                        elem, my_list.get(index));
        
        Integer elem2 = 4;
        my_list.addFirst(elem2);
        assertEquals("List with two items 4,1: list with one item, get doesn't work well.", 
                        elem2, my_list.get(index));
    }

    /**
     * Test of size method, of class SinglyLinkedList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        SinglyLinkedList instance = new SinglyLinkedList();
        int expResult = 0;
        int result = instance.size();
        assertEquals("Size of empty list should be 0.", expResult, result);
    }
    
    /**
     * Test simple mix of add/remove get methods
     */
    @Test
    public void testBasicFlowValid() {
        SinglyLinkedList<Integer> my_list = new SinglyLinkedList<>();
        my_list.addFirst(1);
        my_list.addFirst(2);
        my_list.addFirst(3);
        my_list.addFirst(4);
        my_list.addFirst(4);
        my_list.addFirst(5);
        // 5,4,4,3,2,1
        my_list.removeAt(5);
        // 5,4,4,3,2
        
        int expResult = 2;
        int result = my_list.get(my_list.size()-1);
        assertEquals("> Last item is: 2 in the list 5,4,4,3,2", expResult, result);
        expResult = 5;
        result = my_list.get(0);
        assertEquals("> First item is: 2 in the list 5,4,4,3,2", expResult, result);
        expResult = 4;
        result = my_list.get(1);
        assertEquals("> 2 items is: 4", expResult, result);
        result = my_list.get(2);
        assertEquals("> 3 item is: 4", expResult, result);
        
        expResult = 2;        
        result = my_list.removeLast();
        assertEquals("> Last was 2 (removed)", expResult, result);
        expResult = 3;
        result = my_list.get(my_list.size()-1);
        assertEquals("> Last now is 3", expResult, result);
        
        
        expResult = 5;
        result = my_list.removeFirst();
        assertEquals("> First was 5 (removed)", expResult, result);
        expResult = 4;
        result = my_list.get(0);
        assertEquals("> First now is 4", expResult, result);
        
        expResult = 3;
        result = my_list.removeLast();
        assertEquals("> Last was 3 (removed)", expResult, result);
        expResult = 4;
        result = my_list.get(my_list.size()-1);
        assertEquals("> Last now is 4", expResult, result);
        
        
        expResult = 4;
        result = my_list.removeFirst();
        assertEquals("> First was 4 (removed)", expResult, result);
        expResult = 4;
        result = my_list.get(0);
        assertEquals("> First now is 4", expResult, result);
    }
}
