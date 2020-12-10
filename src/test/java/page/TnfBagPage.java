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
    @FindBy(xpath = "")
    WebElement Nime;


    public TnfBagPage (WebDriver driver){
        super(driver);
    }
    public String getNameOfFirstItem(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(firstItem))
                .getText();
}
public String getNameOfItem(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(NameItem))
                .getText();
}
    
}
