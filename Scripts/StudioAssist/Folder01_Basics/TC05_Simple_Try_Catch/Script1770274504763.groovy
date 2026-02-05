import com.kms.katalon.core.util.KeywordUtil

KeywordUtil.logInfo('Step 1: Start')

KeywordUtil.logInfo('Step 2: Execute operation with try/catch')
try {
    int x = 10
    int y = 0
    // will throw ArithmeticException
    int z = x / y
    KeywordUtil.logInfo("Result: ${z}")
} catch (Exception e) {
    KeywordUtil.logInfo("Caught expected exception: ${e.getClass().getSimpleName()} - ${e.message}")
}

KeywordUtil.logInfo('Step 3: Continue test case after handling exception')
KeywordUtil.markPassed('Handled exception and continued')
