package com.adobe.app;


import java.time.Duration;
import java.time.Instant;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.adobe.convertor.IntegerToRomanConvertor;
import com.adobe.exception.ConvertorException;
import com.adobe.pojo.ConversionResponse;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("/romannumeral") // http://localhost:8080/romannumeral?query=1
public class RomanNumeralResource {

	private static Logger logger = LogManager.getLogger(RomanNumeralResource.class);
	
	/**
	 * REST Service to convert integer to roman
	 * @param integer
	 * @return ConversionResponse
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response integerToRoman(@QueryParam("query") int integer) {
		
		logger.info("Converting " + integer + " to roman numeral");
		Instant start = Instant.now();
		
		ConversionResponse response = new ConversionResponse();
		response.setInput(String.valueOf(integer));
		
		IntegerToRomanConvertor convertor = new IntegerToRomanConvertor();
		
		try {
			response.setOutput(convertor.getRomanNumeral(integer));
		} catch (ConvertorException ex) {
			logger.error("Exception converting integer to roman " + ex.getMessage());
			response.setOutput(ex.getMessage());
		}
		
		//metrics
		logger.info("Roman Number convertor response :" + response.getOutput());
		Instant end = Instant.now();
		logger.info("Time to execute integerToRoman : " + 
        		Duration.between(start, end).getNano()/1000 + " milliseconds");
		
		return Response
			      .status(Response.Status.OK)
			      .entity(new Gson().toJson(response))
			      .build();
	}
	
}
