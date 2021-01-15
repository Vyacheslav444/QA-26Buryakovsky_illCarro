package com.slaviusProdacshin.qa.application;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {

        this.wd = wd;
    }

    public void typeByCss(String cssSelector, String text) {
        if (text != null) {
            clickByCss(cssSelector);
            wd.findElement(By.cssSelector(cssSelector)).clear();
            wd.findElement(By.cssSelector(cssSelector)).sendKeys(text);
        }
    }

    public void clickByCss(String cssSelector) {


        wd.findElement(By.cssSelector(cssSelector)).click();
    }

    public void clickByXpath(String xpath) {
        wd.findElement(By.xpath(xpath)).click();

    }
    public boolean isElementPresent(By locator) {

        return wd.findElements(locator).size() > 0;
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }
    public void click(By locator){

        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
        if(text!=null){
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }

    }
    public void clickYallaButton() {
        click(By.cssSelector("[type='submit']"));
    }

    public void takeScreenshot(String pathToFile){
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot =
                new File(pathToFile);
        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
