
package com.demo.testcases;

import com.demo.utilities.readConfig;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class baseClass {
    readConfig read_config;

    {
        try {
            read_config = new readConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String url = read_config.getBaseURL();
    WebDriver driver;
    public static Logger logger;

    @Test
    @BeforeMethod
    public void setup(){
        //for logging
        logger = LogManager.getLogger("Project_Demo");

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Chrome_Driver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get(url);
        logger.info("url is opened");

        //implicit wait of 10 sec
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    @AfterMethod
    public void teardown(){
        driver.close();
    }

    //user method to capture screen shot
    public void captureScreenShot(WebDriver driver,String testName) throws IOException
    {

        TakesScreenshot screenshot = ((TakesScreenshot)driver);

        File src = screenshot.getScreenshotAs(OutputType.FILE);

        File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");

        FileUtils.copyFile(src, dest);
    }


}

