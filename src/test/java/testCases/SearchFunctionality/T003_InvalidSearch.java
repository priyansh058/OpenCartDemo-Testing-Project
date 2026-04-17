package testCases.SearchFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class T003_InvalidSearch extends BaseClass {
    @Test(dataProvider = "searchData", dataProviderClass = DataProviders.class)
    void verifyInvalidSearch(String keyword){

        HomePage hp = new HomePage(driver);
        hp.enterSearch(keyword);
        hp.clickSearch();

        SearchPage sp = new SearchPage(driver);

        Assert.assertTrue(
                sp.getNoResultMessage().contains("There is no product"),
                "Failed for keyword: " + keyword
        );
    }
}
