
public class BinarySTree {
	
	public Node root; 
	
	public BinarySTree() {
		this.root= null;   
	} 
	
	public void Insert(int data) {
		root = Insert(root, data); 
	}
	
	private Node Insert(Node root, int data) {
		if (root == null) {
			root = new Node(data); return root;  
		} else if (data <=root.data) {
		  root.left = Insert(root.left, data); 
		} else {
			root.right = Insert(root.right, data);}
		return root; 
	}
	
	
	
	public void Delete(int data) {
		root = Delete(root, data); 
	}
	
	
	
	private Node Delete(Node root, int data) {
		if(root==null) {
			return root; 
		} else if(data<root.data) {
			root.left = Delete(root.left, data); 
		} else if(data>root.data) {
			root.right = Delete(root.right, data); 
			
		} else {
			//case 1: no child
			if(root.left==null && root.right==null) {
				root = null; 
				 return root; 
			} // one child in right
			else if (root.left ==null){
				root = root.right; 
				 return root; 
			} else if (root.right ==null) {
				root = root.left; 
				return root; 
			} else {
				//two child
				Node temp = FindMin(root.right); System.out.println("the min in delet is "+temp.data);
				root.data = temp.data; 
				root.right = Delete(root.right,temp.data); 
				return root; 
			}	
			}
		return root; 
		}
	
	public Node FindMin(Node root) {
		if(root.left==null) { return root; 
		}
		else { root = FindMin(root.left);
		} return root; 
	}

	public void Display(Node root) {
		if(root!=null){
			Display(root.left);
			System.out.print(" " + root.data);
			Display(root.right);
		}
	}
	
	
	public static void main(String[] args) {
		
		BinarySTree b = new BinarySTree(); 
		b.Insert(15);
		b.Insert(20);
		b.Insert(16);
		b.Insert(17);
		b.Insert(100);
		b.Insert(21);
		b.Delete(20);
	    b.Display(b.root);
	    System.out.println( "	The root is  "+ b.root.data); 
	}
	
}

class Node {
	 int data; 
	 Node left; 
	 Node right; 
	
	public Node(int x) {
		this.data =  x;
		
	} 
}
