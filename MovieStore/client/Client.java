package client;

import java.util.ArrayList;
import java.util.Date;

public class Client {
	private class Order {
		private int MovieID;
		private double OrderCost;
		private Date StartRent, EndRent;
		
		public Order(int MovieID, double OrderCost, Date StartRent, int RentLenght) {
			this.MovieID = MovieID;
			this.OrderCost = OrderCost;
			this.StartRent = StartRent;
			this.EndRent = new Date(this.StartRent.getYear(), this.StartRent.getMonth(), this.StartRent.getDate() + RentLenght, this.StartRent.getHours(), this.StartRent.getMinutes());
		}
		
		public double GetCost() { return this.OrderCost; }
		public double GetMovieID() { return this.MovieID; }
		
		public boolean IsExpired() {
			return this.SubtractDate(this.EndRent, new Date()) < 0;
		}
		
		private int SubtractDate(Date First, Date Second) {
			return (First.getYear() + First.getMonth() + First.getDate() + First.getHours() + First.getMinutes()) - (Second.getYear() + Second.getMonth() + Second.getDate() + Second.getHours() + Second.getMinutes());
		}
		
		public String toString() {
			return "Order ID " + this.MovieID + " Cost " + this.OrderCost + "\n" + "Start Rent " + this.StartRent + " End Rent " + this.EndRent;
		}
	}
	
	private int ID;
	private String FirstName, Surname;
	private ArrayList<Order> OrdersArray;
	
	public Client(int ID, String FirstName, String Surname) {
		this.ID = ID;
		this.FirstName = FirstName;
		this.Surname = Surname;
		this.OrdersArray = new ArrayList<Order>();
	}
	
	public int GetID() { return this.ID; }
	public String GetFullName() { return this.FirstName + " " + this.Surname; }
	
	public boolean AddOrder(int MovieID, double OrderCost, Date StartRent, int RentLenght) {
		OrdersArray.add(new Order(MovieID, OrderCost, StartRent, RentLenght));
		return true;
	}
	
	public double DeleteOrder(int MovieID) {
		for(int i = 0; i < this.OrdersArray.size(); i++) {
			if(this.OrdersArray.get(i).GetMovieID() == MovieID) {
				double Cost = this.OrdersArray.get(i).GetCost();
				this.OrdersArray.remove(i);
				return Cost;
			}
		}
		
		return 0.0;
	}
	
	public double DeleteOrder(int MovieID[]) {
		double Cost = 0.0;
		for(int i = 0; i < MovieID.length; i++)
			Cost += this.DeleteOrder(MovieID[i]);
		
		return Cost;
	}
	
	public double AllOrderCost() {
		double Cost = 0.0;
		
		for(int i = 0; i < this.OrdersArray.size(); i++)
			Cost += this.OrdersArray.get(i).GetCost();
		
		return Cost;
	}
	
	public double MovieOrderCost(int MovidID) {
		for(int i = 0; i < this.OrdersArray.size(); i++)
			if(this.OrdersArray.get(i).GetMovieID() == MovidID)
				return this.OrdersArray.get(i).GetCost();
		
		return 0.0;
	}
	
	public Debtor HasExpired() {
		
	}
	
	public String toString() {
		String Client = new String("\n" + "Fullname " + this.GetFullName() + " ID " + this.ID + "\n");
		String Orders = new String();
		
		for(int i = 0; i < this.OrdersArray.size(); i++)
			Orders += (this.OrdersArray.get(i) + "\n");
		
		return Client + Orders;
	}
}
