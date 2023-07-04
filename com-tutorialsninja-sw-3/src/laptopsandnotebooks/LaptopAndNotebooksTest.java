package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setfolder.UtilityClass;

public class LaptopAndNotebooksTest extends UtilityClass {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
        clickOn(By.xpath("//span[normalize-space()='Currency']"));
        clickOn(By.xpath("//button[@name='GBP']"));
    }

    @Test

    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //  2.1 and 2.2 Mouse hover on Laptops & Notebooks Tab and click
        WebElement laptops = driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        WebElement allLaptops = driver.findElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(laptops).moveToElement(allLaptops).click().build().perform();
        // 2.3 Select Sort By "Price (High > Low)"
        clickOn(By.xpath("//select[@id='input-sort']"));
        clickOn(By.xpath("//option[text()='Price (High > Low)']"));
        // 2.4 Select Product “MacBook”
        clickOn(By.xpath("//a[normalize-space()='MacBook']"));
        // 2.5 Verify the text “MacBook”
        String expectedText = "MacBook";
        String actualText = getText(By.xpath("//h1[normalize-space()='MacBook']"));
        Assert.assertEquals("Text not verified", actualText, expectedText);
        // 2.6 Click on ‘Add To Cart’ button
        clickOn(By.xpath("//button[@id='button-cart']"));
        // 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String expectedText1 = "Success: You have added MacBook to your shopping cart!\n" +
                "×";
        String actualText1 = getText(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("Text not verified", actualText1, expectedText1);
        // 2.8 Click on link “shopping cart” display into success message
        clickOn(By.xpath("//a[normalize-space()='shopping cart']"));
        // 2.9 Verify the text "Shopping Cart"
        String expectedText2 = "Shopping Cart  (0.00kg)";
        String actualText2 = getText(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        Assert.assertEquals("Text not verified", actualText2, expectedText2);
        //   2.10 Verify the Product name "MacBook"
        String expectedText3 = "MacBook";
        String actualText3 = getText(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        Assert.assertEquals("Text not verified", actualText3, expectedText3);
        //   2.11 Change Quantity "2"
        clear(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).sendKeys("2");
        //  2.12 Click on “Update” Tab
        clickOn(By.xpath("//button[@type='submit']"));
        //  2.13 Verify the message “Success: You have modified your shopping cart !”
        String expectedText4 = "Success: You have modified your shopping cart!\n" +
                "×";
        String actualText4 = getText(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("Text not verified", actualText4, expectedText4);
        //   2.14 Verify the Total £737 .45
        String expectedText5 = "£737.45";
        String actualText5 = getText(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        Assert.assertEquals("Text not verified", actualText5, expectedText5);
        //   2.15 Click on “Checkout” button
        clickOn(By.xpath("//a[@class='btn btn-primary']"));
        //   2.16 Verify the text “Checkout”
        String expectedText6 = "Checkout";
        String actualText6 = getText(By.xpath("//h1[normalize-space()='Checkout']"));
        Assert.assertEquals("Text not verified", actualText6, expectedText6);
        //   2.17 Verify the Text “New Customer”
        clickOn(By.xpath("//a[@class='accordion-toggle']"));
        String expectedText7 = "New Customer";
        String actualText7 = getText(By.xpath("//h2[text()= 'New Customer']"));
        Assert.assertEquals("Text not verified", actualText7, expectedText7);
        //   2.18 Click on “Guest Checkout” radio button
        clickOn(By.xpath("//input[@value='guest']"));
        //  2.19 Click on “Continue” tab
        clickOn(By.xpath("//input[@id='button-account']"));
        //  2.20 Fill the mandatory fields
        // First name
        sendText(By.xpath("//input[@id='input-payment-firstname']"), "aaa");
        // Last name
        sendText(By.xpath("//input[@id='input-payment-lastname']"), "bbb");
        // Email
        sendText(By.xpath("//input[@id='input-payment-email']"), "ccc@gmail.com");
        // Telephone
        sendText(By.xpath("//input[@id='input-payment-telephone']"), "09996663332");
        // Address
        sendText(By.xpath("//input[@id='input-payment-address-1']"), "ddd");
        // City
        sendText(By.xpath("//input[@id='input-payment-city']"), "eee");
        // post code
        sendText(By.xpath("//input[@id='input-payment-postcode']"), "TH58RE");
        // Country
        selectByVisibleText(By.xpath("//select[@id='input-payment-country']"), "Afghanistan");
        // State
        selectByVisibleText(By.xpath("//select[@id='input-payment-zone']"), "Bamian");

        //  2.21 Click on “Continue” Button
        clickOn(By.xpath("//input[@id='button-guest']"));
        //  2.22 Add Comments About your order into text area
        sendText(By.xpath("//textarea[@name='comment']"), "Look Nice");
        //   2.23 Check the Terms & Conditions check box
        clickOn(By.xpath("//input[@name='agree']"));
        //   2.24 Click on “Continue” button
        clickOn(By.id("button-payment-method"));
        //  2.25 Verify the message “Warning: Payment method required !”
        String expectedText8 = "Warning: Payment method required!\n" +
"×";
        String actualText8 = getText(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        Assert.assertEquals("Text not verified", actualText8, expectedText8);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
