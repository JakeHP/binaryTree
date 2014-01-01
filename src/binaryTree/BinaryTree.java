package binaryTree;

import java.util.ArrayList;
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
	
	public Node getDeepestLeftNode(Node n){
		if(n==null){System.out.println("Error - getDeepestLeftNode() - returning bad node.");return new Node(Integer.MIN_VALUE);}
		Node d = new Node(Integer.MIN_VALUE);
		while(n!=null){
			if(n.leftChild!=null){
				n=n.leftChild;
			}else{
				return n;
			}
		}
		System.out.println("Error - getDeepestLeftNode() - Returning bad node.");
		return d;
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
					System.out.println("Error - insert() - Node Already Exists.");
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
					System.out.println("Error - insert() - Invalid Value.");
					hasNodeBeenAdded=true;
					break;
			}
		}
	}
		
// Deletion
// TODO
// Need to change algorithm to find the node to be deleted.
	public boolean delete(Node n){
		if(n==null){return false;}
		if(root==null){return false;}
		boolean deleted = false;
		Queue<Node> hold = new LinkedList<Node>();
		hold.add(root);
		while(!hold.isEmpty() && !deleted){
			Node x = hold.peek();
			if(x.leftChild!=null){
				hold.add(x.leftChild);
			}
			if(x.rightChild!=null){
				hold.add(x.rightChild);
			}
			if(x.value==n.value){
				if(x.rightChild!=null){ //Internal Node Handler
					Node deepestLeft = getDeepestLeftNode(x.rightChild);
					if(deepestLeft.rightChild!=null){ //Fix deepestLeft's right child (no left child, because it is deepest left)
						deepestLeft.rightChild.parent=deepestLeft.parent;
						deepestLeft.parent.leftChild=deepestLeft.rightChild;
						deepestLeft.rightChild=null;
					}
					if(x.parent==null){ //DeepestLeft is new root
						deepestLeft.parent=null;
						root=deepestLeft;
					}else{
						if(x.parent.rightChild.isEqualTo(x)){ //Determine which child x is
							deepestLeft.parent=x.parent;
							deepestLeft.parent.rightChild=deepestLeft;
						}
						if(x.parent.leftChild.isEqualTo(x)){
							deepestLeft.parent=x.parent;
							deepestLeft.parent.leftChild=deepestLeft;
						}
					}
					if(x.leftChild!=null){ //If deleted node has left child, reassign parent
						deepestLeft.leftChild=x.leftChild;
						deepestLeft.leftChild.parent=deepestLeft;
					}
					x.rightChild.parent=deepestLeft; //Fix original right childs relationship
					deepestLeft.rightChild=x.rightChild;
					deleted=true;
				}
				if(x.leftChild!=null && !deleted){ //Internal Node handler
					x.parent.leftChild=x.leftChild;
					x.leftChild.parent=x.parent;
					deleted=true;
				}
				if(x.leftChild==null && x.rightChild==null && !deleted){ //Leaf node
					if(x.parent!=null){
						if(x.parent.rightChild.isEqualTo(x)){ //Determine which child x is
							x.parent.rightChild=null;
						}
						if(x.parent.leftChild.isEqualTo(x)){
							x.parent.leftChild=null;
						}
					}else{ //deleting root, when root is only node in tree.
						root=null;
					}
					deleted=true;
				}
			}
			hold.poll();
		}
		System.out.println("Error - delete() - Node not found.");
		return false;
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
	public boolean isCompleteBinaryTree(){
		if(root==null){return false;}
		int height = this.getTreeHeight();
		ArrayList<Node> temp = new ArrayList<Node>();
		Queue<Node> hold = new LinkedList<Node>();
		hold.add(root);
		while(!hold.isEmpty()){
			Node x = hold.peek();
			if(x!=null){
				temp.add(x);
				if(x.leftChild != null){
					hold.add(x.leftChild);
				}
				if(x.rightChild != null){
					hold.add(x.rightChild);
				}
			}
			hold.poll();
		}

		int nodesBeforeSecondToLastLevel = (int) (Math.pow(2, (height-1)) - 1);
		int nodesOnLastLevel = (temp.size()-((int) (Math.pow(2, height)-1)));	
		// Shim off nodes prev to level before last.
		for(int i=0;i<nodesBeforeSecondToLastLevel;i++){
			temp.remove(0);
		}
		// Shim off last level nodes	
		for(int z=0;z<nodesOnLastLevel;z++){
			temp.remove(temp.size()-1);
		}
		// Check the children of the level before the last
		boolean nullFound = false;
		for(int v=0;v<temp.size();v++){
			if(temp.get(v).leftChild!=null){
				if(nullFound){
					return false;
				}
			}else{
				nullFound=true;
			}
			if(temp.get(v).rightChild!=null){
				if(nullFound){
					return false;
				}
			}else{
				nullFound=true;
			}
		}

		return true;
	}
	
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
