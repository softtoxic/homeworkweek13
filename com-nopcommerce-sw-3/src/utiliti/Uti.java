package utiliti;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Uti extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    /**
     *  This method will get text from element
     */
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    /**
     *  This method will send text to element
     */
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    /**
     *      Drop down selection
     */
    public void selectByVisibleText(By by, String text){
       new Select(driver.findElement(by)).selectByVisibleText(text);

    }
    public void selectByValue(By by, String value){
        new Select(driver.findElement(by)).selectByValue(value);
    }
    public void selectByIndex(By by, int index){
        new Select(driver.findElement(by)).selectByIndex(index);
    }
    public void clearTextToElement(By by) {
        driver.findElement(by).clear();
    }
    public void sendText(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
}
