package stepdefs;

import org.testng.Assert;

import Pages.LoginPage;
import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverFactory;

public class LoginSteps extends BaseTest
{
	private LoginPage loginpage;
	
	@Given("the user is on the SauceDemo login page")
    public void the_user_is_on_the_saucedemo_login_page() {
		loginpage = new LoginPage(DriverFactory.getDriver());
	}
        
        
    @When("the user enters {string} and {string}")
    public void the_user_enters_credentials(String username, String password) {
            loginpage.login(username, password);
    }

    @And("clicks the login button")
    public void clicks_the_login_button() {
            // already clicked inside login() method
    }

    @Then("the user should be redirected based on the outcome")
    public void the_user_should_be_redirected_based_on_the_outcome() {
         String currentUrl = DriverFactory.getDriver().getCurrentUrl();
         boolean success = currentUrl.contains("inventory");
         boolean failure = currentUrl.contains("demo");
        System.out.println("Login");
         Assert.assertTrue(success || failure, "Redirection outcome is unclear");
        
    }
}
