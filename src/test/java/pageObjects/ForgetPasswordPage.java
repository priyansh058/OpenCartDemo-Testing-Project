package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgetPasswordPage extends HomePage {
    public ForgetPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement inputEmailForgetPass;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement clkContinue;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement warningMsg;

    public void setInputEmailForgetPass(String email){
        inputEmailForgetPass.clear();
        inputEmailForgetPass.sendKeys(email);
    }

    public void setClkContinue(){
        clkContinue.click();
    }

    public String getWarningMessage(){
        return warningMsg.getText();
    }

}
