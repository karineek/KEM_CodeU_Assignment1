package codeu_assignement_2;

import java.util.Objects;

/**
 *
 * @author Karine
 *  Inner pojo class Node in the list 
 * Generic here is needed: 
   KemBinaryTree.java:46: error: illegal generic type for instanceof if (!(other instanceof TreeNode)) { 
**/
public class KemTreeNode <E> 
{
    private E data=null;
    private KemTreeNode parent=null;
    private KemTreeNode left=null;
    private KemTreeNode right=null;
    public KemTreeNode(E d)
    {
        data = d;
        parent = null;
        left = null;
        right = null;
    }
    public KemTreeNode(E d,KemTreeNode p, KemTreeNode l, KemTreeNode r)
    {
        data = d;
        parent = p;
        left = l;
        right = r;
    }    
    /* Setters */
    public void setParent(KemTreeNode p) { parent = p; } 
    public void setLeft(KemTreeNode l)   { left = l; } 
    public void setRight(KemTreeNode r)  { right = r; } 
    public void setData(E d) { data = d; } 

    /* Getter */
    public KemTreeNode getParent() { return parent; }
    public KemTreeNode getLeft() { return left; }
    public KemTreeNode getRight() { return right; }
    public E getData() { return data; }

    @Override
    public boolean equals(Object other) {
        /* Check corrner cases */
        if (other == null)
        {
            return false;
        }
        
        /* Check before cast */
        if (!(other instanceof KemTreeNode)) 
        {
            return false;
        }
        
        KemTreeNode n = (KemTreeNode) other;
        if (this == n) 
        {
            return true;
        }

        return ((this.data == n.getData()) &&
                (this.parent == n.getParent()) &&
                (this.right == n.getRight()) && 
                (this.left == n.getLeft())); 
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.data);
        hash = 31 * hash + Objects.hashCode(this.parent);
        hash = 31 * hash + Objects.hashCode(this.left);
        hash = 31 * hash + Objects.hashCode(this.right);
        return hash;
    }
}