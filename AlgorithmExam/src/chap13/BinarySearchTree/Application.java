package chap13.BinarySearchTree;

public class Application {

	
	public static void main(String[] args){
		BinarySearchTree bst = new BinarySearchTree();
		bst.insertBST(80);
		bst.insertBST(90);
		bst.insertBST(50);
		bst.insertBST(70);
		
		
		bst.insertBST(150);
		bst.insertBST(190);
		bst.insertBST(200);
		bst.insertBST(120);
		bst.insertBST(110);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		bst.inOrder();
		
		System.out.println();
		System.out.println("110 검색 : "+bst.searchBST(110));
		System.out.println("250 검색 : "+bst.searchBST(250));
		
		System.out.println("최소값 : " +bst.minValueNode(80).getData()); //시간복잡도 O(h)
		System.out.println("최대값 : " +bst.maxValueNode(80).getData()); //시간복잡도 O(h)
		System.out.println("Successor : " +bst.successor(190)); 
		
		System.out.println("90삭제");
		bst.deleteNode(90);
		bst.inOrder();
	}
}
