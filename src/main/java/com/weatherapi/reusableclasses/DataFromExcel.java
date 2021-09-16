package com.weatherapi.reusableclasses;

import com.weatherapi.constant.Constants;
import com.weatherapi.pojo.CityDataPojo;
import com.weatherapi.utility.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DataFromExcel {
    ExcelReader reader;
    public DataFromExcel(){
        reader = new ExcelReader();
    }
    public CityDataPojo getCityData(int rowNumber) throws IOException, InvalidFormatException {
        List<Map<String, String>> testData= reader.getData(Constants.EXCEL_SHEET_FILE_PATH,"city");
        CityDataPojo cityData = new CityDataPojo();
        cityData.setCityId(testData.get(rowNumber).get("city_id"));
        cityData.setCityName(testData.get(rowNumber).get("city_name"));
        cityData.setStateCode(testData.get(rowNumber).get("state_code"));
        cityData.setCountryCode(testData.get(rowNumber).get("country_code"));
        cityData.setCountryName(testData.get(rowNumber).get("country_full"));
        cityData.setLatitude(testData.get(rowNumber).get("lat"));
        cityData.setLongitude(testData.get(rowNumber).get("lon"));
        return cityData;
    }
}
