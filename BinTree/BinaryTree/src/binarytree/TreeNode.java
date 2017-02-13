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
    
    static class information{
        ArrayList<String> arrOutput;
        int leftSpaces;
        int rightSpaces;
        int width;
        
        public information(ArrayList<String> inpArr, int inpLeft, int inpRight){
            this.arrOutput = inpArr;
            this.leftSpaces = inpLeft;
            this.rightSpaces = inpRight;
            this.width = this.leftSpaces + this.rightSpaces + 1;
        }
    }
    
    public static void printTree(TreeNode root){
        throw new UnsupportedOperationException("printTree not implemented yet!");
    }
    
    private static String genString(String ele, int times){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<times; i++){
            sb.append(ele);
        }
        return sb.toString();
    }
    protected static information buildPrintInfo(TreeNode root){
        if (root == null) 
            return null;
        
        information iLeft = buildPrintInfo(root.left);
        information iRight = buildPrintInfo(root.right);
        String sRootVal = String.valueOf(root.value);
        
        
        //1. collect all attributes
        int leftSpaces = iLeft ==null? 0 : iLeft.width;
        int rightSpaces = iRight==null? 0: iRight.width;
        rightSpaces = rightSpaces<sRootVal.length()? sRootVal.length(): rightSpaces;
        int width = leftSpaces + rightSpaces + 1;
        
        //2. build up the arrOutput
        ArrayList<String> arrOut = new ArrayList();
        
        String line1 = genString(" ", leftSpaces) + sRootVal + genString(" ", rightSpaces - sRootVal.length() + 1 );
        String line2 = genString(" ", leftSpaces) + "|" + genString(" ", rightSpaces);
        String line3 = genString(" ", width);
        String line4Left = leftSpaces==0? "": genString(" ", iLeft.leftSpaces) + "|" + genString(" ", iLeft.rightSpaces);
        String line4Right = rightSpaces==0? "": genString(" ", iRight.leftSpaces) + "|" + genString(" ", iRight.rightSpaces);
        String line4 = line4Left + " "  + line4Right;
        String [] firstPart = new String [] {line1, line2, line3, line4};
        for(String item: firstPart) arrOut.add(item);
        
        int height1 = iLeft==null? 0: iLeft.arrOutput.size();
        int height2 = iRight==null? 0: iRight.arrOutput.size();
        int height = height1<height2? height2: height1;
        for(int i=0; i<height; i++){
            String leftPart = i<height1? iLeft.arrOutput.get(i): genString(" ", leftSpaces);
            String rightPart = i<height2? iRight.arrOutput.get(i): genString(" ", rightSpaces);
            String result = leftPart + " " + rightPart;
            arrOut.add(result);
        }
    
        information ifRes = new information(arrOut, leftSpaces, rightSpaces);
        return ifRes;
    }
    
    //data members
    protected int value;
    protected TreeNode left;
    protected TreeNode right;
}
