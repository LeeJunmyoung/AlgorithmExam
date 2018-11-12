package chap13.BinarySearchTree;

public class Application {

	
	public static void main(String[] args){
		BinarySearchTree bst = new BinarySearchTree();
		bst.insertBST(50);
		bst.insertBST(70);
		bst.insertBST(80);
		bst.insertBST(90);
		bst.insertBST(110);
		bst.insertBST(120);
		bst.insertBST(150);
		bst.insertBST(190);
		bst.insertBST(200);
		
		bst.inOrder();
		
		System.out.println();
		System.out.println("110 검색 : "+bst.searchBST(110));
		System.out.println("250 검색 : "+bst.searchBST(250));
	}
}
