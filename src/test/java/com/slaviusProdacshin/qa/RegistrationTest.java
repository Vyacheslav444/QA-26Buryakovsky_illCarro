package com.slaviusProdacshin.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {
    WebDriver wd;
    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();

    }

    @Test
    public void testRegistration(){
        wd.get("htpps:/google.com");
        wd.quit();
    }

    @AfterMethod
    public void tearDown(){

    }
}
