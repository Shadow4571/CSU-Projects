package coordinate_axis;

public class Dot3D extends Dot2D {
	protected double CoordZ;
	
	public Dot3D() {
		super();
		this.CoordZ = 0;
	}
	
	public Dot3D(double CoordX, double CoordY, double CoordZ) {
		super(CoordX, CoordY);
		this.CoordZ = CoordZ;
	}
	
	public double GetCoordZ() { return this.CoordZ; }
	
	public double Lenght() {
		return Math.sqrt(Math.pow(this.CoordX, 2) + Math.pow(this.CoordY, 2) + Math.pow(this.CoordZ, 2));
	}
	
	public double DotLenght(Dot3D Second) {
		return Math.sqrt(Math.pow(this.CoordX - Second.GetCoordX(), 2) + Math.pow(this.CoordY - Second.GetCoordY(), 2) + Math.pow(this.CoordZ - Second.GetCoordZ(), 2));
	}
	
	public String toString() {
		return "X - " + this.CoordX + " Y - " + this.CoordY + " Z - " + this.CoordZ;
	}
	
	public boolean LessThen(Dot3D Second) {
		return (this.CoordX < Second.GetCoordX()) && (this.CoordY < Second.GetCoordY()) && (this.CoordZ < Second.GetCoordZ());
	}
	
	public boolean MoreThen(Dot3D Second) {
		return (this.CoordX > Second.GetCoordX()) && (this.CoordY > Second.GetCoordY()) && (this.CoordZ > Second.GetCoordZ());
	}
}
