package JavaProgram;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

public class MaxTemperature {

    public static void main(String[] args) {
        // Base URI of the AccuWeather API
        RestAssured.baseURI = "http://dataservice.accuweather.com";

        // API Key for AccuWeather (replace with your actual API key)
        String apiKey = "204848";

        // Location Key for the desired location (replace with your actual location key)
        String locationKey = "pune";

        // Send GET request to retrieve 10-day forecast
        Response response = RestAssured.given()
                .queryParam("apikey", apiKey)
                .queryParam("metric", "true") // Use metric units (Celsius)
                .when()
                .get("/forecasts/v1/daily/10day/" + locationKey)
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Parse the JSON response
        JsonPath jsonPath = response.jsonPath();

        // Extract the list of daily forecasts
        List<Map<String, Object>> dailyForecasts = jsonPath.getList("DailyForecasts");

        // Initialize the maximum temperature variable
        double maxTemperature = Double.MIN_VALUE;

        // Iterate through the daily forecasts to find the maximum temperature
        for (Map<String, Object> forecast : dailyForecasts) {
            Map<String, Object> temperature = (Map<String, Object>) forecast.get("Temperature");
            double maxTemp = (double) temperature.get("Maximum.Value");
            if (maxTemp > maxTemperature) {
                maxTemperature = maxTemp;
            }
        }

        // Print the maximum temperature
        System.out.println("The maximum temperature over the next 10 days is: " + maxTemperature + "°C");
    }
}
