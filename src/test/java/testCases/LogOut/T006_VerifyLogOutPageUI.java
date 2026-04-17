package testCases.LogOut;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class T006_VerifyLogOutPageUI extends BaseClass {
    @Test
    void verifyLogoutPageUI(){

        HomePage hp = new HomePage(driver);
        hp.cLickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.setInputEmail(p.getProperty("email"));
        lp.setInputPassword(p.getProperty("newPassword"));
        lp.ClickLogin();

        MyAccountPage myAccPage = new MyAccountPage(driver);
        myAccPage.clickLogOut();

        // Page heading
        Assert.assertTrue(
                driver.findElement(By.xpath("//h1[text()='Account Logout']")).isDisplayed()
        );
        // URL
        Assert.assertTrue(
                driver.getCurrentUrl().contains("account/logout")
        );
        // Continue button
        Assert.assertTrue(
                driver.findElement(By.xpath("//a[text()='Continue']")).isDisplayed()
        );
        // Breadcrumb
        Assert.assertTrue(
                driver.findElement(By.xpath("//ul[@class='breadcrumb']")).getText().contains("Logout")
        );
    }
}
