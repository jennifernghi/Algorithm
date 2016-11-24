package Recursion;

public class Node {
	public int data;
	public Node left;
	public Node right;

	public Node(int num) {
		this.data = num;
		this.left = null;
		this.right = null;
	}

	public Node() {
		this.left = null;
		this.right = null;
	}

	public static Node createNode(int number) {
		return new Node(number);
	}

	public static void main(String[] args) {
		// root level 0
		Node A = Node.createNode(60);
		// Level 1
		Node B = Node.createNode(20);
		Node C = Node.createNode(80);
		// Level 2
		Node D = Node.createNode(10);
		Node E = Node.createNode(30);
		 Node F = Node.createNode(70); //Node G = Node.createNode(90); // Level
		/* 3 Node H = Node.createNode(65); Node I = Node.createNode(75); Node J
		 * = Node.createNode(95);
		 */

		// connect Level 0 and 1
		A.left = B;
		A.right = C;
		// connect level 1 and level 2
		B.left = D;
		// B.right = E;
		C.left = E;
		E.left = F;
		// connect level 2 and level 3
		/*
		 * D.left = H; F.right = I; G.right = J;
		 */

		System.out.println(Node.countOnlyOneChildNode(A));
	}

	public static int countOnlyOneChildNode(Node root) {

		if (root == null || (root.left == null && root.right == null))
			return 0;
		else {
			if (root.left == null) {
				return 1 + countOnlyOneChildNode(root.right);
			}
			else if (root.right == null) {
				return 1 + countOnlyOneChildNode(root.left);
			} 
			else {
				return countOnlyOneChildNode(root.left) + countOnlyOneChildNode(root.right);
			}
		}
	}
}