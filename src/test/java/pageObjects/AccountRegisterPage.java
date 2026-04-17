package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends HomePage {
    public AccountRegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtFirstname;
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtLastname;
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txtTelephone;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txtConfirm;
    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkdPolicy;
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConformation;
    @FindBy(xpath = "//a[normalize-space()='login page']")
    WebElement lnkLogIn;

    public void setFirstName(String fName) {
        txtFirstname.sendKeys(fName);
    }

    public void setLastName(String lName) {
        txtLastname.sendKeys(lName);
    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setTelephone(String tel) {
        txtTelephone.sendKeys(tel);
    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void setConfirmPass(String pwd) {
        txtConfirm.sendKeys(pwd);
    }

    public void setPolicy() {
        chkdPolicy.click();
    }

    public void setBtnContinue() {
        btnContinue.click();
    }

    public void clickLogInLink(){
        lnkLogIn.click();
    }

    public String getConformationMsg() {
        try {
            return msgConformation.getText();
        } catch (Exception e) {
            return (e.getMessage());
        }

    }
}
