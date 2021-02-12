package com.gittigidiyor.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;
    By search = By.cssSelector("input[data-cy=\"header-search-input\"]");
    By searchbutton = By.cssSelector("button[data-cy=\"search-find-button\"]");

    public SearchPage(WebDriver driver){
        this.driver=driver;
    }

    public void typeSearch(){
        driver.findElement(search).sendKeys("bilgisayar");
    }

    public void searchButton(){
        driver.findElement(searchbutton).click();
    }

}
