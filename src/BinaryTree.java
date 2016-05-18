public class BinaryTree{
	private TreeNode root;
	private TreeNode deleteNode;
	private TreeNode newNode;
	
	private TreeNode parent;
	private char child;
	private int countLevel=0;
	
	public BinaryTree(){
		root=null;
	}
	
	public BinaryTree(Integer newItem){
		root=new TreeNode(newItem);
	}
	
	public boolean isEmpty(){
		return root==null;
	}
	
	public TreeNode getRoot(){
		return root;
	}
	
	public boolean contains(TreeNode node, Integer item){
		boolean status=false;
		if(node==null) status=false;
		else if(item==node.getItem()) status=true;
		else if(item<node.getItem()){
			parent=node;
			child='l';
			status=contains(node.getLeft(), item);
		}else{
			parent=node;
			child='r';
			status=contains(node.getRight(), item);
		}
		return status;
	}
	
	public void insert(TreeNode node, Integer item){
		if(node==null){
			newNode=new TreeNode(item);
			root=newNode;
		}else{
			if(item<node.getItem()){
				if(node.getLeft()==null){
					newNode = new TreeNode(item);
					node.setLeft(newNode);
				}else{
					insert(node.getLeft(), item);
				}
			}else if(item>node.getItem()){
				if(node.getRight()==null){
					newNode=new TreeNode(item);
					node.setRight(newNode);
				}else{
					insert(node.getRight(), item);
				}
			}else{
				System.out.println("Binary Search Tree cannot have a duplicated item.");
			}
		}
	}
	public void inOrder(TreeNode node){
		if(node!=null){
			System.out.print("(");
			inOrder(node.getLeft());
			System.out.print(node.getItem());
			inOrder(node.getRight());
			System.out.print(")");
		}
	}
	
	public void preOrder(TreeNode node){
		if(node!=null){
			System.out.print("("+node.getItem());
			preOrder(node.getLeft());
			preOrder(node.getRight());
			System.out.print(")");
		}
	}
	
	public void postOrder(TreeNode node){
		if(node!=null){
			System.out.print("(");
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.print(")");
		}
	}
	
	public void inOrderSuccessor(TreeNode node){
		if(node.getLeft()==null){
			parent=node;
			child='r';
			countLevel=0;
		}else{
			parent=node;
			child='l';
			countLevel++;
			inOrderSuccessor(node.getLeft());
		}
	}
	
	public void preOrderSuccessor(TreeNode node){
		
	}
	
	public boolean delete(TreeNode node, Integer item){
		boolean status=false;
		if(node==null) status=false;
		else if(contains(node, item)){
			//contains will also keep track of parent of the node
			if(item==node.getItem()){
				//Found the node to delete. Then check if this node is a leaf node or not
				if(node.getLeft()==null && node.getRight()==null){
					//this is a leaf node. Easy
					if(parent!=null){
						System.out.println("has parent");
						if(child=='l')parent.setLeft(null);
						else parent.setRight(null);
					}else{
						//this tree has only 1 node to begin with, so it is a root node too
						root=null;
					}
					status=true;
				}else if(node.getLeft()!=null && node.getRight()!=null){
					//This node has 2 children
					//Option 1: Use inOrderSuccessor, which is to find the most left node of the right subtree
					inOrderSuccessor(node.getRight());
					//TODO
					if(countLevel==0){
						
					}
					status=true;
					//Option 2: Use preOrderSuccessor, which is to find the most right node of the left subtree
					preOrderSuccessor(node.getLeft());
					//TODO
					status=true;
				}else{
					//This node has 1 child. Easy
					if(node.getLeft()!=null){
						//left child of the node will be moved up
						if(child=='l') parent.setLeft(node.getLeft());
						else parent.setRight(node.getLeft());
					}else{
						//right child of the node will be moved up
						if(child=='l') parent.setRight(node.getRight());
						else parent.setRight(node.getRight());
					}
					status=true;
				}
			}else if(item<node.getItem()){
				delete(node.getLeft(), item);
			}else{
				delete(node.getRight(), item);
			}
		}else{
			//Throw exception TODO
			System.out.print("item to delete is not found");
			status=false;
		}
		return status;
	}
	
	//Uncomment this code to test
	public static void main(String[] args){
		BinaryTree bst=new BinaryTree();
		BinaryTree bst_2=new BinaryTree(20);
		
		bst.insert(bst.getRoot(), 2);
		bst.insert(bst.getRoot(), 5);
		bst.insert(bst.getRoot(), 1);
		
		bst_2.insert(bst_2.getRoot(), 50);
		bst_2.insert(bst_2.getRoot(), 10);
		
		bst.inOrder(bst.getRoot());
		bst_2.inOrder(bst_2.getRoot());
		
		System.out.println(bst.contains(bst.getRoot(), 4));
		
		bst.insert(bst.getRoot(), 3);
		bst.preOrder(bst.getRoot());
		bst_2.preOrder(bst_2.getRoot());
		
		bst.delete(bst.getRoot(), 5);
		bst.insert(bst.getRoot(), 4);
		bst.insert(bst.getRoot(), 5);
		bst.delete(bst.getRoot(), 3);
		bst.inOrder(bst.getRoot());
		
		BinaryTree bst_3=new BinaryTree(100);
		bst_3.delete(bst_3.getRoot(), 100);
		bst_3.inOrder(bst_3.getRoot());
	}
}























/*
public class BinaryTree {
	TreeNode root;
	TreeNode newNode;
	TreeNode deleteNode;
	TreeNode locationOfSuccessor;
	int countLevel;
	TreeNode parent;
	char child;

	public BinaryTree(){
		
	}
	
	public TreeNode getRoot(){
		return root;
	}
	public void insertHelper(TreeNode bst, Integer newItem){
		if(bst==null){
			newNode=new TreeNode(newItem);
			if(child=='l') parent.setLeft(newNode);
			else parent.setRight(newNode);
		}else{
			if(newItem<bst.getItem()){
				parent=bst;
				child='l';
				insertHelper(bst.getLeft(), newItem);
			}else if(newItem>bst.getItem()){
				parent=bst;
				child='r';
				insertHelper(bst.getRight(), newItem);
			}else{
				//TODO throw exception
				System.out.println("cannot insert the given item");
			}
		}
	}
	
	public void insert(Integer newItem){ //
		if(root==null){
			newNode=new TreeNode(newItem);
			root=newNode;
		}else insertHelper(root, newItem);
	}
	
	public boolean contains(Integer item){
		boolean status=false;
		if(root==null) {System.out.println("in if of contains");status=false;}
		else{			
			System.out.println("in else of contains root.ITEM= "+root.getItem());
			if(item==root.getItem()) {System.out.println("=="); status=true;}
			else if(item<root.getItem()) {System.out.println("<"); status=containsHelper(root.getLeft(), item);}
			else {System.out.println(">"); status=containsHelper(root.getRight(), item); System.out.println("here??");}
		}
		System.out.println("before return");
		return status;
	}
	
	public boolean containsHelper(TreeNode bst, Integer item){
		boolean status=false;
		System.out.println("containsHelper and bst.item is "+bst.getItem());
		if(bst==null) status=false;
		else{
			if(item==bst.getItem()) {System.out.println("== helper"); status=true;}
			else if(item<bst.getItem()) {System.out.println("< helper"); containsHelper(bst.getLeft(), item);}
			else {System.out.println("> helper"); containsHelper(bst.getRight(), item); }
		}
		System.out.println("next?/?/?");
		return status;
	}
	
	public TreeNode search(Integer item){
		TreeNode location=null;
		if(root==null) return null;
		else{
			if(item==root.getItem()) location=root;
			else {
				System.out.println("getRight parent is "+parent.getItem());
				location=searchHelper(root, item);
			}
		}
		System.out.println(parent.getItem() + " is parent from search method");
		return location;
	}
	
	
	public TreeNode searchHelper(TreeNode bst, Integer item){
		TreeNode location=null;
		if(bst==null) location=null;
		else{
			if(item==bst.getItem()){
				//will not change parent
				//will not change child
				location=bst;
			}
			else if(item<bst.getItem()){
				System.out.println(parent.getItem() + " is parent from searchHelper l method");
				parent=bst;
				child='l';
				location=searchHelper(bst.getLeft(), item);
			}
			else {
				System.out.println(parent.getItem() + " is parent from searchHelper r method");
				parent=bst;
				child='r';
				location=searchHelper(bst.getRight(), item);
			}
		}
		return location;
	}
	
	public void deleteHelper(TreeNode node){
		System.out.println("parent is "+parent.getItem());
		if(node.getLeft()==null && node.getRight()==null){
			// has no children
			System.out.println("------------no children");
			if(child=='l') parent.setLeft(null);
			else parent.setRight(null);
		}else if(node.getLeft()!=null && node.getRight()!=null){
			System.out.println("------------2 children");
			// has 2 children
			// This case is never reached because if this node has more left or right node, it will never be the most left or most right successor
		}else{
			// has 1 child
			System.out.println("------------1 children");
			if(node.getLeft()==null) {
				// if left child of the current node is null, then we move the right child up to replace the deleted current node
				System.out.println("/////////////left!=null");
				parent.setLeft(node.getRight());
			}
			else {
				// if right child of the current node is null, then we move the left child up to replace the deleted current node
				System.out.println("/////////////left=null");
				parent.setRight(node.getLeft());
			}
		}
	}
	
	public boolean delete(Integer item){
		//Option 1: use inordersuccessor method
		boolean status=false;
		System.out.println("in delete and item = "+item);
		if(contains(item)==false) {status=false;}
		else{
			System.out.println("in else of delete");
			
			deleteNode=search(item);
			
			System.out.println("deleteNode.getItem() = "+deleteNode.getItem());
			System.out.println("RIGHT: "+deleteNode.getRight());
			System.out.println("LEFT: "+deleteNode.getLeft().getItem());
			
			if(deleteNode.getLeft()==null && deleteNode.getRight()==null){
				// the deleteNode is a leaf node. Easy to remove
				System.out.println("no children");
				if(child=='l') parent.setLeft(null);
				else parent.setRight(null);
				status=true;
			}else if(deleteNode.getLeft()!=null && deleteNode.getRight()!=null){
				// the deleteNode has 2 children
				System.out.println("2 children");
				
				inordersuccessor(deleteNode.getRight()); // this call will set the "location" field to the found inordersucessor
				
				System.out.println("parent = " +parent.getItem());
				System.out.println("child = " +child);
				
				deleteNode.setItem(locationOfSuccessor.getItem());
				
				System.out.println("deleteNode = "+deleteNode.getItem());
				System.out.println("locationOfSuccessor = "+locationOfSuccessor.getItem());
				
				deleteHelper(locationOfSuccessor);
				

			}else{
				// the deleteNode has 1 child
				
				System.out.println("1 child");
				System.out.println("parent "+ parent.getItem());
				if(deleteNode.getLeft()!=null) parent.setRight(deleteNode.getLeft());
				else parent.setRight(deleteNode.getLeft());
			}
		}
		return status; 
		
		//Option 2: use preordersuccessor method
		
		 boolean status=false;
		 if(contains(item)==false) status=false;
		 else{
			 deleteNode=search(item);
			 deleteNode.setItem(preordersuccessor(deleteNode.getRight()).getItem());
			 if(child=='r') parent.setRight(null); // the immediate left child (i.e. root of left subtree) is the most right node
			 else parent.setLeft(null);
		 }
		 return status;


	}
	
	public void inordersuccessor(TreeNode bst){
		//bst is the root of right subtree
		//this will find the most left node of bst's right subtree
		System.out.println("here bst = "+bst.getItem());
		if(bst==null){
			locationOfSuccessor=null;
			countLevel=0;
			System.out.println("in if bst==null");
		}else{
			if(bst.getLeft()==null){
				// will not change parent
				// will not  change child
				// will not change countLevel
				locationOfSuccessor=bst;
				System.out.println("in getLeft and location is " + locationOfSuccessor.getItem());
			}else{
				System.out.println("in else");
				parent=bst;
				child='l';
				countLevel++;
				inordersuccessor(parent.getLeft());
			}

		}
		System.out.println(";;;;;;;;;;;;;;;;;"+locationOfSuccessor.getItem());
	}
	
	public TreeNode preordersuccessor(TreeNode bst){
		//bst is the root of left subtree
		//this will find the most right node of bst's left subtree
		TreeNode location=null;
		if(bst==null) location=null;
		else{
			if(bst.getRight()==null){
				parent=bst;
				child='l';
				location=bst;
			}else{
				parent=bst;
				child='r';
				preordersuccessor(parent.getRight());
			}
		}
		return location;
	}
	
	public void inorder(TreeNode bst){
		if(bst!=null){
			System.out.print("(");
			inorder(bst.getLeft());
			System.out.print(bst.getItem());
			inorder(bst.getRight());
			System.out.print(")");
		}
	}
	
	public void preorder(TreeNode bst){
		if(bst!=null){
			System.out.print("("+bst.getItem());
			preorder(bst.getLeft());
			preorder(bst.getRight());
			System.out.print(")");
		}
	}
	
	public void postorder(TreeNode bst){
		if(bst!=null){
			System.out.print("(");
			postorder(bst.getLeft());
			postorder(bst.getRight());
			System.out.print(bst.getItem()+")");
		}
	}
	//Uncomment to test the code
	
	public static void main(String[] args){
		BinaryTree tree=new BinaryTree();
		tree.insert(2);
		tree.insert(5);
		tree.insert(3);
		tree.insert(4);
		tree.inorder(tree.getRoot());
		tree.insert(1);
		System.out.println();
		tree.inorder(tree.getRoot());
		System.out.println();
		tree.preorder(tree.getRoot());
		System.out.println();
		tree.inordersuccessor(tree.getRoot().getRight());
		tree.delete(5);
		System.out.println();
		tree.inorder(tree.getRoot());
	}
	
}
*/