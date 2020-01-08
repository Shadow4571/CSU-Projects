package randpres;

import java.util.ArrayList;

public class NumbersList {
	private ArrayList<Integer> CurList;
	private int MaxSize = 0;
	
	public NumbersList(int MaxSize) {
		this.CurList = new ArrayList<Integer>();
		this.MaxSize = MaxSize;
	}
	
	public NumbersList(int Number, int MaxSize) {
		this.CurList = new ArrayList<Integer>(Number);
		this.MaxSize = MaxSize;
	}
	
	public void add(int Number) {
		this.CurList.add(Number);
	}
	
	public int get(int Index) {
		return this.CurList.get(Index);
	}
	
	public boolean nextLast() { 
		return this.CurList.size() >= this.MaxSize - 1;
	}
	
	public int getFullSum() {
		int Sum = 0;
		
		for(int i = 0; i < this.CurList.size(); i++)
			Sum += this.CurList.get(i);
		
		return Sum;
	}
	
	public int size() {
		return this.CurList.size();
	}
	
	public int maxSize() {
		return this.MaxSize;
	}
	
	public boolean hasNumber(int Number) {
		for(int i = 0; i < this.CurList.size(); i++)
			if(this.CurList.get(i) == Number)
				return true;
		
		return false;
	}
	
	public int getLast() {
		return this.MaxSize + (this.MaxSize * 2 - this.getFullSum());
	}
	
	public boolean clear() {
		this.CurList.clear();
		return true;
	}
}
