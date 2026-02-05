import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration

KeywordUtil.logInfo('Step 1: Get project directory')
String dir = RunConfiguration.getProjectDir()
KeywordUtil.logInfo("ProjectDir: ${dir}")

KeywordUtil.logInfo('Step 2: Build a path (not creating file)')
File f = new File(dir, 'tmp/studioassist/sample.txt')
KeywordUtil.logInfo("Built path: ${f.absolutePath}")

KeywordUtil.logInfo('Step 3: Verify parent path contains tmp')
assert f.parentFile.path.toLowerCase().contains('tmp')

KeywordUtil.logInfo('Step 4: End')
