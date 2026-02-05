import com.kms.katalon.core.util.KeywordUtil

KeywordUtil.logInfo('Step 1: Call custom keyword studioassist.SampleWaits.shortDelay(1)')
CustomKeywords.'studioassist.SampleWaits.shortDelay'(1)

KeywordUtil.logInfo('Step 2: Verify execution continued')
assert true

KeywordUtil.logInfo('Step 3: End')
