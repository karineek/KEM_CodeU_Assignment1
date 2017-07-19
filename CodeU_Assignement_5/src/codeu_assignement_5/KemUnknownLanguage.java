package codeu_assignement_5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Karine
 */
public class KemUnknownLanguage {
    /*
     * Input: a alphabetionary (a list of words in lexicographic order) of all words in an unknown/invented language, 
    *  Output: alphabet (an ordered list of characters) of that language, letters we cannot decide are appended in the end.
    */
    public List<Character> getAlphabeit(String[] alienWords) {
        List<Character> alphabet = null;
        if ((alienWords != null) && (alienWords.length > 0)) {
            /* Get the current order by prefix size, starting from 0 */
            alphabet = getBasicAlphaBeit(alienWords, 0); /* Basic Alphabeit */ 
            /* A,R,C from the example! */

            /* Add from prefix while there are letters after first letter of prefix */
            addToDictByPrefixSize(alienWords, alphabet); 

            /* Add all the chars we cannot decide in the end - According to the comments in Slack */
            for (String w : alienWords) {
                for (Character c: w.toCharArray()) {
                    if (!alphabet.contains(c)) {
                        alphabet.add(c);
                    }
                }
            }
        }

        return alphabet;
    }    
    
    /*
     * Inputs: All words with the same prefix (all the first prefixSize chars are the same!)
     * Output: Per common prefix, gets the order of the chars
     *
     * Note: Assume the input is valid here!
    */
    private List<Character> getBasicAlphaBeit(String[] words, int prefixSize) {
        List<Character> ret = new ArrayList(); 
        for (String w : words) {
            if ((w.length() > prefixSize) && (!ret.contains(w.charAt(prefixSize)))) {
                ret.add(w.charAt(prefixSize));
            }
        }   
        
        return ret;
    }
    
    /*
     * Input: the original set of words, current word we are working on, its prefix size
     * Output: the set of the words with this prefix
    */
    private String[] getWordsWithSamePrefix(String[] alienWords, int curr, int prefixSize) {
        ArrayList<String> tempDict = new ArrayList();
        tempDict.add(alienWords[curr]);
        
        String prefix = alienWords[curr].substring(0, prefixSize);
        
        /* Forward search */
        for (int i=curr+1; i<alienWords.length; i++) {
            if (!alienWords[i].startsWith(prefix)) {
                break;
            }       
            tempDict.add(alienWords[i]);
        }
        
        /* Backward search */
        for (int i=curr-1; i >= 0; i--) {
            if (!alienWords[i].startsWith(prefix)) {
                break;
            }
            tempDict.add(0,alienWords[i]); 
        }
        
        return tempDict.toArray(new String[tempDict.size()]);
    }
    
    /*
     * Get two alphabetionary with common latters and merge them into the first alphabet,
     * if none, cannot know, add all these cases later on
     * E.g., we have the current alphabet, A,T,C
     * and withset of rules saying A,R,T to be the new alphabet:
     * A,R,T,C
    */
    private void mergeDict(List<Character> alphabet1, List<Character> alphabet2) {
        int from2 = 0;  /* Start from location 0 in alphabet1 */
        
        /* Pass on alphabet2 and merge it into alphabet1 */
        for (int i=0; i < alphabet2.size(); i++) {
            /* Adds to the alphabet only to satisfy a rule, if not adds all in the end 
              (no rule, or only says "it comes after that symbol", 
               with no restriction of "but it also comes before the other symbol") */
            if (alphabet1.contains(alphabet2.get(i))) { 
                if ((i+1) < alphabet2.size() 
                   && (alphabet1.contains(alphabet2.get(i+1))) 
                   && (alphabet1.indexOf(alphabet2.get(i)) > alphabet1.indexOf(alphabet2.get(i+1)))) {
                    /* Need to fix the order */
                    alphabet1.remove(alphabet2.get(i));
                    alphabet1.add(alphabet1.indexOf(alphabet2.get(i+1)), alphabet2.get(i)); 
                } else {
                    /* Find common point, merge here! */
                    /* Case where we have: */
                    alphabet1.addAll(alphabet1.indexOf(alphabet2.get(i)), alphabet2.subList(from2, i));
                }
                from2 = i+1; /* The next location in alphabet2 to start adding to in alphabet1 */
            }        
        }
        
        /* For all the symbols in alphabet2 that only needs to come after, adds it to the end of alphabet1 */
        if (from2 <= (alphabet2.size()-1)) {
            alphabet1.addAll(alphabet2.subList(from2, alphabet2.size())); /* Add the tail */
        }
    }
    
    /*
     For each length of prefix (1,2,3,4,....(i)), collects all the prefixes
     and if found a new rule adds it to the dictionary
    */
    private void addToDictByPrefixSize(String[] alienWords, List<Character> alphabet) { 
        /* For each size of prefix does the following: */
        for (int i=0; i < alienWords.length; i++) {  /* For each word, do: */
            for (int j=1; j < alienWords[i].length(); j++) { /* For each prefix size */     
                int prefixSize = j;
                String[] sublistWords = getWordsWithSamePrefix(alienWords, i, prefixSize);
                if (sublistWords.length > 1) {
                    List<Character> tempDict = getBasicAlphaBeit(sublistWords, prefixSize);
                    if (!tempDict.isEmpty()) {
                        mergeDict(alphabet,tempDict);
                    }
                } else {
                    break;
                }
            }
        }
    }
}
