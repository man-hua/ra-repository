package ra.common.error

import java.time.Duration

import org.openqa.selenium.Alert
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory



public class TestScriptIssue {
	WebDriver driver = DriverFactory.getWebDriver()

	@Keyword
	void causeTimeoutException() {
		def wait = new WebDriverWait(driver, Duration.ofSeconds(3))
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nonExistentElement")))
	}

	@Keyword
	def causeInvalidSelectorException() {
		driver.findElement(By.xpath("//invalid['xpath']"))
	}

	@Keyword
	def causeIllegalArgumentException() {
		driver.findElement(null)
	}

	@Keyword
	def causeNoAlertPresentException_CloseAlert() {
		WebElement element = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"))
		element.click()
		Alert alert = driver.switchTo().alert()
		alert.accept()
		driver.switchTo().alert()
	}
}
