package testCases.AddToCart;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class T002_AddToCartFromSearchResult extends BaseClass {
    @Test
    void verifyAddToCartFromProductPage(){

        HomePage hp = new HomePage(driver);
        hp.enterSearch(p.getProperty("searchProductName"));
        hp.clickSearch();

        SearchPage sp = new SearchPage(driver);
        sp.selectProduct(p.getProperty("searchProductName"));

        ProductPage pp = new ProductPage(driver);
        pp.clickAddToCart();

        Assert.assertTrue(
                pp.getSuccessMessage().contains("Success"),
                "Product not added to cart"
        );
    }
}
