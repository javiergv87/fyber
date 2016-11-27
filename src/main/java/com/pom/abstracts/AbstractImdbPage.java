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

    /**
     * Load a web page given a url
     * @param url
     */
    public void load(String url) {
        if(driver==null) {
            ChromeDriverManager.getInstance().setup();
        }
        driver = new ChromeDriver();
        driver.get(url);
    }

    /**
     * Close the browser
     */
    public static void closeBrowser() {
        if(driver!=null)
            driver.quit();
    }

    /**
     * Find element in DOM
     * @param selector
     * @return the Webelement
     */
    public WebElement find(final By selector) {

        return driver.findElement(selector);
    }

    /**
     * Find elements in DOM
     * @param selector
     * @return the list of Webelements
     */
    public List<WebElement> findElements(final By selector) {
        return driver.findElements(selector);
    }

    /**
     * Click on a given By
     * @param selector
     */
    public void clickOn(final By selector) {
        find(selector).click();
    }

    /**
     * click on a given Webelement
     * @param element
     */
    public void clickOn(final WebElement element) {
        element.click();
    }

    /**
     * Get text from an element
     * @param selector
     * @return text
     */
    public String getTextFromElement(final By selector) {
        return find(selector).getText();
    }

    /**
     * Return if an element is displayed or not
     * @param selector
     * @return true or false
     */
    public boolean isElementDisplayed(final By selector) {
        try {
            return find(selector).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /**
     * Return if an element is displayed or not
     * @param element
     * @return true or false
     */
    public boolean isElementDisplayed(final WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /**
     * Type in a given field
     * @param selector
     * @param text
     */
    public void typeOnField(final By selector, final String text) {
        find(selector).sendKeys(text);
    }
}
