package binaryTree;
/*
Change this class to jUnits
http://www.tutorialspoint.com/junit/
*/
public class test {

	public static void main(String[] args) {

		// Binary Tree Construction 
		BinaryTree testTree = new BinaryTree();
		Node root = new Node(5);
		Node a = new Node(3);
		Node b = new Node(8);
		Node c = new Node(9);
		Node d = new Node(1);
		Node e = new Node(4);
		Node f = new Node(7);
		testTree.insert(root);
		testTree.insert(a);
		testTree.insert(b);
		testTree.insert(c);
		testTree.insert(d);
		testTree.insert(e);
		testTree.insert(f);
		
		// Traversal Tests
		/*
		testTree.preorderTraversal(testTree.root);
		System.out.println("\n");
		testTree.inorderTraversal(testTree.root);
		System.out.println("\n");
		testTree.postorderTraversal(testTree.root);
		System.out.println("\n");
		testTree.breadthfirstTraversal();
		System.out.println("\n");
		*/
		
		// Helper Func Tests
		/*
		System.out.println(testTree.getDepth(root));
		System.out.println(testTree.getDepth(a));
		System.out.println(testTree.getDepth(b));
		System.out.println(testTree.getDepth(c));
		*/
		
		// Property Tests
		//System.out.println("Is tree degenerate? "+testTree.isDegenerateTree());
		//System.out.println("Is it a full tree? "+testTree.isFullBinaryTree());
		//System.out.println("Is it a perfect binary tree? "+testTree.isPerfectBinaryTree());
	}

}
