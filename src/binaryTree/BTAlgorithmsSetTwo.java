package binaryTree;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import models.BinaryNode;
import models.NodeWithHd;
/**
 * Binary Tree Algorithms Set Two
 * 1.Left view of BT
 * 2.Right view of BT
 * 3.Top view of BT
 * 4.Bottom view of BT
 * 5.Next node in same level
 * 6.Check two nodes are cousins
 * 7.Ancestor of given node
 * 8.Convert BT to its mirrot
 * 9. Check miror of BT
 * 10.Print root to leaf path
 *  @author rima.jain
 */
public class BTAlgorithmsSetTwo {
	
	private static String statement = 
			"1.Print Left view of BT\n"+
			"2.Print Right view of BT\n"+
			"3.Print Bottom view of BT\n"+
			"4.Print Top view of BT\n"+
			"5.Print next node in same level of given node\n"+
			"6.Check two nodes are cousins i.e Different Parents\n"+
			"7.Print ancesstors of a given node\n"+
			"8.Convert a BT to its Mirror\n"+
			"9.Check mirror of BT\n"+
			"10.Print root to leaf path";

	public static void main(String[] args) {
	
		System.out.print("***********************");
		System.out.println("\nEnter your Choice\n"+statement);
		Scanner sc= new Scanner(System.in);
		int userInput= sc.nextInt();
		System.out.println("\n************");
		
		switch(userInput){
		case 1:
			printLeftViewOfBinaryTree(createBinaryTreeOne());
			break;
		case 2:
			printRightViewOfBinaryTree(createBinaryTreeOne());
			break;
		case 3:
			printBottomViewOfBinaryTree(createBinaryTreeTwo());
			break;
		case 4:
			printTopViewOfBinaryTree(createBinaryTreeTwo());
			break;
		case 5:
			System.out.println(printNextNode(createBinaryTreeOne(),100));
			break;
		case 6:
			//TODO
			isTwoNodesCousin(createBinaryTreeOne(),25,8);
			break;
		case 7:
			//TODO- Anccestors
			break;
		case 8:
			convertBinaryTreeToMirror(createBinaryTreeOne());
			break;
		case 9:
			if(isBTsAreMirror(createBinaryTreeTwo(),createBinaryTreeThree()))
				System.out.println("Both the trees are mirror");
			else
				System.out.println("Both the trees are not mirror");
			break;
		case 10: 
			//TODO: Root to leaf
			break;
		}
	}
	/*
	 * To print the left view of Binary Tree
	 */
	public static void printLeftViewOfBinaryTree(BinaryNode root) {
		if(root==null) {
			System.out.println("No elements");
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
	
		while(!queue.isEmpty()) {
			int size = queue.size();
			int level = 0;
			do{
				BinaryNode presentNode = new BinaryNode();
				presentNode=queue.poll();
				level++;
				if(level==1) {
					System.out.println(presentNode.getValue());
				}
				if(presentNode.getLeft()!=null)
					queue.add(presentNode.getLeft());
				if(presentNode.getRight()!=null)
					queue.add(presentNode.getRight());
			}while(level<size);
		}
	}
	/*
	 * To print the right view of Binary Tree
	 */
	public static void printRightViewOfBinaryTree(BinaryNode root) {
		if(root==null) {
			System.out.println("No elements");
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size=queue.size();
			int i =0;
			do {
				BinaryNode presentNode = new BinaryNode();
				presentNode=queue.poll();
				i++;
				if(i==1) {
					System.out.println(presentNode.getValue());
				}
				if(presentNode.getRight()!=null)
					queue.add(presentNode.getRight());
				if(presentNode.getLeft()!=null)
					queue.add(presentNode.getLeft());
			}while(i<size);
		}
	}
	/*
	 * To print the bottom view of Binary Tree
	 */
	public static void printBottomViewOfBinaryTree(BinaryNode root) {
		if(root==null) {
			System.out.println("No elemens");
			return;
		}
		Queue<NodeWithHd> queue = new LinkedList<NodeWithHd>();
		Hashtable<Integer,BinaryNode> htable = new Hashtable<Integer,BinaryNode>();
		queue.add(new NodeWithHd(root, 0));
		while(!queue.isEmpty()) {
			NodeWithHd presentNode = queue.poll();
			htable.put( presentNode.getHd(),presentNode.getNode());
			
			if(presentNode.getNode().getLeft()!=null)
				queue.add(new NodeWithHd(presentNode.getNode().getLeft(), presentNode.getHd()-1));
			
			if(presentNode.getNode().getRight()!=null)
				queue.add(new NodeWithHd(presentNode.getNode().getRight(), presentNode.getHd()+1));
		}
		Set<Integer> keys = htable.keySet();
        for(Integer key: keys){
            System.out.println(htable.get(key));
        }
	}
	
	/*
	 * To print the top view of Binary Tree
	 */
	public static void printTopViewOfBinaryTree(BinaryNode root) {
		if(root==null) {
			System.out.println("No elements");
			return;
		}
		HashMap<Integer,BinaryNode> hmap = new HashMap<>();
		Queue<NodeWithHd> queue = new LinkedList<NodeWithHd>();
		queue.add(new NodeWithHd(root,0));
		while(!queue.isEmpty()) {
			NodeWithHd presentNode = queue.poll();
			if(!hmap.containsKey(presentNode.getHd())) {
				hmap.put(presentNode.getHd(),presentNode.getNode());
			}
			if(presentNode.getNode().getLeft()!=null)
				queue.add(new NodeWithHd(presentNode.getNode().getLeft(),presentNode.getHd()-1));
			if(presentNode.getNode().getRight()!=null)
				queue.add(new NodeWithHd(presentNode.getNode().getRight(), presentNode.getHd()+1));
		}
		 for (Entry<Integer, BinaryNode> entry : hmap.entrySet()) { 
	            System.out.print(entry.getValue().getValue()); 
	        } 
		}
	/*
	 * Printing the next node of the given node
	 */
	public static BinaryNode printNextNode(BinaryNode tree,int value) {
		if(tree==null) {
			System.out.println("No elements");
			return null;
		}
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(tree);
		while(!queue.isEmpty()) {
			int size = queue.size();
			do {
				BinaryNode presentNode = queue.poll();
				if(presentNode.getValue()==value) {
					if(size==0) {
						return null;
					}
					return queue.peek();
				}
				if(presentNode.getLeft()!=null)
					queue.add(presentNode.getLeft());
				if(presentNode.getRight()!=null)
					queue.add(presentNode.getRight());
				size--;
				
			}while(size>0);
		}
		return null;
	}
	/*
	 * To check two Nodes are cousin 
	 */
	public static boolean isTwoNodesCousin(BinaryNode root,int valueOne,int valueTwo) {
		return false;
	}
	/*
	 * Converting BT to its Mirror
	 */
	public static void convertBinaryTreeToMirror(BinaryNode root) {
		if(root==null) {
			return;
		}
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(root);
			while(!queue.isEmpty()) {
				BinaryNode presentNode = new BinaryNode();
				presentNode = queue.poll();
				System.out.println(presentNode.getValue());
				if(presentNode.getRight()!= null)
					queue.add(presentNode.getRight());
				if(presentNode.getLeft()!=null)
					queue.add(presentNode.getLeft());
			}
		}
	/*
	 * Two Binary Tree are Mirror or not
	 */
	public static boolean isBTsAreMirror(BinaryNode rootOne,BinaryNode rootTwo) {
		if(rootOne==null && rootTwo==null)
			return true;
		if(rootOne==null||rootTwo==null)
			return false;
		if(rootOne.getValue()==rootTwo.getValue()) {
			if(isBTsAreMirror(rootOne.getLeft(), rootTwo.getRight())) {
				if(isBTsAreMirror(rootOne.getRight(), rootTwo.getLeft()))
					return true;
			}
		}
		return false;	
	}
	/*
	 * 
	 */
	public static void printNodeToLeaf(BinaryNode root) {
	}
	
	public static BinaryNode createBinaryTreeOne() {
		BinaryNode nodeOne = new BinaryNode(15);
		nodeOne.left = new BinaryNode(10);
		nodeOne.right = new BinaryNode(20);
		nodeOne.left.left = new BinaryNode(8);
		nodeOne.left.right = new BinaryNode(12);
		nodeOne.right.left = new BinaryNode(16);
		nodeOne.right.right = new BinaryNode(25);
		nodeOne.right.left.left = new BinaryNode(19);
		return nodeOne;
	}
	public static BinaryNode createBinaryTreeTwo() {
		BinaryNode nodeTwo = new BinaryNode(1);
		nodeTwo.left = new BinaryNode(2);
		nodeTwo.right = new BinaryNode(3);
		nodeTwo.left.right = new BinaryNode(4); 
		nodeTwo.left.right.right = new BinaryNode(5); 
		nodeTwo.left.right.right.right = new BinaryNode(6);
		return nodeTwo;
	}
	
	public static BinaryNode createBinaryTreeThree() {
		BinaryNode nodeTwo = new BinaryNode(1);
		nodeTwo.left = new BinaryNode(3);
		nodeTwo.right = new BinaryNode(2);
		nodeTwo.right.left = new BinaryNode(4); 
		nodeTwo.right.left.left = new BinaryNode(5); 
		nodeTwo.right.left.left.left = new BinaryNode(6);
		return nodeTwo;
	}
	

}
