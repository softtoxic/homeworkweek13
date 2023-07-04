package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utiliti.Uti;

public class Electronics extends Uti {
    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        clickOnElement(By.xpath(menu));
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        // Mouse Hover on “Electronics” Tab and "Cell Phone" tab
        WebElement electronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']    "));
        WebElement cellPhone = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).moveToElement(cellPhone).click().build().perform();
        // Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals("Text not verified", actualText, expectedText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // Mouse Hover on “Electronics” Tab and "Cell Phone" tab
        WebElement electronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']    "));
        WebElement cellPhone = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).moveToElement(cellPhone).click().build().perform();
        // Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals("Text not verified", actualText, expectedText);
        //  Click on List View Tab
        selectMenu("//a[@title='List']");
        // Navigate to current URL
        String expectedUrl = "https://demo.nopcommerce.com/cell-phones?viewmode=list&orderby=0&pagesize=6";
        if (!baseUrl.equals(expectedUrl)) {
            // Navigate to the new URL
            driver.get(expectedUrl);
        }
        //  Click on product name “Nokia Lumia 1020” link
        selectMenu("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]");
        //  Verify the price “$349.00”
        String expectedPrice = "$349.00";
        String actualPrice = driver.findElement(By.xpath("//span[contains(text(),'$349.00')]")).getText();
        Assert.assertEquals("Text not verified", actualText, expectedText);
        // Change quantity to 2
        WebElement element = driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']"));
        element.click();
        element.clear();
        element.sendKeys("2");
        //  Click on “ADD TO CART” tab
        selectMenu("//button[@id='add-to-cart-button-20']");
        // Close the bar
        selectMenu("//span[@title='Close']");

        // Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedText1 = "The product has been added to your shopping cart";
        String actualText1 = driver.findElement(By.xpath("//p[@class='content']")).getText();
        Assert.assertEquals("Text not verified", actualText1, expectedText1);
        Thread.sleep(2000);


        // Mouse Hover on “Electronics” Tab and "Cell Phone" tab
        WebElement shoppingCart = driver.findElement(By.xpath("//li[@id='topcartlink']"));
        WebElement goToCart = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        Actions action = new Actions(driver);
        action.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();
         String expectedQ = "2";
         String actualQ = driver.findElement(By.xpath("//input[@value='2']")).getText();
         Assert.assertEquals("Quantity not verified", actualQ, expectedQ);
        // Verify the Total
        String expectedTotal = "$698.00";
        String actualTotal = driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
        Assert.assertEquals("Price not verified", expectedTotal, actualTotal);
        // click on checkbox “I agree with the terms of service”
        selectMenu("//input[@id='termsofservice']");
        //  Click on “CHECKOUT”
        selectMenu("//button[@id='checkout']");
        //  Verify the Text “Welcome, Please Sign In!”
        String expectedWelcome = "Welcome, Please Sign In!";
        String actualWelcome = driver.findElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']")).getText();
        Assert.assertEquals("Text not verified", expectedWelcome, actualWelcome);
        // Click on “REGISTER” tab
        selectMenu("//button[normalize-space()='Register']");
        // Verify the text “Register”
        String expectedRegister = "Register";
        String actualRegister = driver.findElement(By.xpath("//h1[normalize-space()='Register']")).getText();
        Assert.assertEquals("Text not verified", expectedRegister, actualRegister);
        // Fill the mandatory fields
        // Click on Gender radio button
        clickOnElement(By.xpath("//input[@id= 'gender-male']"));
        // Enter First Name
        sendText(By.xpath("//input[@id= 'FirstName']"), "jjj");
        //Enter Last Name
        driver.findElement(By.xpath("//input[@id= 'LastName']")).sendKeys("yyy");
        // Click on day
        driver.findElement(By.xpath("//select[@name = 'DateOfBirthDay']//option[@value= '15']")).click();
        // Click on Month
        driver.findElement(By.xpath("//select[@name = 'DateOfBirthMonth']//option[@value= '9']")).click();
        // Click on year
        driver.findElement(By.xpath("//select[@name = 'DateOfBirthYear']//option[@value= '1933']")).click();
        // Enter Email
        driver.findElement(By.xpath("//input[@id= 'Email']")).sendKeys("oopp@gmail.com");
        // Enter Password
        driver.findElement(By.xpath("//input[@name= 'Password']")).sendKeys("xyz@0000");
        // Enter confirm Password
        driver.findElement(By.xpath("//input[@name= 'ConfirmPassword']")).sendKeys("xyz@0000");
        // Click on Register button
        driver.findElement(By.xpath("//button[@name= 'register-button']")).click();
        //  Verify the message “Your registration completed”
        String expectedRegistration = "Your registration completed";
        String actualRegistration = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals("Text not verified", expectedRegistration, actualRegistration);
        // Click on continue
        selectMenu("//a[@class='button-1 register-continue-button']");
        // Login again because cart is empty
        selectMenu("//a[@class='ico-login']");
        sendText(By.xpath("//input[@id='Email']"), "oopp@gmail.com");
        sendText(By.xpath("//input[@id='Password']"), "xyz@0000");
        selectMenu("//button[normalize-space()='Log in']");
        //  Verify the text “Shopping card”
        String expectedShopping = "Shopping cart";
        String actualShopping = driver.findElement(By.xpath("//h1[normalize-space()='Shopping cart']")).getText();
        Assert.assertEquals("Text not verified", actualShopping, expectedShopping);
        //  click on checkbox “I agree with the terms of service”
        selectMenu("//input[@id='termsofservice']");
        //  Click on “CONTINUE”
        selectMenu("//button[@id='checkout']");
        //  Fill all the details
        // First name
        sendText(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "jjj");
        // Last name
        sendText(By.xpath("//input[@id='BillingNewAddress_LastName']"), "yyy");
        // Email
        sendText(By.xpath("//input[@id='BillingNewAddress_Email']"), "");
        // Select country
        selectByValue(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "1");
        // Select State
        selectByValue(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "47");
        // City
        sendText(By.xpath("//input[@id='BillingNewAddress_City']"), "Surat");
        // Address line 1
        sendText(By.xpath("//input[@id='BillingNewAddress_Address1']"), "Katargam");
        // Zip Code
        sendText(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "395004");
        // Phone number
        sendText(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "1234567890");
        // click on continue button
        selectMenu("//button[@onclick='Billing.save()']");
        // Click on Radio Button “2nd Day Air ($0.00)”
        selectMenu("//input[@id='shippingoption_2']");
        // Click on continue button
        selectMenu("//button[@class='button-1 shipping-method-next-step-button']");
        //  Select Radio Button “Credit Card”
        selectMenu("//input[@id='paymentmethod_1']");
        // Click on continue
        selectMenu("//button[@class='button-1 payment-method-next-step-button']");
        // Select visa card option
        selectByValue(By.xpath("//select[@id='CreditCardType']"), "visa");
        //  Fill all the details
        // Cardholder name
        sendText(By.xpath("//input[@id='CardholderName']"), "jjjeee");
        // Card number
        sendText(By.xpath("//input[@id='CardNumber']"), "5555555555554444");
        // Expire date
        selectByValue(By.xpath("//select[@id='ExpireMonth']"), "4");
        // Expire Year
        selectByValue(By.xpath("//select[@id='ExpireYear']"), "2028");
        // Card code
        sendText(By.xpath("//input[@id='CardCode']"), "890");
        // Click on “CONTINUE”
        selectMenu("//button[@class='button-1 payment-info-next-step-button']");
        // Verify “Payment Method” is “Credit Card”
        String expectedMethod = "Credit Card";
        String actualMethod = driver.findElement(By.xpath("//span[normalize-space()='Credit Card']")).getText();
        Assert.assertEquals("Text not verified", expectedMethod, actualMethod);
        //  Verify “Shipping Method” is “2nd Day Air”
        String expectedShipping = "2nd Day Air";
        String actualShipping = driver.findElement(By.xpath("//span[normalize-space()='2nd Day Air']")).getText();
        Assert.assertEquals("Text not verified", actualShipping, expectedShipping);
        // Verify Total is “$698.00”
        String expectedValue = "$698.00";
        String actualValue = driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
        Assert.assertEquals("Text not verified", expectedValue, actualValue);
        //  Click on “CONFIRM”
        selectMenu("//button[normalize-space()='Confirm']");
        // Verify the Text “Thank You”
        String expectedThank = "Thank you";
        String actualThank = driver.findElement(By.xpath("//h1[normalize-space()='Thank you']")).getText();
        Assert.assertEquals("Text not verified", expectedThank, actualThank);
        //  Verify the message “Your order has been successfully processed!”
        String expectedMessage = "Your order has been successfully processed!";
        String actualMessage = driver.findElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")).getText();
        Assert.assertEquals("Text not verified", expectedThank, actualThank);
        //  Click on “CONTINUE”
        selectMenu("//button[normalize-space()='Continue']");
        //  Verify the text “Welcome to our store”
        String expectedWelcome2 = "Welcome to our store";
        String actualWelcome2 = driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).getText();
        Assert.assertEquals("Text not verified", expectedWelcome2, actualWelcome2);
        //  Click on “Logout” link
        selectMenu("//a[@class='ico-logout']");
        //  Verify the URL is “https://demo.nopcommerce.com/”
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl2 = "https://demo.nopcommerce.com/";
        Assert.assertEquals("Url not verified", expectedUrl2, currentUrl);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
