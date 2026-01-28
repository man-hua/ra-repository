import com.common.Context
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.ui.CartFlow
import com.ui.ProductFlow

WebUI.navigateToUrl('https://demoblaze.com')

Context.get(ProductFlow).openProduct('Samsung galaxy s6')
Context.get(CartFlow).addToCart()
Context.get(CartFlow).openCart()

WebUI.verifyTextPresent('Samsung galaxy s6', false)
