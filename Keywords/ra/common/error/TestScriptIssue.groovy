package ra.common.error

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory

public class TestScriptIssue {
	WebDriver driver = DriverFactory.getWebDriver()

	@Keyword
	def causeNoSuchElementException() {
		WebElement element = driver.findElement(By.id("nonexist"))
		element.click()
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
