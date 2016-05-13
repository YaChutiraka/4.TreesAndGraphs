public class BinaryTreeArrayBased {
	protected final int MAX_NODE=100;
	TreeNode[] tree=new TreeNode[MAX_NODE];
	
	protected int count; // number of elements in the tree
	protected int root; // index of root
	protected int free; // which index is first free one to add new element to
	
	public BinaryTreeArrayBased(){
		count=0;
		root=-1;
		free=0;
	}
	
	public BinaryTreeArrayBased(Object rootItem){
		count=1;
		root=0;
		free=1;
		tree[root]=new TreeNode(rootItem);
		tree[root].setLChild((2*root)+1);
		tree[root].setRChild((2*root)+2);
	}
	
	public int size(){
		return count;
	}
	
	public boolean isEmpty(){
		return count==0;
	}
	
	public boolean contains(Object item){
		boolean status=false;;
		for(int i=0; i<free && i<MAX_NODE; i++){
			if(tree[i].getItem()==item){
				status=true;
				break;
			}
		}
		return status;
	}
	
	public int search(Object item){
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
	
	public void add(Object newItem){
		if(free<MAX_NODE){
			tree[free]=new TreeNode(newItem);
			count++;
			free++;
		}else{
			System.out.println("in else");
			//TODO
		}
	}
	
	public void remove(Object item){
		
	}
	
	public void removeAll(){
		for(int i=0; i<free && i<MAX_NODE; i++){
			tree[i].setItem(null);
		}
		count=0;
		root=-1;
		free=0;
	}
	
	public Object getLChild(Object item){
		if(contains(item)){
			int location=(int)search(item);
			return tree[(location*2)+1].getItem();
		}else{
			//throw exception TODO
			return -1;
		}
	}
	
	public Object getRChild(Object item){
		if(contains(item)){
			int location=(int)search(item);
			return tree[(location*2)+2].getItem();
		}else{
			//throw exception TODO
			return -1;
		}
	}
	
	public int searchLChild(Object item){
		if(contains(item)){
			int location=(int)search(item);
			return (location*2)+1;
		}else{
			return -1;
		}
	}
	
	public int searchRChild(Object item){
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
	//traversal methods TODO
	
	
	//Uncomment to test
	public static void main(String args[]){
		BinaryTreeArrayBased bt = new BinaryTreeArrayBased("APPLE");
		bt.add("BANANA");;
		bt.add("CAT");
		bt.add("DOG");
		bt.add("ELEPHANT");
		bt.add("FISH");
		bt.add("GIRL");
		bt.showData();
		System.out.println();
		System.out.print(bt.search("BANANA"));
		System.out.println();
		System.out.print(bt.getLChild("BANANA"));
		System.out.println();
		System.out.print(bt.getRChild("BANANA"));
		System.out.println();
		System.out.print(bt.searchLChild("BANANA"));
		System.out.println();
		System.out.print(bt.searchRChild("BANANA"));
	}
	
}
