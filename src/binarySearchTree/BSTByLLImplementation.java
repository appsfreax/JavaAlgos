package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

import models.BinaryNode;

public class BSTByLLImplementation {
	
	BinaryNode root;
	
	public BinaryNode getRoot() {
		return root;
	}
	
	public BSTByLLImplementation() {
		root=null;
	}
	
	/*
	 * Creating a new node
	 */
	public BinaryNode createNewNode(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);
		return node;
	}
	
	/*
	 * Inserting a value in BST
	 */
	public BinaryNode insert(BinaryNode root, int value) {
		if(root==null) {
			return createNewNode(value);
		}else if(root.getValue() > root.getLeft().getValue()) {
			root.setLeft(insert(root.getLeft(),value));
			return root;
		}else {
			root.setRight(insert(root.getRight(),value));
			return root;
		}
	}
	/*
	 * Searching a binary node
	 */
	public BinaryNode search(BinaryNode root, int value) {
		if(root==null) {
			System.out.println("No element found");
			return null;
		}else if (root.getValue()==value) {
			return root;
		}else if(root.getRight().getValue() > value) {
			return search(root.getRight(),value);
		}else
			return search(root.getLeft(),value);
	}
	/*
	 * To Delete a node 
	 */
	public BinaryNode deleteNodeinBST(BinaryNode root, int value) {
		if(root==null) {
			System.out.println("No elements found");
			return null;
		}else if(root.getLeft().getValue() < root.getLeft().getValue()) {
			deleteNodeinBST(root.getLeft(), value);
		}else if (root.getRight().getValue() > root.getLeft().getValue()) {
			deleteNodeinBST(root.getRight(), value);
		}//When current node is to be deleted
		else {
			// if nodeToBeDeleted have only left child
			if(root.getLeft()!=null) {
				root= root.getLeft();
			}//if nodeTobeDeleted have only right child
			else if(root.getRight()!=null) {
				root = root.getRight();
			}
			//have both childs
			else if(root.getRight()!=null && root.getLeft()!=null) {
				BinaryNode temp = root;
				BinaryNode minNodeForRight = minimumElement(temp.getRight());
				root.setValue(minNodeForRight.getValue());
				root.setRight(deleteNodeinBST(root.getRight(), minNodeForRight.getValue()));
				
			}else
				root=null;
		}
		return root;
	}
	/*
	 * Level order traversal
	 */
	public void levelOrderTraversal(BinaryNode root) {
		if(root==null) {
			System.out.println("No elements found");
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode = new BinaryNode ();
			presentNode = queue.poll();
			System.out.println(presentNode.getValue());
			if(presentNode.getLeft()!=null)
				queue.add(presentNode.getLeft());
			if(presentNode.getRight()!=null)
				queue.add(presentNode.getRight());
		}
	}
	/*
	 * Deleting Tree
	 */
	public void deleteTree(BinaryNode root) {
		root=null;
		System.out.print("Deleted");
	}
	/*
	 * To find the minimum element
	 */
	public BinaryNode minimumElement(BinaryNode root) {
		if(root.getLeft()==null) {
			return root;
		}else
			return minimumElement(root.getLeft());
	}	
}