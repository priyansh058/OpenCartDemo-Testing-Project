package testCases.AddToCart;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class T004_AddToCartFromWishList extends BaseClass {
    @Test
    void verifyAddToCartFromWishlist(){

        HomePage hp = new HomePage(driver);
        hp.cLickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.setInputEmail(p.getProperty("email"));
        lp.setInputPassword(p.getProperty("newPassword"));
        lp.ClickLogin();

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
