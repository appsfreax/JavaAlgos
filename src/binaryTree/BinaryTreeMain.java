package BinaryTree;

public class BinaryTreeMain {

	public static void main(String[] args) {
		
		//Create a blank array to store Binary Tree
		System.out.println("Creating a blank Array to store Binary Tree...");
		BinaryTreeByArray tree = new BinaryTreeByArray(10);
		
		//Insert 10 values in the tree
		System.out.println("Inserting 10 values in the Tree...");
		for(int i=1; i<=10; i++){
			tree.insertValue(i*10);
		}
		
		
		//Level order Traverse
		System.out.println("\nLevel-order Traversal:");
		tree.levelOrder();
		
		//Pre order Traverse, terversing from index 1
		System.out.println("\n\nPre-order Traversal:");
		tree.preOrder(1);
		
		//PostOrder
		System.out.println("\n\nPost-order Traversal:");
		tree.postOrder(1);
		
		//In order
		System.out.println("\n\nIn-order Traversal:");
		tree.inOrder(1);
		
		//Search Value
		System.out.println("\n\nSearch Value:");
		System.out.println(tree.searchNode(20));
		
		//Delete Value
		System.out.println("\n\nDelete Value:");
		tree.deleteValue(40);
		
		//Level order Traverse
		System.out.println("\nLevel-order Traversal:");
		tree.levelOrder();
		
		//Delete Tree
		System.out.println("\nDelete Tree:");
		tree.deleteTree();
		
		//Level order Traverse
		System.out.println("\nLevel-order Traversal:");
		tree.levelOrder();
		
		
		
		
		
		
		
		

				
				

	}

}
