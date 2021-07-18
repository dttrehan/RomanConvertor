package com.adobe.convertor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.adobe.exception.ConvertorException;

public class IntegerToRomanConvertorTest {

	@Test
	public void roman_to_integer_test_success() throws ConvertorException{
		IntegerToRomanConvertor convertor = new IntegerToRomanConvertor();
		String romanNumber = convertor.getRomanNumeral(109);
		assertEquals("CIX", romanNumber);
	}
	
	@Test(expected=ConvertorException.class)
	public void roman_to_integer_test_zero() throws ConvertorException{
		IntegerToRomanConvertor convertor = new IntegerToRomanConvertor();
		convertor.getRomanNumeral(0);
		

	}
	
	@Test(expected=ConvertorException.class)
	public void roman_to_integer_test_more_than_3999() throws ConvertorException{
		IntegerToRomanConvertor convertor = new IntegerToRomanConvertor();
		convertor.getRomanNumeral(5000);

	}
	
	@Test(expected=ConvertorException.class)
	public void roman_to_integer_test_negative() throws ConvertorException{
		IntegerToRomanConvertor convertor = new IntegerToRomanConvertor();
		convertor.getRomanNumeral(-23);

	}
	
	@Test(expected=ConvertorException.class)
	public void roman_to_integer_test_max_integer() throws ConvertorException{
		IntegerToRomanConvertor convertor = new IntegerToRomanConvertor();
		convertor.getRomanNumeral(Integer.MAX_VALUE);

	}
}
