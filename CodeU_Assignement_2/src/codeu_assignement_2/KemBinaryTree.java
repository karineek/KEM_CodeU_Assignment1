package codeu_assignement_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * @author Karine
 * 
 * Binary tree with a tree node
 * Each node points to parent, and left/right child
 * 
 */
public class KemBinaryTree <E> {
    /* Data members of Tree */
    protected KemTreeNode<E> m_root=null;
    
    /* */
    public KemBinaryTree(){} 
            
    /*  Check if the list is empty  */
    public boolean isEmpty() { return (m_root == null); }
    
    /* Allow us to decide where to add items */
    public KemTreeNode<E> getRoot() { return m_root;}
    
    /* Q1: Get all ancestors */
    public void printAncestors(KemTreeNode<E> child)
    {  
        /* Check if child isn't null */
        if (child == null)
        {
            System.out.println("Error: ** Null Pointer **");
            return;
        }
        
        /* Check if child isn't root */
        KemTreeNode<E> curr = child.getParent();
        if (curr == null)
        {
            System.out.println("** Root **: has no ancestors. Done.");
            return;
        }
        
        /* Print all ancestors as long as didn't get to root */
        while (curr != null)
        {
            System.out.print(curr.getData());
            curr = curr.getParent();
            if (curr != null)
                System.out.print(",");
        }
        System.out.println(". Done printAncestors(..).");
    }

    /* Q2: Get all ancestors */
    public KemTreeNode<E> getLowestCommonAncestors(KemTreeNode<E> child1, KemTreeNode<E> child2)
    {
        /* No common if at least one is null */
        if (child1 == null || child2 == null)
            return null;
        
        /* If one of them is the root - return it as the common */
        if (child1 == m_root || child2 == m_root)
            return m_root;
        
        /* Create a trace from child to root, and then return the last 
           Common node onKemTreeNode the prefixes */
        Stack<KemTreeNode<E>> st_c1 = getTraceChild2Root(child1);
        Stack<KemTreeNode<E>> st_c2 = getTraceChild2Root(child2);
        
        KemTreeNode<E> common = null;
        while(!st_c1.empty() && !st_c2.empty())
        {
            KemTreeNode<E> c1 = st_c1.pop();
            KemTreeNode<E> c2 = st_c2.pop();
            if (c1 != c2) return common;
            
            common = c1; /* when c1=c2 */
        }
        
        /* return common, incase one stack is smaller than other, and we
        Get to the last item in the smaller stack, which says it is the common */
        return common;
    }
    
    /* Create the trace from child to root, including the root and the child */
    private Stack<KemTreeNode<E>> getTraceChild2Root(KemTreeNode<E> child)
    {
        if (m_root == null) return null;
        
        /* Create the trace */
        Stack<KemTreeNode<E>> st_c = new Stack();
        KemTreeNode<E> curr = child;
        while (curr != null)
        {
            st_c.push(curr);
            curr = curr.getParent();
        }
        
        return st_c;
    }
       
    /* Check if a node is in the tree */
    public boolean exist(KemTreeNode<E> n)
    {
        /* Go over the tree in pre-order */
        if (m_root!=null)
            return exist(n,m_root);
        else
            return false; /* Nothing is in an empty tree, returns false */
    } 
    
    /* Check if a node is in the tree - Helper method for the recursion */
    private boolean exist(KemTreeNode<E> n, KemTreeNode<E> curr)
    {
        /* Go over the tree in pre-order */
        if (curr!=null)
        {
            if (curr.equals(n)) return true;
            
            /* Check if in Left or Right sub-trees */
            if (exist(n,curr.getLeft())) return true;
            if (exist(n,curr.getRight())) return true;        
        }
        
        /* If didn't find so far - return false */
        return false;
    }

    /* From Root, print in pre-order the tree */
    public void printTree()
    {
        /* Go over the tree in pre-order */
        if (m_root!=null) 
        {
            System.out.println("Tree: ");
            printTree(m_root, "");
        }
        else
            System.out.println("** Tree is Empty **");
        
        System.out.println();
    } 
    
    /* Check if a node is in the tree - Helper method for the recursion
       Print in Pre-order */
    private void printTree(KemTreeNode<E> curr, String indent)
    {
        /* Go over the tree in pre-order */
        if (curr!=null)
        {
            System.out.println(indent+"|"+curr.getData());
            
            /* Check if in Left or Right sub-trees */
            printTree(curr.getLeft(), indent+" ");
            printTree(curr.getRight(), indent+" ");        
        }
    }
    
    /*  Add e element to a node indicating
     * Where? Child of Parent
     * How? if is2Left add child as left of parent, else as right of parent
     * if is2LeftChild - add the original child of parent as left of child (else as right of child)
    */ 
    public void addAt(KemTreeNode<E> parent, E child_data, boolean is2Left, boolean is2LeftChild)
    {             
        /* Check that the parents CAN be in the tree (not null tree) */
        if (parent != null && m_root == null)
             throw new NullPointerException("No tree found. Root is null.");   
            
        /* Creat a new node - child */
        KemTreeNode<E> child = new KemTreeNode<>(child_data, null,null,null);   
             
        /* Set the child as root (empry tree) */
        if (parent == null && m_root == null)
        {
            m_root = child;
            return;
        }
        
        /* Replace the root with child, the root will be the child of child */
        if (parent == null && m_root != null)
        {
            if (is2LeftChild)
                child.setLeft(m_root);
            else
                child.setRight(m_root);
            m_root = child;
            return;
        }
                
        /* The general case - where the root and parent aren't null! */
        if (parent == null || m_root == null)
             throw new NullPointerException(); 
        
        /* Check if the parent is in the tree */
        if (!this.exist(parent))
            throw new IllegalArgumentException();
        
        /* Add the child */
        KemTreeNode<E> tempL=parent.getLeft();
        KemTreeNode<E> tempR=parent.getRight();
       
        child.setParent(parent);
        if (is2Left && (tempL==null))
        {
            parent.setLeft(child);
        }
        else if (!is2Left && (tempR==null))
        {
            parent.setRight(child);
        }
        else /* General case */
        {
            if (is2Left && is2LeftChild) setLL(parent,child,tempL);
            else if (is2Left && (!is2LeftChild)) setLR(parent,child,tempL);
            else if ((!is2Left) && is2LeftChild) setRL(parent,child,tempR);
            else if ((!is2Left) && (!is2LeftChild)) setRR(parent,child,tempR);
            else throw new IllegalArgumentException(); /* Not suppose to get here */
        }
       
    } /* End of addAt */

    /* When add to left and connect to Left */
    private void setLL(KemTreeNode<E> a, KemTreeNode<E> b, KemTreeNode<E> c)
    {
        a.setLeft(b);
        b.setLeft(c);
        
        c.setParent(b);
        b.setParent(a);
    }
    
    /* When add to left and connect to Right */
    private void setLR(KemTreeNode<E> a, KemTreeNode<E> b, KemTreeNode<E> c)
    {
        a.setLeft(b);
        b.setRight(c);
        
        c.setParent(b);
        b.setParent(a);
    }
    
    /* When add to Right and connect to Left */
    private void setRL(KemTreeNode<E> a, KemTreeNode<E> b, KemTreeNode<E> c)
    {
        a.setRight(b);
        b.setLeft(c);
        
        c.setParent(b);
        b.setParent(a);
    }
    
    /* When add to Right and connect to Right */
    private void setRR(KemTreeNode<E> a, KemTreeNode<E> b, KemTreeNode<E> c)
    {
        a.setRight(b);
        b.setRight(c);
        
        c.setParent(b);
        b.setParent(a);
    }
    
    /* Add all in BFS order (i.e., Breadth-First Traversal of a Tree) */
    public void addAll(ArrayList<E> children)
    {
        /* Checks before add */
        if (children == null) 
        {
            return; 
        }
        if (children.isEmpty()) 
        {
            return;
        }
        
        /* Start adding the items */
        Queue<KemTreeNode<E>> qn = new LinkedList<>();
        boolean is2Left = true;        
        Iterator<E> itr = children.iterator();
        
        /* Add first, first */
        if ((m_root == null) && (itr.hasNext()))
        {
            this.addAt(null, itr.next(), true, true);
        }
        
        /* Add the rest in BFS order */
        KemTreeNode<E> curr = m_root; 
        while(itr.hasNext())
        {
            this.addAt(curr, itr.next(), is2Left, true);
            is2Left = !is2Left;
            if (is2Left)
            {
                qn.offer(curr.getLeft());
                qn.offer(curr.getRight());
                curr = qn.poll();
            }
        }
        
        qn.clear(); /* No more items to add, remove all from stack */
    } /* End addAll method */
}
