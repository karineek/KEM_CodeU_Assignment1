package codeu_assignement_5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Karine
 */
public class KemUnknownLanguage {
    /*
     * Input: a dictionary (a list of words in lexicographic order) of all words in an unknown/invented language, 
    *  Output: alphabet (an ordered list of characters) of that language, letters we cannot decide are appended in the end.
    */
    public List<Character> getAlphabeit(String[] alienWords) {
        if ((alienWords != null) && (alienWords.length > 0)) {
           return extractAlphabeitFromWords(alienWords);
        }
        
        return null;
    }

    private List<Character> extractAlphabeitFromWords(String[] alienWords) {
        /* Get the current order by prefix size, starting from 0 */
        List<Character> dict = getBasicAlphaBeit(alienWords, 0); /* Basic Alphabeit */ 
        /* A,R,C from the example! */

        /* Add from prefix while there are letters after first letter of prefix */
        while (!addToDictByPrefix(alienWords, dict)){} 

        /* Add all the chars we cannot decide in the end*/
        for (String w : alienWords) {
            for (Character c: w.toCharArray()) {
                if (!dict.contains(c)) {
                    dict.add(c);
                }
            }
        }
        
        return dict;
    }
    
    
    /*
     * Inputs: All words with the same prefix (all the first prefixSize chars are the same!)
     * Output: Per common prefix, gets the order of the chars
     *
     * Note: Assume the input is valid here!
    */
    private List<Character> getBasicAlphaBeit(String[] words, int prefixSize) {
        List<Character> ret = new ArrayList(); 
        if (words == null) {
            return ret;
        }
        
        for (String w : words) {
            if ((w.length() > prefixSize) && (!ret.contains(w.charAt(prefixSize)))) {
                ret.add(w.charAt(prefixSize));
            }
        }   
        
        return ret;
    }
    
    /*
     * Gives the prefix of a char that isn't in the dictionary
    */
    private int getSizeOfPrefix(String w, List<Character> dict) {
        for (int i=0; i < w.length(); i++) {
            if (!dict.contains(w.charAt(i))) {
                return i;
            }
        }
        
        return w.length();
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
     * Get two dictionary with common latters and merge them into the first dict,
     * if none, cannot know, add all these cases later on
    */
    private void mergeDict(List<Character> dict1, List<Character> dict2) {
        int from2 = 0;  
        for (int i=0; i < dict2.size(); i++) {
            if (dict1.contains(dict2.get(i))) {
                /* Find common point, merge here! */
                dict1.addAll(dict1.indexOf(dict2.get(i)), dict2.subList(from2, i));
                from2 = i+1;
            }        
        }
    }
    
    private boolean addToDictByPrefix(String[] alienWords, List<Character> dict) {
        boolean hasReachMaxPrefix = true;
        for (int i=0; i < alienWords.length; i++) {
            int prefixSize = getSizeOfPrefix(alienWords[i], dict);
            if (prefixSize != alienWords[i].length()) {
                String[] sublistWords = getWordsWithSamePrefix(alienWords, i, prefixSize);
                if (sublistWords.length > 1) {
                    List<Character> tempDict = getBasicAlphaBeit(sublistWords, prefixSize);
                    if (!tempDict.isEmpty()) {
                        int dictSize = dict.size();
                        mergeDict(dict,tempDict);
                        if (dictSize != dict.size()) {
                            hasReachMaxPrefix = false;
                        }
                    }
                }
            }
        }
        
        return hasReachMaxPrefix;
    }
}
