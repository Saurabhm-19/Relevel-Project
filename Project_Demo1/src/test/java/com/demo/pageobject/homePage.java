package com.demo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
    WebDriver driver;

    public homePage(WebDriver d){
        driver = d;
        PageFactory.initElements(d,this);
    }

    @FindBy (id = "amount")
    WebElement amount;

    public void ClickOnAmount(){
        amount.click();
    }

}

