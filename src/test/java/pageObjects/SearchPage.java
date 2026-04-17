package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage extends basePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    // Product names
    @FindBy(xpath = "//div[@class='product-thumb']//h4/a")
    List<WebElement> productNames;

    // All product cards
    @FindBy(xpath = "//div[@class='product-thumb']")
    List<WebElement> products;

    // Add to cart buttons
    @FindBy(xpath = "//button[@data-original-title='Add to Cart']")
    List<WebElement> addToCartBtns;

    // Success message
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successMsg;

    // No result message
    @FindBy(xpath = "//p[contains(text(),'no product')]")
    WebElement noResultMsg;

    // Category dropdown
    @FindBy(name = "category_id")
    WebElement categorySelect;

    // Checkbox (FIXED)
    @FindBy(xpath = "//input[@name='description']")
    WebElement chkDescription;

    @FindBy(xpath = "//input[@name='sub_category']")
    WebElement chkSubCategory;

    // Search input
    @FindBy(id = "input-search")
    WebElement searchCriteria;

    // Search button
    @FindBy(id = "button-search")
    WebElement advSearchBtn;


    @FindBy(xpath = "//button[@type='button']//i[@class='fa fa-heart']")
    WebElement addToWishListBtn;


    // ---------------- METHODS ----------------

    public void enterSearchCriteria(String keyword) {
        searchCriteria.clear();
        searchCriteria.sendKeys(keyword);
    }

    public void clickAdvSearchBtn() {
        advSearchBtn.click();
    }

    public void selectSearchInDescription() {
        if (!chkDescription.isSelected()) {
            chkDescription.click();
        }
    }

    public void clickSubCategory() {
        if (!chkSubCategory.isSelected()) {
            chkSubCategory.click();
        }
    }

    public void setCategorySelect(String categoryName) {
        Select select = new Select(categorySelect);
        select.selectByVisibleText(categoryName);
    }

    public boolean isProductDisplayed(String expectedProduct) {
        for (WebElement product : productNames) {
            if (product.getText().equalsIgnoreCase(expectedProduct)) {
                return true;
            }
        }
        return false;
    }

    public int getProductCount() {
        return products.size();
    }

    public String getNoResultMessage() {
        return noResultMsg.getText();
    }

    public String getSuccessMessage() {
        return successMsg.getText();
    }

    public void selectProduct(String productName) {
        for (WebElement product : productNames) {
            if (product.getText().equalsIgnoreCase(productName)) {
                product.click();
                break;
            }
        }
    }

    public void clickAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> buttons = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//button[@data-original-title='Add to Cart']")
                )
        );

        buttons.get(0).click();
    }

    public boolean areAllProductsRelevant(String keyword) {
        for (WebElement product : productNames) {
            if (!product.getText().toLowerCase().contains(keyword.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public void setAddToWishListBtn(){
        addToWishListBtn.click();
    }
}