package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends basePage {

    public ProductPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "button-cart")
    WebElement btnAddToCart;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successMsg;

    public void clickAddToCart(){
        btnAddToCart.click();
    }

    public String getSuccessMessage(){
        return successMsg.getText();
    }
}