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

public class T005_VerifyLogOutLogInImmediateAfterLogOut extends BaseClass {

    @Test
    void VerifyLogOutLogInImmediateAfterLogOut() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ===== Step 1: Navigate to Login =====
        HomePage hp = new HomePage(driver);
        hp.cLickMyAccount();
        hp.clickLogin();

        // ===== Step 2: Login =====
        LoginPage lp = new LoginPage(driver);
        lp.setInputEmail(p.getProperty("email"));
        lp.setInputPassword(p.getProperty("newPassword"));
        lp.ClickLogin();

        // Wait for successful login
        wait.until(ExpectedConditions.urlContains("account/account"));

        MyAccountPage myAccPage = new MyAccountPage(driver);
        Assert.assertTrue(
                myAccPage.isMyAccountPageExists(),
                "Login failed before logout"
        );

        // ===== Step 3: Logout =====
        myAccPage.clickLogOut();

        // Wait for logout page
        wait.until(ExpectedConditions.urlContains("account/logout"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("account/logout"),
                "Logout failed"
        );

        // ===== Step 4: Click Continue (goes to Home) =====
        HomePage homeAfterLogout = new HomePage(driver);
        homeAfterLogout.clickContinueBtn();

        // ===== Step 5: Login Again Immediately =====
        homeAfterLogout.cLickMyAccount();
        homeAfterLogout.clickLogin();

        LoginPage lp2 = new LoginPage(driver);
        lp2.setInputEmail(p.getProperty("email"));
        lp2.setInputPassword(p.getProperty("newPassword"));
        lp2.ClickLogin();

        // Wait for login again
        wait.until(ExpectedConditions.urlContains("account/account"));

        MyAccountPage myAccPage2 = new MyAccountPage(driver);
        Assert.assertTrue(
                myAccPage2.isMyAccountPageExists(),
                "Login failed after immediate logout"
        );
    }
}