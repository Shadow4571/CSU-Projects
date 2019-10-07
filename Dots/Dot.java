
public class Dot {
	private int CordX, CordY;
	
	public Dot(int CordX, int CordY) {
		this.CordX = CordX;
		this.CordY = CordY;
	}
	
	public int GetX() { return this.CordX; }
	public int GetY() { return this.CordY; }
	
	public String toString() {
		return "X " + this.CordX + " Y " + this.CordY;
	}
	
	public boolean IsBigger(Dot Second) {
		return this.CordX > Second.GetX() || this.CordY > Second.GetY();
	}
	
	public double GetLenght(Dot Second) {
		return Math.sqrt( Math.pow((this.CordX - Second.GetX()), 2) + Math.pow((this.CordY - Second.GetY()), 2));
	}
}
