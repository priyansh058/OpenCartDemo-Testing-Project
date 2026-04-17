package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class T007_allOfWaysLogInNevigation extends BaseClass {
    @Test
    void verifyLogInNavigation() {

        HomePage hp = new HomePage(driver);

        // Way 1: My Account → Login
        hp.cLickMyAccount();
        hp.clickLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains("account/login"));

        // Way 2: Register → Login link
        driver.navigate().back();
        hp.cLickMyAccount();
        hp.clickRegister();

        AccountRegisterPage rp = new AccountRegisterPage(driver);
        rp.clickLogInLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("account/login"));

        // Way 3: Right panel → Login
        LoginPage lp = new LoginPage(driver);
        lp.clickRightLogin();

        Assert.assertTrue(driver.getCurrentUrl().contains("account/login"));
    }}