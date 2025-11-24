import ra.common.error.TestScriptIssue

TestScriptIssue error = new TestScriptIssue()

switch (exception) {
    case 'NoSuchElementException':
        error.causeNoSuchElementException()
	case 'InvalidSelectorException': // NoSuchElementException
		error.causeInvalidSelectorException()
	case 'IllegalArgumentException':
		error.causeIllegalArgumentException()
	case 'NoAlertPresentException':
		error.causeNoAlertPresentException()
	case 'UnexpectedAlertPresentException':
		error.causeUnexpectedAlertPresentException()
	case 'UnhandledAlertException':
		error.causeUnhandledAlertException()
	case 'UnexpectedTagNameException':
		error.causeUnexpectedTagNameException()
    default:
        break
}