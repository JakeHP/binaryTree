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
	
	// Traversal
		// Depth-first order
			//Pre-order
			//In-order
			//Post-order
	
		// Breadth-first order
	
	// isRootedBinaryTree
	
	// isFullBinaryTree
	
	// isPerfectBinaryTree
	
	// isCompleteBinaryTree
	
	// isInfiniteCompleteBinaryTree
	
	// isBalancedBinaryTree
	
	// isDegenrateTree
	
	// Helper Functions

}
