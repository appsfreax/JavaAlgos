package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Model.BinaryNode;

/**
 * 
 * @author rima.jain
 *
 */
public class BTQuestionSetOne {
	
	static BinaryNode nodeOne = createBinaryTreeOne();
	static BinaryNode nodeTwo = createBinaryTreeTwo();
	BinaryNode nodeThree = createBinaryTreeTwo();
	
	private static String statement = "1. Check two tree are Identical: Recursively\n"
			+"2. Check two tree are Identical: Iterative\n"+
			"3. Check three trees are Identical: Recursive";

	public static void main(String[] args) {
		
	
		System.out.print("***********************");
		System.out.println("\nEnter your Choice\n"+statement);
		Scanner sc= new Scanner(System.in);
		int userInput= sc.nextInt();
		System.out.println("\n************");
		
		switch(userInput) {
		case 1:
			if(isIdenticalRecursive(nodeOne, nodeTwo)) {
				System.out.println("Identical");
			}else {
				System.out.println("Not Identical");
			}
			break;
		case 2: 
			if(isIdenticalIterative(nodeOne, nodeTwo)) {
				System.out.println("Identical");
			}else {
				System.out.println("Not Identical");
			}
			break;
		}

	}
	/*
	 * Check two trees are identical: Recursive
	 */
	private static boolean isIdenticalRecursive(BinaryNode x,BinaryNode y) {
		
		if(x==null&& y==null) {
			return true;
		}
		return ((x!=null && y!=null)&&(x.getValue()==y.getValue())
				&&isIdenticalRecursive(x.getLeft(), y.getLeft()) 
				&&(isIdenticalRecursive(x.getRight(), y.getRight())));
		
	}
	/*
	 * Check two program are identical: Iterative
	 */
	private static boolean isIdenticalIterative(BinaryNode x, BinaryNode y) {
		if(x==null&& y==null) {
			return true;
		}
		
		if(x==null || y ==null) {
			return false;
		}
		
		Queue<BinaryNode> queueOne = new LinkedList<BinaryNode>();
		Queue<BinaryNode> queueTwo = new LinkedList<BinaryNode>();
		queueOne.add(x);
		queueTwo.add(y);
		while(!queueOne.isEmpty() && !queueTwo.isEmpty()) {
			BinaryNode presentNodeOne = queueOne.remove();
			BinaryNode presentNodeTwo= queueTwo.remove();
			
			if(presentNodeOne.getValue()!=presentNodeTwo.getValue()){
				return false;
			}
			
			
			if((presentNodeOne.getLeft()!=null)
					&&(presentNodeTwo.getLeft()!=null)) {
				queueOne.add(presentNodeOne.getLeft());
				queueTwo.add(presentNodeTwo.getLeft());
			}else if(presentNodeOne.getLeft()!=null
					||presentNodeTwo.getLeft()!=null) {
				return false;
			}
			
			if((presentNodeOne.getRight()!=null)
					&&(presentNodeTwo.getRight()!=null)) {
				queueOne.add(presentNodeOne.getRight());
				queueTwo.add(presentNodeTwo.getRight());
			}else if(presentNodeOne.getRight()!=null
					||presentNodeTwo.getRight()!=null) {
				return false;
			}	
		}
		return true;
		
	}
	
	private static BinaryNode createBinaryTreeOne() {
		BinaryNode nodeOne = new BinaryNode(15);
		nodeOne.left = new BinaryNode(10);
		nodeOne.right = new BinaryNode(20);
		nodeOne.left.left = new BinaryNode(8);
		nodeOne.left.right = new BinaryNode(12);
		nodeOne.right.left = new BinaryNode(16);
		nodeOne.right.right = new BinaryNode(25);
		return nodeOne;
	}
	
	private static BinaryNode createBinaryTreeTwo() {
		BinaryNode nodeOne = new BinaryNode(15);
		nodeOne.left = new BinaryNode(10);
		nodeOne.right = new BinaryNode(20);
		nodeOne.left.left = new BinaryNode(8);
		nodeOne.left.right = new BinaryNode(12);
		nodeOne.right.left = new BinaryNode(16);
		nodeOne.right.right = new BinaryNode(25);
		return nodeOne;
	}


}
