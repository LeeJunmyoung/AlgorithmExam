package chap12.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class OrderTraversal {

	public void preOrderTraver(TreeNode node){
		
		if(node==null)
			return;
		
		System.out.print(node.getData());
		
		preOrderTraver(node.getLeftNode());
		
		preOrderTraver(node.getRightNode());
		
	}
	
	
	
	public void inOrderTraver(TreeNode node){
		
		if(node==null)
			return;
		
		inOrderTraver(node.getLeftNode());
		
		System.out.print(node.getData());
		
		inOrderTraver(node.getRightNode());
		
	}
	
	public void postOrderTraver(TreeNode node){
		
		if(node==null)
			return;
		
		postOrderTraver(node.getLeftNode());
		
		postOrderTraver(node.getRightNode());
		
		System.out.print(node.getData());
		
	}
	
	public void levelOrderTraver(TreeNode node){
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(node);
		
		while(!q.isEmpty()){
			TreeNode n = q.poll();
			System.out.print(n.getData());
			
			if(n.getLeftNode()!=null)
				q.offer(n.getLeftNode());
			if(n.getRightNode()!=null)
				q.offer(n.getRightNode());
			
			
		}
	}
	
}
