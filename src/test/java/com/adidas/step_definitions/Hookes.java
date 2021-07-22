package com.adidas.step_definitions;

import com.adidas.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.*;


public class Hookes {
    @Before
    public void setDriver(){
        Driver.getDriver();
    }
    @After()
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            byte [] screenShots = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShots,"image/png",scenario.getName());
        }
        Driver.closeDriver();
    }

}
