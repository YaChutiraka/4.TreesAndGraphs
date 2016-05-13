public class TreeNode {
	private Object item;
	private Object lChild;
	private Object rChild;
	
	public TreeNode(){
		item=null;
		lChild=null;
		rChild=null;
	}
	
	public TreeNode(Object newItem){
		item=newItem;
		lChild=null;
		rChild=null;
	}
	
	public TreeNode(Object newItem, Object lChild, Object rChild){
		item=newItem;
		this.lChild=lChild;
		this.rChild=rChild;
	}
	public Object getItem(){
		return item;
	}
	
	public Object getLChild(){
		return lChild;
	}
	
	public Object getRChild(){
		return rChild;
	}
	
	public void setItem(Object newItem){
		item=newItem;
	}
	
	public void setLChild(Object newLChild){
		lChild=newLChild;
	}
	
	public void setRChild(Object newRChild){
		rChild=newRChild;
	}
}
