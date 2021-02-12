package com.gittigidiyor.Testcases;

import com.gittigidiyor.Pages.LoginPage;
import com.gittigidiyor.Pages.ProductDetailPage;
import com.gittigidiyor.Pages.SearchPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testingOfProcesses {

    @Test
    public void loginAndTest(){

        System.setProperty("webdriver.chrome.driver", "/Users/berkayeroglu/Downloads/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.gittigidiyor.com/");

        //MauseHover
        WebElement signInLink = driver.findElement(By.cssSelector("div[data-cy='header-user-menu']"));
        Actions action = new Actions(driver);
        action.moveToElement(signInLink).build().perform();

        @Deprecated
        WebElement element = (new WebDriverWait(driver, 2))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Giriş Yap")));
        driver.findElement(By.linkText("Giriş Yap")).click();

        //The methods of each class are called down there.

        LoginPage login = new LoginPage(driver);
        login.typeUserName();
        login.typePassword();
        login.clickOnLoginButton();

        SearchPage search = new SearchPage(driver);
        search.typeSearch();
        search.searchButton();

        ProductDetailPage processPage = new ProductDetailPage(driver);
        processPage.closeToX();
        processPage.selectSecondPage();
        processPage.selectRandomProduct();
        processPage.getProductPrice();
        processPage.addtoBasketProduct();
        processPage.clickBasket();
        processPage.priceComparison();
        processPage.increaseAmount();
        processPage.deleteProductFromBasket();
        processPage.quitDriver();
    }
}
