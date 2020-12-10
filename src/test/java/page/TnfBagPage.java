package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TnfBagPage extends Page{

    @FindBy(xpath = "//*[@id='body-container']/article/section/div[1]/section[2]/div[5]/aside[1]/div/div[2]/div[2]/div[1]/a/h3")
    WebElement firstItem;

    public TnfBagPage (WebDriver driver){
        super(driver);
    }
    public String getNameOfFirstItem(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(firstItem))
                .getText();
    }
}

