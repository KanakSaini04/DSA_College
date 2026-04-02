class Node {
	int no;
	Node left;
	Node right;
	Node(int no) {
		this.no=no;
		this.left=null;
		this.right=null;
	}
}
class MyTree {
	int count=0;
	int sum=0;
	int ev=0;
	public Node insert(Node root,int no) {
		if(root==null) {
			Node p=new Node(no);
			return p;
		} else if(no>root.no) {
			root.right=insert(root.right,no);
		} else {
			root.left=insert(root.left,no);
		}
		return root;
	}
	public void inOrder(Node root) {
		if(root==null) {
			return;

		}
		inOrder(root.left);
		// count++;
		if(root.no%2==0) {
			ev++;
		}
		System.out.print(root.no+"\t");
		inOrder(root.right);
		// sum=sum+root.no;

	}
	public void preOrder(Node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.no+"\t");
		preOrder(root.left);
		preOrder(root.right);
	}
	public void postOrder(Node root) {
		if(root==null) {
			return;
		}
		postOrder(root.left);
		inOrder(root.right);
		System.out.print(root.no+"\t");
	}
	public boolean validate (Node root) {
		if(root == null) {
			return true;
		}
		if(root.left == null && root == null ) {
			if (root.left != null && root.right != null) {
				int no = root.no;
				int leftno = root.left.no;
				int rightno = root.right.no;
				if (no< leftno || no> rightno) {
					return false;

				}
				else {
					return validate(root.left) && validate(root.right);
				}
			}

		}
		if(root.left != null) {
			int no = root.no;
			int leftno = root.left.no;
			if(no < leftno) {
				return false;
			}
			else {
				return validate(root.left);
			}
		}
		if(root.right != null) {
			int no = root.no;
			int rightno = root.right.no;
			if(no > rightno) {
				return false;
			}
			else {
				return validate(root.right);
			}
		}
		if(root.left == null && root.right ==null) {
			return true;
		}

		return true;
	}
	public int height(Node root) {
		if(root==null) {
			return -1;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight,rightHeight)+1;
	}
	public boolean search(Node root , int key) {
	    if(root == null) {
	        return false;
	    }
	    if(key == root.no) {
	        return true;
	    }
	    if(key<root.no) {
	        return search(root.left , key);
	    } else {
	        return search(root.right , key);
	    }
	}

}

public class Main
{
	public static void main(String[] args) {
		Node root=null;
		MyTree t=new MyTree();
		root=t.insert(root,100);
		root=t.insert(root,90);
		root=t.insert(root,110);
		root=t.insert(root,120);
		root=t.insert(root,95);
// 		root=t.insert(root,120);
// 		root=t.insert(root,95);
// 		t.inOrder(root.left);
// 		if (root.left==null && root!= null){
// 		    System.out.println("No of Nodes is zero");
// 		}
// 		else if (root!= null){
// 		    t.inOrder(root.left);
// 		}
// // 		System.out.print("\n");
// // 		t.preOrder(root);
// // 		System.out.print("\n");
// // 		t.postOrder(root);
// System.out.println("No  of lest sub...."+t.count);

		// t.inOrder(root.right);
		// System.out.println("sum of right nodes are "+t.sum);
		t.inOrder(root);
// 		root.left.no = 150;
		if(root == null) {
			System.out.println("There is no tree");
		} else {
			boolean flag = t.validate(root);
			if(flag == true) {
				System.out.println("Valid BST");
			}
			else {
				System.out.println("Invalid BST");

			}
		}
		//	System.out.println("No of even nodes are:"+t.ev);
		//Write a program to find the height of the given tree
		int treeHeight = t.height(root);
		System.out.println(treeHeight+"....height of tree");
		
		boolean isFind = t.search(root , 150);
		if(isFind) {
		    System.out.println("No is there in BST");
		}
		else {
		    System.out.println("No is not present in BST");
		}
		
		//Write a program to find out the a key in a tree


	}
}













