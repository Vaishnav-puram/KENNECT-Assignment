package org.example.Filter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Filter {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void searchByName(){
        driver.get("https://gor-pathology.web.app");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@kennect.io");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Qwerty@1234");
        driver.findElement(By.xpath("//span[text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//span[contains(text(),'Patients')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("Vais");
        Assert.assertTrue(driver.findElement(By.xpath("(//td[contains(text(),'Vaishnav Puram')])[1]")).isDisplayed());
        driver.quit();
        //td[contains(text(),'jacob')]


    }
    @Test
    public void searchByGenderFemale(){
        driver.get("https://gor-pathology.web.app");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@kennect.io");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Qwerty@1234");
        driver.findElement(By.xpath("//span[text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//span[contains(text(),'Patients')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("f");
        Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'jacob')]")).isDisplayed());
        driver.quit();

    }

}
