package linkedlist;

import models.SingleLLNode;

/*
 * Single Circular LinkedList implementation
 * 1. Creation
 * 2. Insertion
 * 3. Search
 * 4. Traversal
 * 5. Deletion of node
 * 6. Deletion of linked list
 */
public class SingleCircularLinkedList {
	
	private SingleLLNode head;
	private SingleLLNode tail;
	private int size;
	
	public SingleLLNode getHead() {
		return head;
	}
	
	public void setHead(SingleLLNode head) {
		this.head = head;
	}
	
	public SingleLLNode getTail() {
		return tail;
	}
	
	public void setTail(SingleLLNode tail) {
		this.tail = tail;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	/*
	 * Creating a new CircularLinkedList
	 */
	public void createCLL(int value) {
		head = new SingleLLNode();
		SingleLLNode node = new SingleLLNode();
		node.setValue(value);
		head=node;
		tail= node;
		node.setNext(node);
	}
	/*
	 * Inserting a node in Circular Linked List
	 */
	public void insert(int location, int value, SingleLLNode head) {
		SingleLLNode node = new SingleLLNode();
		node.setValue(value);
		if(head ==null) {
			return;
		}else if(location ==0) { //insert at first location
			node.setNext(head);
			head = node;
			tail.setNext(node);
		}else if(location>=size) { //insert at last
			node.setNext(head);
			tail.setNext(node);
			tail = node;
		}else {//internally
			SingleLLNode tempNode = head;
			int index=0;
			while(index < location -1) {
				tempNode = tempNode.getNext();
			}
			node.setNext(tempNode.getNext());
			tempNode.setNext(node);
		}
	}
	/*
	 * Traversal in circular Linked List
	 */
	public void traversal(SingleLLNode head) {
		if(head==null) {
			return;
		}else {
			SingleLLNode tempNode = head;
			for(int i =0;i<size;i++) {
				System.out.println(tempNode.getValue());
				tempNode = tempNode.getNext();
			}
		}
	}
	/*
	 * Searching in circular Linked List
	 */
	public boolean searchNode(int value,SingleLLNode head) {
		if(head == null) {
			return false;
		}else {
			SingleLLNode tempNode = head;
			for(int i=0;i<size;i++){
				if(tempNode.getValue()==value) {
					return true;
				}
				tempNode= tempNode.getNext();
			}
		}
		return false;
	}
	/*
	 * Deleting a node
	 */
	public void deleteNode(int location, SingleLLNode head) {
		if(head==null) {
			return;
		}else {
			if(location ==0) {
				head = head.getNext();
				tail.setNext(head);
				if(size==0) {
					tail=null;
				}
			}else if(location <=size) {
				SingleLLNode tempNode = head;
				for(int i =0;i<size;i++) {
					tempNode = tempNode.getNext();
				}
				if(tempNode==head) {
					tail=null;
					head=null;
				}
				tempNode.setNext(head);
				tail = tempNode;			
			}else {
				SingleLLNode tempNode = head;
				for (int i = 0; i < location - 1; i++) {
					tempNode = tempNode.getNext(); 
				}	
				tempNode.setNext(tempNode.getNext().getNext());
			}
		}
	}
	/*
	 * Deleting LinkedList
	 */
	public void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		head = null;
		if(tail == null) {
			System.out.println("Linked List is already deleted, nothing to delete !");
			return;
		}else {
			tail.setNext(null);
			tail = null;
			System.out.println("Linked List deleted successfully !");
		}
	}
	

}
