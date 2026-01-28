import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.common.Context
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.ui.CartFlow as CartFlow

WebUI.callTestCase(findTestCase('Test Cases/Core Test Cases/WEB/demoblaze/WEB_Add_Product_To_Cart'), null)

Context.get(CartFlow).checkout()

WebUI.verifyTextPresent('Checkout', false)