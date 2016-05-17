public class TreeNode {
	private Integer item; // We do not use generic Object because for a sake of simplicity, we want this to be a comparable key too.
	private TreeNode lChild;
	private TreeNode rChild;
	
	public TreeNode(){
		item=null;
		lChild=null;
		rChild=null;
	}
	
	public TreeNode(Integer newItem){
		item=newItem;
		lChild=null;
		rChild=null;
	}
	
	public TreeNode(Integer newItem, TreeNode lChild, TreeNode rChild){
		item=newItem;
		this.lChild=lChild;
		this.rChild=rChild;
	}
	public Integer getItem(){
		return item;
	}
	
	public TreeNode getLeft(){
		return lChild;
	}
	
	public TreeNode getRight(){
		return rChild;
	}
	
	public void setItem(Integer newItem){
		item=newItem;
	}
	
	public void setLeft(TreeNode newLChild){
		lChild=newLChild;
	}
	
	public void setRight(TreeNode newRChild){
		rChild=newRChild;
	}
}
