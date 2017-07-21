package codeu_assignement_5;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karine
 */
public class KemUnknownLanguageTest {
    public KemUnknownLanguageTest() {
    }
        
    @Test
    public void testGetAlphabeitNullSet() 
    {
        System.out.println("getAlphabeit null set of words");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        assertEquals(null, instance.getAlphabeit(null));
    }

    @Test
    public void testGetAlphabeitEmptySet() {
        System.out.println("getAlphabeit empty set of words");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        assertEquals(new ArrayList(), instance.getAlphabeit(new String[0]));
    }

    @Test
    public void testGetAlphabeitSingleLetter() {
        System.out.println("getAlphabeit with single word");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'A'};
        String[] words = {"A"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testGetAlphabeitTwoLetters() {
        System.out.println("getAlphabeit with single word");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'A','D'};
        String[] words = {"AD"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testGetAlphabeitSingleWord() {
        System.out.println("getAlphabeit with single word");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'A','R','C'};
        String[] words = {"ARC"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testGetAlphabeitTest1() {
        System.out.println("getAlphabeit with the example in the assignment");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'A','T','R','C'};
        String[] words = {"ART", "RAT", "CAT", "CAR"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }

    @Test
    public void testGetAlphabeitTest0() {
        System.out.println("getAlphabeit with letters as words");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'A','T','R','C'};
        String[] words = {"A", "T", "R", "C"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testGetAlphabeitTest2() {
        System.out.println("getAlphabeit with the example from slack question");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'A','R','T','C','D'};
        String[] words = {"ART", "ARC", "ACD", "CAT", "CRC"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testGetAlphabeitTest3() {
        System.out.println("getAlphabeit String with different length");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'A','R','T','C','D'};
        String[] words = {"ART", "ARC", "AC", "CART", "CAT", "CD"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testGetAlphabeitTest4() {
        System.out.println("getAlphabeit first letter is added at prefix check stage");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'D','A','R','T','C'};
        String[] words = {"ART", "ARC", "AC", "CD", "CART", "CAT"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testGetAlphabeitTest5() {
        System.out.println("getAlphabeit all letters but X are added at prefix stage.");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'R','T','C','A'};
        String[] words = {"ART", "ARC", "AC", "AA"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testGetAlphabeitTest6() {
        System.out.println("getAlphabeit from review");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'A','R','C','D','T'};
        String[] words = {"AC", "DR", "D", "TAR", "TAC", "TAD"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    /* These tests are taking from other CodeUer to expose bugs */
    @Test
    public void testExample() {
        System.out.println("getAlphabeit from other CodeUers 1");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'A', 'T', 'R', 'C'};
        String[] words = {"ART", "RAT", "CAT", "CAR"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testExample_2() {
        System.out.println("getAlphabeit from other CodeUers 2");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'A', 'T', 'R', 'C'};
        String[] words = {"ART", "RAT", "ARC", "CAT", "CAR"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    } 
    
    @Test
    public void testExample_3() {
        System.out.println("getAlphabeit from other CodeUers 3");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'T', 'A', 'R', 'C'};
        String[] words = {"ART", "RAT", "CTT", "CTA", "CRA"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    } 
    
    @Test
    public void testExample_4() {
        System.out.println("getAlphabeit from other CodeUers 4");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'A', 'R', 'C', 'D', 'T'};
        String[] words = {"AC", "DR", "D", "TAR", "TAC", "TAD"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    } 
    
    @Test
    public void testExample_5() {
        System.out.println("getAlphabeit from other CodeUers 5");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'T', 'A', 'R', 'C', 'D'};
        String[] words = {"ART", "RAT", "CAT", "CAA", "DT", "DC"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testExample_6() {
        System.out.println("getAlphabeit from other CodeUers 6");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        /* Original was 'T', 'a', but 'T' has no restriction then according to slack-assignement channel answer both are fine. */
        Character[] list = {'A', 'R', 'c', 'C', 'a', 'T'};
        String[] words = {"ART", "RAT", "cAT", "CAR", "CAa"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testExample_7() {
        System.out.println("getAlphabeit from other CodeUers 7");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'A', 'T', 'R', 'C'};
        String[] words = {"ART", "RAT", "RA", "RAT", "CAT", "CAR"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testExample_8() {
        System.out.println("getAlphabeit from other CodeUers 8");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'A', 'T', 'R', 'C', 'D'};
        String[] words = {"ART", "RAT", "CAT", "CAR", "CAD"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testExample_9() {
        System.out.println("getAlphabeit from other CodeUers 9");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'A', 'T', 'R', 'C', 'D', 'S'};
        String[] words = {"ARTS", "RATTA", "CAT", "CAR", "CADDDDDDDDDD"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testExample_10() {
        System.out.println("getAlphabeit from other CodeUers 10");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'A', 'T', 'R', 'C', 'D', 'S'};
        String[] words = {"ARTS", "RATTA", "CAT", "CAR", "CADDDDDDDDDD"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testExample_11() {
        System.out.println("getAlphabeit from other CodeUers 11");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'C', 'B', 'A', 'R', 'D', 'T', 'S'};
        String[] words = {"ART", "RB", "RD", "RT", "TC", "T", "SC", "SB", "SA"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testExample_12() {
        System.out.println("getAlphabeit from other CodeUers 12");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        /** Original:
        Character[] list = {'A', 'T', 'S', 'B', 'R', 'C'};
        * But the only strict order is with the letters A,T,R,C, and thus 'S' and 'B'
        * can come at any order.
        */
        Character[] list = {'A', 'T', 'R', 'C', 'S', 'B'};
        String[] words = {"ART", "RATS", "CATB", "CAR"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testExample_13() {
        System.out.println("getAlphabeit from other CodeUers 13");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        /** Original:
        Character[] list = {'A', 'T', 'B', '!', '3', 'X', 'R', 'C'};
        * But the only strict order is with the letters A,T,R,C, and thus all the rest
        * of the symbols can come at any order (slack answer more than a week ago).
        */
        Character[] list = {'A', 'T', 'R', 'C', 'B', '!', '3', 'X'};
        String[] words = {"ART", "RAT", "CATB!3", "CARX"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testExample_14() {
        System.out.println("getAlphabeit from other CodeUers 14");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        Character[] list = {'A', 'T', 'R', 'C'};
        String[] words = {"ART", "RAAAAATTTT", "CAT", "CAR"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testExample_15() {
        System.out.println("getAlphabeit from other CodeUers 15");
        KemUnknownLanguage instance = new KemUnknownLanguage();
        /** Original:
        Character[] list =  {'T', 'S', 'A', 'R', 'O', 'C'};
        * But given these rules (of partial orders):
        * A,R,C
        * A,O
        * T,R 
        * S,A
        * 
        * Also other orders are fine (as the one my algorithm outputs)
        */        
        Character[] list = {'S', 'A', 'T', 'R', 'C', 'O'};
        String[] words = {"ART", "RAT", "CAT", "CAR", "COS", "COA"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
}
