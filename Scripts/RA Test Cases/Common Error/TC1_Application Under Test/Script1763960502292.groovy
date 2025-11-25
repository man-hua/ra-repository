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
	case 'NoSuchFrameException':
		error.causeNoSuchFrameException()
	case 'NoSuchWindowException':
		error.causeNoSuchWindowException()
	case 'Unauthorized':
		error.causeUnauthorized()
	case 'Forbidden':
		error.causeForbidden()
	case 'BadRequest':
		error.causeBadRequest()
	case 'InternalServerError':
		error.causeInternalServerError()
	case 'ServiceUnavailable':
		error.causeServiceUnavailable()
    default:
        break
}