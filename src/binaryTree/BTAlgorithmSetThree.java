package binaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import models.BinaryNode;

/**
 * 1. Print all root to leaf path in BT
 * 2. Count leaf nodes in BT
 * @author rima.jain
 *
 */
public class BTAlgorithmSetThree {

	static int leafNodeCount=0;
	private static String statement = 
			"1.Print all root to leaf path\n"+
			"2.Count leaf nodes in BT\n"+
			"3.Count leaf nodes: Iterative\n"+
			"4.Calculate sum of all nodes\n"+
			"5.Build BT from given array\n"+
			"6.Find Distance bw given pair of nodes"+
			"7.Determine given BT is subtree of given BT or not";
	
	public static void main(String[] args) {
		System.out.print("***********************");
		System.out.println("\nEnter your Choice\n"+statement);
		Scanner sc= new Scanner(System.in);
		int userInput= sc.nextInt();
		System.out.println("\n************");
		
		switch(userInput) {
		case 1:
			printLeafToNode(completeBinaryTree());
			break;
		case 2: 
			countLeafNodes(completeBinaryTree());
			System.out.print(leafNodeCount);
			break;
		case 3:
			System.out.print(countLeadNodesIterative(completeBinaryTree()));
			break;
		case 4:
			break;
		case 5:
			break;
			
		}

	}
	
	public static void printLeafToNode(BinaryNode root) {
		
	}
	/*
	 * Tp count number of leaf nodes in BT
	 */
	public static void countLeafNodes(BinaryNode root) {
		if(root==null) {
			leafNodeCount =0;
		}else {
			if(root.getLeft()==null && root.getRight()==null)
				leafNodeCount++;
			else {
				countLeafNodes(root.getLeft());
				countLeafNodes(root.getRight());
			}
		}
	}
	/*
	 * Count Leaf nodes: Iterative
	 */
	public static int countLeadNodesIterative(BinaryNode root) {
		if(root==null) {
			System.out.println("No elements");
			return 0;
		}
		int count = 0;
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode = queue.poll();
			if(presentNode.getLeft()==null&&presentNode.getRight()==null) {
				count++;
			}else {
				if(presentNode.getLeft()!=null)
					queue.add(presentNode.getLeft());
				if(presentNode.getRight()!=null)
					queue.add(presentNode.getRight());
			}
		}
		return count;
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
