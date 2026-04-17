package testCases.SearchFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class T006_VerifySearchCategory extends BaseClass {
    @Test(priority = 1)
    void verifySearchWithCorrectCategory(){
        HomePage hp =new HomePage(driver);
        hp.clickSearch();

        SearchPage sp = new SearchPage(driver);
        sp.enterSearchCriteria(p.getProperty("searchProductName"));
        sp.setCategorySelect("Mac");

        sp.clickAdvSearchBtn();

        Assert.assertTrue(
                sp.isProductDisplayed(p.getProperty("searchProductName")) && sp.getProductCount() >= 1,
                "Expected product not displayed"
        );
    }

    @Test(priority = 2)
    void verifySearchWithWrongCategory(){
        HomePage hp =new HomePage(driver);
        hp.clickSearch();

        SearchPage sp = new SearchPage(driver);
        sp.enterSearchCriteria(p.getProperty("searchProductName"));
        sp.setCategorySelect("PC");

        sp.clickAdvSearchBtn();
        Assert.assertTrue(
                sp.getNoResultMessage().contains("no product"),
                "Expected no results message not displayed"
        );
    }

}
