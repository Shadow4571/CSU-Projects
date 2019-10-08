
public class Matrix {
	private int[][] Matrix;					// Matrix
	private int Row, Column;				// Width and Height
	
	/* ================================== */
	/* ========== CONSTRUCTORS ========== */
	
	// Constructor for a rectangular matrix
	public Matrix(int Row, int Column) {
		this.Row = Row;
		this.Column = Column;
		this.Matrix = new int[Row][Column];
		this.FillMatrix();
	}
	
	// Constructor filling a matrix with a certain number
	public Matrix(int Row, int Column, int Number) {
		this.Row = Row;
		this.Column = Column;
		this.Matrix = new int[Row][Column];
		this.FillMatrix(Number);
	}
	
	// Constructor for a square matrix
	public Matrix(int Row) {
		this.Row = Row;
		this.Column = Row;
		this.Matrix = new int[Row][Row];
		this.FillMatrix();
	}
	
	// Constructor to create a matrix from the source
	public Matrix(Matrix New) {
		this.Row = New.GetRow();
		this.Column = New.GetColumn();
		this.Matrix = new int[this.Row][this.Column];
		
		for(int i = 0; i < this.Row; i++) 
			for(int j = 0; j < this.Column; j++) 
				this.Matrix[i][j] = New.ReturnElementByPosition(i, j);
	}
	
	// Constructor creating a matrix from a two-dimensional array
	public Matrix(int Row, int Column, int[][] New) {
		this.Row = Row;
		this.Column = Column;
		this.Matrix = new int[this.Row][this.Column];
		
		for(int i = 0; i < this.Row; i++) 
			for(int j = 0; j < this.Column; j++) 
				this.Matrix[i][j] = New[i][j];
	}
	
	// Constructor creating a transposed matrix
	public Matrix(int[][] TransNew, int TransRow, int TransColumn) {
		this.Row = TransRow;
		this.Column = TransColumn;
		this.Matrix = new int[this.Row][this.Column];
		
		for(int i = 0; i < this.Row; i++) 
			for(int j = 0; j < this.Column; j++) 
				this.Matrix[i][j] = TransNew[j][i];
	}
	
	/* ================================ */
	/* ============ PUBLIC ============ */
			
	// Return width and height dimensions
	public int GetRow() { return this.Row; }
	public int GetColumn() { return this.Column; }
	
	// Print matrix to console
	public void PrintMatrix() {
		for(int i = 0; i < this.Row; i++) {
			for(int j = 0; j < this.Column; j++)
				System.out.print(Matrix[i][j] + " ");
			
			System.out.println();
		}
	}
	
	// Print transposed matrix to console
	public void PrintTransposedMatrix() {
		for(int i = 0; i < this.Column; i++) {
			for(int j = 0; j < this.Row; j++) 
				System.out.print(this.Matrix[j][i] + " ");
			
			System.out.println();
		}
	}
	
	// Return element by position
	public int ReturnElementByPosition(int Row, int Column) {
		if(this.CheckRange(Row, Column))
			return this.Matrix[Row][Column];
		else 
			return 0;
	}
	
	// Set the specified element in position
	public void SetElementByPosition(int Row, int Column, int Number) {
		if(this.CheckRange(Row, Column))
			this.Matrix[Row][Column] = Number;
	}
	
	// Add number in position
	public void AddNumberToPosition(int Row, int Column, int Number) {
		if(this.CheckRange(Row, Column))
			this.Matrix[Row][Column] += Number;
	}
	
	// Add a number to each element of the matrix
	public void AddNumberToMatrix(int Number) {
		for(int i = 0; i < this.Row; i++)
			for(int j = 0; j < this.Column; j++)
				this.Matrix[i][j] += Number;
	}
	
	// Add to each element of the matrix the corresponding element of the second matrix
	public void AddNumberToMatrix(Matrix AddMat) {
		if(this.CheckRange(AddMat.GetRow(), AddMat.GetColumn())) {
			for(int i = 0; i < this.Row; i++)
				for(int j = 0; j < this.Column; j++)
					this.Matrix[i][j] += AddMat.ReturnElementByPosition(i, j);
		}
	}
	
	// Return matrix
	public Matrix ReturnMatrix() {
		return new Matrix(this.Row, this.Column, this.Matrix);
	}
	
	// Return transposed matrix
	public Matrix ReturnTransposedMatrix() {
		return new Matrix(this.Matrix, this.Column, this.Row);
	}
	
	// Multiply the matrix by another matrix
	public Matrix MultiplyMatrix(Matrix MultiplyMat) {
		if(this.Column == MultiplyMat.GetRow()) {
			Matrix Temp = new Matrix(this.Row, MultiplyMat.GetColumn(), 0);
			for(int i = 0; i < Temp.GetRow(); i++) {
				for(int j = 0; j < Temp.GetColumn(); j++) {
					for(int k = 0; k < this.Column; k++) {
						Temp.AddNumberToPosition(i, j, this.Matrix[i][k] * MultiplyMat.ReturnElementByPosition(k, j));
					}
				}
			}
			return Temp;
		}
		return new Matrix(1);
	}
	
	/* ================================= */
	/* ============ PRIVATE ============ */
	
	// Fill the matrix with random numbers
	private void FillMatrix() {
		for(int i = 0; i < this.Row; i++)
			for(int j = 0; j < this.Column; j++)
				this.Matrix[i][j] = (int)(Math.random() * 100);
	}
	
	// fill the matrix with a number
	private void FillMatrix(int Number) {
		for(int i = 0; i < this.Row; i++)
			for(int j = 0; j < this.Column; j++)
				this.Matrix[i][j] = Number;
	}
	
	// Check if the position fits in the matrix size
	private boolean CheckRange(int Row, int Column) {
		return (Row > -1 && Column > -1) && (Row < this.Row && Column < this.Column);
	}
}
