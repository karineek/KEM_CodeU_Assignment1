package codeu_assignment_6;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.util.Pair;

/**
 *
 * @author Karine
 */
public class KemRearrangingCars {
    
    /**
     * Inputs: two arrays, each with a permutation of the numbers 0 to N,
     * where permutationA is the current parking lot state, and permutationB is
     * the desired parking lot state.
     * 
     * Output: A series of moves, which leads from permutationA to permutationB
     * 
     * Process: 
     * 
     *  Time Complexity: O(n)
     *  Memory Compelxity: O(n) 
     *  (2 arrays of size n + and array of steps size (n-1) max.)
     * 
     * @param permutationA
     * @param permutationB
     * @return The return value is pairs of moves ordered from 0 to size of the array,
     * from where the item was to the free location.
     */
    public ArrayList<Pair<Integer,Integer>> getMovesRearrangingCars(Integer[] permutationA, Integer[] permutationB) {
        if (!isValidInput(permutationA,permutationB)) {
            return null;
        }
        
        ArrayList<Pair<Integer,Integer>> moveSeries = new ArrayList<>(); 
        Integer[] lotCurrState = Arrays.copyOf(permutationA, permutationA.length); /* Deep copy */
        int n = lotCurrState.length;
        
        /* Say we wish to swap 3 with 0 (as in the example), we need to find 3 
           We keep the indeces of each element to so in O(1) - we update these
           indeces till the end of the algorithm to keep the performance
        */ // 1,2,0,3 => 2,0,1,3
        Integer[] currIndexToElements = new Integer[n];
        for (int i=0; i<n; i++) {
            currIndexToElements[permutationA[i]] = i;
        }
        
        /* Only for the first time need to find where is the 0 */
        int currZeroLocation = currIndexToElements[0];        
        
        /* Till lotCurrState is not equal to permutationB, max steps n-1 */
        for (int i=0; i<n; i++) {
            if (lotCurrState[i] != permutationB[i]){
                /* If location is not free, move the item there */
                currZeroLocation = swap(lotCurrState[i], currZeroLocation, currIndexToElements, lotCurrState, moveSeries);

                /* swap the right item into location i (excpet in the case of 0) */
                currZeroLocation = swap(permutationB[currZeroLocation], currZeroLocation, currIndexToElements, lotCurrState, moveSeries);
            }
        }
        
        /* The return value is pairs of moves ordered from 0 to size of the array */
        return moveSeries;
    }
    
    /**
     * Return false if the input is invalid (null, not the same size...) 
     * 
     * If required, you may add here throw of exceptions
     */
    private boolean isValidInput(Integer[] permutationA, Integer[] permutationB) {
        if ((permutationA == null) || (permutationB == null)) {
            return false;
        }
        if (permutationA.length != permutationB.length) {
            return false;
        }
        for (int i=0;i<permutationA.length;i++) {
            if (permutationA[i] >= permutationA.length) {
                return false;
            }
            if (permutationB[i] >= permutationB.length) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Process: swap two items in location of the currToSwap and the free space
     * @return the location of the free space after the swap
     */
    private int swap(int currToSwap, int currZeroLocation, 
            Integer[] currIndexToElements, Integer[] lotCurrState, ArrayList<Pair<Integer,Integer>> moveSeries) {
        if (currToSwap == 0) {
            return currZeroLocation;
        }
        
        /* Find the location of the item to swap to current location */
        int locationCurrToSwap = currIndexToElements[currToSwap];
                    
        /* Swap! */
        lotCurrState[currZeroLocation] = currToSwap;
        lotCurrState[locationCurrToSwap] = 0;

        /* Update the output moves */
        Pair<Integer,Integer> move = new Pair<>(locationCurrToSwap, currZeroLocation);
        moveSeries.add(move);

        /* Update the indeces */
        currIndexToElements[currToSwap] = currZeroLocation;
        currIndexToElements[0] = locationCurrToSwap;

        /* Will do out: currZeroLocation = locationCurrToSwap; */
        return locationCurrToSwap;
    }
    
    public ArrayList<Pair<Integer,Integer>> getMovesRearrangingCarsAndPrint(Integer[] permutationA, Integer[] permutationB) {
        ArrayList<Pair<Integer,Integer>> moves = getMovesRearrangingCars(permutationA, permutationB);
         
        if (moves != null) {
            moves.forEach(t->System.out.println("move from " + t.getKey() + " to " + t.getValue()));
        }
         
        return moves;
    }
}
