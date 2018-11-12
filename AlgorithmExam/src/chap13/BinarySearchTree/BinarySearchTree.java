package chap13.BinarySearchTree;

public class BinarySearchTree {
	private TreeNode root = new TreeNode(100);
	
	public void insertKey(TreeNode node,int data){
		TreeNode p = node;
		TreeNode newNode = new TreeNode(data);
				
		
		if(p==null){
			return;
		}else{
			if(p.getData()>newNode.getData()){
				if(p.getLeftNode()==null)
					p.addLeftSubTree(newNode);
				else
					insertKey(p.getLeftNode(),data);
			}else if(p.getData()<newNode.getData()){
				if(p.getRightNode()==null)
					p.addRightSubTree(newNode);
				else
					insertKey(p.getRightNode(),data);
			}else{
				return;
			}
		}
		
		
	}
	
	public void insertBST(int _data){
		insertKey(root, _data);
	}
	
	public boolean searchBST(int _data){
        TreeNode p = root;
        while(p!=null){
            if(_data<p.getData()) p = p.getLeftNode();
            else if(_data>p.getData()) p = p.getRightNode();
            else return true;
        }
        return false;
    }
	
	
	private void inOrderTraver(TreeNode node){
		
		if(node==null)
			return;
		
		inOrderTraver(node.getLeftNode());
		
		System.out.print(node.getData()+" ");
		
		inOrderTraver(node.getRightNode());
		
	}
	
	public void inOrder(){
		inOrderTraver(root);
	}
	
}
