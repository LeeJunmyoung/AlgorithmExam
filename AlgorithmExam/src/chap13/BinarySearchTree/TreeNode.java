package chap13.BinarySearchTree;

public class TreeNode {

	private TreeNode leftNode;
	private TreeNode rightNode;
	private TreeNode parentNode;
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
	public void addParentNode(TreeNode parentNode){
		this.parentNode = parentNode;
	}
	

	public TreeNode getLeftNode() {
		return leftNode;
	}

	public TreeNode getRightNode() {
		return rightNode;
	}

	public TreeNode getParentNode() {
		return parentNode;
	}

	public int getData() {
		return data;
	}
	
}
