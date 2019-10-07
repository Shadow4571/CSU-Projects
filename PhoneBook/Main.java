import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static final String IN_FILE_NAME = "E:\\Eclipse Projects\\PhoneBook\\src\\INPUT.txt";
	public static final String OUT_FILE_NAME = "E:\\Eclipse Projects\\PhoneBook\\src\\OUTPUT.txt";
	
	public static void main(String[] args) throws IOException {
		int PeoplesCount, SearchCount;
		ArrayList<Human> PhoneBook = new ArrayList<Human>();
		Scanner inScanner = new Scanner(new File(IN_FILE_NAME));
		FileWriter OutFile = new FileWriter(new File(OUT_FILE_NAME), false);
		
		PeoplesCount = inScanner.nextInt();
		SearchCount = inScanner.nextInt();
		
		int SearchNumbers[] = new int[SearchCount];
		
		for(int i = 0; i < PeoplesCount; i++)
			PhoneBook.add(new Human(inScanner.nextInt(), inScanner.nextLine() + inScanner.nextLine(), new Adress(inScanner.nextLine())));
		
		for(int i = 0; i < SearchCount; i++)
			SearchNumbers[i] = inScanner.nextInt();
		
		for(int i = 0; i < SearchCount; i++) {
			for(int j = 0; j < PhoneBook.size(); j++) {
				if(PhoneBook.get(j).CheckNumber(SearchNumbers[i])) {
					OutFile.write(PhoneBook.get(j).toString() + "\n");
					break;
				}
			}
		}
		
		inScanner.close();
		OutFile.close();
		
		System.out.println("File OUTPUT.txt succesfull created");
	}

}
