package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import utils.LoginPageUtils;

public class LoginPageStepDef {

	@Given("^I am on the One Drive Home page URL ([^\\\"]*)$")
	public void i_am_on_the_page_on_URL(String url) {
		// Write code here that turns the phrase above into concrete actions
		LoginPageUtils.loadUrl(url);
		LoginPageUtils.clickSignIn();

	}

	@When("^I fill in Username with ([^\"]*) and click Next$")
	public void i_fill_in_username(String username) throws Throwable {
		LoginPageUtils.fillInUsername(username);
	}

	@When("^I fill in Password with ([^\"]*) and click Sign In$")
	public void i_fill_in_with_password(String password) throws Throwable {
		LoginPageUtils.fillInPassword(password);
		LoginPageUtils.signIn();
	}

}
