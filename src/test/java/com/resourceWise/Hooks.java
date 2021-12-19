package com.resourceWise;

import com.resourceWise.utility.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    DriverManager driverManager=new DriverManager();
//    private String url=System.getProperty("url");
    private String url="https://www.argos.co.uk/";

    @Before
    public void setUp() {
        System.out.println("URL: "+url);
        driverManager.runOnLocalHost();
        //to run with Selenium Grid
       // driverManager.runOnRemoteHost();
        driverManager.navigateToHomePage(url);
        driverManager.maxBrowser();
        driverManager.waitForPageLoad();
        driverManager.applyiImplicitWait();
        driverManager.handleCookies();
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            driverManager.takeScreenShot(scenario);
        }
        driverManager.closeBrowser();
    }
}
