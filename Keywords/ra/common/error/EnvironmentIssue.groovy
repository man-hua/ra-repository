package ra.common.error

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.remote.RemoteWebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory

public class EnvironmentIssue {
	WebDriver driver = DriverFactory.getWebDriver()

	@Keyword
	def causeMoveTargetOutOfBounds() {
		WebElement element = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"))
		Actions actions = new Actions(driver)
		actions.moveToElement(element, -1000, -1000).click().perform()
	}
}
