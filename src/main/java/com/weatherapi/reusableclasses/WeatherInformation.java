package com.weatherapi.reusableclasses;

import com.weatherapi.utility.LogUtility;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;


public class WeatherInformation {
    private WeatherInformation(){}
    public static void getWeatherData(Response response){
        JSONObject jsonObject= new JSONObject(response.asString());
        JSONArray weatherData=(JSONArray) jsonObject.get("data");
        JSONObject data= (JSONObject) weatherData.get(0);
        LogUtility.logInfo("Date and time:"+data.get("datetime"));
        LogUtility.logInfo("Country_Code:"+data.get("country_code"));
        LogUtility.logInfo("City_Name:"+data.get("city_name"));
        JSONObject weatherInfo=data.getJSONObject("weather");
        LogUtility.logInfo("Weather code:"+weatherInfo.get("code"));
        LogUtility.logInfo("Weather Description:"+weatherInfo.get("description"));
        System.out.println();
    }
}
