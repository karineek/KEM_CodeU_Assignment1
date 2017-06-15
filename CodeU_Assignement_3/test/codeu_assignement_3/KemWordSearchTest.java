package codeu_assignement_3;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karine
 */
public class KemWordSearchTest {
    
    public KemWordSearchTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testWordSearchNullGridDict() {
        System.out.println("wordSearch Null Grid and Dictionary");
        int row = 0;
        int col = 0;
        char[][] grid = null;
        SimpleDictionary dict = null;
        KemWordSearch instance = new KemWordSearch();
        String[] expResult = null;
        String[] result = instance.wordSearch(row, col, grid,dict);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testWordSearchNullGrid() {
        System.out.println("wordSearch Null Grid");
        int row = 0;
        int col = 0;
        char[][] grid = null;
        SimpleDictionary dict = new SimpleDictionary(null);
        KemWordSearch instance = new KemWordSearch();
        String[] expResult = null;
        String[] result = instance.wordSearch(row, col, grid,dict);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testWordSearchNullGridWithDict() {
        System.out.println("wordSearch Null Grid With Dictionary");
        int row = 0;
        int col = 0;
        char[][] grid = null;
        String[] dict_word = {"CAR", "CARD", "CART", "CAT"};
        SimpleDictionary dict = new SimpleDictionary(dict_word);
        KemWordSearch instance = new KemWordSearch();
        String[] expResult = null;
        String[] result = instance.wordSearch(row, col, grid,dict);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testWordSearchEmptyDict() {
        System.out.println("wordSearch Empty Dictionary");
        int row = 0;
        int col = 0;
        char[][] grid = {{'a','a','r'},{'t','c','d'}};
        SimpleDictionary dict = new SimpleDictionary(null);
        KemWordSearch instance = new KemWordSearch();
        String[] expResult = new String[0];
        String[] result = instance.wordSearch(row, col, grid,dict);
        assertArrayEquals(expResult, result);
    }   
    
    @Test
    public void testWordSearch() {
        System.out.println("wordSearch wiht Dictionary");
        int row = 2;
        int col = 3;
        char[][] grid = {{'A','A','R'},{'T','C','D'}};
        String[] dict_word = {"CAR", "CARD", "CART", "CAT", "AARDCT", "DC", "CD", "CDC"};
        SimpleDictionary dict = new SimpleDictionary(dict_word);
        KemWordSearch instance = new KemWordSearch();
        String[] expResult = {"CD", "CAR", "AARDCT", "CAT", "CARD", "DC"};
        String[] result = instance.wordSearch(row, col, grid,dict);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testWordSearch2() {
        System.out.println("wordSearch with Dictionary (2)");
        int row = 3;
        int col = 2;
        char[][] grid = {{'A','T'},{'A','C'},{'R','D'}};
        String[] dict_word = {"CAR", "CARD", "CART", "CAT", "AT", "FACE", 
                                    "COOL", "OPEN", "RAT", "AARDCT", "ATCARD","ATACA"};
        SimpleDictionary dict = new SimpleDictionary(dict_word);
        KemWordSearch instance = new KemWordSearch();
        String[] expResult = {"AT", "RAT", "CAR", "AARDCT", "CAT", "ATCARD", "CARD"};
        String[] result = instance.wordSearch(row, col, grid,dict);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testWordSearch3() {
        System.out.println("wordSearch with Dictionary (3)");
        int row = 3;
        int col = 3;
        char[][] grid = {{'A','T','I'},{'A','C','J'},{'R','D','K'}};
        String[] dict_word = {"CAR", "CARD", "CART", "CAT","AT","FACE","COOL","OPEN","RAT","I","ARC","AAA","CCC","ACAC"};
        SimpleDictionary dict = new SimpleDictionary(dict_word);
        KemWordSearch instance = new KemWordSearch();
        String[] expResult = {"ARC", "AT", "RAT", "CAR", "CAT", "I", "CARD"};
        String[] result = instance.wordSearch(row, col, grid,dict);
        assertArrayEquals(expResult, result);
    }
}
