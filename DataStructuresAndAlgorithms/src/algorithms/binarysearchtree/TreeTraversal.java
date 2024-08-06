package algorithms.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
/**
 * @author dbommare
 * In this class we are going to define methods for below functionalities
 * 		Inorder Traversal
 * 			Recursive 
 * 			Iterative
 * 		Pre-Order Traversal
 * 			Recursive 
 * 			Iterative
 * 		Post-Order Traversal
 *			Recursive 
 * 			Iterative
 */
public class TreeTraversal {
	public static void main(String[] args) {
		TreeNode root = TreeNode.prepareTree();
		
		/*
		 * In-Order -> Left - Root - Right
		 * 4 10 12 15 18 22 24 25 31 35 44 50 66 70 90 
		 */
		System.out.println("\n\nIn-Order Recursive Approach");
		inOrderTraverRecursive(root);
		
		System.out.println("\n\nIn-Order Iterative Approach");
		inOrderTraverIterative(root);
		
		
		/*
		 * Pre-Order -> Root - Left - Right
		 * 25 15 10 4 12 22 18 24 50 35 31 44 70 66 90 
		 */
		System.out.println("\n\nPre-Order Recursive Approach");
		preOrderTraverRecursive(root);
		
		System.out.println("\n\nPre-Order Iterative Approach");
		preOrderTraverIterative(root);
		
		
		/*
		 * Post-Order -> Left - Right - Root
		 *  4 12 10 18 24 22 15 31 44 35 66 90 70 50 25 
		 */
		System.out.println("\n\nPost-Order Recursive Approach");
		postOrderTraverRecursive(root);
		
		System.out.println("\n\nPost-Order Iterative Approach With Two Stacks");
		postOrderTraverIterative(root);
		
		
		
		/*
		 * Level Order Traversla A.K.A Breadth First Search
		 * Return tree nodes as per their level(breadth)
		 */
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		levelOrderBFSTraversal(root, list, 0);
		
		System.out.println("\n\n\n"+list);
		
		list = new ArrayList<List<Integer>>();
		levelOrderBFSTraversalIterative(root, list);
		
		System.out.println("\n\n\n"+list);
		
	}

	
	public static void levelOrderBFSTraversalIterative(TreeNode root, List<List<Integer>> list) {
		Queue<TreeNode> source = new LinkedList<TreeNode>();
		Queue<TreeNode> target = new LinkedList<TreeNode>();
		source.add(root);
		List<Integer> subList = new ArrayList<Integer>();
		while(root != null || !source.isEmpty()) {
			root = source.poll();
			subList.add(root.val);
			if(root.left != null)
				target.add(root.left);
			if(root.right != null)
				target.add(root.right);
			
			//Whenever level transistion is happening source will become empty
			if(source.isEmpty()) {
				list.add(subList);
				subList = new ArrayList<Integer>();
				if(target.isEmpty())
					break;
				source = target;
				target = new LinkedList<TreeNode>();
			}
		}
		
	}


	public static void levelOrderBFSTraversal(TreeNode root, List<List<Integer>> list, int level) {
		if(root == null)
			return;
		List<Integer> subList = null;
		if(list.size() >= level+1)
			subList = list.get(level);
		else {
			subList = new ArrayList<Integer>();
			list.add(subList);
		}
		subList.add(root.val);
		levelOrderBFSTraversal(root.left, list, level+1);
		levelOrderBFSTraversal(root.right, list, level+1);
	}


	public static void postOrderTraverRecursive(TreeNode root) {
		if(root == null)
			return;
		postOrderTraverRecursive(root.left);
		postOrderTraverRecursive(root.right);
		System.out.print(root.val+" ");
	}
	public static void postOrderTraverIterative(TreeNode root) {
		Stack<TreeNode> source = new Stack<TreeNode>();
		Stack<TreeNode> target = new Stack<TreeNode>();
		source.push(root);
		
		while(!source.isEmpty()) {
			
			TreeNode node = source.pop();
			target.push(node);
		
			if(node.left != null) {
				source.push(node.left);
			}
			
			if(node.right != null) {
				source.push(node.right);
			}
		}
		
		
		while(!target.isEmpty()) {
			TreeNode node = target.pop();
			System.out.print(node.val+" ");
		}
	}



	



	public static void preOrderTraverRecursive(TreeNode root) {
		if(root == null)
			return;
		System.out.print(root.val+" ");
		preOrderTraverRecursive(root.left);
		preOrderTraverRecursive(root.right);		
	}
	
	public static void preOrderTraverIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(root != null || !stack.isEmpty()) {
			while(root != null) {
				System.out.print(root.val+" ");
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			root = root.right;
		}
		
	}
	public static void inOrderTraverRecursive(TreeNode root) {
		if(root == null)
			return;
		inOrderTraverRecursive(root.left);
		System.out.print(root.val+" ");
		inOrderTraverRecursive(root.right);
		
	}
	
	/*
	 * Iteratively print tree's inorder traversal 
	 * Uses Stack as intermediate storage
	 */
	public static void inOrderTraverIterative(TreeNode root) {
		if(root == null)
			return;
		
		int i=6, count =0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		//stack.push(root);
		while(root != null || !stack.isEmpty()) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			System.out.print(root.val+" ");
			if(count++<6)
				i = root.val;
			root = root.right;
		}
		System.out.println(i);
	}
	
	
	
	
}
