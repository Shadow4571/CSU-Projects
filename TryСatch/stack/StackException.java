package stack;

public class StackException extends Exception {
	private static int PrevError = -1;
	
	public StackException(int ErrorCode) {
		super(GetMessageByCode(ErrorCode, PrevError));
		PrevError = ErrorCode;
	}
	
	private static String GetMessageByCode(int Code, int ErrorCode) {
		String Message = new String();
		Message += ("ERROR " + Code);
		
		switch (Code) {
		case 0: {
			Message += " Stack is overload. Cannot add item";
			break;
		}
			
		case 1: {
			Message += " Cannot return item";
			break;
		}
		
		case 2: {
			Message += " Stack is empty. Cannot return item";
			break;
		}

		default:
			Message += " Unknown error. Check previous.";
			break;
		}
		
		Message += ("\n" + "Previous error code: " + ErrorCode);
		return Message;
	}
}
