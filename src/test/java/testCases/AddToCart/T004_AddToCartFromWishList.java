package testCases.AddToCart;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

import java.time.Duration;

public class T004_AddToCartFromWishList extends BaseClass {
    @Test
    void verifyAddToCartFromWishlist(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        HomePage hp = new HomePage(driver);
        hp.cLickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.setInputEmail(p.getProperty("email"));
        lp.setInputPassword(p.getProperty("newPassword"));
        lp.ClickLogin();

        wait.until(ExpectedConditions.urlContains("account/account"));

       HomePage hp1 = new HomePage(driver);
       hp1.enterSearch(p.getProperty("searchProductName"));
       hp1.clickSearch();

        SearchPage sp = new SearchPage(driver);
        sp.setAddToWishListBtn();

        MyAccountPage ap = new MyAccountPage(driver);
        ap.goToWishlist();
        ap.addToCartFromWishlist(p.getProperty("searchProductName"));

        Assert.assertTrue(
                ap.getSuccessMessage().contains("Success"),
                "Add to cart from wishlist failed"
        );
    }
}
