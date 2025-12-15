import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Random random = new Random()
int num = random.nextInt(10)

WebUI.delay(num*num)