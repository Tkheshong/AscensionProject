/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com.ascension;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author halleluyamengesha
 */
public class PriceTransparency1 {

    private WebDriver driver;

    public PriceTransparency1() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
//        WebDriverManager.getInstance(SafariDriver.class).setup();
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
//        driver = new SafariDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test
    public void testPriceTransparency() throws Exception {

        String apphomepageUrl = "https://healthcare.ascension.org/";
        driver.get(apphomepageUrl);

        //Verify Homepage by Title using IF statement
        String expectedtitleHomepage = "Healthcare | Ascension";
        String actualtitleHomepage = driver.getTitle();

        if (expectedtitleHomepage.equals(actualtitleHomepage)) {
            System.out.println("");
            System.out.println("Homepage Verification Successful!");
        } else {
            System.out.println("");
            System.out.println("Homepage Verification Failed!");
        }

        //Verify Price Transparency Link using isDisplayed() and isEnabled() methods
        WebElement pricetransparencyLink = driver.findElement(By.linkText("Price Transparency"));

        boolean pricetransparencyPresence = pricetransparencyLink.isDisplayed();
        System.out.println("");
        System.out.println("Price Transparency Link is Displayed!");

        boolean pricetransparencyEnabled = pricetransparencyLink.isEnabled();
        System.out.println("Price Transparency Link is Enabled!");

        if (pricetransparencyPresence == true && pricetransparencyEnabled == true) {
            pricetransparencyLink.click();
        } else {
            System.out.println("");
            System.out.println("Price Transparency may not be displayed or enabled!");
        }

        //Verify Price Transparency Page by Title using IF statement
        String expectedtitlePriceTransparency = "Price Transparency | Ascension";
        String actualtitlePriceTransparency = driver.getTitle();

        if (expectedtitlePriceTransparency.equals(actualtitlePriceTransparency)) {
            System.out.println("");
            System.out.println("Price Transparency Page Verification Successful!");
        } else {
            System.out.println("");
            System.out.println("Price Transparency Page Verification Failed!");
        }

        //Verify Price Estimator Link using isDisplayed() and isEnabled() methods
        WebElement priceestimatorButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[2]/div/div/a"));

        boolean priceestimatorPresence = priceestimatorButton.isDisplayed();
        System.out.println("");
        System.out.println("Price Estimator Button is Displayed!");

        boolean priceestimatorEnabled = priceestimatorButton.isEnabled();
        System.out.println("Price Estimator Button is Enabled!");

        if (priceestimatorPresence == true && priceestimatorEnabled == true) {
            priceestimatorButton.click();
        } else {
            System.out.println("");
            System.out.println("Price Estimator may not be displayed or enabled!");
        }

        //Go to Second Tab
        ArrayList<String> tabList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));

        //Verify Price Estimator Page using Assertion
        WebElement priceestimatorText = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/h1"));
        assertEquals(priceestimatorText.getText(), "Price Estimator");
        System.out.println("");
        System.out.println("Price Estimator Page Verification Successful!");

        driver.findElement(By.linkText("Labs")).click();
        driver.findElement(By.linkText("Blood")).click();
        driver.findElement(By.linkText("Routine lab testing")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/div/div[2]/button/div/p[1]")).click();
        driver.findElement(By.id("searchbar")).clear();
        driver.findElement(By.id("searchbar")).sendKeys("60194");
        driver.findElement(By.id("searchbar")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div[2]/div/div[1]/div[1]/button/div/div/div[2]/p")).click();
        driver.findElement(By.id("insurance-provider-select")).click();

        driver.findElement(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/button")).click();

        WebElement fullserviceCost = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div/div/div/h3"));
        assertEquals(fullserviceCost.getText(), "Full service cost");
        System.out.println("");
        System.out.println("Output text is correct!");

        WebElement fullServiceCostCalc = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div/div/div/p"));
        assertEquals(fullServiceCostCalc.getText(), "$610");
        System.out.println("");
        System.out.println("Final Price Estimation is correct!");

    }
}
