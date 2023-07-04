package setfolder;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class UtilityClass extends BaseClass{
    /**
     * click on element method
     */
    public void clickOn (By by){
        driver.findElement(by).click();
    }
    /**
     * Get text method
     */
    public String getText(By by){
        return driver.findElement(by).getText();
    }
    /**
     * Send text to element method
     */
    public void sendText(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    /**
     * Select element from drop down menu method
     */
    public void selectByValue(By by, String value){
        new Select(driver.findElement(by)).selectByValue(value);
    }
    public void selectByIndex(By by, int index){
        new Select(driver.findElement(by)).selectByIndex(index);
    }
    public void selectByVisibleText(By by, String text){
        new Select(driver.findElement(by)).selectByVisibleText(text);
    }
    /**
     * Clear the element value method
     */
    public void clear(By by){
        driver.findElement(by).clear();
    }
}
