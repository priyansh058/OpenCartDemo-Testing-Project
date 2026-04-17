package testCases.LogOut;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;

public class T004_VerifyLogOutNotVisiableBeforeLogIn extends BaseClass {
    @Test
    void verifyLogoutNotVisibleBeforeLogin(){

        HomePage hp = new HomePage(driver);
        hp.cLickMyAccount();

        Assert.assertFalse(
                hp.isLogoutVisible(),
                "Logout option should NOT be visible before login"
        );
    }
}
