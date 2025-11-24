import ra.common.error.TestDataIssue

TestDataIssue error = new TestDataIssue()

switch (exception) {
	case 'InvalidCookieDomainException': 
		error.causeInvalidCookieDomainException()
	case 'NoSuchAttributeException':
		error.causeNoSuchAttributeException()
    default:
        break
}