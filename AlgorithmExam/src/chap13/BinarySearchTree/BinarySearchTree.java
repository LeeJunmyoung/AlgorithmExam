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
				if(p.getLeftNode()==null){
					newNode.addParentNode(p);
					p.addLeftSubTree(newNode);
				}else
					insertKey(p.getLeftNode(),data);
			}else if(p.getData()<newNode.getData()){
				if(p.getRightNode()==null){
					newNode.addParentNode(p);
					p.addRightSubTree(newNode);
				}else
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
	
	public TreeNode minValueNode (int _data){
		TreeNode p = searchNode(_data);
		while(p.getLeftNode()!=null){
			p=p.getLeftNode();
		}
		return p;
	}
	
	public TreeNode maxValueNode (int _data){
		TreeNode p = searchNode(_data);
		while(p.getRightNode()!=null){
			p=p.getRightNode();
		}
		return p;
	}
	
	
	//노드 x의 successor 란 key[x]보다 크면서 가장 작은 키를 가진 노드.
	
	public int successor(int _data){
		TreeNode node = searchNode(_data);
		if (node == null)
	        return -1;

	    if (node.getRightNode() != null) {
	        return minValueNode(node.getRightNode().getData()).getData();
	    }

	    // 내 자신이 오른쪽 노드가 없을경우
	    // 반복문으로 내 붐의 오른쪽이 나일경우는 내가 더큰거임. 그렇기 때문에 상위로 올라감 
	    // 상위로 올라갔는데 내가 왼쪽노드라면 나보단 큰수 이기때문에 끝이남.
	    while (null != node.getParentNode()  
	            && node.getParentNode().getRightNode() == node) { 

	        node = node.getParentNode();
	    }

		return node.getParentNode().getData();
	}
	
	private TreeNode searchNode(int _data){
		TreeNode p = root;
		while(p!=null){
            if(_data<p.getData()) p = p.getLeftNode();
            else if(_data>p.getData()) p = p.getRightNode();
            else return p;
        }
		return null;
	}
	
	//삭제시 왼쪽이 있을시
	//왼쪽트리의 가장 큰값으로 대체
	//오른쪽트리의 가장 작은값으로 대체
	public void deleteNode(int _data){
		TreeNode node = searchNode(_data);
		TreeNode replaceNode=null;
		if(node.getLeftNode()!=null){
			replaceNode = maxValueNode(node.getLeftNode().getData());
			replaceNode.getParentNode().addLeftSubTree(null);
		}else if(node.getRightNode()!=null){
			replaceNode = minValueNode(node.getRightNode().getData());
			replaceNode.getParentNode().addRightSubTree(null);
        }
		
	
		if(node.getParentNode().getLeftNode()==node){
			node.getParentNode().addLeftSubTree(replaceNode);
		}else{
			node.getParentNode().addRightSubTree(replaceNode);
		}
		
	}
	
}
