package codeu_assignement_3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Karine
 */
public class KemWordSearch 
{
    private KemDictionary m_dictionary;
    
    public KemWordSearch (KemDictionary dictionary) 
    {
        m_dictionary = dictionary; 
        /* To search word must init first with the dictionary we wish to search in */
    }
    
    /*
    Input: the number of rows, number of columns, a 2-dimensional array of characters (of the native char data type)
    
    Process: 
    
    Output: return the set of all-words found
    */
    String[] wordSearch(int row, int col, char[][] grid)
    {
        /* Corner cases */ 
        if (grid == null) {
            return null;
        }
        
        ArrayList<String> ret_temp = new ArrayList<>();

        /* Search for all possible strings from the grid */
        for (int r = 0 ; r < row; r++)
        {
            for (int c = 0 ; c < row; c++)
            {
                /* Search for all the words from a specific location */
                String[] ret_inner 
                        = wordSearchFromPossition(row,col,grid,r,c,"");
                ret_temp.addAll(Arrays.asList(ret_inner));
            }
        }
        
        /* Return the set from any start point */
        String[] ret = ret_temp.toArray(new String[0]);
        return ret;
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
    private String[] wordSearchFromPossition(int row, int col, char[][] grid, 
                                    int row_curr, int col_curr, String prefix)
    {
        /* End of the recursion condition */
        if ((row_curr == row) || (col_curr == col)) 
        {
            return null;
        }
        
        if ((row_curr < 0) || (col_curr < 0))
        {
            return null;
        }
        
        /* If was here and use this possition (r,c) exit, cannot use twice */
        if (grid[row_curr][col_curr] == '-')
        {
            return null;
        }
        
        /* Create the current prefix to check if it is a valid prefix */
        String new_prefix = prefix + grid[row_curr][col_curr];
        if (!m_dictionary.isPrefix(new_prefix))
        {
            return null; 
        }
        
        /* If it is a prefix of a word in the dictionary, try to add words */
        ArrayList<String> ret_temp = new ArrayList<>();
        
        /* Current cell */
        if (m_dictionary.isWord(new_prefix))
        {
            ret_temp.add(new_prefix);
        }
        
        /* Mark the current cell as USED */
        char current = grid[row_curr][col_curr];
        grid[row_curr][col_curr] = '-';
        
        /* Call in recurssion to search in all near posstions */
        ret_temp.addAll(Arrays.asList(wordSearchFromPossition
                            (row,col,grid,row_curr -1,col_curr,new_prefix)));
        ret_temp.addAll(Arrays.asList(wordSearchFromPossition
                            (row,col,grid,row_curr +1,col_curr,new_prefix)));
        ret_temp.addAll(Arrays.asList(wordSearchFromPossition
                            (row,col,grid,row_curr,col_curr -1,new_prefix)));
        ret_temp.addAll(Arrays.asList(wordSearchFromPossition
                            (row,col,grid,row_curr,col_curr +1,new_prefix)));
        ret_temp.addAll(Arrays.asList(wordSearchFromPossition
                            (row,col,grid,row_curr -1,col_curr -1,new_prefix)));
        ret_temp.addAll(Arrays.asList(wordSearchFromPossition
                            (row,col,grid,row_curr -1,col_curr +1,new_prefix)));
        ret_temp.addAll(Arrays.asList(wordSearchFromPossition
                            (row,col,grid,row_curr +1,col_curr -1,new_prefix)));
        ret_temp.addAll(Arrays.asList(wordSearchFromPossition
                            (row,col,grid,row_curr +1,col_curr +1,new_prefix)));        
        
        /* Free the current location to be used in other search, that didn't use it yet! */
        grid[row_curr][col_curr] = current;
        
        /* Return the strings from a single starting point */
        String[] ret = ret_temp.toArray(new String[0]);
        return ret;
    }
}
