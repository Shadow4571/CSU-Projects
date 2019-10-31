package coordinate_axis;

import ñomparable.ComparableDot;

public class Dot implements ComparableDot {
	protected double CoordX;
	
	public Dot() {
		this.CoordX = 0;
	}
	
	public Dot(double CoordX) {
		this.CoordX = CoordX;
	}
	
	public double GetCoordX() { return this.CoordX; }
	
	public double Lenght() {
		return Math.abs(this.CoordX);
	}
	
	public double DotLenght(Dot Second) {
		return Math.abs(this.CoordX - Second.GetCoordX());
	}
	
	public String toString() {
		return "X - " + this.CoordX;
	}

	@Override
	public boolean LessThen(Dot Second) {
		return this.CoordX < Second.GetCoordX();
	}

	@Override
	public boolean MoreThen(Dot Second) {
		return this.CoordX > Second.GetCoordX();
	}
}
