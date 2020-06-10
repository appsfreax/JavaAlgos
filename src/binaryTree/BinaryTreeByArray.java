package binaryTree;
/**
 * This class is used for BinaryTree implementation with Array
 * @author rima.jain
 *
 */
public class BinaryTreeByArray {
	
	int arr[];
	int lastUsedIndex;
	
	public BinaryTreeByArray(int size) {
		//Size plus one bcs 0 is not considered
		arr= new int[size+1];
		lastUsedIndex = 0;
		System.out.println("BinaryTree has been created with size"+size);
	}
	
	//Check is array is full
	public boolean isTreeFull() {
		if(arr.length-1==lastUsedIndex) {
			return true;
		}else {
			return false;
		}	
	}
	
	//Insert value
	public void insertValue(int value) {
		if(!isTreeFull()) {
			arr[lastUsedIndex+1]=value;
			lastUsedIndex++;
		}else {
			System.out.println("Tree is full, value cannot be inserted");
		}
	}
	
	public int searchNode(int value) {
		for(int i=1;i<=lastUsedIndex;i++) {
			if(arr[i]==value) {
				System.out.println(arr[i]);
				return i;
			}
		}
		
		return -1;
	}
	
	//level order traversal
	public void levelOrder() {
		if(lastUsedIndex==0||arr==null) {
			System.out.println("No elements");
		}else {
			for(int i=1;i<=lastUsedIndex;i++) {
				System.out.println(arr[i]);
			}
		}
	}
	
	//Pre-order traversal
	public void preOrder(int index) {
		if(index>lastUsedIndex) {
			return;
		}
		System.out.println(arr[index]+" ");
		preOrder(index*2);
		preOrder(index*2+1);
		
	}
	
	//In-order traversal
	public void inOrder(int index) {
		if(index>lastUsedIndex) {
			return;
		}else {
			inOrder(index*2);
			System.out.println(arr[index]+" ");
			inOrder(index*2+1);
		}
	}
	
	//Post-order traversal
	public void postOrder(int index) {
		if(index>lastUsedIndex) {
			return;
		}else {
			postOrder(index*2);
			postOrder(index*2+1);
			System.out.println(arr[index]+" ");
		}
	}
	//Delete node
	public void deleteValue(int value) {
		int location = searchNode(value);
		if(location ==-1) {
			System.out.print("Value does not exist ");
		}else {
			//swap current node with lastUsedIndex node
			arr[location]=arr[lastUsedIndex];
			lastUsedIndex--;
			System.out.println("Deleted");
		}
	}
	//Delete Tree
	public void deleteTree() {
		try {
			arr=null;
			lastUsedIndex=0;
			System.out.println("Deleted");
		}catch(Exception e){
			System.out.println("Error while Deleting");
		}
	}

}
