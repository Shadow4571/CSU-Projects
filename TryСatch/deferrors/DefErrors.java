package deferrors;

public class DefErrors {
	public DefErrors() {
		int Number = 10, Result = 0;
		
		int Array[] = new int[5];
		int Array2[] = null;
		
		try {
			Result = Number / 0;
		} catch (Exception Exp) {
			System.out.println("ERROR! Divide by zero.");
		}
		
		try {
			System.out.println(Array[Number]);
		} catch (Exception Exp) {
			System.out.println("ERROR! Beyond the bounds of array");
		}
		
		try {
			System.out.println(Array2[0]);
		} catch (Exception Exp) {
			System.out.println("ERROR! Null Pointer");
		}
	}
}
