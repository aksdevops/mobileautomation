package com.swaglabs.pages;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.swaglabs.AppLaunchCapabilities.AppiumHelper;
import com.swaglabs.commonfunctions.CommonFunctions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductDashboardPage {

    public ProductDashboardPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumHelper.driverInit()), this);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    public MobileElement productsLbl;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Item\"]/descendant::*[@content-desc=\"test-Item title\"]")
    public List<MobileElement> productName;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Item\"]/descendant::*[@content-desc=\"test-ADD TO CART\"]")
    public MobileElement addProduct;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
    public MobileElement cart;
    
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]")
    public MobileElement productToBeRemoved;

    public void verifyDashboardPage(CommonFunctions comfun) {
        comfun.waitCondition(productsLbl);
        assertTrue("Not On Dashboard Page", comfun.isElementPresent(productsLbl));
    }

    public void addProduct(CommonFunctions comfun) {
        for (int i = 0; i < productName.size(); i++) {
            String text=comfun.getText(productName.get(i));
            comfun.click(addProduct);
            verifyAddedProduct(comfun,text);
        }
    }
    
    public void verifyAddedProduct(CommonFunctions comfun,String text) {
        comfun.click(cart);
        Boolean verifyAddedProd=comfun.findElementByString(text).getText().equals(text);
        assertTrue("Not Added", verifyAddedProd);
        comfun.navigateBack();
    }

    public void deleteProduct(CommonFunctions comfun) {
        for (int i = 0; i < productName.size(); i++) {
            String text=comfun.getText(productName.get(i));
            comfun.click(productToBeRemoved);
            verifyDeletedProductCart(comfun,text);
        }
    }

    public void verifyDeletedProductCart(CommonFunctions comfun,String text) {
        comfun.click(cart);
        assertNull("Not Deleted", comfun.findElementByString(text));
        comfun.navigateBack(); 
    }
    
    public void addDeleteProduct(CommonFunctions comfun) {
        for (int i = 0; i < productName.size(); i++) {
            comfun.click(addProduct);
            assertTrue("Add Product Not Displayed", comfun.isElementPresent(productToBeRemoved));
            comfun.click(cart);
            comfun.click(productToBeRemoved);
            comfun.navigateBack();
        }
    }
    
    public void verifyDeletedProductDashboard(CommonFunctions comfun) {
        assertTrue("Add Product Not Displayed", comfun.isElementPresent(addProduct));
        assertFalse("Remove Product is Displayed", comfun.isElementPresent(productToBeRemoved));
    }
}
