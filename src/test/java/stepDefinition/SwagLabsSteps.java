package stepDefinition;

import com.swaglabs.commonfunctions.CommonFunctions;
import com.swaglabs.context.TestContext;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.pages.ProductDashboardPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SwagLabsSteps {
    private LoginPage loginPage;
    private ProductDashboardPage dashboardPage;
    TestContext testContext;
    CommonFunctions comfun = Setup.com_fun;
    public SwagLabsSteps(TestContext context) {
        testContext = context;
        loginPage=testContext.getPageObjectManagerInstance().getloginPage();
        dashboardPage=testContext.getPageObjectManagerInstance().getDashboardPage();
        
    }
    
    @Given("User launches the Mobile Application to land on Welcome Page")
    public void onb_User_launches_the_Mobile_Application_to_land_on_Welcome_Page() throws InterruptedException {
        loginPage.verifyFirstPage(comfun);
    }
    
    @When("User performs login with username {string} and password {string}")
    public void user_performs_login(String uname,String pwd) throws InterruptedException {
        loginPage.login(comfun, uname, pwd);
    }
    
    @Then("User should be able to land on Dashboard page")
    public void user_lands_on_dashboard() throws InterruptedException {
        dashboardPage.verifyDashboardPage(comfun);
    }
    
    @When("User Add and verify added Product in checkoutflow")
    public void user_add_product() throws InterruptedException {
        dashboardPage.addProduct(comfun);
    }
    
    @When("User Delete and verify deleted Product in checkoutflow")
    public void user_delete_product() throws InterruptedException {
        dashboardPage.deleteProduct(comfun);
    }
    
    @When("User Add and delete added Product in checkoutflow")
    public void add_delete_product() throws InterruptedException {
        dashboardPage.addDeleteProduct(comfun);
    }
    
    @When("Verify the deleted Product is ready to be added again from dashboard")
    public void verify_deleted_product_on_dashboard() throws InterruptedException {
        dashboardPage.verifyDeletedProductDashboard(comfun);
    }

}
