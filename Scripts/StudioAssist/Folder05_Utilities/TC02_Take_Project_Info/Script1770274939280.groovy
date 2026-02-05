import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration

KeywordUtil.logInfo('Step 1: Log project directory')
KeywordUtil.logInfo("ProjectDir: ${RunConfiguration.getProjectDir()}")

KeywordUtil.logInfo('Step 2: Log execution properties')
KeywordUtil.logInfo("ExecutionProfile: ${RunConfiguration.getExecutionProfile()}")
KeywordUtil.logInfo("ReportFolder: ${RunConfiguration.getReportFolder()}")

KeywordUtil.logInfo('Step 3: Log system properties')
KeywordUtil.logInfo("os.name: ${System.getProperty('os.name')}")
KeywordUtil.logInfo("java.version: ${System.getProperty('java.version')}")

KeywordUtil.logInfo('Step 4: End')
