package testsuite;

import browserfactory.BaseClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GearTest extends BaseClass {
    String baseurl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //Mouse Hover on Gear ----> Bags ----> Overnight Duffle
        WebElement gear = driver.findElement(By.xpath("//a[@id='ui-id-6']"));
        WebElement bags = driver.findElement(By.xpath("//span[normalize-space()='Bags']"));
        Actions action = new Actions(driver);
        action.moveToElement(gear).moveToElement(bags).click().build().perform();
        // Click on Product Name ‘Overnight Duffle’
        driver.findElement(By.xpath("//a[normalize-space()='Overnight Duffle']")).click();
        // Verify the text ‘Overnight Duffle’
        String expectedText = "Overnight Duffle";
        String actualText = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals("Text not verified", actualText, expectedText);
        // Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        driver.findElement(By.xpath("//input[@id='qty']")).sendKeys("3");
        //  Click on ‘Add to Cart’ Button.
        driver.findElement(By.xpath("//button[@id='product-addtocart-button']")).click();
        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String expectedText1 = "You added Overnight Duffle to your shopping cart.";
        String actualText1 = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        Assert.assertEquals("Text not verified", actualText1, expectedText1);
        // Click on ‘shopping cart’ Link into message
        driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).click();
        // Verify the product name ‘Cronus Yoga Pant’
        // String expectedText2 = "Cronus Yoga Pant";
        //  String actualText2 = driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")).getText();
        //  Assert.assertEquals("Text not verified", actualText2, expectedText2);
        // Verify the Qty is ‘3’
        String expectedText3 = "3";
        String actualText3 = driver.findElement(By.xpath("//input[@id='cart-237769-qty']")).getText();
        Assert.assertEquals("Text not verified", expectedText3, actualText3);
        Thread.sleep(2000);
        // Verify the product price ‘$135.00’
        String expectedText4 = "$135.00";
        String actualText4 = driver.findElement(By.xpath("//span[@data-bind='text: getValue()'][normalize-space()='$135.00']")).getText();
        Assert.assertEquals("Text not verified", expectedText4, actualText4);
        //  Change Qty to ‘5’
        driver.findElement(By.xpath("//input[@id='cart-237499-qty']")).clear();
        driver.findElement(By.xpath("//input[@id='cart-237452-qty']")).sendKeys("5");
        // Click on ‘Update Shopping Cart’ button
        driver.findElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
        //  Verify the product price ‘$225.00’
        String expectedText5 = "$225.00";
        String actualText5 = driver.findElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']")).getText();
        Assert.assertEquals("Text not verified", actualText5, expectedText5);
    }

    @After
    public void tearDown() {
        // closeBrowser();
    }
}