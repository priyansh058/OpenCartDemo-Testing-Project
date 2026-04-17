package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePassword extends HomePage{
    public ChangePassword(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement lnkPassword;

    @FindBy(xpath = "//input[@id='input-confirm']" )
    WebElement lnkConfirmPassword;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement lnkContinue;

    public void inputPassword(String pass){
        lnkPassword.sendKeys(pass);
    }

    public void inputConfirmPass(String confirmPass){
        lnkConfirmPassword.sendKeys(confirmPass);
    }

    public void ClickContinueBtn(){
         lnkContinue.click();
    }
}
