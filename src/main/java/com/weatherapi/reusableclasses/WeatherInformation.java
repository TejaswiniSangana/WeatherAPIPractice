package com.weatherapi.reusableclasses;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.*;

public class WeatherInformation {
    private WeatherInformation(){}
    public static final Logger logger = Logger.getLogger(WeatherInformation.class);
    public static void getWeatherData(Response response){
        JSONObject jsonObject= new JSONObject(response.asString());
        JSONArray weatherData=(JSONArray) jsonObject.get("data");
        JSONObject data= (JSONObject) weatherData.get(0);
        logger.info("Date and time:"+data.get("datetime"));
        logger.info("Country_Code:"+data.get("country_code"));
        logger.info("City_Name:"+data.get("city_name"));
        JSONObject weatherInfo=data.getJSONObject("weather");
        logger.info("Weather code:"+weatherInfo.get("code"));
        logger.info("Weather Description:"+weatherInfo.get("description"));
        System.out.println();
    }
}
