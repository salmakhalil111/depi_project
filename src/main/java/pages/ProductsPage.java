package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

// ProductsPage: the /products page (catalog, search, category and brand filters)
public class ProductsPage extends BasePage {

    // ---- Locators ----
    By allProductsHeader = By.xpath("//h2[normalize-space()='All Products']");
    By productCards      = By.cssSelector(".features_items .product-image-wrapper");
    By productNames      = By.cssSelector(".features_items .productinfo p");
    By productPrices     = By.cssSelector(".features_items .productinfo h2");
    By firstViewProduct  = By.cssSelector(".features_items .choose a[href*='/product_details/']");

    // search
    By searchInput   = By.id("search_product");
    By searchButton  = By.id("submit_search");
    By searchedHeader = By.xpath("//h2[normalize-space()='Searched Products']");

    // sidebar - category
    By categorySidebar = By.id("accordian");
    By womenCategory   = By.xpath("//a[@href='#Women']");
    By menCategory     = By.xpath("//a[@href='#Men']");
    By categoryTitle   = By.cssSelector(".features_items .title.text-center");

    // sidebar - brands
    By brandsTitle = By.xpath("//h2[normalize-space()='Brands']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://automationexercise.com/products");
    }

    // ---- Catalog ----
    public boolean isAllProductsHeaderVisible() { return isDisplayed(allProductsHeader); }
    public boolean isCategorySidebarVisible()   { return isDisplayed(categorySidebar); }
    public boolean isBrandsSidebarVisible()     { return isDisplayed(brandsTitle); }
    public int getProductCount()                { return countElements(productCards); }

    // get list of all product names on the page
    public List<String> getProductNames() {
        List<WebElement> elements = driver.findElements(productNames);
        List<String> names = new ArrayList<>();
        for (WebElement e : elements) {
            names.add(e.getText());
        }
        return names;
    }

    // get list of all product prices on the page
    public List<String> getProductPrices() {
        List<WebElement> elements = driver.findElements(productPrices);
        List<String> prices = new ArrayList<>();
        for (WebElement e : elements) {
            prices.add(e.getText());
        }
        return prices;
    }

    // open the first product's details page
    public ProductDetailsPage openFirstProductDetails() {
        scrollTo(firstViewProduct);
        click(firstViewProduct);
        return new ProductDetailsPage(driver);
    }

    // ---- Search ----
    public void searchFor(String keyword) {
        type(searchInput, keyword);
        click(searchButton);
    }

    public boolean isSearchedHeaderVisible() { return isDisplayed(searchedHeader); }

    // check that at least one result contains the keyword in its name
    public boolean atLeastOneResultContains(String keyword) {
        List<String> names = getProductNames();
        for (String name : names) {
            if (name.toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    // ---- Filter by category ----
    public void clickWomenCategory() {
        scrollTo(womenCategory);
        click(womenCategory);
    }

    public void clickMenCategory() {
        scrollTo(menCategory);
        click(menCategory);
    }

    // open a sub-category like "Dress" under Women
    public void openWomenSubCategory(String subCategoryName) {
        clickWomenCategory();
        By subCategory = By.xpath("//div[@id='Women']//a[normalize-space()='" + subCategoryName + "']");
        click(subCategory);
    }

    public String getCategoryTitle() {
        return getText(categoryTitle);
    }

    // ---- Filter by brand ----
    public void clickBrand(String brandName) {
        scrollTo(brandsTitle);
        By brand = By.xpath("//div[contains(@class,'brands_products')]//a[contains(text(),'" + brandName + "')]");
        click(brand);
    }

    public String getBrandResultTitle() {
        return getText(categoryTitle);
    }
}
