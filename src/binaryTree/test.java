package binaryTree;

public class test {

	public static void main(String[] args) {

		BinaryTree testTree = new BinaryTree();
		Node root = new Node(5);
		Node a = new Node(3);
		Node b = new Node(7);
		
		testTree.insert(root);
		testTree.insert(a);
		testTree.insert(b);
		
		testTree.preorderTraversal(testTree.root);
		System.out.println("\n");
		testTree.inorderTraversal(testTree.root);
		System.out.println("\n");
		testTree.postorderTraversal(testTree.root);
		
	}

}
