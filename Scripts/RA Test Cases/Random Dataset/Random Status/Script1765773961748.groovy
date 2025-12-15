import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

List<String> statuses = ['PASS', 'FAIL', 'ERROR']

List<String> errorMessages = ['Error 1: Invalid input', 'Error 2: Timeout occurred', 'Error 3: Element not found', 'Error 4: Network failure'
    , 'Error 5: Access denied', 'Error 6: Database error', 'Error 7: Unexpected null value', 'Error 8: File not accessible'
    , 'Error 9: Memory overflow', 'Error 10: Disk quota exceeded', 'Error 11: Authentication failed', 'Error 12: Session expired'
    , 'Error 13: API rate limit exceeded', 'Error 14: Invalid token', 'Error 15: Configuration missing', 'Error 16: Dependency failure'
    , 'Error 17: Timeout while waiting', 'Error 18: Invalid response format', 'Error 19: Insufficient permissions', 'Error 20: Service unavailable']

List<String> failMessages = ['Fail 1: Assertion failed', 'Fail 2: Validation error', 'Fail 3: Login unsuccessful', 'Fail 4: Data mismatch'
    , 'Fail 5: Incorrect total', 'Fail 6: Missing required field', 'Fail 7: UI element not visible', 'Fail 8: Button click unsuccessful'
    , 'Fail 9: Form submission failed', 'Fail 10: API call failed', 'Fail 11: Incorrect status code', 'Fail 12: Wrong data format'
    , 'Fail 13: File upload failed', 'Fail 14: Error message not displayed', 'Fail 15: Unexpected page redirection', 'Fail 16: Element presence assertion failed'
    , 'Fail 17: Timeout waiting for element', 'Fail 18: Incorrect page title', 'Fail 19: Unauthorized access', 'Fail 20: Failed to load resource']

Random random = new Random()

int num = random.nextInt(statuses.size())

String randomStatus = statuses[num]

switch (randomStatus) {
    case 'PASS':
        KeywordUtil.markPassed(randomStatus)
        break
    case 'FAIL':
		num = random.nextInt(failMessages.size())
        KeywordUtil.markFailedAndStop(failMessages[num])
        break
    case 'ERROR':
		num = random.nextInt(errorMessages.size())
        KeywordUtil.markErrorAndStop(errorMessages[num])
        break
}