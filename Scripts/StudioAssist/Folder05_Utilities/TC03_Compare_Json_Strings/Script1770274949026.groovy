import groovy.json.JsonSlurper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Define JSON strings')
String j1 = '{"a":1,"b":2}'
String j2 = '{"b":2,"a":1}'

KeywordUtil.logInfo('Step 2: Parse into maps')
def s = new JsonSlurper()
def o1 = s.parseText(j1)
def o2 = s.parseText(j2)

KeywordUtil.logInfo("Parsed1: ${o1}")
KeywordUtil.logInfo("Parsed2: ${o2}")

KeywordUtil.logInfo('Step 3: Verify structural equality')
KeywordUtil.verifyEqual(o1, o2, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 4: End')
