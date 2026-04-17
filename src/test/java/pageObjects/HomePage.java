package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage  extends basePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement linkMyAccount;
    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement linkRegister;
    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement linkLogin;
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement txtSearch;
    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement btnSearch;


    public void cLickMyAccount() {
        linkMyAccount.click();
    }

    public void clickRegister() {
        linkRegister.click();
    }

    public void clickLogin() {
        linkLogin.click();
    }

    public void enterSearch(String Product) {
        txtSearch.clear();
        txtSearch.sendKeys(Product);
    }

    public void clickSearch() {
        btnSearch.click();
    }

    public void clickLogOut() {
        linkMyAccount.click();  // open dropdown first
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
    }

    public boolean isLogoutVisible() {
        return !driver.findElements(By.xpath("//a[contains(@href,'logout')]")).isEmpty();
    }


    @FindBy(xpath = "//a[normalize-space()='Desktops']")
    WebElement menuDesktops;

    @FindBy(xpath = "//a[contains(text(),'Show All Desktops')]")
    WebElement showAllDesktops;

    @FindBy(xpath = "//a[normalize-space()='Mac']")
    WebElement macSubCategory;

    public void navigateToDesktopsMac() {

        Actions act = new Actions(driver);

        // Step 1: move to main menu
        act.moveToElement(menuDesktops).perform();

        // Step 2: small wait (UI animation)
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }

        // Step 3: move slightly offset to trigger dropdown
        act.moveByOffset(10, 10).perform();

        // Step 4: NOW find and click
        WebElement showAll = driver.findElement(
                By.xpath("//a[text()='Show AllDesktops']")
        );

        showAll.click();

        driver.findElement(By.linkText("Mac (1)")).click();

    }
    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueBtn;
    public void clickContinueBtn() {
        continueBtn.click();
    }
}


