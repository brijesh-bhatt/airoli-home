package com.home.airoli.bean;

public class Cargo {

	private int id;
	private int weight;
	private int profit;
	
	public Cargo() {}
	public Cargo(int id, int weight, int profit) {
		super();
		this.id = id;
		this.weight = weight;
		this.profit = profit;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	@Override
	public String toString() {
		return "Cargo [id=" + id + ", weight=" + weight + ", profit=" + profit + "]";
	}
}
