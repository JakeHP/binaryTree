package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

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
			switch (a.compare(it)){
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
	public void delete(Node n){
		if(n==null){return;}
		if(root==null){return;}
	}
	
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
	
	public void postorderTraversal(Node curr, String purpose){
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
	
// Breadth-first order Traversal aka level-order
	public void breadthfirstTraversal(){
		if(root==null){return;}
		Queue<Node> hold = new LinkedList<Node>();
		hold.add(root);
		while(!hold.isEmpty()){
			Node x = hold.peek();
			if(x.leftChild!=null){
				hold.add(x.leftChild);
			}
			if(x.rightChild!=null){
				hold.add(x.rightChild);
			}
			doSomething(x);
			hold.poll();
		}
	}
	
// Helper Functions
	public int getDepth(Node n){
		if(n==null || root==null){return Integer.MIN_VALUE;}
		int depth=0;
		while(n.value!=root.value){
			n=n.parent;
			depth++;
		}
		return depth;
	}
	
	public boolean isLeafNode(Node n){
		if(n.leftChild == null && n.rightChild == null){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isInternalNode(Node n){
		if(n.leftChild !=null || n.rightChild !=null){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isFullInternalNode(Node n){
		if(n.leftChild !=null && n.rightChild !=null){
			return true;
		}else{
			return false;
		}
	}
	
	public int countNumberOfNodes(Node curr){
		if(curr==null){return 0;}
		int count=0;
		Queue<Node> hold = new LinkedList<Node>();
		hold.add(curr);
		while(!hold.isEmpty()){
			Node x = hold.peek();
			if(x.leftChild!=null){
				hold.add(x.leftChild);
			}
			if(x.rightChild!=null){
				hold.add(x.rightChild);
			}
			count++;
			hold.poll();
		}
		return count;
	}
	
// Binary Tree Properties
	public int getTreeHeight(){
		if(root==null){return 0;}
		Queue<Node> hold = new LinkedList<Node>();
		int deepestDepth = Integer.MIN_VALUE;
		hold.add(root);
		while(!hold.isEmpty()){
			Node x = hold.peek();
			if(x.leftChild!=null){
				hold.add(x.leftChild);
			}
			if(x.rightChild!=null){
				hold.add(x.rightChild);
			}
			if(getDepth(x) > deepestDepth){
				deepestDepth = getDepth(x);
			}
			hold.poll();
		}
		return deepestDepth;
	}
	
	public int getNumberOfNodes(){
		if(root==null){return 0;}
		int counter = countNumberOfNodes(root);
		return counter;
	}
			
	// isFullBinaryTree()
	// A Full Binary Tree is a tree in which every node other than the leaves has 
	// two children. That is, every node in a binary tree has 
	// either two children or no children.
	public boolean isFullBinaryTree(){
		if(root==null){return true;}
		Queue<Node> temp = new LinkedList<Node>();
		temp.add(root);
		while(!temp.isEmpty()){
			Node x = temp.peek();
			if(x!=null){
				//Must have 2 valid children or 2 nulls
				if(isFullInternalNode(x) || isLeafNode(x)){//If valid parent, check through children
						temp.add(x.leftChild);
						temp.add(x.rightChild);
				}else
				{
					return false;
				}
			}
			temp.poll();
		}
		
		return true;
	}
	
	// isPerfectBinaryTree()
	// A perfect binary tree is a full binary tree
	// in which all leaves have the same depth/level.
	public boolean isPerfectBinaryTree(){
		if(root==null){return false;}
		if(!isFullBinaryTree()){return false;}
		int lastLeafFoundDepth=Integer.MIN_VALUE;
		Queue<Node> temp = new LinkedList<Node>();
		temp.add(root);
		while(!temp.isEmpty()){
			Node x = temp.peek();
			if(x!=null){
				if(x.leftChild != null){
					temp.add(x.leftChild);
				}
				if(x.rightChild != null){
					temp.add(x.rightChild);
				}
				if(this.isLeafNode(x)){
					// If first neaf lode, set lastDepth, otherwise compare
					// and invalidate tree if not the same depth
					if(lastLeafFoundDepth == Integer.MIN_VALUE){
						lastLeafFoundDepth = getDepth(x);
					}else{
						if(lastLeafFoundDepth != getDepth(x)){
							return false;
						}
					}
				}
			}
			temp.poll();
		}
		return true;
	}
	
	// isCompleteBinaryTree()
	// All levels are full, except for the last. And all
	// nodes in the last level are "all the way left"
	
	// isBalancedBinaryTree()
	// will be writing separate balanced tree structures
	
	// isDegenerateTree()
	// A degenerate tree is a tree where each parent node 
	// has only one associated child node. This means that performance-wise, 
	// the tree will behave like a linked list data structure.
	public boolean isDegenerateTree(){
		if(root==null){return true;}
		Queue<Node> temp = new LinkedList<Node>();
		temp.add(root);
		while(!temp.isEmpty()){
			Node x = temp.peek();
			if(x!=null){
				if(isFullInternalNode(x)){
					return false;
				}
				if(x.leftChild != null){
					temp.add(x.leftChild);
				}
				if(x.rightChild != null){
					temp.add(x.rightChild);
				}
			}
			temp.poll();
		}
		return true;
	}

}
