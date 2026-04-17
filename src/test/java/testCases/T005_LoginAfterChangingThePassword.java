package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class T005_LoginAfterChangingThePassword extends BaseClass {
    @Test
    void verifyLoginChangePassword() {
        try {
            logger.info("**** Started T005_LoginAfterChangingThePassword Test ****");

            String email = p.getProperty("email2");
            String oldPwd =p.getProperty("email2Password");
            String newPwd =p.getProperty("newPassword");

            HomePage hp = new HomePage(driver);

            hp.cLickMyAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.setInputEmail(email);
            lp.setInputPassword(oldPwd);
            lp.ClickLogin();

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            myAccountPage.ClickChangePassword();

            ChangePassword cp = new ChangePassword(driver);
            cp.inputPassword(newPwd);
            cp.inputConfirmPass(newPwd);
            cp.ClickContinueBtn();

            myAccountPage.clickLogOut();
            myAccountPage.clickContinueBtn();

            hp.cLickMyAccount();
            hp.clickLogin();

            lp.setInputEmail(email);
            lp.setInputPassword(newPwd);
            lp.ClickLogin();

            Assert.assertTrue(
                    driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed(),
                    "Login failed - My Account page not displayed"
            );

        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("**** Finished T005_LoginAfterChangingThePassword Test ****");
    }
}