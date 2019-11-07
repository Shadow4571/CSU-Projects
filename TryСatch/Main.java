//import deferrors.DefErrors;
import deque.Deque;
import stack.Stack;
import stack.StackException;

public class Main {
	public static void main(String[] args) throws StackException {
		System.out.println("CREATE DEQUE AND ADD 10, 25, 33");
		Deque<Integer> NewDeque = new Deque<Integer>(10);
		NewDeque.Push(25);
		NewDeque.Push(33);

		while(!NewDeque.IsEmpty()) {
			System.out.println("Deq Elem " + NewDeque.Top() + " Size " + NewDeque.Size());
			NewDeque.Dequeue();
		}
		
		System.out.println();
		System.out.println("CREATE STACK AND ADD 10, 25, 50");
		Stack<Integer> NewStack = new Stack<Integer>(3);
		try {
			NewStack.Push(10);
			NewStack.Push(25);
			NewStack.Push(50);
			NewStack.Push(100);
		} catch (StackException Exp) {
			Exp.printStackTrace();
		}
		
		while(!NewStack.IsEmpty())
			System.out.println("Stack Elem " + NewStack.Pop());
		
		try {
			System.out.println("Stack Elem " + NewStack.Pop());
		} catch (StackException Exp) {
			Exp.printStackTrace();
		}
		
		System.out.println();
		System.out.println("ADD IN EMPTY STACK 100");
		NewStack.Push(100);
		System.out.println("Stack Elem " + NewStack.Top());
	}
}
