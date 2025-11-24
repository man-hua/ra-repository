import ra.common.error.AutomationIssue

AutomationIssue error = new AutomationIssue()

switch (exception) {
	case 'SessionNotFoundException': 
		error.causeSessionNotFoundException()
	case 'NoSuchDriverException':
		error.causeNoSuchDriverException()
	case 'SessionNotCreatedException':
		error.causeSessionNotCreatedException()
	case 'UnknownMethodException':
		error.causeUnknownMethodException()
	case 'NoSuchFrameException':
		error.causeNoSuchFrameException()
	case 'NoSuchWindowException':
		error.causeNoSuchWindowException()
    default:
        break
}