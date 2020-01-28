package com.krishna.mstest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Stock {
	private static final Logger logger = LogManager.getLogger(Stock.class);

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String input = scanner.next(); // 150,200,250,380,50,530,700
		String[] stringArray = input.split(",");
		int[] array = new int[stringArray.length];
		int index = 0;
		for (String string : stringArray) {
			array[index++] = Integer.parseInt(string);
		}
		// buy day ,sell day
		List<Trade> trades = new ArrayList<>();
		List<Integer> newArray =Arrays.stream(array).boxed().collect(Collectors.toList());
			
		Collections.sort(newArray);
		int minPrice = newArray.get(0);
		int maxPrice = newArray.get(newArray.size()-1);
		
		for (int i = 0; i < array.length; i++) {
			
			if(array[i] == minPrice) {
				trades.add(new Trade("Buy", i, array[i]));
			}else if(array[i] == maxPrice) {
				if(!trades.isEmpty() &&  trades.get(trades.size()-1).getWay().equalsIgnoreCase("Buy")) {
					trades.add(new Trade("Sell", i, array[i]));
				}
			}else if (i < array.length - 1 && array[i + 1]  < array[i]) {
				trades.add(new Trade("Sell", i, array[i]));
				trades.add(new Trade("Buy", i + 1, array[i + 1]));
			}
			
			// TODO 
			/*
			 * if (i == 0) { trades.add(new Trade("Buy", i, array[i])); } else if (i <
			 * array.length - 1) {
			 * 
			 * for (Trade trade : trades) {
			 * 
			 * }
			 * 
			 * 
			 * if (array[i + 1] < array[i]) { trades.add(new Trade("Sell", i, array[i]));
			 * trades.add(new Trade("Buy", i + 1, array[i + 1])); }
			 * 
			 * } else { if(array[i] > array[i-1]) { trades.add(new Trade("Sell", i,
			 * array[i])); } }
			 */

		}

		logger.log(Level.INFO, trades);
		int maxProfit = 0;
		for (Trade trade : trades) {
			int value = trade.getWay().equalsIgnoreCase("buy") ? -array[trade.getDay()] : array[trade.getDay()];
			maxProfit = maxProfit + value;
		}
		logger.log(Level.INFO, String.format("Max Profit %d", maxProfit));

	}

}

class Trade {
	String way;
	int day;
	int price;

	public Trade(String way, int day, int price) {
		super();
		this.way = way;
		this.day = day;
		this.price = price;
	}

	@Override
	public String toString() {
		return way + " on day :" + day + " price : " + price + "\n";
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
