package com.resourceWise.webPages;

import com.resourceWise.utility.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductDescriptionPage extends DriverManager {

    public void addProductToBasket(){
        sleepBrowser(2000);
        WebElement trolleyBtn =driver.findElement(By.xpath("//button[@data-test='add-to-trolley-button-button']"));
        sleepBrowser(2000);
        waitUntilElementClickable(trolleyBtn).click();

    }
    public void goToBasket(){
        WebElement goTotrolleyBtn =driver.findElement(By.xpath("//a[@data-test='component-att-button-basket']"));
        sleepBrowser(2000);
        waitUntilElementClickable(goTotrolleyBtn).click();
    }
}