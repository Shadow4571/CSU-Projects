
public class Main {

	public static void main(String[] args) {
		Matrix UserMatrix1 = new Matrix(3, 3);
		Matrix UserMatrix2 = new Matrix(3, 1);
		
		System.out.println("FIRST MATRIX");
		UserMatrix1.PrintMatrix();
		
		System.out.println();
		System.out.println("SECOND MATRIX");
		UserMatrix2.PrintMatrix();
		
		System.out.println();
		System.out.println("SECOND MATRIX WIDTH " + UserMatrix2.GetColumn() + " HEIGHT " + UserMatrix2.GetRow());
		
		System.out.println();
		System.out.println("TRANSPOSED SECOND MATRIX");
		UserMatrix2.PrintTransposedMatrix();
		
		System.out.println();
		System.out.println("MULTUPLY FIRST AND SECOND");
		UserMatrix1.MultiplyMatrix(UserMatrix2).PrintMatrix();
		
		System.out.println();
		System.out.println("MULTUPLY SECOND AND TRANSPOSED SECOND");
		UserMatrix2.MultiplyMatrix(UserMatrix2.ReturnTransposedMatrix()).PrintMatrix();
		
		System.out.println();
		System.out.println("ADD NUMBER TO FIRST");
		UserMatrix1.AddNumberToMatrix(10);
		UserMatrix1.PrintMatrix();
	}

}
