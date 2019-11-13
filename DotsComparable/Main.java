import java.util.Arrays;

import coordinate_axis.Dot3D;

public class Main {
	public static Object FindMax(Object Array[]) {
		Object maxObject = Array[0];
		
		for(int i = 0; i < Array.length; i++)
			if(((Dot3D)maxObject).compareTo((Dot3D)Array[i]) < 0)
				maxObject = Array[i];
					
		return maxObject;
	}
	
	public static void main(String[] args) {
		int Size = 4;
		Dot3D Array[] = new Dot3D[Size];
		
		for(int i = 0; i < Size; i++)
			Array[i] = new Dot3D(Size - i, Size - i, Size - i);
		
		System.out.println("ORIGINAL ARRAY");
		for(Dot3D i : Array)
			System.out.println(i);
		
		Arrays.sort(Array);
		
		System.out.println("\n" + "CHANGED ARRAY");
		for(Dot3D i : Array)
			System.out.println(i);
		
		System.out.println("\n" + "MAX ELEMENT");
		System.out.println((Dot3D)(Main.FindMax(Array)));
	}

}
