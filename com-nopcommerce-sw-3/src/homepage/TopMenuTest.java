package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utiliti.Uti;

public class TopMenuTest extends Uti {
    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        clickOnElement(By.xpath(menu));
    }

    @Test
    public void verifyPageNavigation() {
        selectMenu("//body/div[6]/div[2]/ul[1]/li[1]/a[1]");
        String expectedText = "Computers";
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Computers')]")).getText();
        Assert.assertEquals("Text not verified", actualText, expectedText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
