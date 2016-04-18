package com.expose.restapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

//Annotation for URL path to query the API service
@Path("/ctofservice")
public class CtoFService extends Application
{
	//Request made to the API service
	@GET
	//Desired format for the data shown when calling the API service
	@Produces("application/xml")
	public String convertCtoF()
	{
		Double fahrenheit;
		Double celsius = 36.8;
		fahrenheit = ((celsius * 9)/5) + 32;
		
		String result = "@Produces(\"application/xml\") Output: \n\nC to F converter output: \n\n" + fahrenheit;
		
		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
	}
	
	//Annotation for URL path to pass parameter as a query to the API service. 
	@Path("{C}")
	//Request made to the API service
	@GET
	//Desired format for the data shown when calling the API service
	@Produces("application/xml")
	public String convertCtoFfromParameter(@PathParam("C") Double C)
	{
		Double fahrenheit;
		Double celsius = C;
		fahrenheit = ((celsius * 9)/5) + 32;
		
		String result = "@Produces(\"application/xml\") Output: \n\nC to F converter output: \n\n" + fahrenheit;
		
		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
	}
}
