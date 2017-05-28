package codeu_assignement_1;

import java.util.Collection;

/**
 *
 * @author Karine
 * 
 * Bounds, index and general interface is as in Java LinkedList JavaDoc
 * https:/*docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
 * 
 */
public class SinglyLinkedList <E> {
    /*  Inner pojo class Node in the list  */
    public class Node
    {
        private E data=null;
        private Node next=null;
        public Node(E d,Node n)
        {
            data = d;
            next = n;
        }    
        /* Setters */
        public void setNext(Node n) { next = n; }    
        public void setData(E d) { data = d; } 
        
        /* Getter */
        public Node getNext() { return next; }    
        public E getData() { return data; }
    }
    
    
    /* Data members of LinkedList */
    protected int size=0;
    protected Node m_first=null;
    protected Node m_last=null;
    
    /* */
    public SinglyLinkedList(){} 

    /* C'tor: adds all items of another collection */
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
        /* check - index is begger than size or neg. */
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
     
        Node n = new Node(e, null);             
                
        /* Empty list */
        if(m_first == null) 
        {
            m_first = n;
            m_last = m_first;
        }
        /* Add to first */
        else if (index == 0)
        {
            n.setNext(m_first);
            m_first = n;
        }
        /* Add to last */
        else if (index == size)
        {
            m_last.setNext(n);
            m_last = n;
        }
        /* Add to in the middle */
        else 
        {
            Node curr = m_first;
            index -= 1; /* i = i-1; to get the item befoer where we add */
            for (int i = 0; i < size; i++) 
            {
                if (i == index) 
                {
                    /* Before: curr -> next_curr */
                    Node next_curr = curr.getNext() ;
                    curr.setNext(n);
                    n.setNext(next_curr);
                    break;
                    /* After: curr -> n -> next_curr */
                }

                /* Go to next */
                curr = curr.getNext();
            }
        }
        
        size++ ;
    }
    
    /*
        Add all the items in the collection into the list
        NullPointerException - if the specified collection is null
    
        According to JAVA LinkedList: (docs/api/java/util/LinkedList.html)
        "Appends all of the elements in the specified collection to the end 
        of this list, in the order that they are returned by the specified 
        collection's iterator.
    
        Parameters:
            c - collection containing elements to be added to this list
        Returns:
            true if this list changed as a result of the call
        "
    */
    public boolean addAll(Collection<? extends E> c)
    {
        if (c == null)
            throw new NullPointerException();
        
        if (c.isEmpty()) return false;
        
        /* If there are items - add them one after another */
        c.forEach((i) -> {
            this.addLast(i);
        });
        
        return (size > 0); /* Shall add something */
    }
    
    /*  Remove e element in the front/begining of the list  */
    public E removeFirst() { return removeAt(0); }
    
    /*  Remove e element in the tail/end of the list  */
    public E removeLast() { return removeAt(size-1); }
    
    /*  Remove e element at index  */
    public E removeAt(int index)
    {        
        /* check - index is begger than size or neg. */
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        if (index == 0) /* Remove first */
        { 
            E ret = m_first.getData();
            m_first = m_first.getNext();
            size--;
            return ret;
        }
        else if (index == (size -1)) /* Remove last */
        {
            /* Find prev to the last */
            Node prev = m_first;
            Node curr = m_first;
            while (curr.getNext() != null)
            {
                prev = curr;
                curr = curr.getNext();
            }
            
            /* Remove curr from the list and return it */
            m_last = prev;
            m_last.setNext(null);
            size --;
            
            return curr.getData();
        } 
        else /* The general case where 0 < index < (size-1)  */
        {
            Node prev = m_first;
            index -= 1 ; /* i = i-1; to get the item befoer where we remove */
            for (int i = 0; i < size - 2; i++) 
            {
                if (i == index) 
                {
                    /* prev -> curr -> next */
                    Node curr = prev.getNext();
                    Node next = curr.getNext();
                    prev.setNext(next);
                    curr.setNext(null); /* gc */
                    size --;
                    /* After: prev -> next */
                    
                    return curr.getData();
                }
                prev = prev.getNext();
            }
            
            return null; /* Item wasn't found - Error! */
        }
    } /* End of: public E removeAt(int index) */
    
    /* Returns the element in index location */ 
    public E get(int index)
    {
        /* Checks the the index is in the bounds of the list */ 
        if (size == 0) 
            throw new IndexOutOfBoundsException(); 
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        if (index == 0) /* Get first */
            return this.m_first.getData();
        else if (index == (size-1)) /* Get last */
            return this.m_last.getData();
        /* The general case */
        else  
        {
            Node curr = m_first;
            for (int i = 0; i < size - 1; i++) 
            {
                if (i == index) 
                    return curr.getData();
                
                curr = curr.getNext();
            }
            
            return null;  /* Item wasn't found - Error! */
        }
    } /* End of: public E get(int index) */
    
    public int size() { return this.size; }
}
