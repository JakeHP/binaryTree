package binaryTree;

public class BinaryTree {

	// Fields
	public Node root;
	
	// Constructors
	public BinaryTree(){
		root = null;
	}
	
	public BinaryTree(Node r00t){
		root = r00t;
	}

	// Insertion
	public void insert(Node a){
		if(a==null){return;}
		
		if(root==null){root = a;root.parent=null;return;}
		boolean hasNodeBeenAdded = false;
		Node it = root;
		
		while(!hasNodeBeenAdded){
			switch (a.compareTo(it)){
				case -1:
					if(it.leftChild==null){
						it.leftChild = a;
						a.parent = it;
						hasNodeBeenAdded=true;
					}else{
						it = it.leftChild;
					}
					break;
				case 0:
					System.out.println("Node Already Exists.");
					hasNodeBeenAdded=true;
					break;
				case 1:
					if(it.rightChild==null){
						it.rightChild = a;
						a.parent = it;
						hasNodeBeenAdded=true;
					}else{
						it = it.rightChild;
					}
					break;
				case Integer.MIN_VALUE:
					System.out.println("Error - Invalid Value.");
					hasNodeBeenAdded=true;
					break;
			}
		}
	}
		
	// Deletion
	
	// Depth-first order Traversals
	public void preorderTraversal(Node curr){
		if(curr == null){
			return;
		}
		doSomething(curr);
		preorderTraversal(curr.leftChild);
		preorderTraversal(curr.rightChild);
	}
	
	public void inorderTraversal(Node curr){
		if(curr == null){
			return;
		}
		inorderTraversal(curr.leftChild);
		doSomething(curr);
		inorderTraversal(curr.rightChild);
	}
	
	public void postorderTraversal(Node curr){
		if(curr == null){
			return;
		}
		inorderTraversal(curr.leftChild);
		inorderTraversal(curr.rightChild);
		doSomething(curr);
	}
	
	public void doSomething(Node n){
		System.out.print(n.value);
		System.out.print(",");
	}
	
	// Breadth-first order Traversal
	
	// isRootedBinaryTree
	
	// isFullBinaryTree
	
	// isPerfectBinaryTree
	
	// isCompleteBinaryTree
	
	// isInfiniteCompleteBinaryTree
	
	// isBalancedBinaryTree
	
	// isDegenrateTree
	
	// Helper Functions

}
