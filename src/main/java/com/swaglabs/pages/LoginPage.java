package com.swaglabs.pages;

import static org.junit.Assert.assertTrue;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.support.PageFactory;

import com.swaglabs.AppLaunchCapabilities.AppiumHelper;
import com.swaglabs.commonfunctions.CommonFunctions;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumHelper.driverInit()), this);
    }

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-Login\"]/android.view.ViewGroup/android.widget.ImageView[1]")
    public MobileElement welcomePageLbl;
    
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    public MobileElement username;
    
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    public MobileElement password;
  
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    public MobileElement submit;
            
    public void verifyFirstPage(CommonFunctions comfun) throws InterruptedException {
        comfun.waitCondition(welcomePageLbl);
        assertTrue("Not On Welcome Page", comfun.isElementPresent(welcomePageLbl));
    }
    
    public void login(CommonFunctions comfun,String uname,String pwd) {
        comfun.sendkeys(username, uname);
        comfun.sendkeys(password, pwd);
        comfun.click(submit);      
    }

}
