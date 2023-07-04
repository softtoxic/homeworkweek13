package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import setfolder.UtilityClass;

import java.util.List;

public class MyAccountTest extends UtilityClass {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";
    String option;

    public void selectMyAccountOptions(String option) {
        WebElement select = driver.findElement(By.xpath("//a[@title='My Account']"));
        List<WebElement> options = select.findElements(By.xpath("//a[normalize-space()='Register']"));
        for (WebElement option1 : options) {
            if (option.equals(option1.getText())) {
                option1.click();
            }
        }
        WebElement select1 = driver.findElement(By.xpath("//a[@title='My Account']"));
        List<WebElement> options1 = select1.findElements(By.xpath("//a[normalize-space()='Login']"));
        for (WebElement option2 : options1) {
            if (option.equals(option2.getText())) {
                option2.click();
            }
        }
        if(option=="Logout")
        {
            WebElement select2 = driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
            List<WebElement> option2 = select2.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));
            for (WebElement option3 : option2)
            {
                if (option.equals(option3.getText()))
                {
                    option3.click();
                    return;
                }
            }
        }

    }


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        // 1.1 Click on "My account" tab
        clickOn(By.xpath("//span[normalize-space()='My Account']"));
        // 1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        option = "Register";
        selectMyAccountOptions(option);
        //driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
        // 1.3 Verify the text “Register Account”.
        String expectedText = "Register Account";
        String actualText = getText(By.xpath("//h1[normalize-space()='Register Account']"));
        Assert.assertEquals("Text not verified", actualText, expectedText);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        // 2.1 Click on "My account" tab
        clickOn(By.xpath("//span[normalize-space()='My Account']"));
        // 2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        option = "Login";
        selectMyAccountOptions(option);
        // driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        String expectedText = "Returning Customer";
        String actualText = getText(By.xpath("//h2[normalize-space()='Returning Customer']"));
        Assert.assertEquals("Text not verified", actualText, expectedText);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        // 3.1 Click on My Account Link.
        clickOn(By.xpath("//span[normalize-space()='My Account']"));
        // 3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        option = "Register";
        selectMyAccountOptions(option);
        //driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
        // 3.3 Enter First Name
        sendText(By.xpath("//input[@id='input-firstname']"), "aaa");
        // 3.4 Enter Last Name
        sendText(By.xpath("//input[@id='input-lastname']"), "bbb");
        // 3.5 Enter Email
        sendText(By.xpath("//input[@id='input-email']"), "ddlj@gmail.com");
        // 3.6 Enter Telephone
        sendText(By.xpath("//input[@id='input-telephone']"), "9996663331");
        // 3.7 Enter Password
        sendText(By.xpath("//input[@id='input-password']"), "123456");
        //3.8 Enter Password Confirm
        sendText(By.xpath("//input[@id='input-confirm']"), "123456");
        //3.9 Select Subscribe Yes radio button
        clickOn(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']"));
        //3.10 Click on Privacy Policy check box
        clickOn(By.xpath("//input[@name='agree']"));
        //3.11 Click on Continue button
        clickOn(By.xpath("//input[@value='Continue']"));
        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedText = "Your Account Has Been Created!";
        String actualText = getText(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        Assert.assertEquals("Text not verified", actualText, expectedText);
        //3.13 Click on Continue button
        clickOn(By.xpath("//a[@class='btn btn-primary']"));
        //3.14 Click on My Account Link.
        clickOn(By.xpath("//span[normalize-space()='My Account']"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        clickOn(By.xpath("//a[normalize-space()='Logout']"));
        //3.16 Verify the text “Account Logout”
        String expectedText1 = "Account Logout";
        String actualText1 = getText(By.xpath("//h1[normalize-space()='Account Logout']"));
        Assert.assertEquals("Text not verified", actualText1, expectedText1);
        //3.17 Click on Continue button
        clickOn(By.xpath("//a[@class='btn btn-primary']"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        // 3.1 Click on My Account Link.
        clickOn(By.xpath("//span[normalize-space()='My Account']"));
        // 3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        option = "Login";
        selectMyAccountOptions(option);
        //  4.3 Enter Email address
        sendText(By.xpath("//input[@id='input-email']"), "ddlj@gmail.com");
        //  4.4 Enter Last Name
        //  4.5 Enter Password
        sendText(By.xpath("//input[@id='input-password']"), "123456");
        //  4.6 Click on Login button
        clickOn(By.xpath("//input[@value='Login']"));
        //  4.7 Verify text “My Account”
        String expectedText1 = "My Account";
        String actualText1 = getText(By.xpath("//h2[normalize-space()='My Account']"));
        Assert.assertEquals("Text not verified", actualText1, expectedText1);
        //  4.8 Click on My Account Link.
        clickOn(By.xpath("//span[normalize-space()='My Account']"));
        //  4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        option = "Logout";
        selectMyAccountOptions(option);
       // clickOn(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));
        //  4.10 Verify the text “Account Logout”
        String expectedText2 = "Account Logout";
        String actualText2 = getText(By.xpath("//h1[normalize-space()='Account Logout']"));
        Assert.assertEquals("Text not verified", actualText2, expectedText2);
        //  4.11 Click on Continue button
        clickOn(By.xpath("//a[@class='btn btn-primary']"));

    }


    @After
    public void tearDown() {
        closeBrowser();
    }

}
