import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// Mobile verify text
Mobile.startApplication('path/to/app.apk', false)
Mobile.verifyElementExist(findTestObject('Mobile/Page_Home/label_Text'), 10)
Mobile.closeApplication()