import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

// Test case variables can be defined in Katalon UI; in script we can still use local defaults
String username = (binding.hasVariable('username') && binding.getVariable('username') != null) ? binding.getVariable('username').toString() : 'defaultUser'
int age = (binding.hasVariable('age') && binding.getVariable('age') != null) ? binding.getVariable('age') as int : 18

KeywordUtil.logInfo('Step 1: Log variables')
KeywordUtil.logInfo("username=${username}, age=${age}")

KeywordUtil.logInfo('Step 2: Verify constraints')
KeywordUtil.verifyGreaterThan(username.size(), 0, FailureHandling.STOP_ON_FAILURE)
KeywordUtil.verifyGreaterThan(age, 0, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 3: Compute greeting')
String greet = "Hello ${username}" 
KeywordUtil.verifyMatch(greet, /Hello .+/, false, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 4: End')
