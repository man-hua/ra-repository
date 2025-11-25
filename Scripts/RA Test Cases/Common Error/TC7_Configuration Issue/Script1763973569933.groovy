import ra.common.error.ConfigurationIssue

ConfigurationIssue error = new ConfigurationIssue()

switch (exception) {
	case 'SessionNotFoundException': 
		error.causeSessionNotFoundException()
	case 'NoSuchDriverException':
		error.causeNoSuchDriverException()
	case 'SessionNotCreatedException':
		error.causeSessionNotCreatedException()
	case 'UnknownMethodException':
		error.causeUnknownMethodException()
    default:
        break
}