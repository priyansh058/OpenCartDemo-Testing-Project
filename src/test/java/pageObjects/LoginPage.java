package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage {
    //public Object ClickForgottenPass;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement inputPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement clickLoginBtn;

    @FindBy(xpath = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
    WebElement linkForgottenPassword;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement confirmationMsg;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement failLoginMsg;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Login']")
    WebElement rightLogIn;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueOfNewCust;

    @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement rightLogout;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Order History']")
    WebElement lnkOrderHistory;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Register']")
    WebElement lnkRegister;

    public void setInputEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void setInputPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void ClickLogin() {
        clickLoginBtn.click();
    }

    public void clickOrderHistory(){
        lnkOrderHistory.click();
    }

    public void clickRegisterOption(){
        lnkRegister.click();
    }


    public void ClickForgottenPass() {
        linkForgottenPassword.click();
    }

    public void clickContinueOfNewCustomer(){
        continueOfNewCust.click();
    }

    public void clickRightLogin(){
        rightLogIn.click();
    }

    public void clickRightLogOut(){
        rightLogout.click();
    }

    public String getSuccessMessage(){
          try{
              return confirmationMsg.getText();
          } catch (Exception e) {
              return (e.getMessage());
          }
    }

    public String getLoginFailedMsg(){
        try {
            return failLoginMsg.getText();
        } catch (Exception e) {
            return (e.getMessage());
        }
    }

    public boolean isRightLogoutVisible(){
        return !driver.findElements(By.xpath("//a[contains(@href,'logout')]")).isEmpty();
    }

}

