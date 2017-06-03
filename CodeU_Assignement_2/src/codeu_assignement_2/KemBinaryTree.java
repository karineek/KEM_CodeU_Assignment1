package codeu_assignement_2;

import java.util.ArrayList;
import java.util.Iterator;

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
    protected KemTreeNode<E> m_root = null;
    
    /* */
    public KemBinaryTree (){} 
            
    /*  Check if the list is empty  */
    public boolean isEmpty () 
    { 
        return m_root == null; 
    }
    
    /* Allow us to decide where to add items */
    public KemTreeNode<E> getRoot () 
    { 
        return m_root;
    }
    
    /* Q1: Get all ancestors 
       =====================
    
    Input: a Binary Tree -  KemBinaryTree and a key 
    Process: if the child or the tree is null - return null
             else: Traverse from Child to Parent, this will be also
             the order of the output
    Output: prints all the ancestors of the key in the tree 
                      + Status message (avoid empty prints)
    
    */
    public void printAncestors (KemTreeNode<E> child)
    {  
        /* Check if child isn't null */
        if (child == null)
        {
            throw new NullPointerException("Error: ** Null Pointer **");
        }
        
        /* Check if child isn't root */
        KemTreeNode<E> curr = child.getParent();

        /* Print all ancestors as long as didn't get to root */
        while (curr != null)
        {
            System.out.print(curr.getData());
            curr = curr.getParent();
            if (curr != null)
            {
                System.out.print(",");
            }
        }
        
        /* Print Status Message */
        if (child.getParent() == null)
        {
            System.out.println("** Root **: has no ancestors. Done.");
        } 
        else 
        {
            System.out.println(". Done printAncestors(..).");
        }
    }

    /* Q2: Get all ancestors */
    public KemTreeNode<E> getLowestCommonAncestors (KemTreeNode<E> child1, KemTreeNode<E> child2)
    {
        /* No common if at least one is null */
        if ((child1 == null) || (child2 == null))
        {
            return null;
        }
        /* If one of them is the root - return it as the common */
        if ((child1 == m_root) || (child2 == m_root))
        {
            return m_root;
        }
        /* Couts the edges between the node and the root */
        int c1_loc = getSizeOfTraceChildToRoot(child1);
        int c2_loc = getSizeOfTraceChildToRoot(child2);
        
        /* If larger than 0 */ 
        KemTreeNode<E> common = m_root; /* If root not null, the worst case is root */
        int min = (c2_loc > c1_loc)? c1_loc : c2_loc;
        KemTreeNode<E> curr1 = child1; 
        KemTreeNode<E> curr2 = child2;
        
        /* Go up the tree till the meet level */
        while(c1_loc > min)
        {
            curr1 = curr1.getParent();
            c1_loc--;
        }
        while(c2_loc > min)
        {
            curr2 = curr2.getParent();
            c2_loc--;
        }
              
        /* Search the meet point going one level up each iteration */
        while((c1_loc > 0) && (c2_loc > 0)) /* >, can skip checking root, and if 0 return root */
        {
            if (c1_loc == c1_loc) 
            {
                if (curr1 == curr2)
                {
                    common = curr2;
                    break;
                }
                
                curr1 = curr1.getParent();
                curr2 = curr2.getParent();
                c1_loc--;
                c2_loc--;
            }
            else /* Something went wrong */
            {
                throw new IndexOutOfBoundsException();
            }
        }
        
        /* Return the most inner common */
        return common;
    }
    
    /* Create the trace from child to root, including the root and the child 
        Return -1 if m_root is null
                0 if it is the root that it isn't null
               >0 for any other location on the path
    
    Output: is unsigned number >= 0
    
    */
    private int getSizeOfTraceChildToRoot (KemTreeNode<E> child)
    {
        int ret_val = 0;
        if (m_root == null) 
        {
            return ret_val;
        }
        
        /* Calculate the trace */
        KemTreeNode<E> curr = child;
        while (curr != null)
        {
            ret_val ++;
            curr = curr.getParent();
        }
        
        return ret_val;
    }
       
    /* Check if a node is in the tree */
    public boolean exist (KemTreeNode<E> n)
    {
        /* Go over the tree in pre-order */
        if (m_root != null)
        {
            return exist(n,m_root);
        }
        else
        {
            return false; /* Nothing is in an empty tree, returns false */
        }
    } 
    
    /* Check if a node is in the tree - Helper method for the recursion */
    private boolean exist (KemTreeNode<E> n, KemTreeNode<E> curr)
    {
        /* Go over the tree in pre-order */
        if (curr != null)
        {
            if (curr.equals(n)) 
            { 
                return true;
            }
            
            /* Check if in Left or Right sub-trees */
            if (exist(n,curr.getLeft())) 
            {
                return true;
            }
            if (exist(n,curr.getRight())) 
            {
                return true;
            }        
        }
        
        /* If didn't find so far - return false */
        return false;
    }

    /* From Root, print in pre-order the tree */
    public void printTree ()
    {
        /* Go over the tree in pre-order */
        if (m_root != null) 
        {
            System.out.println("Tree: ");
            printTree(m_root, "");
        }
        else
        {
            System.out.println("** Tree is Empty **");
        }
        
        System.out.println();
    } 
    
    /* Check if a node is in the tree - Helper method for the recursion
       Print in Pre-order */
    private void printTree (KemTreeNode<E> curr, String indent)
    {
        /* Go over the tree in pre-order */
        if (curr != null)
        {
            System.out.println(indent + "|" + curr.getData());
            
            /* Check if in Left or Right sub-trees */
            printTree(curr.getLeft(), indent + " ");
            printTree(curr.getRight(), indent + " ");        
        }
    }
    
    /*  Add e element to a node indicating
     * Where? Child of Parent
     * How? if is2Left add child as left of parent, else as right of parent
     * if is2LeftChild - add the original child of parent as left of child (else as right of child)
    */ 
    public void addAt (KemTreeNode<E> parent, E child_data, boolean is2Left, boolean is2LeftChild)
    {             
        /* Check that the parents CAN be in the tree (not null tree) */
        if ((parent != null) && (m_root == null))
        {
             throw new NullPointerException("No tree found. Root is null.");   
        }   
        /* Creat a new node - child */
        KemTreeNode<E> child = new KemTreeNode<>(child_data, null,null,null);   
             
        /* Set the child as root (empry tree) */
        if ((parent == null) && (m_root == null))
        {
            m_root = child;
            return;
        }
        
        /* Replace the root with child, the root will be the child of child */
        if ((parent == null) && (m_root != null))
        {
            if (is2LeftChild)
            {
                child.setLeft(m_root);
            } 
            else
            {
                child.setRight(m_root);
            }
            
            m_root = child;
            return;
        }
                
        /* The general case - where the root and parent aren't null! */
        if ((parent == null) || (m_root == null))
        {
             throw new NullPointerException(); 
        }
        /* Check if the parent is in the tree */
        if (!this.exist(parent))
        {
            throw new IllegalArgumentException();
        }
        
        /* Add the child */
        KemTreeNode<E> tempL = parent.getLeft();
        KemTreeNode<E> tempR = parent.getRight();
       
        child.setParent(parent);
        if (is2Left && (tempL == null))
        {
            parent.setLeft(child);
        }
        else if (!is2Left && (tempR == null))
        {
            parent.setRight(child);
        }
        else /* General case */
        {
            if (is2Left && is2LeftChild) 
            {
                setLL(parent,child,tempL);
            }
            else if (is2Left && (!is2LeftChild)) 
            {
                setLR(parent,child,tempL);
            }
            else if ((!is2Left) && is2LeftChild) 
            {
                setRL(parent,child,tempR);
            }
            else if ((!is2Left) && (!is2LeftChild)) 
            {
                setRR(parent,child,tempR);
            }
            else 
            {
                throw new IllegalArgumentException();
            } /* Not suppose to get here */
        }
       
    } /* End of addAt */

    /* When add to left and connect to Left */
    private void setLL (KemTreeNode<E> a, KemTreeNode<E> b, KemTreeNode<E> c)
    {
        a.setLeft(b);
        b.setLeft(c);
        
        c.setParent(b);
        b.setParent(a);
    }
    
    /* When add to left and connect to Right */
    private void setLR (KemTreeNode<E> a, KemTreeNode<E> b, KemTreeNode<E> c)
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
    private void setRR (KemTreeNode<E> a, KemTreeNode<E> b, KemTreeNode<E> c)
    {
        a.setRight(b);
        b.setRight(c);
        
        c.setParent(b);
        b.setParent(a);
    }
    
    /* Add all in BFS order (i.e., Breadth-First Traversal of a Tree) */
    public void addAll (ArrayList<E> children)
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
        java.util.Queue<KemTreeNode<E>> qn = new java.util.LinkedList<>();
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
