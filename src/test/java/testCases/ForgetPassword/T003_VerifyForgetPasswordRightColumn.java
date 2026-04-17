package testCases.ForgetPassword;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class T003_VerifyForgetPasswordRightColumn extends BaseClass {
    @Test
    void verifyForgotPasswordFromRightColumn(){

        HomePage hp = new HomePage(driver);
        hp.cLickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.ClickForgottenPass();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("account/forgotten"),
                "Navigation to Forgot Password page failed"
        );
    }
}
