package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class T004_LoginNavigationTest extends BaseClass {
        @Test
        public void verifyBrowserBack(){
            logger.info("***  LoginNavigationTest  ***");
            HomePage hp = new HomePage(driver);
            hp.cLickMyAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.setInputEmail(p.getProperty("email"));
            lp.setInputPassword(p.getProperty("newPassword"));
            lp.ClickLogin();

            driver.navigate().back();

            driver.get("https://tutorialsninja.com/demo/index.php?route=account/account");
            Assert.assertTrue(
                    driver.getCurrentUrl().contains("account/account"),
                    "User session lost after back navigation"
            );
        }
    }


