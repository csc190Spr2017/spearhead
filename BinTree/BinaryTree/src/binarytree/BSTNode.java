/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author csc190
 */
public class BSTNode extends TreeNode{
    public BSTNode (int value, TreeNode left, TreeNode right){
        super(value, left, right);      
    }
    
    /**
     * Edge case: existing numbers tree not changed at all
     * Tree follows the BST schema from there
     * @param number 
     */
    public void insert(int number){
        if(this.value == number)
            return;
        else if(this.value < number){
            if(this.right != null){
                ((BSTNode)this.right).insert(number);
            }
            else
                this.right = new BSTNode(number, null, null);
        }
        else{
            if(this.left != null){
                ((BSTNode) this.left).insert(number);
            }
            else{
                this.left = new BSTNode(number, null, null);
            }
        }
    }
    
    public static BSTNode buildBST(int[] numbers){
        if(numbers == null || numbers.length == 0){
            return null;
        }
        BSTNode root = new BSTNode(numbers[0], null, null);
        for(int i = 1; i < numbers.length; i++){
            root.insert(numbers[i]);
        }
        return root;
    }
    
}
