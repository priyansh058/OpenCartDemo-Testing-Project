package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class T002_LoginTest extends BaseClass {
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void  VerifyLoginTest(String email, String pwd, String exp){
        logger.info("*** Test Start T002_LoginTest *** ");
        System.out.println("Running → Email: " + email + " | Password: " + pwd + " | Expected: " + exp);
        try{
            //Home Page
            HomePage hp = new HomePage(driver);
            hp.cLickMyAccount();
            hp.clickLogin();

            //LogIn page
            LoginPage lp = new LoginPage(driver);
            lp.setInputEmail(email);
            lp.setInputPassword(pwd);
            lp.ClickLogin();

            //MyAccount Page
            MyAccountPage myAccPage = new MyAccountPage(driver);
            boolean targetPage = myAccPage.isMyAccountPageExits();

            if(exp.equalsIgnoreCase("Valid")) {
                if (targetPage == true) {
                    myAccPage.clickLogOut();
                    myAccPage.clickContinueBtn();
                    System.out.println("Result → Email: " + email + " | Expected: " + exp + " | Actual: " + targetPage);
                    Assert.assertTrue(true);
                } else {
                    System.out.println("Result → Email: " + email + " | Expected: " + exp + " | Actual: " + targetPage);
                    Assert.assertTrue(false);
                }
            }

            if(exp.equalsIgnoreCase("Invalid")) {
                if (targetPage == true) {
                    myAccPage.clickLogOut();
                    myAccPage.clickContinueBtn();
                    System.out.println("Result → Email: " + email + " | Expected: " + exp + " | Actual: " + targetPage);
                    Assert.assertTrue(false);
                } else {
                    System.out.println("Result → Email: " + email + " | Expected: " + exp + " | Actual: " + targetPage);
                    Assert.assertTrue(true);
                }
            }

        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("**** Finished T002_LoginTest ****");
        }
    }

