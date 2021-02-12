package com.gittigidiyor.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class ProductDetailPage {
    WebDriver driver;
    public String finalPrice;
    private String basketPrice;

    public ProductDetailPage(WebDriver driver){
        this.driver=driver;
    }

    //After the word computer is typed in the search bar, it clicks on the second page.
    public void selectSecondPage(){
        driver.findElement(By.cssSelector("li.next-link")).click();
    }

    //After the word computer is typed in the search bar, it randomly selects products from the list.
    public void selectRandomProduct(){
        List<WebElement> allProducts = driver.findElements(By.cssSelector(".catalog-seem-cell"));
        Random rand = new Random();
        int randomProduct = rand.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
    }

    //This code is for closing ads that appear on the screen.
    public void closeToX(){
        List<WebElement> allX = driver.findElements(By.cssSelector(".btn-alert-close"));
        allX.get(0).click();
    }

    //The price of the selected random product is confirmed.
    public void getProductPrice(){
        boolean normalPriceBoolean= driver.findElement(By.id("sp-price-highPrice")).isDisplayed();
        boolean discountPriceBoolean= driver.findElement(By.id("sp-price-discountPrice")).isDisplayed();
        boolean lowPriceBoolean= driver.findElement(By.id("sp-price-lowPrice")).isDisplayed();

        if(discountPriceBoolean==true){
            finalPrice= driver.findElement(By.id("sp-price-discountPrice")).getText();
            System.out.println("FirstPrice: " + finalPrice);
        }else if(lowPriceBoolean==true){
            finalPrice= driver.findElement(By.id("sp-price-lowPrice")).getText();
            System.out.println("FirstPrice: " + finalPrice);
        }else if(normalPriceBoolean==true){
            finalPrice= driver.findElement(By.id("sp-price-highPrice")).getText();
            System.out.println("FirstPrice: " + finalPrice);
        }
    }

    //Random adds the selected product to the cart.
    public void addtoBasketProduct(){
        driver.findElement(By.id("add-to-basket")).click();
    }

    //After the product is added to the cart, the basket button at the top right is clicked.
    public void clickBasket(){

        WebElement waitBasketIcon = driver.findElement(By.cssSelector(".basket-icon-container"));
        Actions action = new Actions(driver);
        action.moveToElement(waitBasketIcon).build().perform();
        driver.findElement(By.cssSelector(".basket-icon-container")).click();
    }

    //The price of the selected product on the product page is compared with the price in the cart.
    public void priceComparison(){

        String basketPrice = driver.findElement(By.cssSelector(".new-price")).getText();
        System.out.println("BasketPrice: " + basketPrice);
        System.out.println("Finalprice: " + finalPrice);
        Assert.assertEquals(basketPrice,finalPrice);
    }

    //The amount of the selected product is increased.
    public void increaseAmount(){

        WebElement testDropDown = driver.findElement(By.cssSelector("select.amount"));
        Select dropdown = new Select(testDropDown);
        dropdown.selectByIndex(2);
    }

    //After the product is added to the cart, it is deleted.
    public void deleteProductFromBasket(){

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div[2]/div[6]/" +
                "div[2]/div[2]/div[3]/div/div[2]/div/a/i")).click();
    }

    //After the procedures are finished, the exit is made.
    public void quitDriver(){
        driver.close();
        driver.quit();
    }

}
