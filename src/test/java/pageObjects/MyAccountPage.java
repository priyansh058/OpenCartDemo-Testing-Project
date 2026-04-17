package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAccountPage extends basePage{
   public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text() ='My Account']")
    WebElement msgHandling;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement linkLogout;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement lnkContinue;

    @FindBy(xpath = "//a[normalize-space()='Password']")
    WebElement changePass;


    public boolean isMyAccountPageExits() {
        try {
            return msgHandling.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickLogOut() {
            linkLogout.click();
        }

    public void ClickChangePassword(){
        changePass.click();
    }


        public void clickContinueBtn(){
        lnkContinue.click();
        }


    @FindBy(xpath = "//a[text()='Wish List']")
    WebElement wishListLink;

    @FindBy(xpath = "//button[@data-original-title='Add to Cart']")
    List<WebElement> wishlistAddToCartBtns;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successMsg;

    public void goToWishlist(){
        wishListLink.click();
    }

    public void addToCartFromWishlist(String productName){
        for(WebElement btn : wishlistAddToCartBtns){
            btn.click(); // simple version (can improve later)
            break;
        }
    }

    public String getSuccessMessage(){
        return successMsg.getText();
    }



    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement myAccountHeading;
    public boolean isMyAccountPageExists() {
        try {
            return myAccountHeading.isDisplayed(); // locate "My Account" heading
        } catch (Exception e) {
            return false;
        }
    }
}
