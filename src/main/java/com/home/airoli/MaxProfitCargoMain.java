package com.home.airoli;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.home.airoli.bean.Cargo;

public class MaxProfitCargoMain {

	static int[] maxProfitCargo(int maxLoad, int[][] cargoList) {
		List<Cargo> listCargo = new ArrayList<>();
		for(int i=0; i<cargoList.length; i++) {
			Cargo cargo = new Cargo(cargoList[i][0], cargoList[i][1], cargoList[i][2]);
			listCargo.add(cargo);
		}
		Collections.sort(listCargo, new Comparator<Cargo>() {

			@Override
			public int compare(Cargo o1, Cargo o2) {
				// TODO Auto-generated method stub
				return o1.getWeight() - o2.getWeight();
			}
		});
		Iterator<Cargo> itr = listCargo.iterator();
		Integer loadTruck = 0;
		Integer truckProfit = 0;
		List<Integer> cargoIds = new ArrayList<>();
		while(itr.hasNext()) {
			Cargo c = itr.next();
			if(loadTruck + c.getWeight() < maxLoad) {
				loadTruck = loadTruck + c.getWeight();
				truckProfit = truckProfit + c.getProfit();
				cargoIds.add(c.getId());
			}
		}
		Collections.sort(listCargo, new Comparator<Cargo>() {

			@Override
			public int compare(Cargo o1, Cargo o2) {
				// TODO Auto-generated method stub
				return o1.getProfit() - o2.getProfit();
			}
		});
		Cargo c = listCargo.get(listCargo.size()-1);
		if(truckProfit < c.getProfit()) {
			truckProfit = c.getProfit();
			loadTruck = c.getWeight();
			cargoIds.clear();
			cargoIds.add(c.getId());
		}
		System.out.println("loadTruck, truckProfit, cargoIds: " + loadTruck + truckProfit + cargoIds);
		return null;
	}
	
	public static void main(String[] args) {
		int[][] cargoList = { {38,130,500}, {21,280,1800}, {13,120,1500} };
		int maxLoad = 300;
		int[] arr = maxProfitCargo(maxLoad, cargoList);
	}
}
