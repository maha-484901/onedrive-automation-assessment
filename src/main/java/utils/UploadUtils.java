package utils;

import static utils.WebDriverUtils.driver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobject.UploadPage;

public class UploadUtils {

	public static void upload(String filename, boolean zeroByte) throws InterruptedException {

		// wait until "Documents" folder is available
		WebElement element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(UploadPage.DOCUMENT_FOLDER)));

		element.click();

		// send file path to hidden upload input
		driver.findElement(By.xpath(UploadPage.UPLOAD_INPUT)).sendKeys(filename);

		// if not a zero byte file
		if (!zeroByte) {
			// click file info icon
			driver.findElement(By.xpath(UploadPage.UPLOAD_FILE_META_BTN)).click();

			// file meta info
			WebElement fileMetaPathElem = driver.findElement(By.cssSelector(UploadPage.FILE_META_PATH));
			// check if the file meta info has the word "Documents" shows that it uploaded
			// in "Documents" folder
			if (null == fileMetaPathElem || !fileMetaPathElem.getText().equalsIgnoreCase("Documents")) {
				throw new RuntimeException("file uploaded in invalid path");
			}

		} else {
			// zero byte file upload error element
			WebElement uploadStatusElem = driver.findElement(By.xpath(UploadPage.ZERO_BYTE_FILE_UPLOAD_ERROR_ELEMENT));
			// check and throw error is no error message is present
			if (uploadStatusElem == null || !uploadStatusElem.getText()
					.equalsIgnoreCase("Sorry, OneDrive can't upload empty folders or empty files. Please try again.")) {
				throw new RuntimeException("Error verifying file upload");
			}

		}
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void editUploadedFileInOneDriveEditor(String modifiedFileContent) throws InterruptedException {

		// click file
		driver.findElement(By.xpath(UploadPage.FILE_LINK)).click();
		Thread.sleep(2000);

		// click file open
		driver.findElement(By.xpath(UploadPage.FILE_OPEN)).click();
		Thread.sleep(2000);

		// click file open in text editor
		driver.findElement(By.xpath(UploadPage.FILE_OPEN_TEXT_EDITOR)).click();
		Thread.sleep(2000);

		// retain parent window for furture use
		String parentWinHandle = driver.getWindowHandle();

		// switch to new window
		Set<String> winHandles = driver.getWindowHandles();

		for (String handle : winHandles) {
			if (!handle.equals(parentWinHandle)) {
				driver.switchTo().window(handle);

			}
		}

		// edit file content
		WebElement e = driver.findElement(By.className(UploadPage.FILE_EDITOR_FIRST_LINE));

		Actions actions = new Actions(driver);
		actions.moveToElement(e, 0, -1);
		actions.click().sendKeys(modifiedFileContent);

		Thread.sleep(1000);
		actions.build().perform();

		// click file save
		driver.findElement(By.xpath(UploadPage.FILE_SAVE)).click();
		Thread.sleep(2000);

		// Switching the control back to parent window
		// driver.switchTo().window(parentWinHandle);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public static void verifyVersionHistory(String modifiedFileContent, String fileLoc)
			throws InterruptedException, IOException {

		// click version history
		driver.findElement(By.xpath(UploadPage.FILE_VERSION_HISTORY_BTN)).click();
		Thread.sleep(3000);

		// new version file click to download
		driver.findElement(By.xpath(UploadPage.NEW_VERSION_FILE_LINK)).click();

		// old version file click to download
		driver.findElement(By.xpath(UploadPage.OLD_VERSION_FILE_LINK)).click();
		Thread.sleep(2000);

		// read file
		String newFileContent = readFile(modifiedFileContent, fileLoc);
		String oldFileContent = readFile(modifiedFileContent, fileLoc.replace(".txt", " (1).txt"));

		if (!newFileContent.equalsIgnoreCase(modifiedFileContent)
				&& oldFileContent.equalsIgnoreCase(modifiedFileContent)) {
			throw new RuntimeException("file not saved properly");
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static String readFile(String modifiedFileContent, String fileLoc) {

		StringBuilder sb = new StringBuilder();
		// try with resource closes fileReader object when done
		try (FileReader fileReader = new FileReader(fileLoc)) {

			int ch;
			while ((ch = fileReader.read()) != -1) {
				sb.append((char) ch);
			}
		} catch (IOException e) {
			throw new RuntimeException("error occured while reading file");
		}

		return sb.toString();
	}

	public static void deleteFile() throws InterruptedException {

		// click the version history close icon
		driver.findElement(By.xpath(UploadPage.VERSION_HISTORY_CLOSE_ICON)).click();

		Thread.sleep(2000);
		// click the delete icon
		driver.findElement(By.xpath(UploadPage.DELETE_BUTTON)).click();
		
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
}