package setfolder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        ChromeOptions options = new ChromeOptions();
        // Disable browser notification
        options.addArguments("--disable-notifications");
        // Launch the Chrome browser
        driver = new ChromeDriver();

        // Open the url into browser
        driver.get(baseUrl);

        // Maximise browser
        driver.manage().window().maximize();

        // We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        // Close the browser
        driver.quit();
    }
}
