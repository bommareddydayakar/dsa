package algorithms.binarysearchtree;

public class TreeNode {
	int val;

	TreeNode left;
	TreeNode right;

	private TreeNode() {

	}

	public TreeNode(int v) {
		this.val= v; 
	}

	public TreeNode(int v, TreeNode l, TreeNode r) {
		this.val = v;
		this.left = l;
		this.right = r;
	}
	
	
	public static TreeNode prepareTree() {
		TreeNode r21 = new TreeNode(70,new TreeNode(66), new TreeNode(90));
		TreeNode l21 = new TreeNode(35,new TreeNode(31), new TreeNode(44));
		TreeNode r11 = new TreeNode(22,new TreeNode(18), new TreeNode(24));
		TreeNode l11 = new TreeNode(10,new TreeNode(4), new TreeNode(12));
		TreeNode r1 = new TreeNode(50, l21, r21);
		TreeNode l1 = new TreeNode(15, l11,r11);
		TreeNode root = new TreeNode(25,l1, r1);
		return root;
	}
	
	
	
}
