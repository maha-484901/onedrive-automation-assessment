package utils;

import static utils.WebDriverUtils.driver;
import utils.WebDriverUtils;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import pageobject.LoginPage;

public class LoginPageUtils {

	public static void loadUrl(String url) {
		//WebDriverUtils webDriverUtils = new WebDriverUtils();
		// webDriverUtils.getDriver().get(url);
		WebDriverUtils.driver.get(url);
	}

	public static void clickSignIn() {

		driver.findElement(By.linkText(LoginPage.LINK_SIGN_IN)).click();
	}

	public static void fillInUsername(String username) {
		driver.switchTo().frame(WebDriverUtils.driver.findElement(By.xpath(LoginPage.IFRAME_SIGNIN)));

		driver.findElement((By.xpath(LoginPage.INPUT_EMAIL))).sendKeys(username);
		driver.findElement(By.xpath(LoginPage.BTN_NEXT)).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public static void fillInPassword(String password) {
		driver.findElement(By.xpath(LoginPage.INPUT_PASSWORD)).sendKeys(password);
	}

	public static void signIn() {
		driver.findElement(By.xpath(LoginPage.BTN_SIGN_IN)).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

}
