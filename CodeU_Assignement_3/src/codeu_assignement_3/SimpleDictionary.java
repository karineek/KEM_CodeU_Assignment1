package codeu_assignement_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Karine
 * Simple dictionary only for testing
 * 
 * Consider using mocked dictionary instead of this implementation
 * 
 */
public class SimpleDictionary implements KemDictionary 
{
    /* Dictionary as an array */
    private final ArrayList<String> m_dict = new ArrayList<>(); 
    
    public SimpleDictionary(String[] wordsInDict)
    {
        if (wordsInDict != null)
        {
            List<String> temp = Arrays.asList(wordsInDict);
            temp.replaceAll(String::toUpperCase);
            m_dict.addAll(temp);
        }
    }
    
    /* 
       Returns whether the given string is a valid word 
    */
    @Override
    public boolean isWord (String w)
    {
        return m_dict.contains(w.toUpperCase());
    }
    
    
    /* 
       Returns whether the given string is a prefix of at 
       least one word in thedictionary 
    */
    @Override
    public boolean isPrefix (String p)
    {
        if (isWord(p)) 
        {
            return true;
        }
        
        /* Else search if is a prefix */
        String p_u = p.toUpperCase();
        for (int i=0; i< m_dict.size(); i++)
        {
            if (m_dict.get(i).startsWith(p_u))
            {
                return true;
            }
        }
        
        return false;
    }
}
