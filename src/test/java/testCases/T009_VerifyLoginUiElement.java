package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;

public class T009_VerifyLoginUiElement extends BaseClass {
    @Test
    void verifyLoginPageUIElements() {

        HomePage hp = new HomePage(driver);
        hp.cLickMyAccount();
        hp.clickLogin();

        // Sections
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='New Customer']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Returning Customer']")).isDisplayed());

        // Fields
        Assert.assertTrue(driver.findElement(By.name("email")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.name("password")).isDisplayed());

        // Labels
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='E-Mail Address']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Password']")).isDisplayed());

        // Buttons & links
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Login']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Continue']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("Forgotten Password")).isDisplayed());
    }
}