package codeu_assignement_4;

/**
 *
 * @author Karine
 * 
 * The class is an Algorithm that starts from the only public method countIslands which 
 * gets: a map and the size of the map (rxc) and returns the number of Islands in the map
 */
public class KEMIslandsFinder {
    
    private boolean[][] visistedMap;
    
    public int countIslands(int row, int col, boolean[][] map)
    {        
        if ((row > 0) && (col > 0))
        {
            if ((map.length == row) && (map[0].length == col))
            {
                visistedMap = new boolean[row][col];
                return countIslands(map, 0, 0);
            } 
            else
            {
                throw new IllegalArgumentException();
            }
        }
        
        return 0;
    }
    
    /* Private Helpers */
    private int countIslands(boolean[][] map, int curr_row, int curr_col)
    {
        int currentNumberOfIslands = 0;
        
        currentNumberOfIslands += countNewIsland(map,curr_row,curr_col);
        markIslandAsVisited(map,curr_row,curr_col);
        
        /* Move to the next location */
        if ((curr_col+1) < map[curr_row].length)
        {
            currentNumberOfIslands += countIslands(map, curr_row, curr_col + 1);
        }     
        else if ((curr_row+1) < map.length)
        {
            currentNumberOfIslands += countIslands(map, curr_row + 1, 0);
        } 
        else 
        {
            /* Recursion End */
        }
        
        return currentNumberOfIslands;
    }
    
    private void markIslandAsVisited(boolean[][] map, int curr_row, int curr_col)
    {
        /* Stop marking as one Island, if out of bound, marked or not an island */
        if ((map.length <= curr_row) || (curr_row < 0) || (curr_col < 0))
        {
            return;
        }
        if ((map[curr_row].length <= curr_col)
            || (!map[curr_row][curr_col])      
            || (visistedMap[curr_row][curr_col]))
        {
            return;
        }
        
        visistedMap[curr_row][curr_col] = true;
        for (int i = -1; i < 2; i++)
        {
            markIslandAsVisited(map,curr_row+i,curr_col);
            markIslandAsVisited(map,curr_row,curr_col+i);
        }
    }
    
    private int countNewIsland(boolean[][] map, int curr_row, int curr_col)
    {
        return ((map[curr_row][curr_col]) && 
                (!visistedMap[curr_row][curr_col])) ? 1 : 0;
    }
}
