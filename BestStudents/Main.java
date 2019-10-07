import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static final String IN_FILE_NAME = "E:\\Eclipse Projects\\BestStudent\\src\\INPUT.TXT";
	public static final String OUT_FILE_NAME = "E:\\Eclipse Projects\\BestStudent\\src\\OUTPUT.TXT";
	
	public static void main(String[] args) throws IOException {
		Scanner inScanner = new Scanner(new File(IN_FILE_NAME));
		FileWriter OutFile = new FileWriter(new File(OUT_FILE_NAME), false);
		
		ArrayList<Student> StudentsList = new ArrayList<Student>();
		int StudentsCount = inScanner.nextInt(), RatingCount = inScanner.nextInt();
		
		for(int i = 0; i < StudentsCount; i++)
			StudentsList.add(new Student(inScanner.next(), inScanner.nextLine(), inScanner.nextLine(), RatingCount));
		
		double[] MaxRating = new double[3];
		for(int i = 0; i < StudentsList.size(); i++)
			if(MaxRating[0] < StudentsList.get(i).GetRating())
				MaxRating[0] = StudentsList.get(i).GetRating();
			
		int Count = 0;
		while(Count < 3) {
			for(int i = 0; i < StudentsList.size(); i++) {
				if(Count < 2) {
					if((MaxRating[Count + 1] < StudentsList.get(i).GetRating()) && (StudentsList.get(i).GetRating() < MaxRating[Count]))
						MaxRating[Count + 1] = StudentsList.get(i).GetRating();
				} else {
					if(MaxRating[Count] < StudentsList.get(i).GetRating() && StudentsList.get(i).GetRating() < MaxRating[Count - 1])
						MaxRating[Count] = StudentsList.get(i).GetRating();
				}

				if(StudentsList.get(i).GetRating() == MaxRating[Count])
					OutFile.write(StudentsList.get(i).toString());
			}
			Count++;
		}
		
		inScanner.close();
		OutFile.close();
	}
}
