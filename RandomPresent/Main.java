import randpres.RandomPresent;

public class Main {
	public static void main(String args[]) {
		RandomPresent RandomClass = new RandomPresent(6);
		RandomClass.RandomGenerate();
		RandomClass.CreateFiles();
	}
}
