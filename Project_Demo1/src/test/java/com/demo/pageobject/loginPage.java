package com.demo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    WebDriver driver;

    public loginPage(WebDriver d){
        driver = d;
        PageFactory.initElements(d,this);
    }

    //identify web elements

    // username
    @FindBy (id = "username")
    WebElement username;

    // password
    @FindBy (id = "password")
    WebElement password;

    // Login button
    @FindBy (id = "log-in")
    WebElement login_btn;

    //Validation message for Username
    @FindBy (xpath = "//*[@class=\"alert alert-warning\"]")
    WebElement validation;


    public void enterUsername(String uname){
        username.clear();
        username.sendKeys(uname);
    }

    public void enterPassword(String pass){
        password.clear();
        password.sendKeys(pass);
    }

    public void clickOnLogin(){
        login_btn.click();
    }

    public String getValidation(){
        String message =  validation.getText();
        return message;
    }
}
