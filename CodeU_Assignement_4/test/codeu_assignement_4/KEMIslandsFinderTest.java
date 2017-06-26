package codeu_assignement_4;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karine
 */
public class KEMIslandsFinderTest {
    
    public KEMIslandsFinderTest() {
    }
    
    public static void setUpClass() {
    }
    
    public static void tearDownClass() {
    }

    @Test
    public void testCountIslandsEmptyMap() {
        System.out.println("countIslands for empty map");
        int row = 0;
        int col = 0;
        boolean[][] map = null;
        KEMIslandsFinder instance = new KEMIslandsFinder();
        assertEquals(0, instance.countIslands(row, col, map));
    }

    @Test
    public void testCountIslandsyMap1x1NoIsland() {
        System.out.println("countIslands for 1x1 map with no islands");
        int row = 1;
        int col = 1;
        boolean[][] map = {{false}};
        KEMIslandsFinder instance = new KEMIslandsFinder();
        assertEquals(0, instance.countIslands(row, col, map));
    }    
    
    @Test
    public void testCountIslandsyMap1x1SingleIsland() {
        System.out.println("countIslands for 1x1 map with single islands");
        int row = 1;
        int col = 1;
        boolean[][] map = {{true}};
        KEMIslandsFinder instance = new KEMIslandsFinder();
        assertEquals(1, instance.countIslands(row, col, map));
    } 
    
    @Test
    public void testCountIslandsyMap2x1NoIsland() {
        System.out.println("countIslands for 2x1 map with no islands");
        int row = 2;
        int col = 1;
        boolean[][] map = {{false},{false}};
        KEMIslandsFinder instance = new KEMIslandsFinder();
        assertEquals(0, instance.countIslands(row, col, map));
    }    
    
    @Test
    public void testCountIslandsyMap1x2SingleIsland() {
        System.out.println("countIslands for 1x2 map with single islands");
        int row = 1;
        int col = 2;
        boolean[][] map = {{true,true}};
        KEMIslandsFinder instance = new KEMIslandsFinder();
        assertEquals(1, instance.countIslands(row, col, map));
    } 
    
    @Test
    public void testCountIslandsyMap2x2SingleIsland() {
        System.out.println("countIslands for 2x2 map with single islands");
        int row = 2;
        int col = 2;
        boolean[][] map = {{true,false},{false,true}};
        KEMIslandsFinder instance = new KEMIslandsFinder();
        assertEquals(1, instance.countIslands(row, col, map));
    }
    
    @Test
    public void testCountIslandsyMap3x3() {
        System.out.println("countIslands for 3x3 map with two islands");
        int row = 3;
        int col = 3;
        boolean[][] map = {{true,false,false},{false,false,false},{false,false,true}};
        KEMIslandsFinder instance = new KEMIslandsFinder();
        assertEquals(2, instance.countIslands(row, col, map));
    }
    
    @Test
    public void testCountIslandsyMap5x5() {
        System.out.println("countIslands for 5x5 map with 3 islands");
        int row = 5;
        int col = 5;
        boolean[][] map = {{true,false,false,false,true},
		{true,false,false,false,false},
		{false,false,true,true,false},
		{false,false,false,true,false},
		{false,false,false,true,false}};
        KEMIslandsFinder instance = new KEMIslandsFinder();
        assertEquals(3, instance.countIslands(row, col, map));
    }
    
    @Test
    public void testCountIslandsyMap7x7() {
        System.out.println("countIslands for 7x7 map with 1 island");
        int row = 7;
        int col = 7;
        boolean[][] map = {
            {true,false,false,false,false,false,true},
            {false,true,false,false,false,true,false},
            {false,false,true,false,true,false,false},
            {false,false,false,true,false,false,false},
            {false,false,true,false,true,false,false},
            {false,true,false,false,false,true,false},
            {true,false,false,false,false,false,true}
		};
        KEMIslandsFinder instance = new KEMIslandsFinder();
        assertEquals(1, instance.countIslands(row, col, map));
    }
    
    @Test
    public void testCountIslandsyMap5x3() {
        System.out.println("countIslands for 5x3 map with 2 islands");
        int row = 5;
        int col = 3;
        boolean[][] map = {{true,false,false},
		{true,false,false},
		{false,false,true},
		{false,false,true},
		{false,true,false}};
        KEMIslandsFinder instance = new KEMIslandsFinder();
        assertEquals(2, instance.countIslands(row, col, map));
    }
    
    @Test
    public void testCountIslandsyMap3x5() {
        System.out.println("countIslands for 3x5 map with 5 islands");
        int row = 3;
        int col = 5;
        boolean[][] map = {
                {true,false,true,false,true},
		{false,false,true,false,false},
		{true,false,true,false,true}};
        KEMIslandsFinder instance = new KEMIslandsFinder();
        assertEquals(5, instance.countIslands(row, col, map));
    }
}
