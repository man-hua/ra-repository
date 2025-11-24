import ra.common.error.EnvironmentIssue

EnvironmentIssue error = new EnvironmentIssue()

switch (exception) {
	case 'MoveTargetOutOfBounds': // NoSuchElementException
		error.causeMoveTargetOutOfBounds()
	case 'RemoteDriverServerException':
		error.causeRemoteDriverServerException()
    default:
        break
}