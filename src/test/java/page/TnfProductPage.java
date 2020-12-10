package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.ToIntFunction;

public class TnfProductPage extends Page {
    
    @FindBy(id = "buttonAddToBag")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id='master-container']/div/header/div[2]/div/nav/ul/li[12]/a")
    WebElement openBagButton;

    @FindBy(xpath = "//button[@class='product-content-form-size-btn-label attr-box']")
    WebElement selectQuantity;

    @FindBy(xpath = "//*[@id='ecom-product-actions']/div[1]/a[2]")
    WebElement addFavoriteButton;

    @FindBy(xpath = "//*[@id='master-container']/div/div/header/div[1]/nav")
    WebElement openFavoriteButton;

    @FindBy(xpath = "//*[@id='product-attr-form']/section[2]/div[3]/div/button[3]")
    private WebElement selectSizeButton;

    @FindBy(xpath = "/html/body/div[3]/div/header/div[5]/div/div[3]/span/p")
    private WebElement failedAddToFavoriteErrorMessage;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[1]/div[1]")
    private WebElement closeAdButton;

    public TnfProductPage(WebDriver driver){
        super(driver);
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
        openBagButton.click();
        return new TnfBagPage(driver);
    }

    public TnfProductPage addToFavorite(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(addFavoriteButton));
        addFavoriteButton.click();
        return this;
    }

    public Boolean canAddToFavorite(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(failedAddToFavoriteErrorMessage));
        return !(failedAddToFavoriteErrorMessage.isDisplayed());
    }

    public TnfProductPage setSize(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(selectSizeButton))
                .click();
        return this;
    }

    public TnfProductPage closePopUps() {

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(closeAdButton));
        closeAdButton.click();
        return this;
    }
}

