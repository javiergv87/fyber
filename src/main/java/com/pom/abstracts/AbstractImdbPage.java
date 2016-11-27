package com.pom.abstracts;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Javi on 26/11/2016.
 */
public abstract class AbstractImdbPage {


    private static WebDriver driver ;

    public void load(String url) {
        if(driver==null) {
            ChromeDriverManager.getInstance().setup();
        }
        driver = new ChromeDriver();
        driver.get(url);
    }

    public static void closeBrowser() {
        if(driver!=null)
            driver.quit();
    }

    public WebElement find(final By selector) {

        return driver.findElement(selector);
    }

    public void changeToLatestTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
    }

    public List<WebElement> findElements(final By selector) {
        return driver.findElements(selector);
    }

    public void clickOn(final By selector) {
        find(selector).click();
    }

    public void clickOn(final WebElement element) {
        element.click();
    }

    public String getTextFromElement(final By selector) {
        return find(selector).getText();
    }

    public boolean isElementDisplayed(final By selector) {
        try {
            return find(selector).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isElementDisplayed(final WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void typeOnField(final By selector, final String text) {
        find(selector).sendKeys(text);
    }
}
