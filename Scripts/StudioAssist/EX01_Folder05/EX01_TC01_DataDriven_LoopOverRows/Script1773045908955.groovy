import com.kms.katalon.core.util.KeywordUtil

List<Map<String, Object>> rows = [
	[username: 'user1', enabled: true],
	[username: 'user2', enabled: false],
	[username: 'user3', enabled: true]
]

rows.eachWithIndex { row, idx ->
	KeywordUtil.logInfo("Row ${idx+1}: username=${row.username}, enabled=${row.enabled}")
	assert row.username != null
}

KeywordUtil.markPassed('Sample loop completed')