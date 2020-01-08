package movie;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import client.Client;
import client.Debtor;

public class Store {
	LinkedList<Movie> MovieList = new LinkedList<Movie>();
	LinkedList<Client> ClientList = new LinkedList<Client>();
	
	public Store() {
		
	}
	
	public boolean AddClient(int ID, String FirstName, String Surname) {
		this.ClientList.add(new Client(ID, FirstName, Surname));
		return true;
	}
	
	public boolean AddMovie(int ID, String Name, int Year, int MovieCount, double MovieCost) {
		this.MovieList.add(new Movie(ID, Name, Year, MovieCount, MovieCost));
		return true;
	}
	
	public boolean AddOrder(int ClientID, int MovieID, int RentLenght) {
		for(int i = 0; i < this.ClientList.size(); i++) {
			if(this.ClientList.get(i).GetID() == ClientID) {
				for(int j = 0; j < this.MovieList.size(); j++) {
					if(this.MovieList.get(j).GetID() == MovieID) {
						if(this.MovieList.get(j).RentMovie()) {
							this.ClientList.get(i).AddOrder(MovieID, this.MovieList.get(j).GetCost(), new Date(), RentLenght);
							return true;
						}
						return false;
					}
				}
				
				return false;
			}
		}
		
		return false;
	}
	
	public double DeleteOrder(int ClientID, int MovieID) {
		for(int i = 0; i < this.ClientList.size(); i++) {
			if(this.ClientList.get(i).GetID() == ClientID) {
				for(int j = 0; j < this.MovieList.size(); j++) {
					if(this.MovieList.get(i).GetID() == MovieID) {
						if(this.MovieList.get(i).UnRentMovie()) {
							return this.ClientList.get(i).DeleteOrder(MovieID);
						}
						return 0.0;
					}
				}
				
				return 0.0;
			}
		}
		
		return 0.0;
	}
	
	public double DeleteOrder(int ClientID, int MovieID[]) {
		double Cost = 0.0;
		
		for(int i = 0; i < MovieID.length; i++) 
			Cost += this.DeleteOrder(ClientID, MovieID[i]);
		
		return Cost;
	}
	
	public ArrayList<Debtor> PastRent() {
		ArrayList<Debtor> Temp = new ArrayList<Debtor>();
		
		for(int i = 0; i < this.ClientList.size(); i++)
			Temp.add(this.ClientList.get(i).HasExpired());
		
		return Temp;
	}
	
	public String toString() {
		String MovieString = new String("=== MOVIE ===" + "\n" + "Movie count " + this.MovieList.size() + "\n");
		for(int i = 0; i < this.MovieList.size(); i++)
			MovieString += this.MovieList.get(i);
		
		String ClientString = new String("\n" + "=== CLIENT ===" + "\n" + "Client count " + this.ClientList.size() + "\n");
		for(int i = 0; i < this.ClientList.size(); i++)
			ClientString += this.ClientList.get(i);
		
		return MovieString + ClientString;
	}
}
