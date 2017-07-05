package codeu_assignement_5;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karine
 */
public class kemUnknownLanguageTest 
{
    public kemUnknownLanguageTest() {
    }
        
    @Test
    public void testGetAlphabeitNullSet() 
    {
        System.out.println("getAlphabeit null set of words");
        kemUnknownLanguage instance = new kemUnknownLanguage();
        assertEquals(null, instance.getAlphabeit(null));
    }

    @Test
    public void testGetAlphabeitEmptySet() {
        System.out.println("getAlphabeit empty set of words");
        kemUnknownLanguage instance = new kemUnknownLanguage();
        assertEquals(null, instance.getAlphabeit(new String[0]));
    }

    @Test
    public void testGetAlphabeitSingleWord() {
        System.out.println("getAlphabeit with single word");
        kemUnknownLanguage instance = new kemUnknownLanguage();
        Character[] list = {'A','R','C'};
        String[] words = {"ARC"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testGetAlphabeitTest1() {
        System.out.println("getAlphabeit with the example in the assignment");
        kemUnknownLanguage instance = new kemUnknownLanguage();
        Character[] list = {'A','T','R','C'};
        String[] words = {"ART", "RAT", "CAT", "CAR"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testGetAlphabeitTest2() {
        System.out.println("getAlphabeit with the example from slack question");
        kemUnknownLanguage instance = new kemUnknownLanguage();
        Character[] list = {'A','R','T','C','D'};
        String[] words = {"ART", "ARC", "ACD", "CAT", "CRC"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testGetAlphabeitTest3() {
        System.out.println("getAlphabeit String with different length");
        kemUnknownLanguage instance = new kemUnknownLanguage();
        Character[] list = {'A','R','T','C','D'};
        String[] words = {"ART", "ARC", "AC", "CART", "CAT", "CD"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testGetAlphabeitTest4() {
        System.out.println("getAlphabeit first letter is added at prefix check stage");
        kemUnknownLanguage instance = new kemUnknownLanguage();
        Character[] list = {'D','A','R','T','C'};
        String[] words = {"ART", "ARC", "AC", "CD", "CART", "CAT"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
    
    @Test
    public void testGetAlphabeitTest5() {
        System.out.println("getAlphabeit all letters but X are added at prefix stage.");
        kemUnknownLanguage instance = new kemUnknownLanguage();
        Character[] list = {'R','T','C','A'};
        String[] words = {"ART", "ARC", "AC", "AA"};
        assertEquals(Arrays.asList(list), instance.getAlphabeit(words));
    }
}
