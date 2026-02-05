import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Build temp file path')
File f = new File(RunConfiguration.getProjectDir(), 'tmp/studioassist/temp.txt')
f.parentFile.mkdirs()

KeywordUtil.logInfo('Step 2: Write file')
f.text = 'hello-studioassist'

KeywordUtil.logInfo('Step 3: Read file')
String read = f.text
KeywordUtil.logInfo("Read: ${read}")

KeywordUtil.logInfo('Step 4: Verify content')
KeywordUtil.verifyEqual(read, 'hello-studioassist', FailureHandling.STOP_ON_FAILURE)
