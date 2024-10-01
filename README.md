# Weather-Info-Servlet

This is a Java-based web application that fetches and displays weather information for a specified city using the Open Weather Map API. The application uses the Jakarta Servlet API to handle HTTP requests and responses, Google Gson to parse JSON data from the API, and HttpURLConnection to establish a connection to the API. The frontend is built using JSP, HTML, CSS, and JavaScript for a responsive and user-friendly interface.

# Features
1. Fetches real-time weather data for any city using the Open Weather Map API.
2. Displays weather information such as temperature, weather conditions, humidity, and wind speed.
3. Provides dynamic weather icons based on current conditions (clouds, clear sky, rain, etc.).
4. Simple and clean user interface with search functionality.
   
# Technologies Used
1. Java: For backend logic and handling HTTP requests and responses.
2. Jakarta Servlet API: To process HTTP requests and send responses.
3. Google Gson: For parsing JSON data received from the Open Weather Map API.
4. HttpURLConnection: To establish a connection with the external API.
5. JSP: For rendering the frontend with dynamic content.
6. HTML/CSS: For the overall web structure and design.
7. JavaScript: For dynamic interactions on the frontend.
8. FontAwesome: For search icons and UI enhancements.

# How It Works
1. User Input: Users can input a city name in the search bar on the home page (index.html).
2. Weather Fetch: Upon submission, the form sends a request to the servlet (MyServlet.java), which then makes a call to the Open Weather Map API.
3. Data Parsing: The servlet parses the JSON response from the API using Google Gson.
4. Result Display: The weather details, including temperature, conditions, and wind speed, are displayed on a JSP page with appropriate weather icons.
