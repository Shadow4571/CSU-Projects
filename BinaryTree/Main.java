import binarytree.BinaryTree;

public class Main {
	public static void main(String[] args) {
		BinaryTree<Integer> Tree = new BinaryTree<Integer>(5);
		Tree.Add(3);
		Tree.Add(8);
		
		System.out.println(Tree);
	}
}
