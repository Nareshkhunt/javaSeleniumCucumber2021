package com.resourceWise.utility;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static WebDriver driver;
//    private String browser=System.getProperty("instance");
    private String browser="chrome";


public DriverManager(){
    PageFactory.initElements(driver,this);
}

    public void runOnLocalHost(){
        System.out.println("Running instance is : " + browser);
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
//                ChromeOptions options = new ChromeOptions();
//                options.setHeadless(true);
//                 options.addArguments("start-maximized"); // open Browser in maximized mode
//                 options.addArguments("disable-infobars"); // disabling infobars
//                 options.addArguments("--disable-extensions"); // disabling extensions
//                 options.addArguments("--disable-gpu"); // applicable to windows os only
//                 options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//                 options.addArguments("--no-sandbox"); // Bypass OS security model
//                driver = new ChromeDriver(options);
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver=new InternetExplorerDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;
            default:
                WebDriverManager.operadriver().setup();
                driver=new OperaDriver();

        }
}
    //this method for parallel testing using selenium Grid
    public void runOnRemoteHost() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.1.17:5555/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public void maxBrowser(){
        driver.manage().window().maximize();

    }
    public void handleCookies(){
    driver.findElement(By.id("consent_prompt_submit")).click();
    }
    public void navigateToHomePage(String url)
    {
    driver.get(url);
    }
    public void closeBrowser(){
    driver.quit();
    }
    public void waitForPageLoad(){

    driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    }

    public void applyiImplicitWait(){

    driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    }

    public void sleepBrowser(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement waitUntilElementClickable(WebElement element){
        WebDriverWait webDriverWait=new WebDriverWait(driver,30);
    return  webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitUntilElementVisible(By by){
        WebDriverWait webDriverWait=new WebDriverWait(driver,30);
        return  webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public Boolean waitUntilElementInvisible(By by){
        return new WebDriverWait(driver,15).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void takeScreenShot(Scenario scenario) {
        byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenShot, "image/png");
//take a screen shot
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("C:/Users/nares/Desktop/TestResult/Error.jpg"));
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}


