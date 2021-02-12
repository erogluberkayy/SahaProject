package com.gittigidiyor.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    By username = By.id("L-UserNameField");
    By password = By.id("L-PasswordField");
    By loginButton = By.id("gg-login-enter");


    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void typeUserName(){
        driver.findElement(username).sendKeys("berkayeroglu@gmail.com");
    }

    public void typePassword(){
        driver.findElement(password).sendKeys("bef6594");
    }

    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }
}
