package ra.common.error

import org.openqa.selenium.By
import org.openqa.selenium.Cookie
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory

public class TestDataIssue {
	WebDriver driver = DriverFactory.getWebDriver()

	@Keyword
	void causeInvalidCookieDomainException() {
		Cookie invalidDomainCookie = new Cookie.Builder('testCookie', 'testValue')
				.domain('invalid-domain.com')
				.build()
		driver.manage().addCookie(invalidDomainCookie)
	}
}
