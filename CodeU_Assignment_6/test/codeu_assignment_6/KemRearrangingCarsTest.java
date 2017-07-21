package codeu_assignment_6;

import java.util.ArrayList;
import javafx.util.Pair;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karine
 */
public class KemRearrangingCarsTest {
    
    public KemRearrangingCarsTest() {
    }
    
    @Test
    public void testGetMovesRearrangingCarsNullLists() {
        System.out.println("getMovesRearrangingCars null lists");
        assertEquals(null, (new KemRearrangingCars()).getMovesRearrangingCars(null, null));
    }
    
    @Test
    public void testGetMovesRearrangingCarsSingleItemInvalid() {
        System.out.println("getMovesRearrangingCars single item (Invalid input)");
        Integer[] permutationA = {1};
        Integer[] permutationB = {1};
        assertEquals(null, (new KemRearrangingCars()).getMovesRearrangingCars(permutationA, permutationB));
    }
    
    @Test
    public void testGetMovesRearrangingCarsSingleItem() {
        System.out.println("getMovesRearrangingCars single item (valid input)");
        Integer[] permutationA = {0};
        Integer[] permutationB = {0};
        assertEquals(new ArrayList<>(), (new KemRearrangingCars()).getMovesRearrangingCars(permutationA, permutationB));
    }

    @Test
    public void testGetMovesRearrangingCars2Items() {
        System.out.println("getMovesRearrangingCars two items");
        Integer[] permutationA = {0,1};
        Integer[] permutationB = {1,0};
        ArrayList<Pair<Integer, Integer>> expectedRes = new ArrayList<>();
        expectedRes.add(new Pair<>(1,0));
        assertEquals(expectedRes, (new KemRearrangingCars()).getMovesRearrangingCars(permutationA, permutationB));
    }        
    
    @Test
    public void testGetMovesRearrangingCars3Items() {
        System.out.println("getMovesRearrangingCars 3 items");
        Integer[] permutationA = {0,1,2};
        Integer[] permutationB = {1,0,2};
        ArrayList<Pair<Integer, Integer>> expectedRes = new ArrayList<>();
        expectedRes.add(new Pair<>(1,0));
        assertEquals(expectedRes, (new KemRearrangingCars()).getMovesRearrangingCars(permutationA, permutationB));
    }
    
    @Test
    public void testGetMovesRearrangingCars4Items() {
        System.out.println("getMovesRearrangingCars 4 items");
        Integer[] permutationA = {1,2,0,3};
        Integer[] permutationB = {3,1,2,0};
        ArrayList<Pair<Integer, Integer>> expectedRes = new ArrayList<>();
        expectedRes.add(new Pair<>(0,2));
        expectedRes.add(new Pair<>(3,0));
        expectedRes.add(new Pair<>(1,3));
        expectedRes.add(new Pair<>(2,1));
        expectedRes.add(new Pair<>(3,2));
        
        assertEquals(expectedRes, (new KemRearrangingCars()).getMovesRearrangingCars(permutationA, permutationB));
    }
    
    @Test
    public void testGetMovesRearrangingCars5Items() {
        System.out.println("getMovesRearrangingCars 5 items");
        Integer[] permutationA = {1,2,0,3,4};
        Integer[] permutationB = {3,1,2,0,4};
        ArrayList<Pair<Integer, Integer>> expectedRes = new ArrayList<>();
        expectedRes.add(new Pair<>(0,2));
        expectedRes.add(new Pair<>(3,0));
        expectedRes.add(new Pair<>(1,3));
        expectedRes.add(new Pair<>(2,1));
        expectedRes.add(new Pair<>(3,2));
        
        assertEquals(expectedRes, (new KemRearrangingCars()).getMovesRearrangingCars(permutationA, permutationB));
    }
    
    @Test
    public void testGetMovesRearrangingCars6Items() {
        System.out.println("getMovesRearrangingCars 6 items");
        Integer[] permutationA = {1,2,3,4,5,0};
        Integer[] permutationB = {0,1,2,3,4,5};
        ArrayList<Pair<Integer, Integer>> expectedRes = new ArrayList<>();
        expectedRes.add(new Pair<>(0,5));
        expectedRes.add(new Pair<>(1,0));
        expectedRes.add(new Pair<>(5,1));
        expectedRes.add(new Pair<>(2,5));
        expectedRes.add(new Pair<>(0,2));
        expectedRes.add(new Pair<>(3,0));
        expectedRes.add(new Pair<>(5,3));
        expectedRes.add(new Pair<>(4,5));
        expectedRes.add(new Pair<>(0,4));
        
        assertEquals(expectedRes, (new KemRearrangingCars()).getMovesRearrangingCars(permutationA, permutationB));
    }
    
    @Test
    public void testGetMovesRearrangingCars6ItemsRev() {
        System.out.println("getMovesRearrangingCars 6 items reversed order");
        Integer[] permutationA = {0,5,4,3,2,1};
        Integer[] permutationB = {0,1,2,3,4,5};
        ArrayList<Pair<Integer, Integer>> expectedRes = new ArrayList<>();
        expectedRes.add(new Pair<>(1,0));
        expectedRes.add(new Pair<>(5,1));
        expectedRes.add(new Pair<>(2,5));
        expectedRes.add(new Pair<>(4,2));
        expectedRes.add(new Pair<>(5,4));
        expectedRes.add(new Pair<>(0,5));
        
        assertEquals(expectedRes, (new KemRearrangingCars()).getMovesRearrangingCars(permutationA, permutationB));
    }
    
    @Test
    public void testGetMovesRearrangingCars7Items0inMiddle() {
        System.out.println("getMovesRearrangingCars 7 items with free space in the middle");
        Integer[] permutationA = {1,5,4,0,2,3,6};
        Integer[] permutationB = {0,1,2,3,4,5,6};
        ArrayList<Pair<Integer, Integer>> expectedRes = new ArrayList<>();
        expectedRes.add(new Pair<>(0,3));
        expectedRes.add(new Pair<>(1,0));
        expectedRes.add(new Pair<>(3,1));
        expectedRes.add(new Pair<>(2,3));
        expectedRes.add(new Pair<>(4,2));
        expectedRes.add(new Pair<>(3,4));
        expectedRes.add(new Pair<>(5,3));
        expectedRes.add(new Pair<>(0,5));
        
        assertEquals(expectedRes, (new KemRearrangingCars()).getMovesRearrangingCars(permutationA, permutationB));
    }
    
    @Test
    public void testGetMovesRearrangingCars10ItemsMix() {
        System.out.println("getMovesRearrangingCars 10 items, test 1");
        Integer[] permutationA = {0,1,2,3,4,5,6,7,8,9};
        Integer[] permutationB = {6,4,2,7,9,0,3,5,1,8};
        ArrayList<Pair<Integer, Integer>> expectedRes = new ArrayList<>();
        expectedRes.add(new Pair<>(6,0));
        expectedRes.add(new Pair<>(1,6));
        expectedRes.add(new Pair<>(4,1));
        expectedRes.add(new Pair<>(3,4));
        expectedRes.add(new Pair<>(7,3));
        expectedRes.add(new Pair<>(4,7));
        expectedRes.add(new Pair<>(9,4));
        expectedRes.add(new Pair<>(5,9));
        expectedRes.add(new Pair<>(6,5));
        expectedRes.add(new Pair<>(7,6));
        expectedRes.add(new Pair<>(9,7));
        expectedRes.add(new Pair<>(8,9));
        expectedRes.add(new Pair<>(5,8));
        
        assertEquals(expectedRes, (new KemRearrangingCars()).getMovesRearrangingCars(permutationA, permutationB));
    }
    
    @Test
    public void testGetMovesRearrangingCars10ItemsMixToMix() {
        System.out.println("getMovesRearrangingCars 10 items, test 2");
        Integer[] permutationA = {8,0,3,7,5,2,4,1,9,6};
        Integer[] permutationB = {6,4,2,7,9,0,3,5,1,8};
        ArrayList<Pair<Integer, Integer>> expectedRes = new ArrayList<>();;
        expectedRes.add(new Pair<>(0,1)); 
        expectedRes.add(new Pair<>(9,0));
        expectedRes.add(new Pair<>(1,9));
        expectedRes.add(new Pair<>(6,1));
        expectedRes.add(new Pair<>(2,6)); 
        expectedRes.add(new Pair<>(5,2)); 
        expectedRes.add(new Pair<>(4,5));
        expectedRes.add(new Pair<>(8,4)); 
        expectedRes.add(new Pair<>(5,8));
        expectedRes.add(new Pair<>(7,5));
        expectedRes.add(new Pair<>(8,7));
        expectedRes.add(new Pair<>(5,8));
        assertEquals(expectedRes, (new KemRearrangingCars()).getMovesRearrangingCars(permutationA, permutationB));
    }
}
