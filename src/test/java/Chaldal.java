import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Chaldal {
    public WebDriver driver;

    @Test
    public void browser() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Integer> contentSettings = new HashMap<String, Integer>();
        //0 - Default, 1 - Allow, 2 - Block
        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--remote-allow-origins=*");
//
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.get("https://chaldal.com/");
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
        //driver.findElement(By.xpath("(//input[@name=\"name\"])[1]")).sendKeys("afsana");
        driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[1]")).click();
        driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[1]")).sendKeys("rice");
        Thread.sleep(1000);
        // driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[1]")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//section[@class=\"addButtonWrapper border-radius-small\"])[1]")).click();
        driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[1]")).click();
        driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[1]")).sendKeys("Medicine");


    }
}
