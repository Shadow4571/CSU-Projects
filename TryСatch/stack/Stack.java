package stack;

public class Stack<Type> {
	private Object StackArray[];
	private int Size = 0, Position = 0;
	
	// Constructor creates stack of specified size
	public Stack(int Size) {
		this.StackArray = new Object[Size];
		this.Size = Size;
	}
	
	// Return stack size and check if it is empty or full
	public int Size() { return this.Size; }
	public boolean IsEmpty() { return this.Position == 0; }
	public boolean IsFull() { return this.Position == this.Size; }
	
	// Add item to stack
	public boolean Push(Type Data) throws StackException {
		try {
			this.StackArray[this.Position++] = Data;
		} catch (Exception Exp) {
			throw new StackException(0);
		} finally {
			if(this.Position > this.Size)
				this.Position = this.Size;
		}
		
		return true;
	}
	
	// Return item from stack without deleting
	public Object Top() throws StackException {
		try {
			return this.StackArray[this.Position - 1];
		} catch (Exception Exp) {
			throw new StackException(2);
		}
	}
	
	// Return an item from the stack and delete it
	public Object Pop() throws StackException {
		try {
			return this.StackArray[--this.Position];
		} catch (Exception Exp) {
			throw new StackException(2);
		} finally {
			if(this.Position < 0)
				this.Position = 0;
		}
	}
}