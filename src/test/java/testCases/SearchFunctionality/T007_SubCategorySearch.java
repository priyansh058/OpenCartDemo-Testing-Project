package testCases.SearchFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class T007_SubCategorySearch extends BaseClass {
    @Test(priority = 1)
    void verifySearchWithOFFSubCategoryOn(){
        HomePage hp =new HomePage(driver);
        hp.clickSearch();

        SearchPage sp = new SearchPage(driver);
        sp.enterSearchCriteria("iMac");
        sp.setCategorySelect("Desktops");

        sp.clickAdvSearchBtn();

        Assert.assertTrue(
                sp.getProductCount() == 0,
                "Products displayed even when subcategory OFF"
        );
    }

    @Test(priority = 2)
    void verifySearchWithOnSubCategory(){
        HomePage hp =new HomePage(driver);
        hp.clickSearch();

        SearchPage sp = new SearchPage(driver);
        sp.enterSearchCriteria("iMac");
        sp.setCategorySelect("Desktops");
        sp.clickSubCategory();

        sp.clickAdvSearchBtn();

        Assert.assertTrue(
                sp.isProductDisplayed("iMac") && sp.getProductCount() >= 1,
                "Expected product not displayed"
        );
    }


}
