import ra.common.error.ConfigurationIssue

ConfigurationIssue error = new ConfigurationIssue()

switch (exception) {
	case 'InvalidCookieDomainException':
		error.causeInvalidCookieDomainException()
		break
	case 'SessionNotFoundException': 
		error.causeSessionNotFoundException()
		break
	case 'NoSuchDriverException':
		error.causeNoSuchDriverException()
		break
	case 'SessionNotCreatedException':
		error.causeSessionNotCreatedException()
		break
	case 'UnknownMethodException':
		error.causeUnknownMethodException()
		break
	case 'RemoteDriverServerException':
		error.causeRemoteDriverServerException()
		break
    default:
        break
}