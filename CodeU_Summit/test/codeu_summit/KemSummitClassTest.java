package codeu_summit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karine
 */
public class KemSummitClassTest {
    
    public KemSummitClassTest() {
    }
    
    /**
     * Test of kemMainAlg method, of class KemSummitClass.
     */
    @Test
    public void testKemMainAlg() {
        System.out.println("kemMainAlg");
        int x = 0;
        int y = 0;
        KemSummitClass instance = new KemSummitClass();
        int expResult = 1;
        int result = instance.kemMainAlg(x, y);
        assertEquals(expResult, result);
    }
    
}
