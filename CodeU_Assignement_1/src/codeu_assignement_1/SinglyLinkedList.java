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
    public class Node <T>
    {
        private T data=null;
        private Node<T> next=null;
        public Node(T d,Node n)
        {
            data = d;
            next = n;
        }    
        /* Setters */
        public void setNext(Node<T> n) { next = n; }    
        public void setData(T d) { data = d; } 
        
        /* Getter */
        public Node<T> getNext() { return next; }    
        public T getData() { return data; }
    }
    
    
    /* Data members of LinkedList */
    protected int size=0;
    protected Node<E> m_first=null;
    protected Node<E> m_last=null;
    
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
     
        Node<E> n = new Node<>(e, null);             
                
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
            Node<E> curr = m_first;
            for (int i = 0; i < index; i++) 
            {
                /* Go to next index times */
                curr = curr.getNext();
            }
            
            /* Before: curr -> next_curr */
            Node<E> next_curr = curr.getNext() ;
            curr.setNext(n);
            n.setNext(next_curr);
            /* After: curr -> n -> next_curr */
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
    public final boolean addAll(Collection<? extends E> c)
    {
        if (c == null)
            throw new NullPointerException();
        
        if (c.isEmpty()) return false;
        
        /* If there are items - add them one after another */
        int prev_size = size;
        c.forEach((i) -> {
            this.addLast(i);
        });
        
        return ((size > 0) && (size > prev_size)); /* Shall add something */
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
            Node<E> temp = m_first;
            m_first = m_first.getNext();
            size--;
            temp.setNext(null); /* gc */
            return ret;
        }
        else if (index == (size -1)) /* Remove last */
        {
            /* Find prev to the last */
            Node<E> prev = m_first;
            Node<E> curr = m_first;
            while (curr.getNext() != null)
            {
                prev = curr;
                curr = curr.getNext();
            }
            
            /* Remove curr from the list and return it */
            m_last = prev;
            m_last.setNext(null);
            size --;
            
            curr.setNext(null); /* gc */
            return curr.getData();
        } 
        else /* The general case where 0 < index < (size-1)  */
        {
            Node<E> prev = m_first;
            E ret_val = null;
            index -= 1 ; /* i = i-1; to get the item befoer where we remove */
            for (int i = 0; (i < size - 2); i++) 
            {
                if (i == index) 
                {
                    /* prev -> curr -> next */
                    Node<E> curr = prev.getNext();
                    Node<E> next = curr.getNext();
                    prev.setNext(next);
                    curr.setNext(null); /* gc */
                    size --;
                    /* After: prev -> next */
                    
                    ret_val = curr.getData();
                    break;
                }
                else 
                {
                    prev = prev.getNext();
                }
            }
            
            return ret_val; /* Item wasn't found - Error! */
        }
    } /* End of: public E removeAt(int index) */
    
    /* 
    Returns the element in index location 
    */ 
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
            Node<E> curr = m_first;
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
