package deque;

public class Deque<Type> {
	/* NODE CLASS */
	private class Node {
		private Type Data;
		private Node Next;
		
		public Node(Type Data) {
			this.Data = Data;
			this.Next = null;
		}
		
		public boolean SetNext(Node Next) { 
			if(Next == null)
				return false;
			
			this.Next = Next; 
			return true; 
		} 
		
		public Type GetData() { return this.Data; }
		public Node GetNext() { return this.Next; }
	}
	
	/* DEQUE CLASS */
	private Node Start, End;
	private int Size = 0;
	
	// Constructor without data
	public Deque() {
		this.Start = null;
		this.End = null;
		this.Size = 0;
	}
	
	// Constructor with data
	public Deque(Type Data) {
		try {
			this.End = new Node(Data);
			this.Start = End;
			this.Size++;
		} catch(Exception Exp) {
			Exp.printStackTrace();
		}
	}
	
	// Add item to end of queue
	public boolean Push(Type Data) {
		if(this.Start == null && this.End == null) {
			try {
				this.End = new Node(Data);
				this.Start = End;
				this.Size++;
			} catch(Exception Exp) {
				Exp.printStackTrace();
				return false;
			}
			
			return true;
		}
		
		try {
			Node Temp = new Node(Data);
			this.End.SetNext(Temp);
			this.End = Temp;
			this.Size++;
		} catch(Exception Exp) {
			Exp.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	// Remove item from front of queue
	public boolean Dequeue() {
		if(this.Start == null)
			return false;
		
		try {
			this.Start = this.Start.GetNext();
			this.Size--;
		} catch (Exception Exp) {
			Exp.printStackTrace();
			return false;
		}
		
		if(this.Start == null)
			this.End = null;
		
		return true;
	}
	
	// Get item from the front of queue
	public Type Top() {
		return this.Start.GetData();
	}
	
	// Get queue size
	public int Size() {
		return this.Size;
	}
	
	// Check if queue is empty
	public boolean IsEmpty() {
		return this.Start == null && this.End == null;
	}
	
	// Get String
	public String toString() {
		if(this.Start != null)
			return "Size " + this.Size + " Element Type " + this.Start.GetData().getClass();
		else
			return "Size " + this.Size;
	}
}
