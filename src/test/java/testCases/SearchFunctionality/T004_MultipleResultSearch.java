package testCases.SearchFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class T004_MultipleResultSearch extends BaseClass {
    @Test
    void verifyMultipleResultsSearch(){

        HomePage hp = new HomePage(driver);
        hp.enterSearch("Mac");
        hp.clickSearch();

        SearchPage sp = new SearchPage(driver);

        //Count validation
        Assert.assertTrue(
                sp.getProductCount() > 1,
                "Less than expected products"
        );

        //Content validation
        Assert.assertTrue(
                sp.areAllProductsRelevant("Mac"),
                "Irrelevant products found in results"
        );
    }
}
