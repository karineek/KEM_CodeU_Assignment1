package codeu_assignement_3;

/**
 *
 * @author Karine
 * 
 * Interface of a dictionary 
 * Contains to methods: isWord and isPrefix
 */
public interface KemDictionary 
{
    /* 
       Returns whether the given string is a valid word 
    */
    public boolean isWord (String w);
    
    
    /* 
       Returns whether the given string is a prefix of at 
       least one word in thedictionary 
    */
    public boolean isPrefix (String p);
}
