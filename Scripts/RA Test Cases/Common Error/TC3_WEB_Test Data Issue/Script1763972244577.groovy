import ra.common.error.TestDataIssue

TestDataIssue error = new TestDataIssue()

switch (exception) {
	case 'InvalidTestData':
		error.causeInvalidTestData()
		break
	case 'DataMismatch':
		error.causeDataMismatch()
		break
	case 'MissingTestData':
		error.causeMissingTestData()
		break
	case 'DataFormatIssue':
		error.causeDataFormatIssue()
		break
	case 'CaseSensitivityIssue':
		error.causeCaseSensitivityIssue()
		break
    default:
        break
}