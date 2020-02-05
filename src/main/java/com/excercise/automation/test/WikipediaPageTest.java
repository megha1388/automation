package com.excercise.automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikipediaPageTest extends TestReportConfig {
    WebDriver webDriver;

    public void init(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        webDriver = new ChromeDriver();

    }
    public void launch(){
        webDriver.get(getUrl());
    }

    public String getUrl(){
        return "https://www.wikipedia.org/";
    }
    public void quit(){
        webDriver.close();
        webDriver.quit();

    }

    @Test
    public void wikiTest(){
        init();
        launch();
        Assert.assertEquals("Wikipedia",webDriver.getTitle());
        quit();

    }

    @Test
    public void wikiSearchTest(){
        init();
        launch();
        webDriver.findElement(By.name("search")).sendKeys("Megha");
        webDriver.findElement(By.id("search-form")).submit();
        Assert.assertEquals("Megha - Wikipedia",webDriver.getTitle());
        quit();

    }



}
