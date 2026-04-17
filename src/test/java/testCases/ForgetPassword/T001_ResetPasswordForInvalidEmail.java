package testCases.ForgetPassword;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ForgetPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class T001_ResetPasswordForInvalidEmail extends BaseClass {
    @Test
    void verifyForgotPasswordWithInvalidEmail() {

        HomePage hp = new HomePage(driver);
        hp.cLickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.ClickForgottenPass();

        ForgetPasswordPage fpp = new ForgetPasswordPage(driver);
        fpp.setInputEmailForgetPass("invalid123@gmail.com");
        fpp.setClkContinue();

        // validation
        String warningMsg = driver.findElement(
                By.xpath("//div[contains(@class,'alert-danger')]")
        ).getText();

        Assert.assertTrue(
                warningMsg.contains("If an account with this email exists"),
                "Generic message not displayed"
        );
    }
}