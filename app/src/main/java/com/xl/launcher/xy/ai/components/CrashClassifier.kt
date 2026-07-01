package com.xl.launcher.xy.ai.components

data class CrashClassification(
    val errorType: String,
    val severity: String,
    val explanation: String,
    val category: String
)

class CrashClassifier {
    fun classify(analysis: CrashAnalysisResult): CrashClassification {
        return CrashClassification(
            errorType = analysis.cause,
            severity = determineSeverity(analysis.cause),
            explanation = getExplanation(analysis.cause),
            category = categorizeError(analysis.cause)
        )
    }

    private fun determineSeverity(cause: String): String {
        return when (cause) {
            "Insufficient Memory" -> "CRITICAL"
            "Mod Conflict" -> "HIGH"
            "Missing Asset" -> "MEDIUM"
            else -> "LOW"
        }
    }

    private fun getExplanation(cause: String): String {
        return when (cause) {
            "Insufficient Memory" -> "Your device doesn't have enough RAM"
            "Mod Conflict" -> "Two or more mods are conflicting"
            "Missing Asset" -> "A required game file is missing"
            else -> "An unexpected error occurred"
        }
    }

    private fun categorizeError(cause: String): String {
        return when (cause) {
            "Insufficient Memory" -> "MEMORY"
            "Mod Conflict", "Missing Library" -> "COMPATIBILITY"
            "Missing Asset" -> "ASSET"
            else -> "UNKNOWN"
        }
    }
}
