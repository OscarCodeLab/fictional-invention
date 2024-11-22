package com.automationexercise.actioninterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {
    // Scrolling
    public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele);
    
    // Click operations
    public void click(WebDriver driver, WebElement ele);
    public boolean click1(WebElement locator, String locatorName);
    public boolean JSClick(WebDriver driver, WebElement ele);
    
    // Text operations
    public void clearTextField(WebElement element);
    public String getText(WebDriver driver, WebElement ele);
    public boolean type(WebElement ele, String text);
    
    // Element state checks
    public boolean findElement(WebDriver driver, WebElement ele);
    public boolean isDisplayed(WebDriver driver, WebElement ele);
    public boolean isSelected(WebDriver driver, WebElement ele);
    public boolean isEnabled(WebDriver driver, WebElement ele);
    
    // Dropdown operations with JavaScript
    public boolean selectByVisibleTextjs(WebElement dropdownElement, String visibleText);
    public boolean selectByValuejs(WebElement dropdownElement, String value);
    public boolean selectByIndexjs(WebElement dropdownElement, int index);
    
    // Standard dropdown operations
    public boolean selectByIndex(WebElement element, int index);
    public boolean selectByValue(WebElement element, String value);
    public boolean selectByVisibleText(String visibletext, WebElement ele);
    
    // Mouse operations
    public boolean mouseHoverByJavaScript(WebElement ele);
    public void mouseOverElement(WebDriver driver, WebElement element);
    public boolean moveToElement(WebDriver driver, WebElement ele);
    public boolean mouseover(WebDriver driver, WebElement ele);
    public boolean rightclick(WebDriver driver, WebElement ele);
    
    // Drag and drop operations
    public boolean draggable(WebDriver driver, WebElement source, int x, int y);
    public boolean draganddrop(WebDriver driver, WebElement source, WebElement target);
    public boolean slider(WebDriver driver, WebElement ele, int x, int y);
    
    // Frame operations
    public boolean switchToFrameByIndex(WebDriver driver, int index);
    public boolean switchToFrameById(WebDriver driver, String idValue);
    public boolean switchToFrameByName(WebDriver driver, String nameValue);
    public boolean switchToDefaultFrame(WebDriver driver);
    
    // Window operations
    public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count);
    public boolean switchToNewWindow(WebDriver driver);
    public boolean switchToOldWindow(WebDriver driver);
    public void maximizePageWindow(WebDriver driver);
    
    // Table operations
    public int getColumncount(WebElement row);
    public int getRowCount(WebElement table);
    
    // Alert operations
    public boolean Alert(WebDriver driver);
    public boolean isAlertPresent(WebDriver driver);
    
    // Browser operations
    public boolean launchUrl(WebDriver driver, String url);
    public String getTitle(WebDriver driver);
    public String getCurrentURL(WebDriver driver);
    
    // Wait operations
    public void fluentWait(WebDriver driver, WebElement element, int timeOut);
    public void implicitWait(WebDriver driver, int timeOut);
    public void explicitWait(WebDriver driver, WebElement element, int timeOut);
    public void pageLoadTimeOut(WebDriver driver, int timeOut);
    
    // Screenshot and time operations
    public String screenShot(WebDriver driver, String filename);
    public String getCurrentTime();
}
