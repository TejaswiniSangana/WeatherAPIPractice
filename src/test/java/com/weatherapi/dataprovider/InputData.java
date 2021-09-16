package com.weatherapi.dataprovider;

import com.weatherapi.reusableclasses.DataFromExcel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class InputData{
        @DataProvider(name = "CityInformation")
        public Object[][] cityInformation() throws IOException, InvalidFormatException {
            DataFromExcel dataFromExcel= new DataFromExcel();
            Object[][] cityData=new Object[][]{
                    {dataFromExcel.getCityData(0)},
                    {dataFromExcel.getCityData(1)},
                    {dataFromExcel.getCityData(2)},
                    {dataFromExcel.getCityData(3)}
            };
            return cityData;

        }
}
