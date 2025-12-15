import ra.common.error.TestScriptIssue

TestScriptIssue error = new TestScriptIssue()

switch (exception) {
	case 'TimeoutException':
		error.causeTimeoutException()
		break
	case 'InvalidSelectorException': // NoSuchElementException
		error.causeInvalidSelectorException()
		break
	case 'IllegalArgumentException':
		error.causeIllegalArgumentException()
		break
	case 'NoAlertPresentException':
		error.causeNoAlertPresentException_CloseAlert()
		break
    default:
        break
}