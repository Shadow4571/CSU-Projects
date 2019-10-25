
public class Main {

	public static final void PrintMatrix(Matrix Temp) {
		for(int i = 0; i < Temp.GetRow(); i++) {
			for(int j = 0; j < Temp.GetColumn(); j++) {
				System.out.print(Temp.GetElementByPosition(i, j) + " ");
			}
			System.out.println();
		}
	}
	
	public static final void PrintArray(Matrix Temp) {
		for(int i = 0; i < Temp.GetRow() * Temp.GetColumn(); i++)
			System.out.print(Temp.GetElementByPosition(i) + " ");
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		Matrix UserMatrix1 = new Matrix(3, 3);
		Matrix UserMatrix2 = new Matrix(3, 1);
		Matrix UserMatrix3 = new Matrix(3, 3);
		Matrix UserMatrix4 = new Matrix(5, 3);
		
		System.out.println();
		System.out.println("FIRST MATRIX");
		PrintMatrix(UserMatrix1);
		
		System.out.println();
		System.out.println("SECOND MATRIX");
		PrintMatrix(UserMatrix2);
		
		System.out.println();
		System.out.println("THIRD MATRIX");
		PrintMatrix(UserMatrix3);
		
		System.out.println();
		System.out.println("FOUR MATRIX");
		PrintMatrix(UserMatrix4);
		
		UserMatrix1.AddNumberInMatrix(UserMatrix3);
		System.out.println();
		System.out.println("ADD THIRD MATRIX INTO FIRST");
		PrintMatrix(UserMatrix1);
		
		UserMatrix3.AddNumberInMatrix(10);
		System.out.println();
		System.out.println("ADD 10 INTO THIRD");
		PrintMatrix(UserMatrix3);
		
		UserMatrix3.TransposeMatrix();
		System.out.println();
		System.out.println("TRANSPOSE THIRD");
		PrintMatrix(UserMatrix3);
		
		UserMatrix2.TransposeMatrix();
		System.out.println();
		System.out.println("TRANSPOSE SECOND");
		PrintMatrix(UserMatrix2);
		
		UserMatrix4.TransposeMatrix();
		System.out.println();
		System.out.println("TRANSPOSE FOUR");
		PrintMatrix(UserMatrix4);
		
		UserMatrix4.SetElementByPosition(2, 2, 99);
		System.out.println();
		System.out.println("SET 2 2 ELEM ON 99 IN FOUR MATRIX");
		PrintMatrix(UserMatrix4);
		
		Matrix UserMatrix5 = UserMatrix1.ReturnTransposedMatrix();
		System.out.println();
		System.out.println("CREATE NEW MATRIX TRANSPOSED FROM ");
		PrintMatrix(UserMatrix5);
	}

}
