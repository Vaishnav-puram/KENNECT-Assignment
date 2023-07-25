package org.example.TestCalculator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestCalculator {
    WebDriver driver;

    @Test
    public void calc1() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://gor-pathology.web.app/");
        //maximize browser window
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@kennect.io");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Qwerty@1234");
        driver.findElement(By.xpath("//span[text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("patient-test")).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'332.5 ₹')]")).getText().contains("332.5"));

    }
    @Test
    public void calc2() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://gor-pathology.web.app/");
        //maximize browser window
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@kennect.io");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Qwerty@1234");
        driver.findElement(By.xpath("//span[text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("patient-test")).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        driver.findElement(By.id("patient-test")).click();
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'950 ₹')]")).getText(),"950 ₹");

    }

    @AfterClass
    public void closure(){
        driver.quit();
    }
}
