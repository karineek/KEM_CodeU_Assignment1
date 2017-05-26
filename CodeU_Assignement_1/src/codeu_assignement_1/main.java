/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeu_assignement_1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Karine
 */
public class main {
    /**
     * @param args the command line arguments
     * 
     * Gives a basic interface to do some partial testing to the code
     * 
     */
    public static void main(String[] args) {
        if (args.length == 0) // run tests!
        {
            run_tests_Q1();
            run_tests_Q2();
            return;
        }
        
        // TODO code application logic here
        System.out.println("Parsing Input... (String1, String2, k2Last and a list of elements)");      
        if (args.length!=4)
        {
            System.out.println("Error: " + args.length 
                    + " parameters only. Expect somthing like: Listen Silen 5 1,2,3,4,5,6,7");      
            return;
        }
         
        // Q1: Run and result
        System.out.println("Q1: " + args[0] 
                + (q1_permutation(args[0],args[1]) ? " is " : " isn't ") 
                + "a permutation of " + args[1]);
        
        // Q2: Run and result
        int k2last = 0;
        try {
            k2last = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Error: " + args[2] 
                    + " is not a number, shall be the k-th to the last location");      
            return;
        }
        
        // Create a list:
        String[] list_user = args[3].split(",");
        SinglyLinkedList<String> intput_list;
        intput_list = new SinglyLinkedList<>(Arrays.asList(list_user));
        
        // Q2: Run and result
        String res = q2_getKthElement(intput_list, k2last); // Incase of error will throw exception before print
        System.out.println("Q2: the " + k2last + "-th to the last element is " + res);
    }
    
    /*
    * Q1: doesn't need a class, a simple method
    * Input is taken from the main parameters
    * Output to the screen
    */
    static boolean q1_permutation(String s1, String s2) 
    {
        // Sanity checks
        if (s1 == null || s2 == null)
            if (s1 == null && s2 == null)
                return true;
            else 
                return false;
        
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
                
        /* Start the algorithm : */
        
        // To array of chars
        char[] t1 = s1.toLowerCase().toCharArray();
        char[] t2 = s2.toLowerCase().toCharArray();
        
        // Order
        Arrays.sort(t1);
        Arrays.sort(t2);
        
        // Compare
        return Arrays.equals(t2, t1);
    } // End Q1
    
    /*
     * Works on my own SinglyLinkedList
     * Index starts from 0 to size-1
     */
    static <E> E q2_getKthElement(SinglyLinkedList<E> l, int k2last) 
    {
        if (l.isEmpty())
            throw new IndexOutOfBoundsException(); // Any index is out of bound
        
        // Gets the k-th location out-of the k-th to the last location
        int k = l.size() - k2last - 1;
        if (k < 0 || k > l.size()) 
            throw new IndexOutOfBoundsException();
    
        return l.get(k);
    } // End Q2
    
    // Some testings to the algorithms
    static void run_tests_Q1()
    {
       String s1 = null;
       String s2 = null;
       System.out.println("Q1: (true) " + s1 + (q1_permutation(s1,s2) ? " is " : " isn't ") 
                + "a permutation of " + s2);
       
       s1 = "";
       System.out.println("Q1: (false) " + s1 + (q1_permutation(s1,s2) ? " is " : " isn't ") 
                + "a permutation of " + s2);
       
       s2 = "";
       System.out.println("Q1: (true) " + s1 + (q1_permutation(s1,s2) ? " is " : " isn't ") 
                + "a permutation of " + s2);
       
       s2 = "a";
       System.out.println("Q1: (false) " + s1 + (q1_permutation(s1,s2) ? " is " : " isn't ") 
                + "a permutation of " + s2);
       
       s1 = null;
       System.out.println("Q1: (false) " + s1 + (q1_permutation(s1,s2) ? " is " : " isn't ") 
                + "a permutation of " + s2);
       
       s1 = "";
       System.out.println("Q1: (false) " + s1 + (q1_permutation(s1,s2) ? " is " : " isn't ") 
                + "a permutation of " + s2);
       
       s1 = "a";
       System.out.println("Q1: (true) " + s1 + (q1_permutation(s1,s2) ? " is " : " isn't ") 
                + "a permutation of " + s2);
       
       s2 = "aa";
       System.out.println("Q1: (false) " + s1 + (q1_permutation(s1,s2) ? " is " : " isn't ") 
                + "a permutation of " + s2);
       
       s1 = "aaa";
       System.out.println("Q1: (false) " + s1 + (q1_permutation(s1,s2) ? " is " : " isn't ") 
                + "a permutation of " + s2);
       
       s2 = "";
       System.out.println("Q1: (false) " + s1 + (q1_permutation(s1,s2) ? " is " : " isn't ") 
                + "a permutation of " + s2);
       
       s1=" ";
       System.out.println("Q1: (false) " + s1 + (q1_permutation(s1,s2) ? " is " : " isn't ") 
                + "a permutation of " + s2);
       
       s1="abc";
       s2="bcd";
       System.out.println("Q1: (false) " + s1 + (q1_permutation(s1,s2) ? " is " : " isn't ") 
                + "a permutation of " + s2);
             
        s1="Listen";
        s2="Silent";
        System.out.println("Q1: (true) " + s1 + (q1_permutation(s1,s2) ? " is " : " isn't ") 
                + "a permutation of " + s2);
       
       
        s1="Triangle";
        s2="Integral";
        System.out.println("Q1: (true) " + s1 + (q1_permutation(s1,s2) ? " is " : " isn't ") 
                + "a permutation of " + s2);
       
        s1="Apple";
        s2="Pabble";
        System.out.println("Q1: (false) " + s1 + (q1_permutation(s1,s2) ? " is " : " isn't ") 
                + "a permutation of " + s2);
    }
    
    // Some testings to the algorithms
    static void run_tests_Q2()
    {
        String str_list = "34,9,8,10,1,2,-1,99";
        run_test_Q2(str_list, 1);
        run_test_Q2(str_list, 0);
        run_test_Q2(str_list, 2);
        run_test_Q2(str_list, 7);
        
        str_list = "99";
        run_test_Q2(str_list, 0);
        
        str_list = "55,1";
        run_test_Q2(str_list, 1);
        run_test_Q2(str_list, 0);
        
        str_list = "34,9,8,10,1,2,-1,99,3";
        run_test_Q2(str_list, 1);
        run_test_Q2(str_list, 0);
        run_test_Q2(str_list, 2);
        run_test_Q2(str_list, 7);

        // General testing
        System.out.println(">> Starts General testing for SinglyLinkedList: ");
        SinglyLinkedList<Integer> my_list;
        my_list = new SinglyLinkedList<>();
        my_list.addFirst(1);
        my_list.addFirst(2);
        my_list.addFirst(3);
        my_list.addFirst(4);
        my_list.addFirst(4);
        my_list.addFirst(5);
        my_list.removeAt(5);
        
        System.out.println("> Last item is: " + my_list.get(my_list.size()-1));
        System.out.println("> First item is: " + my_list.get(0));
        System.out.println("> 2-3 items are: " + my_list.get(1) + ", " + my_list.get(2));
        System.out.println("> Last was " + my_list.removeLast() + 
                " and now is " + my_list.get(my_list.size()-1));
        
        if (my_list.size !=0)
            System.out.println("> First was " + my_list.removeFirst() + 
                " and now is " + my_list.get(0));
        
        if (my_list.size !=0)
            System.out.println("> Last was " + my_list.removeLast() + 
                " and now is " + my_list.get(my_list.size()-1));
        
        if (my_list.size !=0)
            System.out.println("> First was " + my_list.removeFirst() + 
                " and now is " + my_list.get(0));  
        
        if (my_list.size !=0)
            System.out.println("> Last was " + my_list.removeLast() + 
                " and now is " + my_list.get(my_list.size()-1));
        
        if (my_list.size !=0)
            System.out.println("> First was " + my_list.removeFirst() + 
                    " and now is " + my_list.get(0));
    }
        
    static void run_test_Q2(String str_list, int k2last)
    {
        String[] intput_list = str_list.split(",");
        
        SinglyLinkedList<String> my_list;
        my_list = new SinglyLinkedList<>(Arrays.asList(intput_list));
        
        LinkedList<String> _list;
        _list = new LinkedList<>(Arrays.asList(intput_list));
        
        // Q2: Run and result
        String res = q2_getKthElement(my_list, k2last); // Incase of error will throw exception before print
        String _res = test_getKthElement(_list, k2last);
        System.out.println("Q2: the " + k2last + "-th to the last element is " 
                + res + ((res.compareTo(_res) == 0) ? " and correct result" : " and not correct result"));
        
    }

    /*
     * Works on Java LinkedList - to test the result is the 
     * same as with my own container!
     * Index starts from 0 to size-1
     */    
    static <E> E test_getKthElement(LinkedList<E> l, int k2last) 
    {
        if (l.isEmpty())
            throw new IndexOutOfBoundsException(); // Any index is out of bound
        
        // Gets the k-th location out-of the k-th to the last location
        int k = l.size() - k2last - 1;
        if (k < 0 || k > l.size()) 
            throw new IndexOutOfBoundsException();
    
        return l.get(k);
    } // End Q2
}
