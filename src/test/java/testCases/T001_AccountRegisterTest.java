package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class T001_AccountRegisterTest extends BaseClass {

    @Test
    void verify_account_registration() {
        try {
            logger.info("**** Start the Case T001_AccountRegisterTest **** ");
            HomePage hp = new HomePage(driver);
            hp.cLickMyAccount();
            logger.info("Clicked on my account");
            hp.clickRegister();
            logger.info("Clicked on Register Link");

            AccountRegisterPage regPage = new AccountRegisterPage(driver);

            logger.info("Providing Customer Info..");
            regPage.setFirstName(randomeString().toUpperCase());
            regPage.setLastName(randomeString().toUpperCase());
            regPage.setEmail(randomeString() + "@gmail.com");
            regPage.setTelephone(randomeNumber());
            String Password = randomeAlphaNumberic();
            regPage.setPassword(Password);
            regPage.setConfirmPass(Password);
            regPage.setPolicy();
            regPage.setBtnContinue();

            logger.info("Validating Expected Message....");
            String comMsg = regPage.getConformationMsg();
            if (comMsg.equals("Your Account Has Been Created!")) {
                Assert.assertTrue(true);
            } else {
                logger.error("Test Failed...");
                logger.debug("Debug logs...");
                Assert.assertTrue(false);
            }
        }
         catch (Exception e) {
            Assert.fail();
        }
        logger.info("**** Finished T001_AccountRegisterTest ****");
    }
}
