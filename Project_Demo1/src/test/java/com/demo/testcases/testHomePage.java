package com.demo.testcases;

import com.demo.pageobject.homePage;
import com.demo.pageobject.loginPage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class testHomePage extends baseClass{

    @Test
    public void SortAmount() throws IOException {

        loginPage lp = new loginPage(driver);

        File src = new File("C:\\Users\\hp\\IdeaProjects\\Project_Demo\\Test Data\\Testdata.xlsx");

        FileInputStream fis = new FileInputStream(src);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet1 = wb.getSheetAt(0);
        String username =  sheet1.getRow(0).getCell(0).getStringCellValue();
        String pass = sheet1.getRow(0).getCell(1).getStringCellValue();

        lp.enterUsername(username);
        logger.info("Username is entered");
        lp.enterPassword(pass);
        logger.info("Password is entered");
        lp.clickOnLogin();
        logger.info("Clicked on login button");

        // Asserting Homepage title
        String title = "Demo App";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, title);
        logger.info("User is logged in successfully");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        captureScreenShot(driver,"SortAmount_values_before_sorting");

        homePage hp = new homePage(driver);

        List<WebElement> closcount = driver.findElements(By.xpath("//table[@id=\"transactionsTable\"]//tr"));
        int rows = closcount.size();
        ArrayList<String> amountBefore = new ArrayList<String>();

        for (int i=1;i<rows;i++) {
            WebElement amount_Before_Sort = driver.findElement(By.xpath("//table[@id=\"transactionsTable\"]//tr[" + i + "]//td[5]"));
            String current_amount = amount_Before_Sort.getText();
            amountBefore.add(current_amount);

        }
        hp.ClickOnAmount();
        logger.info("Clicked on Amount");

        ArrayList<String> amountAfter = new ArrayList<String>();

        for (int i=1;i<rows;i++) {
            WebElement amount_After_Sort = driver.findElement(By.xpath("//table[@id=\"transactionsTable\"]//tr[" + i + "]//td[5]"));
            String current_amount = amount_After_Sort.getText();
            amountAfter.add(current_amount);

        }
        boolean equalArrays = amountBefore.equals(amountAfter);

        Assert.assertFalse(equalArrays,"Values are not sorted after clicking on Amount");
        logger.info("Values are sorted");
        captureScreenShot(driver,"SortAmount_values_after_sorting");








    }

}


