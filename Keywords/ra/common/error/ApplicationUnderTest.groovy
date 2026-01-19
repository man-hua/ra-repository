package ra.common.error
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory


public class ApplicationUnderTest {
	final String url = "https://mock.httpstatus.io/"
	WebDriver driver = DriverFactory.getWebDriver()

	@Keyword
	def causeNoSuchElementException() {
		WebElement element = driver.findElement(By.id("nonexist"))
		element.click()
	}

	@Keyword
	void causeJavascriptException() {
		JavascriptExecutor js = (JavascriptExecutor) driver
		js.executeScript("throw new Error('Simulated JS Error')")
	}

	@Keyword
	void causeElementClickInterceptedException() {
		WebElement clickElement = driver.findElement(By.id("kt_blockui_default"))
		WebElement overlay = driver.findElement(By.id("kt_blockui_page_default"))
		overlay.click()
		clickElement.click()
	}

	@Keyword
	void causeElementNotInteractableException_DisplayNone() {
		WebElement hiddenElement = driver.findElement(By.xpath("//button[text()='2']")) // element with CSS display:none
		hiddenElement.click()
	}

	@Keyword
	def causeElementNotInteractableException_Disabled() {
		WebElement frame = driver.findElement(By.id("iframeResult"))
		driver.switchTo().frame(frame)
		WebElement element = driver.findElement(By.id("lname"))
		element.sendKeys("text")
	}

	@Keyword
	void causeStaleElementReferenceException() {
		WebElement staleElement = driver.findElement(By.id("content"))
		WebElement button = driver.findElement(By.xpath("//a[text()='click here']"))
		button.click()
		staleElement.click()
	}

	@Keyword
	void causeUnauthorized() {
		def get = new URL("https://mock.httpstatus.io/401")
		get.text
	}

	@Keyword
	void causeForbidden() {
		def get = new URL("https://mock.httpstatus.io/403")
		get.text
	}

	@Keyword
	void causeBadRequest() {
		def get = new URL("https://mock.httpstatus.io/400")
		get.text
	}

	@Keyword
	void causeInternalServerError() {
		def get = new URL("https://mock.httpstatus.io/500")
		get.text
	}

	@Keyword
	void causeServiceUnavailable() {
		def get = new URL("https://mock.httpstatus.io/503")
		get.text
	}

	@Keyword
	def causeNoSuchFrameException() {
		driver.switchTo().frame("nonexistent")
	}

	@Keyword
	def causeNoSuchWindowException() {
		driver.switchTo().window("nonexistent")
	}

	@Keyword
	def causeNoAlertPresentException() {
		driver.switchTo().alert()
	}

	@Keyword
	def causeUnhandledAlertException() {
		WebElement element = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"))
		element.click()
		element.click()
	}

	@Keyword
	def causeUnexpectedAlertPresentException() {
		WebElement element = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"))
		element.click()
		driver.switchTo().alert()
		driver.findElement(By.linkText("OK")).click()
	}

	@Keyword
	def causeUnexpectedTagNameException() {
		WebElement element = driver.findElement(By.xpath("//a[text()]"))
		Select select = new Select(element)
	}
}