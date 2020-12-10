package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TnfHomePage extends Page {
    private static final String HOMEPAGE_URL = "https://www.thenorthface.com";

    @FindBy(xpath = "//*[@id=\"catalog-results\"]/div[3]/div[1]/figure/a/div")
    private WebElement addProductButton;

    public TnfHomePage(WebDriver driver){
        super(driver);
    }

    public TnfHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());
        return this;
    }
    public TnfProductPage goToProduct(){
        WebElement goToCartButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(addProductButton));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(goToCartButton));
        goToCartButton.click();
        return new TnfProductPage(driver);
    }

}
