import java.util.Date;

import movie.Store;

public class Main {
	public static void main(String[] args) {
		Store AllStore = new Store();
		
		AllStore.AddClient(1, "Nikita", "Myznikov");
		AllStore.AddClient(2, "Mariya", "Motaeva");
		AllStore.AddMovie(100, "9 Rota", 2000, 10, 250);
		
		AllStore.AddOrder(1, 100, 17);
		AllStore.AddOrder(2, 100, -2);
		
		System.out.println(AllStore + "\n");
		System.out.println("Nikita pay rent " + AllStore.DeleteOrder(1, 100) + "\n");
		
	}
}
