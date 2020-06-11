package binaryTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import models.BinaryNode;

/**
 * BT Interview Questions
 * 1. Identical BT
 * 2. Height of Tree
 * 3. Prorder Iterative
 * 4. PostOrder Iterative
 * 5. Reverse level order
 * 6. spriral/zig order
 * @author rima.jain
 *
 */
public class BTQuestionSetOne {
	
	static BinaryNode nodeOne = createBinaryTreeOne();
	static BinaryNode nodeTwo = createBinaryTreeTwo();
	static BinaryNode nodeThree = null;
	
	private static String statement = 
			"1.Check two tree are Identical: Recursively\n"+
			"2.Check two tree are Identical: Iterative\n"+
			"3.Check three trees are Identical: Recursive\n"+
			"4.Calculate height of tree: Recursively\n"+
			"5.Calculate height of tree: Iterartive\n"+
			"6.Preorder Traversal Iterative\n"+
			"7.PostOrder Traversal Iterative\n"+
			"8.Reverse Level Order ie Traversal from bottom\n"+
			"9.Spiral/Zig-zag traversal\n"+
			"10.Check given binary tree is complete or not";

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
		case 3: 
			if(isThreeTreesIdentical(nodeOne, nodeTwo,nodeThree)) {
				System.out.println("Identical");
			}else {
				System.out.println("Not Identical");
			}
			break;
		case 4:
			System.out.println(calculateHeightOfTree(nodeOne));
			break;
		case 5:
			System.out.println(calculateHeightOfTreeIterative(nodeOne));
			break;
		case 6:
			preOderTraversalIterative(nodeOne);
			break;
		case 7:
			postOrderIterative(nodeOne);
			break;
		case 8:
			reverseLevelOrder(createBinaryTreeFour());
			break;
		case 9:
			zigzagTraversal(createBinaryTreeFour());
			break;
		case 10:
			if(checkGivenBinaryTreeComplete(completeBinaryTree()))
				System.out.println("Complete Binary tree");
			else
				System.out.println("Not a complete Binary tree");
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
	/*
	 * To check three trees are identical: Recursive
	 */
	public static boolean isThreeTreesIdentical(BinaryNode x, BinaryNode y, BinaryNode z) {
		if(x==null && y==null && z==null){
			return true;
		}
		
		if(x==null||y==null||z==null)
			return false;
		
		return ((x.getValue()==y.getValue()&&(y.getValue()==z.getValue())&&
				(x!=null && y!=null&&z!=null)&&
				(isThreeTreesIdentical(x.getLeft(), y.getLeft(), z.getLeft()))&&
				(isThreeTreesIdentical(x.getRight(), y.getRight(), z.getRight()))));
	}
	/*
	 * To calculate Height of Tree: Recursively
	 */
	public static int calculateHeightOfTree(BinaryNode x) {
		if(x==null)
			return 0;
		
		return Math.max(calculateHeightOfTree(x.getLeft()), calculateHeightOfTree(x.getRight()))+1;
	}
	/*
	 * Calculate height of Tree: Iterative
	 */
	public static int calculateHeightOfTreeIterative(BinaryNode root) {
			if (root == null) {
				return 0;
			}
			
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(root);
			int height=0;
			while(!queue.isEmpty()) {
				int size = queue.size();
				while(size>0) {
					BinaryNode presentNode = queue.poll();
					size--;
					if(presentNode.getLeft()!=null)
						queue.add(presentNode.getLeft());
					if(presentNode.getRight()!=null)
						queue.add(presentNode.getRight());
					
				}
				height++;	
			}
			return height;
	}
	/*
	 * Preorder Traversal Iterative 
	 */
	public static void preOderTraversalIterative(BinaryNode root) {
		if(root==null) {
			System.out.println("No items to traverse");
			return;
		}
		
		Stack<BinaryNode> stack= new Stack<BinaryNode>();
		stack.add(root);
		while(!stack.isEmpty()) {
			BinaryNode presentNode = stack.pop();
			System.out.println(presentNode.getValue());
			
			if(presentNode.getRight()!=null)
				stack.add(presentNode.getRight());
			if(presentNode.getLeft()!=null)
				stack.add(presentNode.getLeft());
		}
		
	}
	/*
	 * Post Order Traversal Iterative
	 */
	public static void postOrderIterative(BinaryNode root) {
		if(root==null) {
			System.out.println("No items to traverse");
			return;
		}
		Stack<BinaryNode> stackForInput = new Stack<BinaryNode>();
		Stack<BinaryNode> stackForOutput = new Stack<BinaryNode>();
		stackForInput.add(root);
		while(!stackForInput.isEmpty()) {
			BinaryNode presentNode = stackForInput.pop();
			System.out.println(presentNode.getValue());
			stackForOutput.push(presentNode);
			
			if(presentNode.getRight()!=null)
				stackForInput.add(presentNode.getRight());
			if(presentNode.getLeft()!=null)
				stackForInput.add(presentNode.getLeft());
		
		}
		
		//For printing the output
		while(!stackForOutput.isEmpty()) {
			System.out.println(stackForOutput.pop().getValue());
		}
	}
	
	/*
	 * Reverse LevelOrder
	 */
	public static void reverseLevelOrder(BinaryNode root) {
		if(root==null) {
			System.out.println("No elements to reverse");
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode = new BinaryNode();
			presentNode = queue.poll();
			stack.add(presentNode);
			
			if(presentNode.getRight()!=null)
				queue.add(presentNode.getRight());
			if(presentNode.getLeft()!=null)
				queue.add(presentNode.getLeft());
			
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().getValue());
		}
			
			
	}
	/*
	 * Printing zig zag order
	 */
	public static void zigzagTraversal(BinaryNode root) {
		Stack<BinaryNode> stackOne = new Stack<BinaryNode>();
		Stack<BinaryNode> stackTwo = new Stack<BinaryNode>();
		
		stackOne.add(root);
		while(!stackOne.isEmpty()||!stackTwo.isEmpty()) {
			
			while(!stackOne.isEmpty()) {
				BinaryNode tempNode=stackOne.pop();
				System.out.print(tempNode);
				if(tempNode.getLeft()!=null)
					stackTwo.add(tempNode.getRight());
				if(tempNode.getLeft()!=null)
					stackTwo.add(tempNode.getLeft());
			}
			while(!stackTwo.isEmpty()) {
				BinaryNode tempNode=stackTwo.pop();
				System.out.print(tempNode);
				if(tempNode.getLeft()!=null)
					stackOne.add(tempNode.getLeft());
				if(tempNode.getRight()!=null)
					stackOne.add(tempNode.getRight());
			}
		}
	}
	/*
	 * Check BinaryTree is complete or not
	 */
	public static boolean checkGivenBinaryTreeComplete(BinaryNode root) {
		if(root==null) {
			System.out.println("No elements");
			return false;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode = new BinaryNode();
			presentNode = queue.poll();
			
			if(presentNode.getLeft()!=null)
				queue.add(presentNode.getLeft());
			
			if(presentNode.getLeft()==null 
					&& presentNode.getRight()!=null)
				return false;
			
			if(presentNode.getRight()!=null) {
				queue.add(presentNode.getRight());
			}	
		}
		return true;
	}
	
	
	public static BinaryNode createBinaryTreeOne() {
		BinaryNode nodeOne = new BinaryNode(15);
		nodeOne.left = new BinaryNode(10);
		nodeOne.right = new BinaryNode(20);
		nodeOne.left.left = new BinaryNode(8);
		nodeOne.left.right = new BinaryNode(12);
		nodeOne.right.left = new BinaryNode(16);
		nodeOne.right.right = new BinaryNode(25);
		return nodeOne;
	}
	
	public static BinaryNode createBinaryTreeTwo() {
		BinaryNode nodeOne = new BinaryNode(15);
		nodeOne.left = new BinaryNode(10);
		nodeOne.right = new BinaryNode(20);
		nodeOne.left.left = new BinaryNode(8);
		nodeOne.left.right = new BinaryNode(12);
		nodeOne.right.left = new BinaryNode(16);
		nodeOne.right.right = new BinaryNode(25);
		return nodeOne;
	}
	
	public static BinaryNode createBinaryTreeThree() {
		BinaryNode nodeOne = new BinaryNode(15);
		nodeOne.left = new BinaryNode(10);
		nodeOne.right = new BinaryNode(20);
		nodeOne.left.left = new BinaryNode(8);
		nodeOne.right.right = new BinaryNode(25);
		return nodeOne;
	}
	
	public static BinaryNode createBinaryTreeFour() {
		BinaryNode nodeOne = new BinaryNode(1);
		nodeOne.left = new BinaryNode(2);
		nodeOne.right = new BinaryNode(3);
		nodeOne.left.left = new BinaryNode(4);
		nodeOne.left.right = new BinaryNode(5);
		nodeOne.right.left = new BinaryNode(6);
		nodeOne.right.right = new BinaryNode(7);
		return nodeOne;
	}

	public static BinaryNode completeBinaryTree() {
		BinaryNode root = new BinaryNode(1);
		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);
		root.left.left = new BinaryNode(4);
		root.left.right = new BinaryNode(5);
		root.right.left = new BinaryNode(6);
		root.right.right = new BinaryNode(7);
		return root;
	}
	
}
