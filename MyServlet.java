package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class MyServlet
 */

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		String apiKey = "21c494d8f4df8b1337d4dc2588fc9da1";
		
		String city = request.getParameter("city");
		
		String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
		
		//API integration
		URL url = new URL(apiUrl);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		
		//to read data from network
		InputStream inputstream = connection.getInputStream();
		InputStreamReader reader = new InputStreamReader(inputstream);
		
		//to take input from reader
		Scanner id = new Scanner(reader);
		StringBuilder res = new StringBuilder();
		
		while(id.hasNext())
		{
			res.append(id.nextLine());
		}
		
		id.close();
		
	    
	    
	 Gson gson = new Gson();
     JsonObject jsonObject = gson.fromJson(res.toString(), JsonObject.class);
     
     
     //Date & Time
     long dateTimestamp = jsonObject.get("dt").getAsLong() * 1000;
     String date = new Date(dateTimestamp).toString();
     
     //Temperature
     double temperatureKelvin = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
     int temperatureCelsius = (int) (temperatureKelvin - 273.15);
    
     //Humidity
     int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
     
     //Wind Speed
     double windSpeed = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();
     
     //Weather Condition
     String weatherCondition = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
     
     // Set the data as request attributes (for sending to the jsp page)
     request.setAttribute("date", date);
     request.setAttribute("city", city);
     request.setAttribute("temperature", temperatureCelsius);
     request.setAttribute("weatherCondition", weatherCondition); 
     request.setAttribute("humidity", humidity);    
     request.setAttribute("windSpeed", windSpeed);
     request.setAttribute("weatherData", res.toString());
     
     connection.disconnect();

     //to send to the client
     request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	}


