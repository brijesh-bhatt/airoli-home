package com.home.airoli;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.home.airoli.bean.Cargo;

public class MaxProfitCargoNew {

	static Integer[][] maxProfitCargo(int maxLoad, int[][] cargoList) {
		List<Cargo> listCargo = new ArrayList<>();
		for(int i=0; i<cargoList.length; i++) {
			Cargo cargo = new Cargo(cargoList[i][0], cargoList[i][1], cargoList[i][2]);
			listCargo.add(cargo);
		}
		Cargo c = listCargo.stream().max((o1, o2) -> o1.getProfit() - o2.getProfit()).get();
		int sum=0;
		System.out.println(listCargo.stream()
							 .sorted((o1,o2) -> o1.getWeight() - o2.getWeight())
							 .mapToInt(m -> m.getWeight())
							 .sum());
		System.out.println("Cargo: " + sum);
		System.out.println("listCargo: " + listCargo);
		return null;
	}
}
