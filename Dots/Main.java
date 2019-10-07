import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static final String IN_FILE_NAME = "E:\\Eclipse Projects\\Dots\\src\\INPUT.TXT";
	public static final String OUT_FILE_NAME = "E:\\Eclipse Projects\\Dots\\src\\OUTPUT.TXT";
	
	public static void main(String[] args) throws IOException {
		Scanner inScanner = new Scanner(new File(IN_FILE_NAME));
		FileWriter OutFile = new FileWriter(new File(OUT_FILE_NAME), false);
		
		ArrayList<Dot> DotsList = new ArrayList<Dot>();
		int DotsCount = inScanner.nextInt();
		double TempLenght = 0, MinLenght = Double.MAX_VALUE, MaxLenght = Double.MIN_VALUE;
		int MinFirst = 0, MinSecond = 0, MaxFirst = 0, MaxSecond = 0;
		
		for(int i = 0; i < DotsCount; i++)
			DotsList.add(new Dot(inScanner.nextInt(), inScanner.nextInt()));
		
		for(int i = 0; i < DotsList.size() - 1; i++) {
			for(int j = i + 1; j < DotsList.size(); j++) {
				if(DotsList.get(i).IsBigger(DotsList.get(j)))
					TempLenght = DotsList.get(i).GetLenght(DotsList.get(j));
				else
					TempLenght = DotsList.get(j).GetLenght(DotsList.get(i));
				
				if(TempLenght < MinLenght) {
					MinLenght = TempLenght;
					MinFirst = i + 1;
					MinSecond = j + 1;
				}
				
				if(TempLenght > MaxLenght) {
					MaxLenght = TempLenght;
					MaxFirst = i + 1;
					MaxSecond = j + 1;
				}
			}
		}
		
		OutFile.write(MinFirst + " " + MinSecond + "\n" + MaxFirst + " " + MaxSecond);
		
		inScanner.close();
		OutFile.close();
	}

}
