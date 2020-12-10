package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TnfBagPage extends Page{

    @FindBy(xpath = "//div[container(@class,'item-detail-info-name item-name-js')]/h3/*[@id=\"254180537\"]")
    WebElement firstItem;

    @FindBy(xpath = "//*[@id=\"checkout-shopcart-quantity-254180537\"]/option[3]\"]")
    WebElement countOfFirstItem;


    public TnfBagPage (WebDriver driver){
        super(driver);
    }
    public String getNameOfFirstItem(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(firstItem))
                .getText();
}
    public String getCountOfItems(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(countOfFirstItem));
        Select countSelect = new Select(countOfFirstItem);
        return countSelect.getFirstSelectedOption().getText();
    }
}
