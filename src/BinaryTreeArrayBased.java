public class BinaryTreeArrayBased {
	protected final int MAX_NODE=100;
	TreeNode[] tree=new TreeNode[MAX_NODE];
	
	protected int count; // number of elements in the tree
	protected int root; // index of root
	protected int free; // which index is first free one to add new element to
	
	protected int lIndex;
	protected int rIndex;
	
	public BinaryTreeArrayBased(){
		count=0;
		root=-1;
		free=0;
	}
	
	public BinaryTreeArrayBased(Integer rootItem){
		count=1;
		root=0;
		free=1;
		tree[root]=new TreeNode(rootItem);
		lIndex=(2*root)+1;
		rIndex=(2*root)+2;
	}
	
	public int size(){
		return count;
	}
	
	public boolean isEmpty(){
		return count==0;
	}
	
	public boolean contains(Integer item){
		boolean status=false;;
		for(int i=0; i<free && i<MAX_NODE; i++){
			if(tree[i].getItem()==item){
				status=true;
				break;
			}
		}
		return status;
	}
	
	public int search(Integer item){
		int location=-1;
		if(contains(item)){
			for(int i=0; i<free && i<MAX_NODE; i++){
				if(tree[i].getItem()==item){
					location=i;
				}
			}
		}
		return location;
	}
	
	public void add(Integer newItem){
		if(free<MAX_NODE){
			tree[free]=new TreeNode(newItem);
			count++;
			free++;
		}else{
			System.out.println("in else");
			//TODO
		}
	}
	
	public void remove(Integer item){
		
	}
	
	public void removeAll(){
		for(int i=0; i<free && i<MAX_NODE; i++){
			tree[i].setItem(null);
		}
		count=0;
		root=-1;
		free=0;
	}
	
	public Integer getLeft(Integer item){
		if(contains(item)){
			int location=(int)search(item);
			if((location*2)+1<free) return tree[(location*2)+1].getItem();
			else return -1; //throw exception TODO
		}else{
			//throw exception TODO
			return -1;
		}
	}
	
	public Integer getRight(Integer item){
		if(contains(item)){
			int location=(int)search(item);
			if((location*2)+2<free)return tree[(location*2)+2].getItem();
			else return -1; // through exception TODO
		}else{
			//throw exception TODO
			return -1;
		}
	}
	
	public Integer searchLeft(Integer item){
		if(contains(item)){
			int location=(int)search(item);
			return (location*2)+1;
		}else{
			return -1;
		}
	}
	
	public Integer searchRight(Integer item){
		if(contains(item)){
			int location=(int)search(item);
			return (location*2)+2;
		}else{
			return -1;
		}
	}
	
	public void showData(){
		if(count>=1){
			for(int i=0; i<free && i<MAX_NODE; i++){
				System.out.print(tree[i].getItem()+" ");
			}
		}
	}
	
	public void expandCapacity(){
		
	}
	
	public void detachLSubtree(){
		
	}
	
	public void detachRSubtree(){
		
	}
	
	public void attachLSubtree(){
		
	}
	
	public void attachRSubtree(){
		
	}
	//traversal methods TODO
	
	public void preorder(Integer item){ 
		// Root --> Left --> Right
		if(contains(item)){
			int location=(int)search(item);
			System.out.print("("+tree[location].getItem());
			if((location*2)+1<free) preorder(tree[(location*2)+1].getItem());
			if((location*2)+2<free) preorder(tree[(location*2)+2].getItem());
			System.out.print(")");
		}else{
			System.out.print("item not found");
			//not found throw exception TODO
		}
	}
	
	public void inorder(Integer item){ 
		// Left --> Root --> Right
		if(contains(item)){
			int location=(int)search(item);
			System.out.print("(");
			if((location*2)+1<free) inorder(tree[(location*2)+1].getItem());
			System.out.print(tree[location].getItem());
			if((location*2)+2<free) inorder(tree[(location*2)+2].getItem());
			System.out.print(")");
		}else{
			System.out.print("item not found");
		}
	}
	
	public void postorder(Integer item){ 
		// Left --> Right --> Root
		if(contains(item)){
			int location=(int)search(item);
			System.out.print("(");
			if((location*2)+1<free) postorder(tree[(location*2)+1].getItem());
			if((location)*2+2<free) postorder(tree[(location*2)+2].getItem());
			System.out.print(tree[location].getItem()+")");
		}else{
			System.out.println("item not found");
		}
	}
	
	
	//Uncomment to test
	public static void main(String args[]){
		BinaryTreeArrayBased bt = new BinaryTreeArrayBased(4);
		bt.add(2);
		bt.add(6);
		bt.add(1);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.showData();
		System.out.println();
		System.out.println(bt.search(2));//return index=1
		System.out.println();
		//System.out.print(bt.getLeft("BANANA"));
		//System.out.println();
		//System.out.print(bt.getRight("BANANA"));
		//System.out.println();
		//System.out.println(bt.searchLChild("BANANA"));
		//System.out.println(bt.searchRChild("BANANA"));
		//System.out.println(bt.getLeft("ELEPHANT"));
		//System.out.println();
		//System.out.println();
		bt.preorder(1);
		System.out.println();
		bt.preorder(4);
		System.out.println();
		bt.inorder(4);
		System.out.println();
		bt.inorder(6);
		System.out.println();
		bt.postorder(4);
		
	}
	
}
