package linkedlist;

import models.SingleLLNode;
/*
 * Implementation of Single LinkedList
 * 1. Creation
 * 2. Inserting
 * 3. Searching
 * 4. Traversing
 * 5. Deletion of node
 * 6. Deletion of LL
 */
public class SingleLinkedList {
	
	private SingleLLNode head;
	private SingleLLNode tail;
	private int size;
	
	/*
	 * Create a Single Linked List
	 */
	public SingleLLNode createLinkedList(int value) {
		head = new SingleLLNode();
		SingleLLNode node = new SingleLLNode();
		node.setValue(value);
		node.setNext(null);
		tail = node;
		head = node;
		return head;
	}
	/*
	 * Insert in a Single Linked List
	 */
	public void insert(int data, int location,SingleLLNode head,int size) {
		SingleLLNode node = new SingleLLNode();
		node.setValue(data);
		if(head==null) {
			System.out.println("No elements");
			return;
		}else if (location ==0) { //insert at first position
			node.setNext(null);
			head = node;
		}else if (location>=size) { //insert at last location
			tail = node;
			tail.setNext(node);
			node.setNext(null);
		}else {//insert internally
			SingleLLNode tempNode = new SingleLLNode();
			int index =0;
			while(index<location -1) {
				tempNode = tempNode.getNext();
				index++;
			}
			SingleLLNode nextNode = tempNode.getNext();
			tempNode.setNext(node);
			node.setNext(nextNode);
		}
	}
	/*
	 * Delete Single LinkedList
	 */
	public void deleteLinkedList(SingleLLNode head,SingleLLNode tail) {
		head=null;
		tail=null;
		System.out.println("Deleted");
	}
	/*
	 * Deletion of Node in Single Linked List
	 */
	public void deleteNode(SingleLLNode head, int location, int size) {
		if(head==null) {
			System.out.println("No elements to delete");
			return;
		}else if(location ==0){//delete first element
			head=head.getNext();
			if(size==0) {
				tail =null;
			}
		}else if(location >=size) {//delete last element
			SingleLLNode tempNode = new SingleLLNode();
			for(int i =0;i<size;i++) {
				tempNode = tempNode.getNext();
			}
			if(tempNode == head) {//if this is the only element
				head=null;
				tail=null;
				return;
			}
			tempNode.setNext(null);
			tail = tempNode;
		}else {//delete internal element
			SingleLLNode tempNode = new SingleLLNode();
			for(int i =0;i<location -1;i++) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(tempNode.getNext().getNext());
		}
	}
	/*
	 * Traversing in Single LinkedList
	 */
	public void traversing(SingleLLNode head,int size) {
		if(head!=null) {
			SingleLLNode tempNode = head;
			for(int i =0;i<size;i++) {
				System.out.println(tempNode.getValue());
				tempNode = tempNode.getNext();
			}
		}else {
			System.out.print("No elements to traverse");
		}
	}
	/*
	 * Searching in Single Linked List
	 */
	public boolean search(int value,SingleLLNode head,int size) {
		if(head ==null) {
			System.out.println("No elements to search");
			return false;
		}else {
			SingleLLNode tempNode = head;
			for(int i=0;i<size;i++) {
				if(tempNode.getValue()==value) {
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		return false;
	}
}
