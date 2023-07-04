package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import setfolder.UtilityClass;

import java.util.List;

public class TopMenuTest extends UtilityClass {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";
    String option;

    public void selectMenu(String option) {
        WebElement select = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        List<WebElement> options = select.findElements(By.xpath("//a[normalize-space()='Mac (1)']"));
        for (WebElement option1 : options) {
            if (option.equals(option1.getText())) {
                option1.click();
            }
        }
        WebElement select1 = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        List<WebElement> options1 = select1.findElements(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        for (WebElement option2 : options1) {
            if (option.equals(option2.getText())) {
                option2.click();
            }
        }

    }

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        // 1.1 Mouse hover on “Desktops” Tab and click
        clickOn(By.xpath("//a[normalize-space()='Desktops']"));
        // 1.2 call selectMenu method and pass the menu = “Show All Desktops”
        option = "Show AllDesktops";
        selectMenu(option);
        // 1.3 Verify the text ‘Desktops’
        String expectedText = "Desktops";
        String actualText = getText(By.xpath("//h2[normalize-space()='Desktops']"));
        Assert.assertEquals("Text not verified", actualText, expectedText);
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
      //  2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        clickOn(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        // 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        option = "Show AllLaptops & Notebooks";
        selectMenu(option);
        clickOn(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        // 2.3 Verify the text ‘Laptops & Notebooks’
        String expectedText = "Laptops & Notebooks";
        String actualText = getText(By.xpath("//h2[normalize-space()='Laptops & Notebooks']"));
        Assert.assertEquals("Text not verified", actualText, expectedText);

    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        // 3.1 Mouse hover on “Components” Tab and click
        clickOn(By.xpath("//a[normalize-space()='Components']"));
        // 3.2 call selectMenu method and pass the menu = “Show All Components”
        option = "Show AllComponents";
        selectMenu(option);
        clickOn(By.xpath("//a[normalize-space()='Show AllComponents']"));
        // 3.3 Verify the text ‘Components’
        String expectedText = "Components";
        String actualText = getText(By.xpath("//h2[normalize-space()='Components']"));
        Assert.assertEquals("Text not verified", actualText, expectedText);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
