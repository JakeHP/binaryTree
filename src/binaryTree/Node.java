package binaryTree;

public class Node {
	
	// Fields
	public Node leftChild;
	public Node rightChild;
	public int data;
	
	// Constructors
	public Node(){
		leftChild = null;
		rightChild = null;
		data = Integer.MIN_VALUE;
	}
		
	public Node(Node left, Node right, int value){
		leftChild = left;
		rightChild = right;
		data = value;
	}
	
	// Mutators
	public void setLeftChild(Node left){
		leftChild = left;
	}
	
	public void setRightChild(Node right){
		rightChild = right;
	}
	
	public void setData(int value){
		data = value;
	}

	// Accessors
	public Node getLeftChild(){
		return leftChild;
	}
	
	public Node getRightChild(){
		return rightChild;
	}
	
	public int getData(){
		return data;
	}
	
}
