import ra.common.error.ApplicationUnderTest as ApplicationUnderTest

ApplicationUnderTest error = new ApplicationUnderTest()

switch (exception) {
    case 'JavascriptException':
        error.causeJavascriptException()
    case 'TimeoutException':
        error.causeTimeoutException()
	case 'ElementClickInterceptedException':
		error.causeElementClickInterceptedException()
	case 'ElementNotInteractableException_DisplayNone':
		error.causeElementNotInteractableException_DisplayNone()
	case 'ElementNotInteractableException_Disabled':
		error.causeElementNotInteractableException_Disabled()
	case 'StaleElementReferenceException':
		error.causeStaleElementReferenceException()
    default:
        break
}