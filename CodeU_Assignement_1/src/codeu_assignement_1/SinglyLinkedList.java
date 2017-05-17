/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeu_assignement_1;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Karine
 * 
 * Bounds, index and general interface is as in Java LinkedList JavaDoc
 * https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
 * 
 */
public class SinglyLinkedList <E> {
    /*  Inner pojo class Node in the list  */
    public class Node <T>
    {
        protected T data;
        protected Node next;

        /*  Default C'tor  */
        public Node()
        {
            next = null;
            data = null;
        }    
        /*  C'tor  */
        public Node(T d,Node n)
        {
            data = d;
            next = n;
        }    
        // Setters
        public void setNext(Node n) { next = n; }    
        public void setData(T d) { data = d; } 
        
        // Getter
        public Node getNext() { return next; }    
        public T getData() { return data; }
    }
    
    
    /* Data members of LinkedList */
    protected int size=0;
    protected Node m_first=null;
    protected Node m_last=null;
    
    // Default c'tor
    public SinglyLinkedList(){} 

    // C'tor: adds all items of another collection
    public SinglyLinkedList(Collection<? extends E> c) { this.addAll(c); } 
            
    /*  Check if the list is empty  */
    public boolean isEmpty() { return (m_first == null); }

    /*  Get the current size of the list  */
    public int getSize() { return size; }
 
    /*  Add e element in the front/begining of the list  */
    public void addFirst(E e) { addAt(0,e); }
    
    /*  Add e element in the tail/end of the list  */
    public void addLast(E e) { addAt(size,e); }
    
    /*  Add e element at index  */
    public void addAt(int index, E e)
    {        
        // check - index is begger than size or neg.
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
     
        Node n = new Node(e, null);             
                
        // Empty list
        if(m_first == null) 
        {
            m_first = n;
            m_last = m_first;
        }
        // Add to first
        else if (index == 0)
        {
            n.setNext(m_first);
            m_first = n;
        }
        // Add to last
        else if (index == size)
        {
            m_last.setNext(n);
            m_last = n;
        }
        // Add to in the middle
        else 
        {
            Node curr = m_first;
            index -= 1; // i = i-1; to get the item befoer where we add
            for (int i = 0; i < size; i++) 
            {
                if (i == index) 
                {
                    // Before: curr -> next_curr
                    Node next_curr = curr.getNext() ;
                    curr.setNext(n);
                    n.setNext(next_curr);
                    break;
                    // After: curr -> n -> next_curr
                }

                // Go to next
                curr = curr.getNext();
            }
        }
        
        size++ ;
    }
    
    /*
        Add all the items in the collection into the list
        NullPointerException - if the specified collection is null
    */
    public boolean addAll(Collection<? extends E> c)
    {
        if (c == null)
            throw new NullPointerException();
        
        Iterator <? extends E> itr = c.iterator();
        if (!itr.hasNext()) 
            return false;
        
        // If there are items - add them one after another
        while (itr.hasNext()) 
        {
            this.addLast(itr.next());
        }
        
        return (size > 0); // Shall add something
    }
    
    /*  Add e element in the front/begining of the list  */
    public E removeFirst() { return removeAt(0); }
    
    /*  Add e element in the tail/end of the list  */
    public E removeLast() { return removeAt(size-1); }
    
    /*  Add e element at index  */
    public E removeAt(int index)
    {        
        // check - index is begger than size or neg.
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        if (index == 0) // Remove first 
        { 
            E ret = (E) m_first.getData();
            m_first = m_first.getNext();
            size--;
            return ret;
        }
        else if (index == (size -1)) // Remove last
        {
            // Find prev to the last
            Node prev = m_first;
            Node curr = m_first;
            while (curr.getNext() != null)
            {
                prev = curr;
                curr = curr.getNext();
            }
            
            // Return curr, and remove it from the list
            m_last = prev;
            m_last.setNext(null);
            size --;
            
            return (E) curr.getData();
        } 
        else // The general case where 0 < index < (size-1) 
        {
            Node prev = m_first;
            index -= 1 ; // i = i-1; to get the item befoer where we remove
            for (int i = 0; i < size - 2; i++) 
            {
                if (i == index) 
                {
                    // prev -> curr -> next
                    Node curr = prev.getNext();
                    Node next = curr.getNext();
                    prev.setNext(next);
                    curr.setNext(null); // gc 
                    size --;
                    // After: prev -> next
                    
                    return (E) curr.getData();
                }
                prev = prev.getNext();
            }
            
            return null; // Item wasn't found - Error!
        }
    } // End of: public E removeAt(int index)
    
    public E get(int index)
    {
        if (size == 0) return null; // If empty return null
        
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        if (index == 0) // Get first
            return (E) this.m_first.getData();
        else if (index == (size-1)) // Get last
            return (E) this.m_last.getData();
        // The general case
        else  
        {
            Node curr = m_first;
            for (int i = 0; i < size - 1; i++) 
            {
                if (i == index) 
                    return (E) curr.getData();
                
                curr = curr.getNext();
            }
            
            return null;  // Item wasn't found - Error!
        }
    } // End of: public E get(int index)
    
    public int size() { return this.size; }
}
