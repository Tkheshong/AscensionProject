/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package firstSeleniumTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author ratho
 */
public class firstSelTest {
    
    private WebDriver driver;
    private String baseUrl;
    
    public firstSelTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @BeforeMethod
    public void setUpMethod() throws Exception {
        
        System.setProperty("webdriver.chrome.driver", "C:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    
    @AfterMethod
    public void tearDownMethod() throws Exception {
    }



    @Test
    public void OpenBrowser() throws Exception {

        //Going to Ascensions Main HomePage
        driver.get("https://healthcare.ascension.org/");
        
        //Getting the web handle for homepage
        String currentTabHandle = driver.getWindowHandle();
        
        //Click on Donate
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[1]/div/div/div/div/div/div[1]/div/div/div/div[1]/div/div/div/div/ul/li[2]/div/a")).click();
        
        //Click on Illinois
        driver.findElement(By.xpath("//*[@id=\"facets-section__state\"]/li[4]/a/div/div/h3")).click();
        
        //Click on Foundation
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[1]/div/h3/a")).click();

        //Geting handles of all tabs - since a new tab was opened, and then swithcing to tne new tab
        Thread.sleep(3000);
        Set<String> allTabHandles = driver.getWindowHandles();

        for (String tabHandle : allTabHandles) {
            if (!tabHandle.equals(currentTabHandle)) {
                driver.switchTo().window(tabHandle);
                break;
            }
        }
        //Wait until element make a gift is visible and then clicking on it
        WebDriverWait wait = new WebDriverWait(driver, 20);  //20 sec
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"comp-l8ep9eh1\"]/a/div/span[1]"))).click();
        
        /*
        Switching to the "form" iframe in the donation page
        */
        Thread.sleep(5000);
        WebElement iframe = driver.findElement(By.xpath("//iFrame[@class=\"wuksD5\"]"));
        driver.switchTo().frame(iframe);
        
        //Scrolling down a little
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        
        // Waiting till the "other" donation box is visible and then clicking on it
        WebDriverWait wait2 = new WebDriverWait(driver, 20);  //20 sec
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bboxdonation_gift_rdlstGivingLevels\"]/div[6]/div/label/span")));
        driver.findElement(By.xpath("//*[@id=\"bboxdonation_gift_rdlstGivingLevels\"]/div[6]/div/label/span")).click();
        Thread.sleep(5000);
        
        //inputing $1 for dollar amount to be donated
        driver.findElement(By.xpath("//*[@id=\"bboxdonation_gift_txtOtherAmountButtons\"]")).sendKeys("1");
        


    }
    
}

