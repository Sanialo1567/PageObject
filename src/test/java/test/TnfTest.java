package test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.TnfHomePage;

public class TnfTest {

private static WebDriver driver;

@BeforeAll
static void BrowserSetup(){
System.setProperty("webdriver.chrome.driver", "D://webdriver/chromedriver.exe");
driver = new ChromeDriver();
}

@BeforeEach
public void clearCookies(){
driver.manage().deleteAllCookies();
}

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

Assertions.assertEquals(itemName, "WOMEN’S BACK-TO-BERKELEY MID WP");
}

@Test
public void addToFavoriteTest(){
Boolean canAdd = new TnfHomePage(driver)
.openPage()
.goToProduct()
.setSize()
.addToFavorite()
.canAddToFavorite();

Assertions.assertFalse(canAdd);
}

@AfterAll
static void driverShutDown(){
driver.quit();
driver=null;
}

}