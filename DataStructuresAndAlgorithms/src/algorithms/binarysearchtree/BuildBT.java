package algorithms.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class BuildBT {
	public static void main(String[] args) {
		
		//int[] preOrder = {3,9,20,15,7};
		//int[] inOrder = {9,3,15,20,7};
		
		int[] preOrder = {1,2};
		int[] inOrder = {2,1};
		
		TreeNode root = new BuildBT().buildTree(preOrder,inOrder); 
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		TreeTraversal.levelOrderBFSTraversal(root, list, 0);
		
		System.out.println(list);
		
	}
	
	
	int preIndex = 0; 

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        int inStart = 0, inEnd = inOrder.length-1;
        return buildTree(preOrder, inOrder, inStart, inEnd);
    }
    public TreeNode buildTree(int[] preOrder, int[] inOrder, int inStart, int inEnd){
        //These 2 pointers cannot cross each other
        if(inStart > inEnd)
            return null;
        //Prepare current node
        TreeNode node = new TreeNode(preOrder[preIndex++]);
        // If both pointers are pointing to same index, 
        // then this range is only single node    
        if(inStart == inEnd)
            return node;
        //find out the index of current preIndex element in inOrder array withing given inStart and inEnd
        int inIndex = search(node.val, inOrder, inStart, inEnd);
        //Divide the inorder array as left and right branches for recursive processing
        //Prepare current node's left and right branches and return the node.
        node.left = buildTree(preOrder, inOrder, inStart, inIndex-1);
        node.right = buildTree(preOrder, inOrder, inIndex+1, inEnd);
        return node;
    }
    public int search(int val, int[] inOrder, int start, int end){
        for(int i= start; i<=end;i++){
            if(inOrder[i] == val)
                return i;
        }
        return -1;
    }
}
