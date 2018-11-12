package chap13.BinarySearchTree;

public class TreeNode {

	private TreeNode leftNode;
	private TreeNode rightNode;
	private int data;
	
	public TreeNode(){
		
	}
	
	public TreeNode(int _data){
		this.data=_data;
	}
	
	
	public void addLeftSubTree(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	
	public void addRightSubTree(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public TreeNode getLeftNode() {
		return leftNode;
	}

	public TreeNode getRightNode() {
		return rightNode;
	}

	public int getData() {
		return data;
	}
	
}
