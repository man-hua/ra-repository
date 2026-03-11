import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')
WebUI.waitForPageLoad(30)

TestObject menuBtn = new TestObject('menuBtn')
menuBtn.addProperty('css', com.kms.katalon.core.testobject.ConditionType.EQUALS, '#menu-toggle')
WebUI.click(menuBtn)

TestObject sideBar = new TestObject('sidebar')
sideBar.addProperty('css', com.kms.katalon.core.testobject.ConditionType.EQUALS, '#sidebar-wrapper')
WebUI.verifyElementVisible(sideBar, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()