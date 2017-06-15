package codeu_assignement_3;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Karine
 */
public class KemWordSearch 
{
    /*
    Input: the number of rows, number of columns, 
           a 2-dimensional array of characters (of the native char data type)
           a dictionary
    
    Process: 
    
    Output: return the set of all-words found
    */
    String[] wordSearch(int row, int col, char[][] grid, KemDictionary dictionary)
    {
        /* Corner cases */ 
        if (grid == null) {
            return null;
        }
        if (dictionary == null)
        {
            return null;
        }
        
        HashSet<String> ret_temp = new HashSet<>();

        /* Search for all possible strings from the grid */
        for (int r = 0; r < row; r++)
        {
            for (int c = 0; c < col; c++)
            {
                /* Search for all the words from a specific location and add then to the ret container */
                ret_temp.addAll(wordSearchFromPossition(row,col,grid,dictionary,r,c,""));
            }
        }
        
        /* Return the set from any start point */
        return (ret_temp.isEmpty()) ? (new String[0]) : (ret_temp.toArray(new String[0]));
    }
    
    /*
     * Input: the number of rows, 
              the number of columns, 
              a 2-dimensional array of characters (of the native char data type),
              the current possition on the grid of the search,
              the prefix so far of this search
    
        Check if we use this tile or to the edge of the grid (if so return null - as
        there are no words to generate). If can use the current tile, creates a new
        updated prefix and check if it is a valid prefix.
        If valid, also check if a valid word, and call rec with all 8 tiles around
       
        output: All the possible word of the current prefix. 
    */
    private HashSet<String> wordSearchFromPossition(int row, int col, char[][] grid,
                                    KemDictionary dictionary,
                                    int row_curr, int col_curr, String prefix)
    {        
        /* End of the recursion condition */
        if ((row_curr == row) || (col_curr == col)) 
        {
            return new HashSet<>();
        }
        
        if ((row_curr < 0) || (col_curr < 0))
        {
            return new HashSet<>();
        }
        
        /* If was here and use this possition (r,c) exit, cannot use twice */
        if (grid[row_curr][col_curr] == '-')
        {
            return new HashSet<>();
        }
        
        /* Create the current prefix to check if it is a valid prefix */
        String new_prefix = prefix + grid[row_curr][col_curr];
        if (!dictionary.isPrefix(new_prefix))
        {
            return new HashSet<>();
        }
        
        /* If it is a prefix of a word in the dictionary, try to add words */
        HashSet<String> ret_temp = new HashSet<>();
        
        /* Current cell */
        if (dictionary.isWord(new_prefix))
        {
            ret_temp.add(new_prefix);
        }
        
        /* Mark the current cell as USED */
        char current = grid[row_curr][col_curr];
        grid[row_curr][col_curr] = '-';
        
        /* Call in recurssion to search in all near posstions */
        for (int r_i = -1; r_i < 2; r_i++)
        {
            for (int c_j = -1; c_j < 2; c_j++)
            {
                /* Search for all the words from a specific location and add then to the ret container */
                ret_temp.addAll(wordSearchFromPossition
                        (row, col, grid,dictionary, 
                                row_curr + r_i, col_curr + c_j,
                                new_prefix));
            }
        }      
        
        /* Free the current location to be used in other search, that didn't use it yet! */
        grid[row_curr][col_curr] = current;
        
        /* Return the strings from a single starting point */
        return ret_temp;
    }
}
