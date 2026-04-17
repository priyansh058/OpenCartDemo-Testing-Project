package testCases.SearchFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class T005_SearchInProductDescription extends BaseClass {
    @Test
    void verifySearchInProductDescription(){

        HomePage hp = new HomePage(driver);
        hp.clickSearch();

        SearchPage sp = new SearchPage(driver);
        sp.enterSearchCriteria("iLife");
        sp.selectSearchInDescription();
        sp.clickAdvSearchBtn();

        Assert.assertTrue(
                sp.isProductDisplayed("iMac"),
                "Expected product not displayed"
        );
    }
}
