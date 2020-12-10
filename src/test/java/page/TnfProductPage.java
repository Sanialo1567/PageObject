package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TnfProductPage extends Page {

    private static String sizeTemplate = "size_S_%s";//ужно поставить как-тоо nteger тобы размер не S был,а число 6 
    
    @FindBy(id = "buttonAddToBag")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"checkout\"mini-cart-action button primary\"]")
    WebElement openBagButton;

    @FindBy(xpath = "//button[@class='product-content-form-size-btn-label attr-box']")
    WebElement selectQuantity;

   @FindBy(xpath = "//*[@id="ecom-product-actions"]/div[1]/a[2]")
    WebElement addFavoriteButton;

   @FindBy(xpath = "//*[@id="master-container"]/div/div/header/div[1]/nav")
    WebElement openFavoriteButton;

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


    public TnfBagPage openCart(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(openBagButton))
                .click();
        return new TnfBagPage(driver);
    }
public TnfBagPage addToFavorite(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(addFavoriteButton))
                .click();
        return this;
    }
public TnfBagPage openFavorite(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(openFavoriteButton))
                .click();
        return new TnfFavoritePage(driver);
    }

}

