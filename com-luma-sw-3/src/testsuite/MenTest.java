package testsuite;

import browserfactory.BaseClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenTest extends BaseClass {
    String baseurl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        //Mouse Hover on Men Menu ----> Bottoms ----> Click on Pants
        WebElement men = driver.findElement(By.xpath("//span[normalize-space()='Men']"));
        WebElement bottoms = driver.findElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
        WebElement pants = driver.findElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        Actions action = new Actions(driver);
        action.moveToElement(men).build().perform();
        action.moveToElement(bottoms).build().perform();
        action.moveToElement(pants).click().build().perform();
        // Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.
        WebElement cronus = driver.findElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        WebElement size = driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(cronus).moveToElement(size).click().build().perform();
        // Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        WebElement cronusP = driver.findElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        WebElement colour = driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        Actions action2 = new Actions(driver);
        action2.moveToElement(cronusP).moveToElement(colour).click().build().perform();
        // Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        WebElement yoga = driver.findElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        WebElement cart = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
        Actions action3 = new Actions(driver);
        action3.moveToElement(cronusP).moveToElement(cart).click().build().perform();
        //  Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualText = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        Assert.assertEquals("Text not verified", actualText, expectedText);
        // Click on ‘shopping cart’ Link into message
        driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).click();
        // Verify the text ‘Shopping Cart.’
        String expectedText1 = "Shopping Cart";
        String actualText1 = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals("Text not verified", actualText1, expectedText1);
        // Verify the product name ‘Cronus Yoga Pant’
        String expectedText2 = "Cronus Yoga Pant";
        String actualText2 = driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")).getText();
        Assert.assertEquals("Text not verified", actualText2, expectedText2);
        // Verify the product size ‘32’
        String expectedText3 = "32";
        String actualText3 = driver.findElement(By.xpath("//dd[contains(text(),'32')]")).getText();
        Assert.assertEquals("Text not verified", actualText3, expectedText3);
        // Verify the product colour ‘Black’
        String expectedText4 = "Black";
        String actualText4 = driver.findElement(By.xpath("//dd[contains(text(),'Black')]")).getText();
        Assert.assertEquals("Text not verified", actualText4, expectedText4);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}