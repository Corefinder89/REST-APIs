package com.expose.restapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

//Annotation for URL path to query the API service
@Path("/ftocservice")
public class FtoCService 
{
	//Request made to the API service
	@GET
	//Desired format for the data shown when calling the API service
	@Produces("application/json")
	public Response convertFtoC() throws JSONException
	{
		JSONObject jsonObject = new JSONObject();
		Double fahrenheit = 98.24;
		Double celsius;
		celsius = (fahrenheit - 32)*5/9; 
		jsonObject.put("F Value", fahrenheit); 
		jsonObject.put("C Value", celsius);
 
		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}
	//Annotation for URL path to pass parameter as a query to the API service.
	@Path("{F}")
	//Request made to the API service
	@GET
	//Desired format for the data shown when calling the API service
	@Produces("application/json")
	public Response convertFtoCfromParameter(@PathParam("F") float F) throws JSONException
	{
		JSONObject jsonObject = new JSONObject();
		float celsius;
		celsius =  (F - 32)*5/9; 
		jsonObject.put("F Value", F); 
		jsonObject.put("C Value", celsius);
 
		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}
}
