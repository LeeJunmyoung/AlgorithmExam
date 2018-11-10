package chap12.Tree;

public class Application {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode("a");
		
		TreeNode b =new TreeNode("b");
		TreeNode c =new TreeNode("c");
		root.addLeftSubTree(b);
		root.addRightSubTree(c);
		
		
		TreeNode d =new TreeNode("d");
		TreeNode e =new TreeNode("E");
		b.addLeftSubTree(d);
		b.addRightSubTree(e);
		
		
		TreeNode f =new TreeNode("f");
		TreeNode g =new TreeNode("g");
		c.addLeftSubTree(f);
		c.addRightSubTree(g);
		
		//순회 알고리즘 To-do
	}
	
}
