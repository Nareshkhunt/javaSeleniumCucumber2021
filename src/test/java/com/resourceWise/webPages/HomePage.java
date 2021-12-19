package com.resourceWise.webPages;

import com.resourceWise.utility.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class HomePage extends DriverManager {
     public static String searchItem;
    public void searchProduct(String item){
        searchItem=item;
       driver.findElement(By.id("searchTerm")).sendKeys(item);

    }
    public void toClick(){

        driver.findElement(By.xpath("//span[contains(text(),'Search button')]")).submit();
    }
   public String getPresentUrl(){
    return driver.getCurrentUrl();
   }



}
