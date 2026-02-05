import com.kms.katalon.core.util.KeywordUtil

KeywordUtil.logInfo('Step 1: Start timer')
long start = System.nanoTime()

KeywordUtil.logInfo('Step 2: Execute operation')
def sum = (1..10000).sum()

KeywordUtil.logInfo('Step 3: Stop timer')
long elapsedMs = (System.nanoTime() - start) / 1_000_000
KeywordUtil.logInfo("Sum=${sum}, elapsedMs=${elapsedMs}")

KeywordUtil.logInfo('Step 4: Assert sum')
assert sum == 50005000
