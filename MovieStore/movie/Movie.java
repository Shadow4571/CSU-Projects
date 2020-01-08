package movie;

public class Movie {
	private int ID;
	private String Name;
	private int Year;
	private int MovieCount;
	private double MovieCost;
	private int RentCount;
	
	public Movie(int ID, String Name, int Year, int MovieCount, double MovieCost) {
		this.ID = ID;
		this.Name = Name;
		this.Year = Year;
		this.MovieCount = MovieCount;
		this.MovieCost = MovieCost;
		this.RentCount = 0;
	}
	
	public int GetID() { return this.ID; }
	public String GetName() { return this.Name; }
	public int GetCount() { return this.MovieCount; }
	public double GetCost() { return this.MovieCost; }
	public int GetRentCount() { return this.RentCount; }
	public boolean CanRent() { return this.MovieCount - this.RentCount > 0; }
	
	public boolean RentMovie() { 
		if(this.CanRent()) {
			this.RentCount++;
			return true;
		}
		
		return false;
	}
	
	public boolean UnRentMovie() {
		if(this.RentCount > 0) {
			this.RentCount--;
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		return "\n" + "Movie ID " + this.ID + " Name " + this.Name + " (" + this.Year + ")" + "\n" + "Count " + 
				this.MovieCount + " / Leased " + this.RentCount + " - Cost " + this.MovieCost + "\n";
	}
}
