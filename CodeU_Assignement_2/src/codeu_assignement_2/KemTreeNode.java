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
    private KemTreeNode<E> parent=null;
    private KemTreeNode<E> left=null;
    private KemTreeNode<E> right=null;
    public KemTreeNode(E d)
    {
        data = d;
        parent = null;
        left = null;
        right = null;
    }
    public KemTreeNode(E d,KemTreeNode<E> p, KemTreeNode<E> l, KemTreeNode<E> r)
    {
        data = d;
        parent = p;
        left = l;
        right = r;
    }    
    /* Setters */
    public void setParent(KemTreeNode<E> p) { parent = p; } 
    public void setLeft(KemTreeNode<E> l)   { left = l; } 
    public void setRight(KemTreeNode<E> r)  { right = r; } 
    public void setData(E d) { data = d; } 

    /* Getter */
    public KemTreeNode<E> getParent() { return parent; }
    public KemTreeNode<E> getLeft() { return left; }
    public KemTreeNode<E> getRight() { return right; }
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
        
        KemTreeNode<E> n = (KemTreeNode<E>) other;
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