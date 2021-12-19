package com.resourceWise.webPages;

import com.resourceWise.utility.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SearchResultpage extends DriverManager {
    public static String selectedProduct;

    public String getProductsHeaderText(){
 return driver.findElement(By.cssSelector(".search-title__term")).getText();
    }
    public void selectAnyProduct(){
     List<WebElement> elementList  =driver.findElements(By.xpath("//a[@data-test='component-product-card-title']"));
    int noOfElements =elementList.size();
        if(noOfElements ==0){
            throw new RuntimeException("No products found.");
        }
        Random random = new Random();
        int randomNumber = random.nextInt(noOfElements);
        WebElement selectedWebElement = elementList.get(randomNumber);
        selectedProduct = selectedWebElement.getText();
        selectedWebElement.click();
        System.out.println(elementList);
        System.out.println(noOfElements);
        System.out.println(selectedProduct);
        System.out.println(randomNumber);


    }


}
