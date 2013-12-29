package binaryTree;

public class Node {
	
	// Fields
	public Node leftChild;
	public Node rightChild;
	public Node parent;
	public int value;
	
	// Constructors
	public Node(){
		leftChild = null;
		rightChild = null;
		value = Integer.MIN_VALUE;
	}
	
	public Node (int newValue){
		leftChild = null;
		rightChild = null;
		value = newValue;
	}
		
	public Node(Node left, Node right, int newValue){
		leftChild = left;
		rightChild = right;
		value = newValue;
	}
	
	// Mutators
	public void setLeftChild(Node left){
		leftChild = left;
	}
	
	public void setRightChild(Node right){
		rightChild = right;
	}
	
	public void setData(int newValue){
		value = newValue;
	}

	// Accessors
	public Node getLeftChild(){
		return leftChild;
	}
	
	public Node getRightChild(){
		return rightChild;
	}
	
	public int getValue(){
		return value;
	}
	
	// Comparators
	public boolean isLessThan(Node b){
		if(this.value < b.value){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isGreaterThan(Node b){
		if(this.value > b.value){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isEqualTo(Node b){
		if(this.value == b.value){
			return true;
		}else{
			return false;
		}
	}
	
	public int compareTo(Node b){
		if(this.isLessThan(b)){
			return -1;
		}
		if(this.isEqualTo(b)){
			return 0;
		}
		if(this.isGreaterThan(b)){
			return 1;
		}
		return Integer.MIN_VALUE;
	}
	
}
