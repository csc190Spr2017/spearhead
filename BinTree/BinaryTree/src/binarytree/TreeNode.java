/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.util.ArrayList;

/**
 *
 * @author csc190
 */
public class TreeNode {
    //ops
    public TreeNode(int v, TreeNode left, TreeNode right){
        this.value = v;
        this.left = left;
        this.right = right;
    }
    
    public int getValue(){return this.value;}
    public TreeNode getLeft() {return this.left;}
    public TreeNode getRight() {return this.right;}
    public void setValue(int v){this.value =v;}
    public void setLeft(TreeNode left){this.left = left;}
    public void setRight(TreeNode right) {this.right = right;}
    public ArrayList<Integer> inOrder(){
        ArrayList<Integer> list = new ArrayList<Integer> ();
        
        ArrayList<Integer> leftList = this.left==null?
                new ArrayList<Integer>(): this.left.inOrder();
        ArrayList<Integer> rightList = this.right==null?
                new ArrayList<Integer>(): this.right.inOrder();
        list.addAll(leftList);
        list.add(this.value);
        list.addAll(rightList);
        return list;
    }
    
    @Override
    public String toString() {
        String leftValue = this.left==null? "null":
                String.valueOf(this.left.value);
        String rightValue = this.right==null? "null":
                String.valueOf(this.right.value);
        return String.valueOf(this.value) + "left: " + leftValue
                + ", right: " + rightValue;       
    }
    
    
    
    //data members
    protected int value;
    protected TreeNode left;
    protected TreeNode right;
}
