import com.kms.katalon.core.util.KeywordUtil

import ra.common.error.ApplicationUnderTest as ApplicationUnderTest

ApplicationUnderTest error = new ApplicationUnderTest()

switch (exception) {
	case 'NoSuchElementException':
		error.causeNoSuchElementException()
		break
    case 'JavascriptException':
        error.causeJavascriptException()
		break
	case 'ElementClickInterceptedException':
		error.causeElementClickInterceptedException()
		break
	case 'ElementNotInteractableException_DisplayNone':
		error.causeElementNotInteractableException_DisplayNone()
		break
	case 'ElementNotInteractableException_Disabled':
		error.causeElementNotInteractableException_Disabled()
		break
	case 'StaleElementReferenceException':
		error.causeStaleElementReferenceException()
		break
	case 'NoSuchFrameException':
		error.causeNoSuchFrameException()
		break
	case 'NoSuchWindowException':
		error.causeNoSuchWindowException()
		break
	case 'Unauthorized':
		error.causeUnauthorized()
		break
	case 'Forbidden':
		error.causeForbidden()
		break
	case 'BadRequest':
		error.causeBadRequest()
		break
	case 'InternalServerError':
		error.causeInternalServerError()
		break
	case 'ServiceUnavailable':
		error.causeServiceUnavailable()
		break
	case 'NoAlertPresentException':
		error.causeNoAlertPresentException()
		break
	case 'UnexpectedAlertPresentException':
		error.causeUnexpectedAlertPresentException()
		break
	case 'UnhandledAlertException':
		error.causeUnhandledAlertException()
		break
	case 'UnexpectedTagNameException':
		KeywordUtil.markErrorAndStop("Library is not included, please reinstall the npm to continue the run")
		error.causeUnexpectedTagNameException()
		break
    default:
        break
}