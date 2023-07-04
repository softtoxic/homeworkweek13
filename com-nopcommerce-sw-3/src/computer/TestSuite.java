package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utiliti.Uti;

public class TestSuite extends Uti {
    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        clickOnElement(By.xpath(menu));
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //Click on Computer tab
        selectMenu("//body/div[6]/div[2]/ul[1]/li[1]/a[1]");
        // Click on Desktops tab
        selectMenu("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]");
        //Select Z to A order
        WebElement dropdown = driver.findElement(By.id("products-orderby"));
        Select select = new Select(dropdown);
        // Select by visible text
        select.selectByVisibleText("Name: Z to A");
        // Verify the Product will arrange in Descending order.
        String expectedText = "Name: Z to A";
        String actualText = driver.findElement(By.xpath("//option[contains(text(),'Name: Z to A')]")).getText();
        Assert.assertEquals("Text not verified", actualText, expectedText);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Click on Computer tab
        selectMenu("//body/div[6]/div[2]/ul[1]/li[1]/a[1]");
        // Click on Desktops tab
        selectMenu("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]");
        //Select Z to A order
        WebElement dropdown = driver.findElement(By.id("products-orderby"));
        Select select = new Select(dropdown);
        // Select by visible text
        select.selectByVisibleText("Name: A to Z");
        //Click on "Add To Cart
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]")).click();
        // Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = driver.findElement(By.xpath("//h1[normalize-space()='Build your own computer']")).getText();
        Assert.assertEquals("Text not verified", expectedText, actualText);
        //  Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        WebElement dropDown1 = driver.findElement(By.name("product_attribute_1"));
        Select select1 = new Select(dropDown1);
        select1.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

        //  Select HDD radio "400 GB [+$100.00]"
        selectMenu("//input[@id='product_attribute_3_7']");
        // Select "8GB [+$60.00]" using Select class.
        WebElement ram = driver.findElement(By.id("product_attribute_2"));
        Select select2 = new Select(ram);
        select2.selectByValue("5");
        // Select OS radio "Vista Premium [+$60.00]"
        selectMenu("//input[@id='product_attribute_4_9']");
        //  Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        selectMenu("//input[@id='product_attribute_5_12']");
        //  Verify the price "$1,475.00"
        //String expectedPrice = "$1,475.00";
        //String actualPrice = driver.findElement(By.xpath("//span[@id='price-value-1']")).getText();
        // Assert.assertEquals("Price not verified", expectedPrice, actualPrice);
        //  Click on "ADD TO CARD" Button.
        selectMenu("//button[@id='add-to-cart-button-1']");
        //  Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedText1 = "The product has been added to your shopping cart";
        String actualText2 = driver.findElement(By.xpath("//p[@class='content']")).getText();
        Assert.assertEquals("Text not verified", expectedText1, actualText2);
        //  close the bar clicking on the cross button.
        selectMenu("//span[@title='Close']");
        Thread.sleep(1000);
        // Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        WebElement shoppingCart = driver.findElement(By.xpath("//span[@class='cart-label']"));
        WebElement goToCart = driver.findElement(By.xpath("//button[normalize-space()='Go to cart']"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();
        // Verify the message "Shopping cart"
        String expectedText3 = "Shopping cart";
        String actualText3 = driver.findElement(By.xpath("//h1[normalize-space()='Shopping cart']")).getText();
        Assert.assertEquals("Text not verified", expectedText3, actualText3);
        // Change quantity to 2
        clearTextToElement(By.className("qty-input"));
        sendTextToElement(By.className("qty-input"), "2");
        clickOnElement(By.id("updatecart"));
        // Click on Update shopping cart
        selectMenu("//button[@id='updatecart']");
        //  Verify the Total"$2,950.00"
        String expectedText4 = "$2,950.00";
        String actualText4 = driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
        Assert.assertEquals("Text not verified", expectedText4, actualText4);
        // click on checkbox “I agree with the terms of service”
        selectMenu("//input[@id='termsofservice']");
        //  Click on “CHECKOUT”
        selectMenu("//button[@id='checkout']");
        // Verify the Text “Welcome, Please Sign In!”
        String expectedText5 = "Welcome, Please Sign In!";
        String actualText5 = driver.findElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']")).getText();
        Assert.assertEquals("Text not verified", expectedText5, actualText5);
        // Click on “CHECKOUT AS GUEST” Tab
        selectMenu("//button[normalize-space()='Checkout as Guest']");
        // Fill the all mandatory field
        // First name
        sendText(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "aaa");
        // Last name
        sendText(By.xpath("//input[@id='BillingNewAddress_LastName']"), "bbb");
        // Email
        sendText(By.xpath("//input[@id='BillingNewAddress_Email']"), "ccc@gmail.com");
        // Company name
        sendText(By.xpath("//input[@id='BillingNewAddress_Company']"), "ddd");
        // Country
        WebElement dropdown7 = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select select7 = new Select(dropdown7);
        // Select by visible text
        select7.selectByVisibleText("United States");
        // State
        selectByValue(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "47");
        // City
        sendText(By.xpath("//input[@id='BillingNewAddress_City']"), "Surat");
        // Address line 1
        sendText(By.xpath("//input[@id='BillingNewAddress_Address1']"), "Katargam");
        // Zip code
        sendText(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "395004");
        // Phone number
        sendText(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "0001112223");
        // Fax number
        sendText(By.xpath("//input[@id='BillingNewAddress_FaxNumber']"), "5558889");
        // Click on “CONTINUE”
        selectMenu("//button[@onclick='Billing.save()']");
        //  Click on Radio Button “Next Day Air($0.00)”
        selectMenu("//input[@id='shippingoption_1']");
        //  Click on “CONTINUE”
        selectMenu("//button[@class='button-1 shipping-method-next-step-button']");
        // Select Radio Button “Credit Card”
        selectMenu("//input[@id='paymentmethod_1']");
        // click on continue
        selectMenu("//button[@class='button-1 payment-method-next-step-button']");
        // Select “Master card” From Select credit card dropdown
        selectByValue(By.xpath("//select[@id='CreditCardType']"), "MasterCard");
        // Fill all the details
        sendText(By.xpath("//input[@id='CardholderName']"), "aaa");
        sendText(By.xpath("//input[@id='CardNumber']"), "5555555555554444");
        selectByValue(By.xpath("//select[@id='ExpireMonth']"), "5");
        selectByValue(By.xpath("//select[@id='ExpireYear']"), "2026");
        sendText(By.xpath("//input[@id='CardCode']"), "888");
        //  Click on “CONTINUE”
        selectMenu("//button[@class='button-1 payment-info-next-step-button']");
        //  Verify “Payment Method” is “Credit Card”
        String expectedMethod = "Credit Card";
        String actualMethod = driver.findElement(By.xpath("//span[normalize-space()='Credit Card']")).getText();
        Assert.assertEquals("Text not verified", expectedMethod, actualMethod);
        // Shipping method
        String expectedShippingMethod = "Next Day Air";
        String actualShippingMethod = driver.findElement(By.xpath("//span[normalize-space()='Next Day Air']")).getText();
        Assert.assertEquals("Text not verified", expectedShippingMethod, actualShippingMethod);
        // Verify the total price
        String expectedTotal = "$2,950.00";
        String actualTotal = driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
        Assert.assertEquals("Text not verified", expectedTotal, actualTotal);
        // Click on confirm button
        selectMenu("//button[normalize-space()='Confirm']");
        // Verify the Text “Thank You”
        String expectedThank = "Thank you";
        String actualThank = driver.findElement(By.xpath("//h1[normalize-space()='Thank you']")).getText();
        Assert.assertEquals("Text not verified", expectedThank, actualThank);

        //  Verify the message “Your order has been successfully processed!”
        String expectedOrder = "Your order has been successfully processed!";
        String actualOrder = driver.findElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")).getText();
        Assert.assertEquals("Text not verified", expectedOrder, actualOrder);

        // Click on “CONTINUE”
        selectMenu("//button[normalize-space()='Continue']");

        //  Verify the text “Welcome to our store”
        String expectedStore = "Welcome to our store";
        String actualStore = driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).getText();
        Assert.assertEquals("Text not verified", expectedStore, actualStore);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
