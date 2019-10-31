import coordinate_axis.Dot3D;

public class Main {
	public static void main(String[] args) {
		Dot3D TempDot1 = new Dot3D(2, 5, 3);
		Dot3D TempDot2 = new Dot3D(4, 6, 5);
		
		System.out.println("FIRST DOT - " + TempDot1);
		System.out.println("SECOND DOT - " + TempDot2);
		
		System.out.println("LENGHT BETWEEN FIRST AND SECOND - " + TempDot1.DotLenght(TempDot2));
		System.out.println("LENGHT BETWEEN FIRST AND CENTER - " + TempDot1.Lenght());
		System.out.println("LENGHT BETWEEN SECOND AND CENTER - " + TempDot2.Lenght());
		System.out.println("IS FIRST LESS THEN SECOND - " + TempDot1.LessThen(TempDot2));
		System.out.println("IS FIRST MORE THEN SECOND - " + TempDot1.MoreThen(TempDot2));
	}

}
