
public class Matrix {
	private int[] Matrix;					// Matrix
	private int Row, Column;				// Width and Height
	private boolean IsSquare, IsTransposed;	// Is the matrix square and has it been transposed
	
	/* ================================= */
	/* ========== CONSTRUCTOR ========== */
	
	// Create a square matrix and fill with random numbers
	public Matrix(int Row) {
		this.Row = Row;
		this.Column = Row;
		this.Matrix = new int[Row * Row];
		this.IsSquare = true;
		this.IsTransposed = false;
		this.FillMatrix();
	}
	
	// Create a square/rectangular matrix and fill with random numbers
	public Matrix(int Row, int Column) {
		this.Row = Row;
		this.Column = Column;
		this.Matrix = new int[Row * Column];
		
		if(this.Row == this.Column)
			this.IsSquare = true;
		else 
			this.IsSquare = false;
		
		this.IsTransposed = false;
		this.FillMatrix();
	}
	
	// Create a square/rectangular matrix and fill with current number
	public Matrix(int Row, int Column, int Number) {
		this.Row = Row;
		this.Column = Column;
		this.Matrix = new int[Row * Column];
		
		if(this.Row == this.Column)
			this.IsSquare = true;
		else 
			this.IsSquare = false;
		
		this.IsTransposed = false;
		this.FillMatrix(Number);
	}
	
	// Create a square/rectangular matrix from array
	public Matrix(int Row, int Column, int[] Array) {
		if(Array.length != Row * Column) {
			this.Row = 1;
			this.Column = 1;
			this.Matrix = new int[1];
		} else {
			this.Row = Row;
			this.Column = Column;
			this.Matrix = new int[Row * Column];
			for(int i = 0; i < Row * Column; i++)
				this.Matrix[i] = Array[i];
		}
		
		if(Row == Column)
			this.IsSquare = true;
		else 
			this.IsSquare = false;
		
		this.IsTransposed = false;
	}
	
	/* ================================ */
	/* ============ PUBLIC ============ */
	
	public int GetRow() { return this.Row; }
	public int GetColumn() { return this.Column; }
	public int[] GetMatrixArray() { return this.Matrix; }
	public boolean GetIsSquare() { return this.IsSquare; }
	public boolean GetIsTransposed() { return this.IsTransposed; } 
	
	// Return matrix item from position
	public int GetElementByPosition(int i, int j) {
		if(this.CheckRange(i, j))
			return this.Matrix[j * this.Row + i];
		
		return Integer.MIN_VALUE;
	}
	
	// Return item from array position
	public int GetElementByPosition(int Position) {
		if(this.CheckRange(Position))
			return this.Matrix[Position];
		else
			return Integer.MIN_VALUE;
	}
	
	// Set item to matrix position
	public boolean SetElementByPosition(int i, int j, int Number) {
		if(this.CheckRange(i, j)) {
			this.Matrix[j * this.Row + i] = Number;
			
			return true;
		}
		
		return false;
	}
	
	// Set item to array position
	public boolean SetElementByPosition(int Position, int Number) {
		if(this.CheckRange(Position)) {
			this.Matrix[Position] = Number;
			
			return true;
		}
		
		return false;
	}
	
	// Add number to matrix item
	public boolean AddNumberInPosition(int i, int j, int Number) {
		if(this.CheckRange(Row, Column)) {
			this.Matrix[j * this.Row + i] += Number;
			
			return true;
		}
		
		return false;
	}
	
	// Add a number to each item of the matrix
	public boolean AddNumberInMatrix(int Number) {
		for(int i = 0; i < this.Row * this.Column; i++)
			this.Matrix[i] += Number;
		
		return true;
	}
	
	// Add each matrix item to each item of the matrix
	public boolean AddNumberInMatrix(Matrix Temp) {
		if((this.Row == Temp.GetRow() && this.Column == Temp.GetColumn()) || (this.Row == Temp.GetColumn() && this.Column == Temp.GetRow())) {
			for(int i = 0; i < this.Row * this.Column; i++)
				this.Matrix[i] += Temp.GetElementByPosition(i);
			
			return true;
		}
		
		return false;
	}
	
	// Transpose matrix
	public boolean TransposeMatrix() {
		if(this.IsSquare)
			this.TransposeSquare();
		else 
			this.TransposeRect();
		
		this.IsTransposed = !this.IsTransposed;
		return true;
	}
	
	// Return matrix
	public Matrix ReturnMatrix() {
		return new Matrix(this.Row, this.Column, this.Matrix);
	}
	
	// Return transposed matrix
	public Matrix ReturnTransposedMatrix() {
		Matrix Temp = new Matrix(this.Row, this.Column, this.Matrix);
		Temp.TransposeMatrix();
		return Temp;
	}
	
	/* ================================= */
	/* ============ PRIVATE ============ */
	
	// Fill the matrix with random numbers
	private void FillMatrix() {
		for(int i = 0; i < this.Row * this.Column; i++)
			this.Matrix[i] = (int)(Math.random() * 100);
	}
	
	// fill the matrix with a number
	private void FillMatrix(int Number) {
		for(int i = 0; i < this.Row * this.Column; i++)
			this.Matrix[i] = Number;
	}
	
	// Check if the position fits in the matrix size
	private boolean CheckRange(int i, int j) {
		return (i > -1 && j > -1) && (i < this.Row && j < this.Column);
	}
	
	// Check if the position fits in the array size
	private boolean CheckRange(int Position) {
		return (Position > -1) && (Position < this.Row * this.Column);
	}
	
	// Transpose square matrix
	private void TransposeSquare() {
		int Array[] = new int[this.Row * this.Column];
		int Count = 0;
		
		for(int i = 0; i < this.Column; i++)
			for(int j = 0; j < this.Row; j++)
				Array[Count++] = this.Matrix[j * this.Column + i];
		
		for(int i = 0; i < this.Row * this.Column; i++)
			this.Matrix[i] = Array[i];
	}
	
	// Transpose rectangular matrix
	private void TransposeRect() {
		int Array[] = new int[this.Row * this.Column];
		int Count = 0;
		
		for(int i = 0; i < this.Row; i++)
			for(int j = 0; j < this.Column; j++)
				Array[Count++] = this.Matrix[j * this.Row + i];
		
		for(int i = 0; i < this.Row * this.Column; i++)
			this.Matrix[i] = Array[i];
		
		int Temp = this.Row;
		this.Row = this.Column;
		this.Column = Temp;
	}
}
