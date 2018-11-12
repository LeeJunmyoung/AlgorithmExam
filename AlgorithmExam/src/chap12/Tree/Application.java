package chap12.Tree;

public class Application {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode("F");
		
		TreeNode B =new TreeNode("B");
		TreeNode G =new TreeNode("G");
		root.addLeftSubTree(B);
		root.addRightSubTree(G);
		
		
		TreeNode A =new TreeNode("A");
		TreeNode D =new TreeNode("D");
		B.addLeftSubTree(A);
		B.addRightSubTree(D);
		
		
		TreeNode C =new TreeNode("C");
		TreeNode E =new TreeNode("E");
		D.addLeftSubTree(C);
		D.addRightSubTree(E);
		
		TreeNode I =new TreeNode("I");
		G.addRightSubTree(I);
		
		TreeNode H =new TreeNode("H");
		I.addLeftSubTree(H);
		
		OrderTraversal order = new OrderTraversal();
		//전위 순회
		System.out.println("전위 순회 : ");
		order.preOrderTraver(root);
		System.out.println();
		System.out.println("중위 순회 : ");
		order.inOrderTraver(root);
		System.out.println();
		System.out.println("후위 순회 : ");
		order.postOrderTraver(root);
		System.out.println();
		System.out.println("레벨 순서 순회 : ");
		order.levelOrderTraver(root);
	}
	
}
