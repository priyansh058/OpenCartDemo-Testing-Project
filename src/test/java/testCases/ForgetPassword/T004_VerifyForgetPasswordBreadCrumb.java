package testCases.ForgetPassword;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class T004_VerifyForgetPasswordBreadCrumb extends BaseClass {
    @Test
    void verifyForgotPasswordBreadcrumb() {

        HomePage hp = new HomePage(driver);
        hp.cLickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.ClickForgottenPass();

        String breadcrumb = driver.findElement(
                By.xpath("//ul[@class='breadcrumb']")
        ).getText();

        Assert.assertTrue(
                driver.findElement(By.xpath("//ul[@class='breadcrumb']//a")).isDisplayed()
        ); // Home icon

        Assert.assertTrue(
                driver.findElement(By.xpath("//a[normalize-space()='Account']")).isDisplayed()
        );

        Assert.assertTrue(
                driver.findElement(By.xpath("//ul[@class='breadcrumb']//li[normalize-space()='Forgotten Password']")).isDisplayed()
        );
    }
}
