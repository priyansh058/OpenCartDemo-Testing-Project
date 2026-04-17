package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;

public class T008_VerifyLogInPageUI extends BaseClass {
    @BeforeMethod
    void setUpPage() {
        HomePage hp = new HomePage(driver);
        hp.cLickMyAccount();
        hp.clickLogin();
    }
    @Test (priority = 0)
    void pageURL(){
        Assert.assertTrue(driver.getCurrentUrl().contains("account/login"));
    }

    @Test (priority = 1)
    void pageTitle(){
        Assert.assertEquals(driver.getTitle(), "Account Login");
    }

    @Test (priority = 2)
    void pageHeading(){
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Returning Customer']")).isDisplayed());
    }

    @Test (priority = 3)
    void breadcrumb(){
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']")).getText().contains("Login"));
    }
}
