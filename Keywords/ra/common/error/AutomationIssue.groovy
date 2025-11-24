package ra.common.error

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.RemoteWebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class AutomationIssue {
	WebDriver driver = DriverFactory.getWebDriver()

	@Keyword
	def causeSessionNotFoundException() {
		WebUI.closeBrowser()
		driver.getTitle()
	}

	@Keyword
	def causeNoSuchDriverException() {
		ChromeOptions options = new ChromeOptions()
		options.setBinary('/invalid/path/to/browser') // Invalid browser path
		new ChromeDriver(options)
	}

	@Keyword
	def causeSessionNotCreatedException() {
		ChromeOptions options = new ChromeOptions()
		options.addArguments("--user-data-dir=/invalid/path/to/profile")
		new ChromeDriver(options)
	}

	@Keyword
	def causeUnknownMethodException() {
		driver.executeScript("return window.someNonExistentFunction();")
	}

	@Keyword
	def causeNoSuchFrameException() {
		driver.switchTo().frame("nonexistent")
	}

	@Keyword
	def causeNoSuchWindowException() {
		driver.switchTo().window("nonexistent");
	}
}
