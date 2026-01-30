import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.example.com/login')
WebUI.setText(findTestObject('Page_Login/txt_Username'), 'user')
WebUI.setText(findTestObject('Page_Login/txt_Password'), 'pass')
WebUI.click(findTestObject('Page_Login/btn_Login'))
WebUI.verifyElementPresent(findTestObject('Page_Home/label_Welcome'), 10)
WebUI.closeBrowser()