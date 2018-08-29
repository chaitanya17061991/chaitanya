package com.spring.accumulator;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class SpringAccumulator {

	
	public int add(String number) {
		int sum = 0;
		String[] numbers;
		String negativeNumbers = "";

		if (StringUtils.isBlank(number)) {
			return sum;
		} else {
			if (number.startsWith("//", 0)) {
				String[] numberlist = number.split("\\r?\\n", -1);
				String newNumber = "";
				if (numberlist.length <= 1) {
					throw new RuntimeException("Invalid String " + number);
				}
				String[] delimitierRegex = numberlist[0].substring(2).split("\\|", -1);
				String finalDelimiter = ",";
				for (String regex : delimitierRegex) {
					if (isEmptyString(regex)) {
						throw new RuntimeException("Invalid Expression " + number);
					}
					finalDelimiter = finalDelimiter + "|" + appendEscapeCharacter(regex);
				}
				for (int i = 1; i < numberlist.length; i++) {
					newNumber = newNumber + numberlist[i];
					if (i < numberlist.length - 1) {
						newNumber = newNumber + ",";
					}
				}
				numbers = newNumber.split(finalDelimiter, -1);

			} else {
				numbers = number.split("\\r?\\n|,", -1);
			}
			for (String num : numbers) {
				if (isEmptyString(num)) {
					throw new RuntimeException("Invalid String" + number);
				} else if (isNotNumber(num)) {
					throw new RuntimeException("Invalid string " + number);
				} else if (isNegativeNumber(num)) {
					negativeNumbers = negativeNumbers + num + ",";
				}
			}
			if (!StringUtils.isBlank(negativeNumbers)) {
				throw new RuntimeException("Negative Numbers are not allowed : " + negativeNumbers);
			}
			sum = this.sum(numbers);

		}
		return sum;
	}

	private boolean isNegativeNumber(final String number) {
		if (Pattern.matches("^[-]\\d*", number)) {
			return true;
		}
		return false;
	}

	private boolean isNotNumber(final String number) {
		if (Pattern.matches("\\d*|^[-]\\d*", number)) {
			return false;
		}
		return true;
	}

	private boolean isEmptyString(final String number) {
		if (StringUtils.isBlank(number)) {
			return true;
		}
		return false;
	}

	private int sum(final String[] numbers) {

		int sum = 0;
		for (String num : numbers) {
			int value = Integer.parseInt(num);
			if (value <= 1000) {
				sum = sum + value;
			}
		}
		return sum;
	}

	private String appendEscapeCharacter(final String str) {
		String finalString = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '*' || str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '='
					|| str.charAt(i) == '?') {
				finalString = finalString + "\\" + str.charAt(i);
			} else {
				finalString = finalString + str.charAt(i);
			}
		}
		return finalString;
	}

}