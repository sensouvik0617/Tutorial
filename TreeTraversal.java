package com.souvik.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TreeTraversal {

	  public static void main(String args[]){
		     
		  TreeTraversal treeTraverse = new TreeTraversal();
		  TreeNode rootNode = createBinaryTree();
		  System.out.println("Enter your choice :");
		  int n = new Scanner(System.in).nextInt();
		  
		  if(n == 1){
			  treeTraverse.preOrder(rootNode);
		  }
		  else if(n == 2){
			  treeTraverse.inOrder(rootNode);
		  }
		  else if(n == 3){
			  treeTraverse.postOrder(rootNode);
		  }
		  else if(n == 4){
			  treeTraverse.levelOrderTraversal(rootNode);
		  }
		  else if(n == 5){
			  treeTraverse.spriralOrZigZagOrder(rootNode);
		  }
		  else if(n == 6){ 
		      treeTraverse.printAllPathsToLeaf(rootNode, new int[100], 0);
		  }
	  }
	  
	  public static TreeNode createBinaryTree(){
		
		  TreeNode rootNode = new TreeNode(40);
		  TreeNode node20=new TreeNode(20);
		  TreeNode node10=new TreeNode(10);
		  TreeNode node30=new TreeNode(30);
		  TreeNode node60=new TreeNode(60);
		  TreeNode node50=new TreeNode(50);
		  TreeNode node70=new TreeNode(70);
		  
		  rootNode.left=node20;
		  rootNode.right=node60;
		  
		  node20.left=node10;
		  node20.right=node30;
		  
		  node60.left=node50;
		  node60.right=node70;
		  
		  return rootNode;
		  
	  }
	  
	  public void preOrder(TreeNode rootNode){
		  
		     if(rootNode != null){
		    	 System.out.printf("%d ",rootNode.data);
		    	 preOrder(rootNode.left);
		    	 preOrder(rootNode.right);
		     }
	  }
	  
	  public void inOrder(TreeNode rootNode){
		  
		    if(rootNode != null){
		    	inOrder(rootNode.left);
		    	System.out.printf("%d ",rootNode.data);
		    	inOrder(rootNode.right);
		    }
		  
	  }
	  
	  public void postOrder(TreeNode rootNode){
		  
		     if(rootNode != null){
		    	 postOrder(rootNode.left);
		    	 postOrder(rootNode.right);
		    	 System.out.printf("%d ",rootNode.data);
		     }
	  }
	  
	  public void levelOrderTraversal(TreeNode rootNode){
		  
		  Queue<TreeNode> queue = new LinkedList<TreeNode>();
		  Stack<TreeNode> stack = new Stack<TreeNode>();
		  queue.add(rootNode);
		  while(!queue.isEmpty()){
			  TreeNode popedNode = queue.poll();
			  System.out.printf("%d ", popedNode.data);
			  if(popedNode.left != null){
				  queue.add(popedNode.left);
			  }
			  if(popedNode.right != null){
				  queue.add(popedNode.right);
			  }
			  stack.push(popedNode);
		  }
		  while(!stack.isEmpty()){
			  System.out.println(stack.pop().data);
		  }
	  }
	  
	  public void spriralOrZigZagOrder(TreeNode rootNode){
		     
		  if(rootNode != null){
			  Stack<TreeNode> stack = new Stack<TreeNode>();
			  stack.push(rootNode);
			  
			  boolean directionFlag = false;
			  while(!stack.isEmpty()){
				  Stack<TreeNode> tempStack = new Stack<TreeNode>();
				  
				  while(!stack.isEmpty()){
					  TreeNode tempNode = stack.pop();
					  System.out.printf("%d ",tempNode.data);
					  
					  if(!directionFlag){
						
						  if(tempNode.left != null){
							  tempStack.push(tempNode.left);
						  }
						  if(tempNode.right != null){
							  tempStack.push(tempNode.right);
						  }
					  }
					  else {
						  if(tempNode.right != null){
							  tempStack.push(tempNode.right);
						  }
						  if(tempNode.left != null){
							  tempStack.push(tempNode.left);
						  }
					   }
				  } 
				 
                  directionFlag = !directionFlag;
				  
				  stack = tempStack;  
			  }
		  }
	  }
	  
	  
	  public void printAllPathsToLeaf(TreeNode rootNode, int[] paths, int length){
		  
		if(rootNode == null){
			return;
		}
		//storing data in array
		paths[length] = rootNode.data;
		length++ ;
		
		if(rootNode.left == null && rootNode.right == null){
			printArray(paths, length);
		}
		 
		printAllPathsToLeaf(rootNode.left, paths, length);
		printAllPathsToLeaf(rootNode.right, paths, length);
	  }
	  
	  public static void  printArray(int[] path,int len){
		   for (int i = 0; i < len; i++) {
			   System.out.print(" "+path[i]);
		   }
		   System.out.println();
	 }
}
