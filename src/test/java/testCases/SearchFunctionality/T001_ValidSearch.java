package testCases.SearchFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class T001_ValidSearch extends BaseClass {
    @Test
    void verifyValidSearch() {
        HomePage hp = new HomePage(driver);
        hp.enterSearch("iMac");
        hp.clickSearch();

        SearchPage sp = new SearchPage(driver);
        Assert.assertTrue(sp.isProductDisplayed(p.getProperty("searchProductName")),
                "Product not found in search result");
    }
}