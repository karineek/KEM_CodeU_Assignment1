package codeu_assignement_3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karine
 * 
 * Test two methods: isWord and isPrefix with different sized of dictionary
 * Null, Empty, with only one word (single word), and a small dictionary with several words
 * 
 */
public class SimpleDictionaryTest {
    
    public SimpleDictionaryTest() {
    }

    @Test
    public void testIsWordNullDict() {
        System.out.println("isWord Null dictionary");
        String w = "";
        SimpleDictionary instance = new SimpleDictionary(null);
        boolean expResult = false;
        boolean result = instance.isWord(w);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsPrefixNullDict() {
        System.out.println("isPrefix Null dictionary");
        String p = "";
        SimpleDictionary instance = new SimpleDictionary(null);
        boolean expResult = false;
        boolean result = instance.isPrefix(p);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsWordEmptyDict() {
        System.out.println("isWord Empty dictionary");
        String w = "";
        String[] dict = new String[0];
        SimpleDictionary instance = new SimpleDictionary(dict);
        boolean expResult = false;
        boolean result = instance.isWord(w);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsPrefixEmptyDict() {
        System.out.println("isPrefix Empty dictionary");
        String p = "";
        String[] dict = new String[0];
        SimpleDictionary instance = new SimpleDictionary(dict);
        boolean expResult = false;
        boolean result = instance.isPrefix(p);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsWordSingleWordDict_F() {
        System.out.println("isWord SingleWord dictionary (F)");
        String w = "";
        String[] dict = new String[1];
        dict[0] = "cat";
        SimpleDictionary instance = new SimpleDictionary(dict);
        boolean expResult = false;
        boolean result = instance.isWord(w);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsPrefixSingleWordDict_F() {
        System.out.println("isPrefix SingleWord dictionary (F)");
        String p1 = "b";
        String p2 = "a";
        String p3 = "t";
        String p4 = "at";
        String p5 = "ta";
        String[] dict = new String[1];
        dict[0] = "cat";
        SimpleDictionary instance = new SimpleDictionary(dict);
        boolean expResult = false;
        boolean result1 = instance.isPrefix(p1);
        boolean result2 = instance.isPrefix(p2);
        boolean result3 = instance.isPrefix(p3);
        boolean result4 = instance.isPrefix(p4);
        boolean result5 = instance.isPrefix(p5);
        assertEquals(expResult, result1);
        assertEquals(expResult, result2);
        assertEquals(expResult, result3);
        assertEquals(expResult, result4);
        assertEquals(expResult, result5);
    } 

   @Test
    public void testIsWordSingleWordDict_T() {
        System.out.println("isWord SingleWord dictionary (T)");
        String w = "cat";
        String[] dict = new String[1];
        dict[0] = "cat";
        SimpleDictionary instance = new SimpleDictionary(dict);
        boolean expResult = true;
        boolean result = instance.isWord(w);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsPrefixSingleWordDict_T() {
        System.out.println("isPrefix SingleWord dictionary (T)");
        String p1 = "c";
        String p2 = "ca";
        String p3 = "cat";
        String p4 = "";
        String[] dict = new String[1];
        dict[0] = "cat";
        SimpleDictionary instance = new SimpleDictionary(dict);
        boolean expResult = true;
        boolean result1 = instance.isPrefix(p1);
        boolean result2 = instance.isPrefix(p2);
        boolean result3 = instance.isPrefix(p3);
        boolean result4 = instance.isPrefix(p4);
        assertEquals(expResult, result1);
        assertEquals(expResult, result2);
        assertEquals(expResult, result3);
        assertEquals(expResult, result4);
    }  

    @Test
    public void testIsWordSmallDict_F() {
        System.out.println("isWord Small dictionary (F)");
        String w = "AT";
        String[] dict = {"CAR", "CARD", "CART", "CAT"};
        SimpleDictionary instance = new SimpleDictionary(dict);
        boolean expResult = false;
        boolean result = instance.isWord(w);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsPrefixSmallDict_F() {
        System.out.println("isPrefix Small dictionary (F)");
        String p1 = "CAM";
        String p2 = "PAR";
        String[] dict = {"CAR", "CARD", "CART", "CAT"};
        SimpleDictionary instance = new SimpleDictionary(dict);
        boolean expResult = false;
        boolean result1 = instance.isPrefix(p1);
        boolean result2 = instance.isPrefix(p2);
        assertEquals(expResult, result1);
        assertEquals(expResult, result2);
    } 

    @Test
    public void testIsWordSmallDict_T() {
        System.out.println("isWord Small dictionary (T)");
        String w1 = "CAR";
        String w2 = "CART";
        String w3 = "CAT";
        String[] dict = {"CAR", "CARD", "CART", "CAT"};
        SimpleDictionary instance = new SimpleDictionary(dict);
        boolean expResult = true;
        boolean result1 = instance.isWord(w1);
        boolean result2 = instance.isWord(w2);
        boolean result3 = instance.isWord(w3);
        assertEquals(expResult, result1);
        assertEquals(expResult, result2);
        assertEquals(expResult, result3);
    }
    
    @Test
    public void testIsPrefixSmallDict_T() {
        System.out.println("isPrefix Small dictionary (T)");
        String p1 = "CA";
        String p2 = "CAR";
        String[] dict = {"CAR", "CARD", "CART", "CAT"};
        SimpleDictionary instance = new SimpleDictionary(dict);
        boolean expResult = true;
        boolean result1 = instance.isPrefix(p1);
        boolean result2 = instance.isPrefix(p2);
        assertEquals(expResult, result1);
        assertEquals(expResult, result2);
    }     
}
