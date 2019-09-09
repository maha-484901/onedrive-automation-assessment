package hooks;

import utils.WebDriverUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class WebHooks {

	@Before
	public void setup() {
		new WebDriverUtils().getDriver();
	}

	@After
	public void tearDown(Scenario scenario) {
		try {
			WebDriverUtils.driver.quit();
			if (scenario.isFailed()) {
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}