
public class Student {
	private String FirstName, LastName;
	private int[] Rating;
	private double AverageRating;
	
	public Student(String FirstName, String LastName, String RatingString, int RatingCount) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Rating = new int[RatingCount];
		
		int j = 0;
		for(int i = 0; i < RatingString.length(); i++) {
			if(RatingString.charAt(i) != ' ') {
				Rating[j] = Integer.parseInt(RatingString.substring(i, i + 1));
				j++;
			}
		}
		
		this.CountRating();
	}
	
	public double GetRating() { return this.AverageRating; }
	
	private void CountRating() {
		for(int i = 0; i < this.Rating.length; i++)
			this.AverageRating += Rating[i];
		
		this.AverageRating = this.AverageRating / this.Rating.length;
	}
	
	public String toString() {
		String Temp = this.FirstName + " " + this.LastName + " ( ";
		for(int i = 0; i < this.Rating.length; i++)
			Temp += Rating[i] + " ";
		
		return Temp + ")\n";
	}
}
