package binaryTree;

public class test {

	public static void main(String[] args) {

		// Binary Tree Construction 
		BinaryTree testTree = new BinaryTree();
		Node root = new Node(5);
		Node a = new Node(3);
		Node b = new Node(7);
		Node c = new Node(8);
		Node d = new Node(1);
		testTree.insert(root);
		testTree.insert(a);
		testTree.insert(b);
		testTree.insert(c);
		testTree.insert(d);
		
		// Traversal Tests
		/*
		testTree.preorderTraversal(testTree.root);
		System.out.println("\n");
		testTree.inorderTraversal(testTree.root);
		System.out.println("\n");
		testTree.postorderTraversal(testTree.root);
		System.out.println("\n");
		testTree.breadthfirstTraversal();
		*/
		
		// Property Tests
		System.out.println("Is tree degenerate? "+testTree.isDegenerateTree());
	}

}
