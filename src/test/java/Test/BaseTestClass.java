package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract class BaseTestClass {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--disable-notifications");
//        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver");
        driver = new ChromeDriver(chromeOptions);
        System.out.println("initialization WebDriver");
    }

    @AfterMethod
    public void TearsDown() {
        driver.quit();
        System.out.println("quit WebDriver instance");
    }

    public void getTinkoffHomePage(String homePageURL) {
        driver.get(homePageURL);
    }
}
