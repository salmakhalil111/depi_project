package tests;

import base.BaseTestTwo;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

// Feature 4: Filter products by Category or Brand
public class ProductFilterTests extends BaseTestTwo {

    // TC01: Category sidebar is visible on products page
    @Test(priority = 1)
    public void categorySidebarVisible() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        Assert.assertTrue(products.isCategorySidebarVisible(),
                "Category sidebar should be visible");
    }

    // TC02: Click on "Women" category expands the list (sub-category appears clickable)
    @Test(priority = 2)
    public void filterByWomenDressSubCategory() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        products.openWomenSubCategory("Dress");
        String title = products.getCategoryTitle().toLowerCase();
        Assert.assertTrue(title.contains("women") && title.contains("dress"),
                "Page title should reflect Women - Dress filter. Actual: " + title);
    }

    // TC03: Filter by Men - Tshirts
    @Test(priority = 3)
    public void filterByMenTshirtsSubCategory() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        products.clickMenCategory();
        org.openqa.selenium.By sub =
                org.openqa.selenium.By.xpath("//div[@id='Men']//a[normalize-space()='Tshirts']");
        products.click(sub);
        String title = products.getCategoryTitle().toLowerCase();
        Assert.assertTrue(title.contains("men") && title.contains("tshirts"),
                "Page title should reflect Men - Tshirts filter. Actual: " + title);
    }

    // TC04: Brands sidebar is visible
    @Test(priority = 4)
    public void brandsSidebarVisible() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        Assert.assertTrue(products.isBrandsSidebarVisible(),
                "Brands sidebar should be visible");
    }

    // TC05: Filter by brand "Polo"
    @Test(priority = 5)
    public void filterByPoloBrand() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        products.clickBrand("Polo");
        String title = products.getBrandResultTitle().toLowerCase();
        Assert.assertTrue(title.contains("polo"),
                "Brand title should contain 'Polo'. Actual: " + title);
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("polo"),
                "URL should contain the brand name");
    }
}
