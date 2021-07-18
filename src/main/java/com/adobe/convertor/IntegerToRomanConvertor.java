package com.adobe.convertor;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.adobe.exception.ConvertorException;
import com.adobe.pojo.RomanPair;

public class IntegerToRomanConvertor {

	private static Logger logger = LogManager.getLogger(IntegerToRomanConvertor.class);
	private static List<RomanPair> romanMap = new ArrayList<>();
	
	static {
		// Create a list to store the numbers and their Roman literals
		// in the static block it will be initialized only once when the class is loaded
		
		 romanMap.add(new RomanPair(1000, "M"));
		 romanMap.add(new RomanPair(900,"CM"));
		 romanMap.add(new RomanPair(500,"D"));
		 romanMap.add(new RomanPair(400,"CD"));
		 romanMap.add(new RomanPair(100,"C"));
		 romanMap.add(new RomanPair(90,"XC"));
		 romanMap.add(new RomanPair(50,"L"));
		 romanMap.add(new RomanPair(40,"XL"));
		 romanMap.add(new RomanPair(10,"X"));
		 romanMap.add(new RomanPair(9,"IX"));
		 romanMap.add(new RomanPair(5,"V"));
		 romanMap.add(new RomanPair(4,"IV"));
		 romanMap.add(new RomanPair(1,"I"));
	}
	
	/**
	 * This method iterates through each digit of the number 
	 * and deciphers the RomanPair equivalent
	 * Runtime complexity : O(1) nearly constant because the maximum number is 3999
	 * Space complexity : O(1) constant because we always keep the same 13 numbers in the map. 
	 * @param num
	 * @return String(Roman number)
	 */
	public String getRomanNumeral(int num) throws ConvertorException {

		logger.info("entering getRomanNumeral ");
		//If the input is less than 0 or > 3999, report an error message
		if (num < 1 || num > 3999) {
			throw new ConvertorException("Input out of range") ;
		}		

		StringBuilder result = new StringBuilder();
		int index = 0;
		// Iterate through the number till it becomes 0
		// keep incrementing the index pointer till the number is greater than the number at index
		// Once a lower number is seen, find its roman value and subtract the key from the number to continue
		while (num > 0) {
	           
            while (index < romanMap.size()
                 && romanMap.get(index).getKey() > num) {
                index++;
                
            }
            result.append(romanMap.get(index).getValue());
            num = num - romanMap.get(index).getKey();
        }
		
		logger.info("exiting getRomanNumeral");
		return result.toString();
	}
}
