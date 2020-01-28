package com.krishna.mstest;

import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LongestUniformString {

	private static final Logger logger = LogManager.getLogger(LongestUniformString.class);

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String input = scanner.next(); // example input aaabbbbcccc

		if (input.length() > 0) {

			char startingChar = input.charAt(0);
			int reqIndex = 0;
			int reqLength = 0;
			int tempLength = 1;

			for (int i = 1; i < input.length(); i++) {

				if (startingChar == input.charAt(i)) {
					tempLength++;
				} else if (startingChar != input.charAt(i)) {
					tempLength = 1;
					startingChar = input.charAt(i);
				}

				if (reqLength < tempLength) {
					reqLength = tempLength;
					reqIndex = i - tempLength + 1;

				}
			}
			logger.log(Level.INFO, input);
			String o = String.format("Output: [ %d %d]",reqIndex,reqLength );
			logger.log(Level.INFO, o);
			
		}

	}
}
