package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ForgetPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class T003_ForgotPasswordTest extends BaseClass {

    @Test
    void VerifyForgottenPassword(){
        try {
            logger.info("**** Start T003_ForgotPasswordTest ****");
            HomePage hp = new HomePage(driver);
            hp.cLickMyAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.ClickForgottenPass();

            ForgetPasswordPage fpp = new ForgetPasswordPage(driver);
            fpp.setInputEmailForgetPass(p.getProperty("email"));
            fpp.setClkContinue();

            Thread.sleep(2000);

            LoginPage loginPage = new LoginPage(driver);
            String msg = loginPage.getSuccessMessage();
            Assert.assertTrue(
                    msg.contains("confirmation link has been sent"),
                    "Forgot password failed"
            );
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("**** Finished T002_ForgotPasswordTest  ****");
    }
}
