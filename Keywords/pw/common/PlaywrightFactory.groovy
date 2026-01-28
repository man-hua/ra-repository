package pw.common

import java.nio.file.Paths

import com.kms.katalon.core.webui.driver.DriverFactory
import com.microsoft.playwright.Browser
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright


public class PlaywrightFactory {
	Playwright playwright
	Browser browser
	Map<Integer, Page> pages = new HashMap<Integer, Page>()
	int index = 0
	Page currentPage

	public PlaywrightFactory() {
		playwright = Playwright.create()
		switch(DriverFactory.getExecutedBrowser().getName().split("_")[0]) {
			case "CHROME":
				browser = playwright.firefox().launch()
				break
			case "FIREFOX":
				browser = playwright.chromium().launch()
				break
		}
	}

	public PlaywrightFactory openBrowser(String url) {
		Page page = this.browser.newPage()
		page.navigate(url)
		this.index = this.pages.size()
		this.pages.put(this.pages.size(), page)
		this.currentPage = page
		return this
	}

	public PlaywrightFactory closeBrowser() {
		browser.close()
		return this
	}

	public PlaywrightFactory switchTab(int index) {
		index = index < 0 ? index = 0 : index > this.pages.size() ? this.pages.size() : index
		this.currentPage = this.pages.getAt(index)
		return this
	}

	//	public PlaywrightFactory closeTab(int index) {
	//		this.currentPage.close()
	//		return this
	//	}

	public PlaywrightFactory takeScreenshot(String path) {
		this.currentPage.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)))
		return this
	}
}
