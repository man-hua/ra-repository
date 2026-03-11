import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil

KeywordUtil.logInfo("Base URL from GlobalVariable (if defined): ${GlobalVariable.G_BaseUrl}")
// This assertion is just an example; remove if you don't have that variable
// assert GlobalVariable.G_BaseUrl != null

KeywordUtil.markPassed('GlobalVariable example executed')