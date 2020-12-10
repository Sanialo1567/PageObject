package test;

import junit.framework.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.TnfHomePage;

public class TnfTest {

    private static WebDriver driver;
 @BeforeAll
    public void init() {
    System.setProperty("webdriver.chrome.driver", "D://webdriver/chromedriver.exe");
    static void BrowserSetup(){
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void clearCookies(){ }

    @Test
    public void addToCartTest(){
        String itemName = new TnfHomePage(driver)
                .openPage()
                .goToProduct()
                .closePopUps()
                .setSize()
                .addToCart()
                .openCart()
                .getNameOfFirstItem();

            Assert.assertEquals(itemName, "WOMEN’S BACK-TO-BERKELEY MID WP");
        }

    @Test
    public void addToFavoriteTest(){
        Boolean canAdd = new TnfHomePage(driver)
                .openPage()
                .goToProduct()
                .setSize()
                .addToFavorite()
                .canAddToFavorite();

        Assert.assertFalse(canAdd);
        }

    @AfterAll
    static void driverShutDown(){
        driver.quit();
        driver=null;
    }

}
