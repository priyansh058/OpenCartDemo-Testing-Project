package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;


public class T006_VerifyNavigateToDifferentPagesFromLogin extends BaseClass {
    @Test
    void verifyNavigation(){

        try {
            logger.info("****  Started of T006_VerifyNavigateToDifferentPagesFromLogin  ****");
            HomePage hp = new HomePage(driver);
            hp.cLickMyAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.clickContinueOfNewCustomer();

            Assert.assertTrue(
                    driver.getCurrentUrl().contains("account/register"),
                    "Not navigated to Register page"
            );
            driver.navigate().back();
            lp = new LoginPage(driver);
            lp.ClickForgottenPass();
            Assert.assertTrue(
                    driver.getCurrentUrl().contains("account/forgotten"),
                    "Not navigated to Forgotten Password page"
            );
            driver.navigate().back();
            lp = new LoginPage(driver);
            lp.clickRegisterOption();
            Assert.assertTrue(
                    driver.getCurrentUrl().contains("account/register"),
                    "Not navigated to Register page"
            );
            driver.navigate().back();
            lp = new LoginPage(driver);
            lp.clickOrderHistory();
            Assert.assertTrue(
                    driver.getCurrentUrl().contains("account/login"),
                    "User should remain on Login page for restricted link"
            );
            driver.navigate().back();
        } catch (Exception e) {
            Assert.fail();
        }
    }
}
