package binarytree;

import java.util.ArrayList;

public class BinaryTree<Type extends Comparable<Type>> {
	private class Node {
		private Node Parent, Left, Right;
		private Type Data;
		
		public Node(Type Data, Node Parent) {
			this.Parent = Parent;
			this.Data = Data;
			this.Left = null;
			this.Right = null;
		}
		
		public Node(Type Data) {
			this.Parent = null;
			this.Data = Data;
			this.Left = null;
			this.Right = null;
		}
		
		public Type GetData() {
			return this.Data;
		}
		
		public Node GetLeft() { return this.Left; }
		public Node GetRight() { return this.Right; }
		public Node GetParent() { return this.Parent; }
		public void SetLeft(Node Left) { this.Left = Left; }
		public void SetRight(Node Right) { this.Right = Right; }
		public void SetParent(Node Parent) { this.Parent = Parent; }
	}
	
	private Node TreeRoot;
	private int Size = 0;
	
	public BinaryTree(Type Data) {
		this.TreeRoot = new Node(Data);
		this.Size++;
	}
	
	public void Add(Type Data) {
		Node Temp = this.TreeRoot;
		
		while(true) {
			if(Data.compareTo(Temp.GetData()) > 0) {
				if(Temp.GetRight() != null) {
					Temp = Temp.GetRight();
				} else {
					Temp.SetRight(new Node(Data, Temp));
					this.Size++;
					break;
				}
			}
			
			if(Data.compareTo(Temp.GetData()) < 0) {
				if(Temp.GetLeft() != null) {
					Temp = Temp.GetLeft();
				} else {
					Temp.SetLeft(new Node(Data, Temp));
					this.Size++;
					break;
				}
			}
			
			if(Data.compareTo(Temp.GetData()) == 0)
				break;
		}
	}
	
	public ArrayList<Type> DFS(Node Temp, ArrayList<Type> List) {
		if(Temp.GetLeft() != null)
			List = this.DFS(Temp.GetLeft(), List);
		
		List.add(Temp.GetData());
		
		if(Temp.GetRight() != null)
			List = this.DFS(Temp.GetRight(), List);
		
		return List;
	}
	
	public String toString() {
		String AllNode = new String("Tree Size " + this.Size);
		ArrayList<Type> List = this.DFS(this.TreeRoot, new ArrayList<Type>());
		
		for(int i = 0; i < List.size(); i++)
			AllNode += ("\n" + List.get(i));
		
		return AllNode;
	}
}
