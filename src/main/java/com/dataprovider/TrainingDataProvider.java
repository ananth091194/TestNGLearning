package com.dataprovider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TrainingDataProvider {
    @DataProvider(name="mobile")
    public Object [] mobileDataName(){
        return new Object [] {"realme"};
    }

    static long start;
    static WebDriver driver;

    @BeforeClass (groups = "default")
    public static void browserLaunch() {
        System.out.println("BrowserLaunch");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterClass (groups = "default")
    public static void browserQuit() {
        System.out.println("BrowserQuit");
        driver.quit();
    }

    @BeforeMethod  (groups = "default")
    public void startTime() {
        start = System.currentTimeMillis();
        System.out.println("StartTime");
    }

    @AfterMethod  (groups = "default")
    public void endTime() {
        long end = System.currentTimeMillis();
        System.out.println("Running Time" + (end - start));
    }

    @Parameters("URL")
    @Test (priority = 1)
    public void Login(String url) {
        System.out.println("login");
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test(priority = 3, dataProvider = "mobile")
    public void search(String producutName) {
        System.out.println("search mobile");
        WebElement Search = driver.findElement(By.name("q"));
        Search.sendKeys(producutName);
        Search.sendKeys(Keys.ENTER);
    }

    @Test (priority = 4)
    public void mobiles() {
        System.out.println("select mobiles");
    }

    @Test (priority = 2)
    public void window() {
        System.out.println("window handling");
    }
}
