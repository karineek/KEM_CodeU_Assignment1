/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeu_assignement_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static javafx.scene.input.KeyCode.T;

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
    
    
    /* Add all in BFS order (i.e., Breadth-First Traversal of a Tree) */
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
        final ArrayList<String> dict_temp = new ArrayList<>();
        String p_u = p.toUpperCase();
        m_dict.forEach(str -> {
	    if(str.startsWith(p_u)) 
            {
                dict_temp.add(str);
            }
        });
        
        return (dict_temp.size() > 0);
    }
}
