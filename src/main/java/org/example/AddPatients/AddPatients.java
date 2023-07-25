package org.example.AddPatients;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class AddPatients {
    WebDriver driver;
    JavascriptExecutor js;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void noPhone() {
        driver.get("https://gor-pathology.web.app");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@kennect.io");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Qwerty@1234");
        driver.findElement(By.xpath("//span[text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//span[contains(text(),'Patients')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/main[1]/div[2]/div[1]/a[1]/button[1]/span[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("Vaishnav Puram");
        driver.findElement(By.name("email")).sendKeys("puramv307@gmail.com");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
        WebDriverWait webDriverWait=new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement element=webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Required')]")));
        Assert.assertEquals(element.getText(),"Required");

        driver.close();
    }
    @Test
    public void noName() {
        driver.get("https://gor-pathology.web.app");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@kennect.io");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Qwerty@1234");
        driver.findElement(By.xpath("//span[text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//span[contains(text(),'Patients')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/main[1]/div[2]/div[1]/a[1]/button[1]/span[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.name("name")).click();
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
        WebDriverWait webDriverWait=new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement element=webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Patient name is required')]")));
        Assert.assertEquals(element.getText(),"Patient name is required");
        driver.close();
    }
    @Test
    public void addPatient() {
        driver.get("https://gor-pathology.web.app");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@kennect.io");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Qwerty@1234");
        driver.findElement(By.xpath("//span[text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//span[contains(text(),'Patients')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/main[1]/div[2]/div[1]/a[1]/button[1]/span[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.name("name")).sendKeys("Vaishnav Puram");
        driver.findElement(By.name("email")).sendKeys("puramv307@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("9234488759");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
        driver.findElement(By.name("height")).sendKeys("152.4");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("70").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys("23").sendKeys(Keys.TAB).build().perform();
        actions.sendKeys("80").sendKeys(Keys.TAB).sendKeys("90").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        WebDriverWait webDriverWait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement element=webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='patient-test']")));
        actions.moveToElement(element);
        element.click();
        //driver.findElement(By.xpath("//input[@id='patient-test']")).click();
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("(//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[1]")).click();
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
        driver.findElement(By.xpath("(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiAutocomplete-inputRoot MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-adornedEnd MuiOutlinedInput-adornedEnd'])[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiAutocomplete-inputRoot MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-adornedEnd MuiOutlinedInput-adornedEnd']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
       // driver.findElement(By.xpath("(//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[2]")).click();
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]")).click();
        actions.sendKeys(Keys.ENTER).perform();

        driver.close();
    }
}
