package testCases.SearchFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class T002_EmptySearch extends BaseClass {
    @Test
    void verifyEmptySearch() {
        HomePage hp = new HomePage(driver);
        hp.clickSearch();

        SearchPage sp = new SearchPage(driver);

        Assert.assertTrue(
                sp.getNoResultMessage().contains("There is no product"),
                "Empty search failed"
        );
    }
}

