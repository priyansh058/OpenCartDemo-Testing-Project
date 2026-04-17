package testCases.ForgetPassword;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ForgetPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class T002_VerifyForgetPasswordWithInvalidFormat extends BaseClass {
    @Test
    void verifyForgotPasswordWithInvalidFormats(){

        HomePage hp = new HomePage(driver);
        hp.cLickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.ClickForgottenPass();

        ForgetPasswordPage fpp = new ForgetPasswordPage(driver);

        String[] invalidEmails = {
                "pavanol",
                "pavanol@",
                "pavanol@gmail",
                "pavanol@gmail."
        };

        for(String email : invalidEmails){

            fpp.setInputEmailForgetPass(email);
            fpp.setClkContinue();

            String warning = fpp.getWarningMessage();

            Assert.assertTrue(
                    warning.toLowerCase().contains("valid email"),
                    "Validation message not shown for invalid format: " + email
            );
        }
    }
}
