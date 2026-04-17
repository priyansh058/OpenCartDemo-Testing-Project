package testCases.LogOut;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

import java.time.Duration;

public class T002_LogOutByRightColumn  extends BaseClass {
    @Test
    void verifyLogoutFromMyAccountDropdown() {

        HomePage hp = new HomePage(driver);
        hp.cLickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.setInputEmail(p.getProperty("email"));
        lp.setInputPassword(p.getProperty("newPassword"));
        lp.ClickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("account/account"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("account/account"),
                "Login failed before logout"
        );

        MyAccountPage ap = new MyAccountPage(driver);
        ap.clickLogOut();
        wait.until(ExpectedConditions.urlContains("account/logout"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("account/logout"),
                "Logout failed"
        );
    }
}
