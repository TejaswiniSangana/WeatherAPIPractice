package com.weatherapi.tests;

import com.weatherapi.constant.Constants;
import com.weatherapi.pojo.CityDataPojo;
import com.weatherapi.reusableclasses.WeatherInformation;
import com.weatherapi.dataprovider.InputData;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCurrentWeatherData {
    @BeforeTest
    public void setBaseURI(){
        RestAssured.baseURI= Constants.BASE_URI;
    }

    @Test(dataProvider = "CityInformation",dataProviderClass = InputData.class)
    public void getCurrentObservationByLatAndLon(CityDataPojo cityData){
        Response response=RestAssured.given()
                .when()
                .get("current?lat={lat}&lon={lon}&key={key}",cityData.getLatitude(),cityData.getLongitude(), Constants.KEY);
        WeatherInformation.getWeatherData(response);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(dataProvider = "CityInformation",dataProviderClass = InputData.class)
    public void getCurrentObservationByCityId(CityDataPojo cityData){
        RequestSpecification requestSpecification= RestAssured.given();
        Response response= requestSpecification.request(Method.GET,"current?city_id={city_id}&key={key}",cityData.getCityId(), Constants.KEY);
        WeatherInformation.getWeatherData(response);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(dataProvider = "CityInformation",dataProviderClass = InputData.class)
    public void getCurrentObservationByCityAndCountryCode(CityDataPojo cityData){
        RestAssured.given().when()
                .get("current?city={city_name}&country={country_code}&key={key}",cityData.getCityName(),cityData.getCountryCode(), Constants.KEY)
                .then().assertThat().statusCode(200);
    }
}
