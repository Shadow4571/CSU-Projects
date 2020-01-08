package randpres;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class RandomPresent {
	private int Count;
	private Scanner FileScanner;
	private String NameList[], FunnyList[];
	private NumbersList FirstList, SecondList;
	
	public RandomPresent(int Count) {
		this.Count = Count;
		this.NameList = new String[this.Count];
		this.FunnyList = new String[this.Count];
		
		try {
			this.FileScanner = new Scanner(new File("E:\\Eclipse Projects\\RandomPresent\\src\\randpres\\NamesList"));
		} catch (Exception Exp) {
			Exp.printStackTrace();
		}
		
		for(int i = 0; i < this.Count * 2; i++) {
			if(i < this.Count)
				this.NameList[i] = this.FileScanner.nextLine();
			else
				this.FunnyList[i - this.Count] = this.FileScanner.nextLine();
		}
		
		this.FirstList = new NumbersList(this.Count);
		this.SecondList = new NumbersList(this.Count);
	}
	
	public boolean RandomGenerate() {
		while(this.FirstList.size() < this.FirstList.maxSize()) {
			int FirstRandom = (int)(Math.random() * this.Count);
			int SecondRandom = (int)(Math.random() * this.Count);
			
			if(FirstRandom != SecondRandom && !this.FirstList.hasNumber(FirstRandom) && !this.SecondList.hasNumber(SecondRandom)) {
				this.FirstList.add(FirstRandom);
				this.SecondList.add(SecondRandom);
			}
			
			if(this.FirstList.size() == this.FirstList.maxSize() - 1 && this.FirstList.getLast() == this.SecondList.getLast()) {
				System.out.println("LAST IN FIRST " + this.FirstList.getLast() + " EQUAL LAST IN SECOND  " + this.SecondList.getLast() + " CLEAR LIST");
				this.FirstList.clear();
				this.SecondList.clear();
			}
		}
		/*
		for(int i = 0; i < this.Count; i++) {
			System.out.println(this.FirstList.get(i) + " - " + this.SecondList.get(i));
		}
		*/
		return true;
	}
	
	public boolean CreateFiles() {
		for(int i = 0; i < this.Count; i++) {
			String fileString = new String("E:\\Eclipse Projects\\RandomPresent\\src\\randpres\\Result\\" + this.FirstList.get(i) + "-" + this.NameList[this.FirstList.get(i)] + ".txt");
			System.out.println(fileString);
			try {
				FileWriter OutFile = new FileWriter(fileString);
				OutFile.write(this.FunnyList[this.FirstList.get(i)] + " -> " + this.FunnyList[this.SecondList.get(i)] + "\n");
				//OutFile.write(this.FirstList.get(i) + " -> " + this.SecondList.get(i));
				OutFile.close();
			} catch (Exception Exp) {
				Exp.printStackTrace();
			}
		}
		
		return true;
	}
}
