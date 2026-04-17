package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;



public class T010_BrowserBackAfterLogout extends BaseClass {
    @Test
    void verifyBrowserBack(){
        HomePage hp = new HomePage(driver);
        hp.cLickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.setInputEmail(p.getProperty("email"));
        lp.setInputPassword(p.getProperty("newPassword"));
        lp.ClickLogin();

        hp = new HomePage(driver);
        hp.cLickMyAccount();
        hp.clickLogOut();

        driver.navigate().back();
        driver.navigate().refresh();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("account/login"),
                "User is still logged in after logout + back"
        );
    }
}
