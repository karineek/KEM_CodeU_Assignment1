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
    /*  Inner pojo class Node in the list  */
    public class TreeNode <E>
    {
        private E data=null;
        private TreeNode parent=null;
        private TreeNode left=null;
        private TreeNode right=null;
        public TreeNode(E d,TreeNode p, TreeNode l, TreeNode r)
        {
            data = d;
            parent = p;
            left = l;
            right = r;
        }    
        /* Setters */
        public void setParent(TreeNode p) { parent = p; } 
        public void setLeft(TreeNode l)   { left = l; } 
        public void setRight(TreeNode r)  { right = r; } 
        public void setData(E d) { data = d; } 
        
        /* Getter */
        public TreeNode getParent() { return parent; }
        public TreeNode getLeft() { return left; }
        public TreeNode getRight() { return right; }
        public E getData() { return data; }
        
        @Override
        public boolean equals(Object other) {
            if (!(other instanceof TreeNode)) {
                return false;
            }

            TreeNode n = (TreeNode) other;

            /* Custom equality check here. */
            return (this.data.equals(n.data) &&
                    this.parent.equals(n.parent) &&
                    this.left.equals(n.left) && this.left.equals(n.left)); 
        }
    }
    
    /* Data members of Tree */
    protected TreeNode m_root=null;
    
    /* */
    public KemBinaryTree(){} 
            
    /*  Check if the list is empty  */
    public boolean isEmpty() { return (m_root == null); }
    
    /* Allow us to decide where to add items */
    public TreeNode getRoot() { return m_root;}
    
    /* Q1: Get all ancestors */
    public void printAncestors(TreeNode child)
    {  
        /* Check if child isn't null */
        if (child == null)
        {
            System.out.println("Error: ** Null Pointer **");
            return;
        }
        
        /* Check if child isn't root */
        TreeNode curr = child.getParent();
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
    public TreeNode getLowestCommonAncestors(TreeNode child1, TreeNode child2)
    {
        /* No common if at least one is null */
        if (child1 == null || child2 == null)
            return null;
        
        /* If one of them is the root - return it as the common */
        if (child1 == m_root || child2 == m_root)
            return m_root;
        
        /* Create a trace from child to root, and then return the last 
           Common node on the prefixes */
        Stack<TreeNode> st_c1 = getTraceChild2Root(child1);
        Stack<TreeNode> st_c2 = getTraceChild2Root(child2);
        
        TreeNode common = null;
        while(!st_c1.empty() && !st_c2.empty())
        {
            TreeNode c1 = st_c1.pop();
            TreeNode c2 = st_c2.pop();
            if (c1 != c2) return common;
            
            common = c1; /* when c1=c2 */
        }
        
        /* return common, incase one stack is smaller than other, and we
        Get to the last item in the smaller stack, which says it is the common */
        return common;
    }
    
    /* Create the trace from child to root, including the root and the child */
    private Stack<TreeNode> getTraceChild2Root(TreeNode child)
    {
        if (m_root == null) return null;
        
        /* Create the trace */
        Stack<TreeNode> st_c = new Stack();
        TreeNode curr = child;
        while (curr != null)
        {
            st_c.push(curr);
            curr = curr.getParent();
        }
        
        return st_c;
    }
       
    /* Check if a node is in the tree */
    public boolean exist(TreeNode n)
    {
        /* Go over the tree in pre-order */
        if (m_root!=null)
            return exist(n,m_root);
        
        /* If didn't find so far - return false */
        return false;
    } 
    
    /* Check if a node is in the tree - Helper method for the recursion */
    private boolean exist(TreeNode n, TreeNode curr)
    {
        /* Go over the tree in pre-order */
        if (curr!=null)
        {
            if (curr == n ) return true;
            
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
    private void printTree(TreeNode curr, String indent)
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
    public void addAt(TreeNode parent, E child_data, boolean is2Left, boolean is2LeftChild)
    {             
        /* Check that the parents CAN be in the tree (not null tree) */
        if (parent != null && m_root == null)
             throw new NullPointerException("No tree found. Root is null.");   
            
        /* Creat a new node - child */
        TreeNode child = new TreeNode(child_data, null,null,null);   
             
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
        TreeNode tempL=parent.getLeft();
        TreeNode tempR=parent.getRight();
       
        child.setParent(parent);
        if (is2Left && tempL==null)
            parent.setLeft(child);
        else if (!is2Left && tempR==null)
            parent.setRight(child);
        else /* General case */
        {
            if (is2Left && is2LeftChild) setLL(parent,child,tempL);
            else if (is2Left && !is2LeftChild) setLR(parent,child,tempL);
            else if (!is2Left && is2LeftChild) setRL(parent,child,tempR);
            else if (!is2Left && !is2LeftChild) setRR(parent,child,tempR);
            else throw new IllegalArgumentException(); /* Not suppose to get here */
        }
       
    } /* End of addAt */

    /* When add to left and connect to Left */
    private void setLL(TreeNode a, TreeNode b, TreeNode c)
    {
        a.setLeft(b);
        b.setLeft(c);
        
        c.setParent(b);
        b.setParent(a);
    }
    
    /* When add to left and connect to Right */
    private void setLR(TreeNode a, TreeNode b, TreeNode c)
    {
        a.setLeft(b);
        b.setRight(c);
        
        c.setParent(b);
        b.setParent(a);
    }
    
    /* When add to Right and connect to Left */
    private void setRL(TreeNode a, TreeNode b, TreeNode c)
    {
        a.setRight(b);
        b.setLeft(c);
        
        c.setParent(b);
        b.setParent(a);
    }
    
    /* When add to Right and connect to Right */
    private void setRR(TreeNode a, TreeNode b, TreeNode c)
    {
        a.setRight(b);
        b.setRight(c);
        
        c.setParent(b);
        b.setParent(a);
    }
    
    /* Add all in BFS order (i.e., Breadth-First Traversal of a Tree) */
    public void addAll(ArrayList<E> children)
    {
        if (children.isEmpty()) 
            return;
        
        /* Start adding the items */
        Queue<TreeNode> qn;
        qn = new LinkedList<>();
        boolean is2Left = true;        
        Iterator<E> itr = children.iterator();
        
        /* Add first, first */
        if ((m_root == null) && (itr.hasNext()))
        {
            this.addAt(null, itr.next(), true, true);
        }
        
        /* Add the rest in BFS order */
        TreeNode curr = m_root; 
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
