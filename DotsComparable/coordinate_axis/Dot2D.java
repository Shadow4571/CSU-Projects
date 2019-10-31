package coordinate_axis;

public class Dot2D extends Dot {
	protected double CoordY;
	
	public Dot2D() {
		super();
		this.CoordY = 0;
	}
	
	public Dot2D(double CoordX, double CoordY) {
		super(CoordX);
		this.CoordY = CoordY;
	}
	
	public double GetCoordY() { return this.CoordY; }
	
	public double Lenght() {
		return Math.sqrt(Math.pow(this.CoordX, 2) + Math.pow(this.CoordY, 2));
	}
	
	public double DotLenght(Dot2D Second) {
		return Math.sqrt( Math.pow(this.CoordX - Second.GetCoordX(), 2) + Math.pow(this.CoordY - Second.GetCoordY(), 2) );
	}
	
	public String toString() {
		return "X - " + this.CoordX + " Y - " + this.CoordY;
	}
	
	public boolean LessThen(Dot2D Second) {
		return (this.CoordX < Second.GetCoordX()) && (this.CoordY < Second.GetCoordY());
	}
	
	public boolean MoreThen(Dot2D Second) {
		return (this.CoordX > Second.GetCoordX()) && (this.CoordY > Second.GetCoordY());
	}
}
