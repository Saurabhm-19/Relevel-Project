package com.demo.testcases;

import com.demo.pageobject.loginPage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class testLoginPage extends baseClass{



    // keeping Username and Password both blank
    @Test (description = "TC001-This test verifies validation message displayed when user login with blank user name and password")
    public void VerifyLoginBlankInput() throws IOException {

        loginPage lp = new loginPage(driver);
        logger.info("Username is kept blank");
        logger.info("Password is kept blank");
        lp.clickOnLogin();
        logger.info("Clicked on login button");

        String requiredlMessage = "Both Username and Password must be present";
        String actualMessage = lp.getValidation();

        //Asserting Validation Message
        Assert.assertEquals(actualMessage,requiredlMessage);

        //printing validation message for blank username
        System.out.println(lp.getValidation());
        logger.info("Validation for blank username and password is displayed");
        captureScreenShot(driver,"VerifyLoginBlankInput");
    }

    // keeping Username blank
    @Test(description = "TC002-This test verifies validation message displayed when user login with blank user name and correct password")
    public void VerifyLoginBlankUsername() throws IOException, InterruptedException {

        loginPage lp = new loginPage(driver);

        File src = new File("C:\\Users\\hp\\IdeaProjects\\Project_Demo\\Test Data\\Testdata.xlsx");

        FileInputStream fis = new FileInputStream(src);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet1 = wb.getSheetAt(0);
        String pass = sheet1.getRow(0).getCell(1).getStringCellValue();

        logger.info("Username kept blank");
        lp.enterPassword(pass);
        Thread.sleep(5);
        logger.info("Password is entered");
        Thread.sleep(5);
        lp.clickOnLogin();
        logger.info("Clicked on login button");

        String requiredlMessage = "Username must be present";
        String actualMessage = lp.getValidation();

        //Asserting Username Validation Message
        Assert.assertEquals(actualMessage,requiredlMessage);

        //printing validation message for blank username
        System.out.println(lp.getValidation());
        logger.info("Validation for blank username is displayed");
        captureScreenShot(driver,"VerifyLoginBlankUsername");
    }

    // keeping Password blank
    @Test (description = "TC003-This test verifies validation message displayed when user login with correct user name and blank password")
    public void VerifyLoginBlankPassword() throws IOException {

        loginPage lp = new loginPage(driver);

        File src = new File("C:\\Users\\hp\\IdeaProjects\\Project_Demo\\Test Data\\Testdata.xlsx");

        FileInputStream fis = new FileInputStream(src);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet1 = wb.getSheetAt(0);
        String username =  sheet1.getRow(0).getCell(0).getStringCellValue();

        lp.enterUsername(username);
        logger.info("Username is entered");
        logger.info("Password is kept blank");
        lp.clickOnLogin();
        logger.info("Clicked on login button");

        String requiredlMessage = "Password must be present";
        String actualMessage = lp.getValidation();

        //Asserting Username Validation Message
        Assert.assertEquals(actualMessage,requiredlMessage);

        //printing validation message for blank username
        System.out.println(lp.getValidation());
        logger.info("Validation for blank password is displayed");
        captureScreenShot(driver,"VerifyLoginBlankPassword");
    }

    // Enter Username and password Both
    @Test (description = "TC001-This test verifies validation message displayed when user login with correct user name and password")
    public void VerifyLoginBothInputs() throws IOException {

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
        captureScreenShot(driver,"VerifyLoginBothInputs");

    }
}
