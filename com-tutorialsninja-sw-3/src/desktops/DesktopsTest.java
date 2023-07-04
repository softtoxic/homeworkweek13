package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setfolder.UtilityClass;

public class DesktopsTest extends UtilityClass {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        // 1.1 and 1.2 Then MouseHover on "Desktops" tab and Click
        WebElement desktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        WebElement allDesktop = driver.findElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(desktop).moveToElement(allDesktop).click().build().perform();
        // 1.3 Click on “Show All Desktops”
        selectByVisibleText(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        // 1.4 Verify the Product will arrange in Descending order.
        String expectedText1 = "Name (Z - A)";
        String actualText1 = driver.findElement(By.xpath("//option[@value='https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC']")).getText();
        Assert.assertEquals("Text not verified", actualText1, expectedText1);
        
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        // 2.1 an 2.2 Then MouseHover on "Desktops" tab and Click
        WebElement desktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        WebElement allDesktop = driver.findElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(desktop).moveToElement(allDesktop).click().build().perform();
        // 2.3 Click on “Show All Desktops”
        selectByVisibleText(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
        // 2.4 Select product “HP LP3065”
        clickOn(By.xpath("//a[normalize-space()='HP LP3065']"));
        //  Verify the Text "HP LP3065"
        String expectedText2 = "HP LP3065";
        String actualText2 = getText(By.xpath("//h1[normalize-space()='HP LP3065']"));
        Assert.assertEquals("Text not verified", actualText2, expectedText2);
        // 2.6 Select Delivery Date "2022-11-30"
        clear(By.xpath("//input[@id='input-option225']"));
        sendText(By.xpath("//input[@id='input-option225']"), "2022-11-30");
        // 2.7.Enter Qty "1” using Select class.
        clear(By.xpath("//input[@id='input-quantity']"));
        sendText(By.xpath("//input[@id='input-quantity']"), "1");
        // 2.8 Click on “Add to Cart” button
        clickOn(By.xpath("//button[@id='button-cart']"));
        // 2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String expectedText3 = "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×";
        String actualText3 = getText(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("Text not verified", actualText3, expectedText3);
        // 2.10 Click on link “shopping cart” display into success message
        clickOn(By.xpath("//a[normalize-space()='shopping cart']"));
        // 2.11 Verify the text "Shopping Cart"
        String expectedText4 = "Shopping Cart  (1.00kg)";
        String actualText4 = getText(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        Assert.assertEquals("Text not verified", actualText4, expectedText4);
        // 2.12 Verify the Product name "HP LP3065"
        String expectedText5 = "HP LP3065";
        String actualText5 = getText(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        Assert.assertEquals("Text not verified", actualText5, expectedText5);
        // Verify the Delivery Date "2022-11-30"
        String expectedText6 = "Delivery Date:2022-11-30";
        String actualText6 = getText(By.xpath("//small[normalize-space()='Delivery Date:2022-11-30']"));
        Assert.assertEquals("Text not verified", actualText6, expectedText6);
        // 2.14 Verify the Model "Product21"
        String expectedText7 = "Product 21";
        String actualText7 = getText(By.xpath("//td[normalize-space()='Product 21']"));
        Assert.assertEquals("Text not verified", actualText7, expectedText7);
        // 2.15 Verify the Total "£74.73"
        String expectedText8 = "$122.00";
        String actualText8 = getText(By.xpath("//html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]"));
        Assert.assertEquals("Text not verified", actualText8, expectedText8);

    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
