import ra.common.error.TestDataIssue

TestDataIssue error = new TestDataIssue()

switch (exception) {
	case 'InvalidCookieDomainException': 
		error.causeInvalidCookieDomainException()
	case 'InvalidTestData':
		error.causeInvalidTestData()
	case 'DataMismatch':
		error.causeDataMismatch()
	case 'MissingTestData':
		error.causeMissingTestData()
	case 'DataFormatIssue':
		error.causeDataFormatIssue()
	case 'CaseSensitivityIssue':
		error.causeCaseSensitivityIssue()
    default:
        break
}