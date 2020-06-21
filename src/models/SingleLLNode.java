package models;
/*
 * LinkedList Node
 */
public class SingleLLNode {
	
	private int value;
	private SingleLLNode next;
	
	public SingleLLNode getNext() {
		return next;
	}
	
	public void setNext(SingleLLNode next) {
		this.next = next;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
