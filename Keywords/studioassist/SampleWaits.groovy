package studioassist

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class SampleWaits {

    @Keyword
    def shortDelay(int seconds) {
        WebUI.delay(seconds)
    }
}
