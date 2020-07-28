package com.example.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Converter {
	List<String> ones = Arrays.asList("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
	List<String> tens = Arrays.asList("", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety");
	List<String> unique = Arrays.asList("", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen");
	
	public String numToWord(int num) {
		String numb = Integer.toString(num);
		List<String> nums = Arrays.asList(numb.split(""));
		String returnString = "";
		
		if (nums.size() > 4) {
			return "Not valid";
		}
		
		for (int i = 0; i < nums.size(); i++) {
			if (nums.size() == 4 && i == 0) {
				returnString += ones.get(Integer.parseInt(nums.get(i)));
				returnString += " thousand ";
			} else if ((nums.size() == 3 && i == 0) || (nums.size() == 4 && i == 1)) {
				returnString += ones.get(Integer.parseInt(nums.get(i)));
				returnString += " hundred ";
			} else if (((nums.size() == 2 && i == 0) || (nums.size() == 3 && i == 1)
					|| (nums.size() == 4 && i == 2)) && (nums.get(nums.size() - 1).equals("0"))) {
				returnString += " " + tens.get(Integer.parseInt(nums.get(i)));
				break;
			} else if (((nums.size() == 2 && i == 0) || (nums.size() == 3 && i == 1)
					|| (nums.size() == 4 && i == 2)) && (Integer.parseInt(nums.get(nums.size() - 2)) != 0 )) {
				String lastTwo = nums.get(i);
				lastTwo += nums.get(i + 1);
				int lt = Integer.parseInt(lastTwo);
				
				if (lt < 20 & lt > 10) {
					returnString += " " + unique.get(Integer.parseInt(nums.get(nums.size() - 1)));
					break;
				} else if (lt > 20) {
					returnString += " " + tens.get(Integer.parseInt(nums.get(nums.size() - 2)));
					returnString += " " + ones.get(Integer.parseInt(nums.get(nums.size() - 1)));
					break;
				}
			} else if ((nums.size() == 1 && i == 0) || (nums.size() == 2 && i == 1)
					|| (nums.size() == 3 && i == 2) || (nums.size() == 4 && i == 3)) {
				returnString += " " + ones.get(Integer.parseInt(nums.get(nums.size() - 1)));
			}
		}
		
		return returnString;
	}
}
