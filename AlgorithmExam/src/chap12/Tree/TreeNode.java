package chap12.Tree;

public class TreeNode {

	private TreeNode leftNode;
	private TreeNode rightNode;
	private String data;
	
	public TreeNode(String data) {
		this.data = data; 
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

	public String getData() {
		return data;
	}
	
}
