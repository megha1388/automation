package com.excercise.automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GooglePageTest extends TestReportConfig{

    WebDriver driver;

    public void initialize(String browser){
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browser.equals("ie")){
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
        }
    }

    public String getUrl() {
        return "https://www.google.com/";
    }

    public void launch() {
        driver.get(getUrl());
    }

    public void enterText(String text) {
        driver.findElement(By.name("q")).sendKeys(text);
    }



    public void submitForm() {
        driver.findElement(By.id("tsf")).submit();
    }

    public void closeDriver(){
        driver.close();
        driver.quit();
    }


    @Test
    public void firstTest(){
        initialize("chrome");
        launch();
        enterText("Selenium Test");
        submitForm();
        Assert.assertEquals("Selenium Test - Google Search",driver.getTitle());
        Assert.assertEquals("Selenium Test",driver.findElement(By.name("q")).getAttribute("value"));
        closeDriver();
    }


}
