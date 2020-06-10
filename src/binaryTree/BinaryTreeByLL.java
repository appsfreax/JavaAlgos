package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import models.BinaryNode;

public class BinaryTreeByLL {
	
	BinaryNode root;  
	
	public BinaryTreeByLL() {
		this.root =null;
	}
	
	//Insertion
	public void insertValue(int value) {
		BinaryNode tempNode = new BinaryNode();
		tempNode.setValue(value);
		if(root==null) {
			root = tempNode;
			return;
		}
		
		//Creating a queue
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			//Removing the first item from queue for operation
			BinaryNode presentNode = queue.remove();
			//If left child is not present
			if(presentNode.getLeft()==null) {
				presentNode.setLeft(tempNode);
				break;
			}//If right child is not present
			else if(presentNode.getRight()==null) {
				presentNode.setRight(tempNode);
				break;
			}//Add the nodes left nd right element in queue
			else {
				queue.add(presentNode.getLeft());
				queue.add(presentNode.getRight());
			}
			
		}
	}
	//Search value
	public void searchValue(int value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if(presentNode.getValue()==value) {
				System.out.print("Found");
				return;
			}else {
				if(presentNode.getLeft()!=null) {
					queue.add(presentNode.getLeft());
				}
				if(presentNode.getRight()!=null) {
					queue.add(presentNode.getRight());
				}
			}
			System.out.print("Value not found");
		}
	}
	//Pre order
	public void preOrderTraversal(BinaryNode node) {
		if(node ==null)
			return;
		System.out.println(node.getValue());
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
	}
	//Post Order
	public void postOrderTraversal(BinaryNode node) {
		if(node ==null)
			return;
		
		postOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
		System.out.print(node.getValue());
	}
	//In order
	public void inOrderTraversal(BinaryNode node) {
		if(node ==null)
			return;
		
		inOrderTraversal(node.getLeft());
		System.out.print(node.getValue());
		inOrderTraversal(node.getRight());
		
	}
	//Level order
	public void levelOrderTraversal() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.getValue());
			
			if(presentNode.getLeft()!=null) {
				queue.add(presentNode.getLeft());
			}
			if(presentNode.getRight()!=null) {
				queue.add(presentNode.getRight());
			}
		}
	}
	
	//Delete Tree
	public void deleteTree() {
		root=null;
		System.out.print("Deleted");
	}
	
	//get last node of the last level of tree
	public BinaryNode getDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode presentNode = null;
		while(!queue.isEmpty()) {
			presentNode = queue.remove();
			if(presentNode.getLeft()!=null) {
				queue.add(presentNode.getLeft());
			}
			if(presentNode.getRight()!=null) {
				queue.add(presentNode.getRight());
			}
		}
		return presentNode;
	}
	//DeleteDeepestNode
	//deleteNodeOfBinaryTree

}
