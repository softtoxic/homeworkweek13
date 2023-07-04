package testsuite;

import browserfactory.BaseClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WomenTest extends BaseClass {
    String baseurl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);

    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        //Mouse Hover on Women Menu - tops - click on jacket
        WebElement women = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        WebElement jacket = driver.findElement(By.xpath("//a[@id='ui-id-11']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(women).build().perform();
        actions.moveToElement(tops).build().perform();
        actions.moveToElement(jacket).click().build().perform();
        // Select Sort By filter “Product Name”
        driver.findElement(By.xpath("//select[@id='sorter']//option[@value='name']")).click();
        //  Verify the products name display in alphabetical order
        //String expectedText = "Product Name";
        //String actualText = driver.findElement(By.xpath("//select[@id='sorter']//option[@value='name']")).getText();
        //Assert.assertEquals("Text not matched", actualText, expectedText);


    }

    @Test
    public void verifyTheSortByPriceFilter() {
        //Mouse Hover on Women Menu - tops - click on jacket
        WebElement women = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        WebElement jacket = driver.findElement(By.xpath("//a[@id='ui-id-11']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(women).build().perform();
        actions.moveToElement(tops).build().perform();
        actions.moveToElement(jacket).click().build().perform();
        // Select Sort By filter “Price”
        driver.findElement(By.xpath("//div[2]//div[3]//select[1]//option[@value='price']")).click();
        // Verify the products price display in Low to High
        String expectedText = "Price";
        String actualText = driver.findElement(By.xpath("//div[2]//div[3]//select[1]//option[@value='price']")).getText();
        Assert.assertEquals("Text not matched", actualText, expectedText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}