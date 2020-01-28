package com.krishna.mstest;

import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LongestSubString {

	private static final Logger logger = LogManager.getLogger();
	
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		logger.log(Level.INFO, "waiting for the input string value");
		String s = scanner.next();
		logger.info(s);
		int i=0;
		int reqLength=0;
		while(i < s.length()) {
			for(int j=i+1; j< s.length(); j++) {
				if(s.charAt(i) != s.charAt(j)) {
					if(reqLength <= j-i) {
						
					}
					break;
				}else {
					i++;
				}
			}
			
		}
		
		
	}
}
