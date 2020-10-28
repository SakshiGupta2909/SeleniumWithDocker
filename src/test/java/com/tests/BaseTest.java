package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
//    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        public void setupDriver()throws MalformedURLException {
        // BROWSER => chrome / firefox
        // HUB_HOST => localhost / 10.0.1.3 / hostname
//
//
//
////      options.addArguments("start-maximized");
//        ChromeDriver driver = new ChromeDriver(options);
//        driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
////

        String host = "localhost";
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            capabilities.setBrowserName("firefox");
//            WebDriver driver = new FirefoxDriver();
        }else{
            capabilities.setBrowserName("chrome");
//            WebDriver driver = new ChromeDriver();
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeUrl), capabilities);

//
//        String testName = ctx.getCurrentXmlTest().getName();
//        dc.setCapability("name", testName);
//
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }



}