package ra.common.error
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory


public class ApplicationUnderTest {
	WebDriver driver = DriverFactory.getWebDriver()

	@Keyword
	void causeJavascriptException() {
		JavascriptExecutor js = (JavascriptExecutor) driver
		js.executeScript("throw new Error('Simulated JS Error')")
	}

	@Keyword
	void causeTimeoutException() {
		def wait = new WebDriverWait(driver, 3)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nonExistentElement")))
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
}