
public class Adress {
	private String Street;
	private int House;
	private int Appartaments;
	
	public Adress(String FullAdress) {
		int Space = FullAdress.indexOf(' ');
		int Defis = FullAdress.indexOf('-');
		
		this.Street = FullAdress.substring(0, Space);
		this.House = Integer.parseInt(FullAdress.substring(Space + 1, Defis));
		this.Appartaments = Integer.parseInt(FullAdress.substring(Defis + 1, FullAdress.length()));
	}
	
	public String toString() {
		return this.Street + " " + this.House + "-" + this.Appartaments;
	}
}
