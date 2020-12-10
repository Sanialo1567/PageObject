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
    static void BrowserSetup(){
        driver = new ChromeDriver();
    }

        @BeforeEach
        public void clearCookies(){
            //clear cookies
        }

        @Test
        public void addToCartTest(){
            String itemName = new TnfHomePage(driver)
                    .openPage()
                    .goToProduct()
                    .setSize()
                    .addToCart()
                    .openCart()
                    .getNameOfFirstItem();

            Assert.assertEquals(itemName, "Women’s Back-To-Berkeley Mid WP");
        }

        @Test
        public void addToCartManyItemsTest(){
            String countOfItems = new TnfHomePage(driver)
                    .openPage()
                    .goToProduct()
                    .setSize()
                    .addToCart()
                    .openCart()
                    .setCountOfItems()
                    .getCountOfItems();

            Assert.assertEquals(countOfItems, "3");
        }

        @AfterAll
        static void driverShutDown(){
            driver.quit();
            driver=null;
        }

    }
