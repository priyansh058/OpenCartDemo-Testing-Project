package testCases.LogOut;
import testBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class T001_LogOutByDropMenu extends BaseClass {
@Test
    void verifyLogoutFromMyAccountDropdown(){

    HomePage hp = new HomePage(driver);
    hp.cLickMyAccount();
    hp.clickLogin();

    LoginPage lp = new LoginPage(driver);
    lp.setInputEmail(p.getProperty("email"));
    lp.setInputPassword(p.getProperty("newPassword"));
    lp.ClickLogin();

    Assert.assertTrue(
            driver.getCurrentUrl().contains("account/account"),
            "Login failed before logout"
    );

    hp.clickLogOut();

    Assert.assertTrue(
            driver.getCurrentUrl().contains("account/logout"),
            "Logout failed"
    );
  }
}

