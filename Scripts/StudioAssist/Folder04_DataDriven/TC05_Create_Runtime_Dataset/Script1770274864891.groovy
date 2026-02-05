import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

KeywordUtil.logInfo('Step 1: Build runtime dataset')
def dataset = (1..5).collect { [id: it, name: "Item${it}"] }
KeywordUtil.logInfo("Dataset: ${dataset}")

KeywordUtil.logInfo('Step 2: Verify each record')
dataset.each { rec ->
    KeywordUtil.verifyGreaterThan(rec.id as int, 0, FailureHandling.STOP_ON_FAILURE)
    KeywordUtil.verifyMatch(rec.name, /Item\d+/, false, FailureHandling.STOP_ON_FAILURE)
}

KeywordUtil.logInfo('Step 3: Verify total records')
KeywordUtil.verifyEqual(dataset.size(), 5, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Step 4: End')
