package testCases.LogOut;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class T003_VerifyLogOutNotDisplayRightCol extends BaseClass {
    @Test
    void VerifyLogOutNotDisplayAtRightCol(){

        HomePage hp = new HomePage(driver);
        hp.cLickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        Assert.assertFalse(
                lp.isRightLogoutVisible(),
                "Logout option should NOT be visible before login"
        );
    }
}
