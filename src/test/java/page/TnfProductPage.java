package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TnfProductPage extends Page {

    private static String sizeTemplate = "size_6_%s";
    private static String countTemplate = ".dk_options_inner > li:nth-child(%s)";

    @FindBy(id = "buttonAddToBag")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"checkout\"mini-cart-action button primary\"]")
    WebElement openBagButton;

    @FindBy(xpath = "//button[@class='product-content-form-size-btn-label attr-box']")
    WebElement selectQuantity;

    public TnfProductPage(WebDriver driver){
        super(driver);
    }

    public TnfProductPage setSize(String size){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(sizeTemplate,size))
                .click();
        return this;
    }

    public TnfProductPage addToCart(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(addToCartButton))
                .click();
        return this;
    }

    public TnfProductPage setCountOfItems(String count) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(selectQuantity))
                .click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(countTemplate,count))
                .click();
        return this;
    }

    public TnfBagPage openCart(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(openBagButton))
                .click();
        return new TnfBagPage(driver);
    }
}

