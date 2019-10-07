
public class Human {
	private int PhoneNumber;
	private String FirstName, LastName, Patronymic;
	private Adress HumanAdress;
	
	public Human(int PhoneNumber, String FullName, Adress HumanAdress ) {
		this.PhoneNumber = PhoneNumber;
		this.HumanAdress = HumanAdress;
		
		int ParseStart = 0, ParseEnd = FullName.indexOf(' ');
		this.FirstName = FullName.substring(ParseStart, ParseEnd);
		ParseStart = ParseEnd + 1;
		ParseEnd = FullName.indexOf(' ', ParseEnd + 1);
		this.LastName = FullName.substring(ParseStart, ParseEnd);
		this.Patronymic = FullName.substring(ParseEnd + 1, FullName.length());
	}
	
	public boolean CheckNumber(int PhoneNumber) {
		return this.PhoneNumber == PhoneNumber;
	}
	
	public String toString() {
		return this.FirstName + " " + this.LastName + " " + this.Patronymic + " (" + this.HumanAdress + ")";
	}
}
