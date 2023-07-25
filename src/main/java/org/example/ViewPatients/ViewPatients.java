package org.example.ViewPatients;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ViewPatients {
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
    public void view(){
        driver.get("https://gor-pathology.web.app");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@kennect.io");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Qwerty@1234");
        driver.findElement(By.xpath("//span[text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//span[contains(text(),'Patients')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("(//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft'])[1]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Vaishnav Puram')])[1]")).getText(),"Vaishnav Puram");
        driver.quit();
    }
}
