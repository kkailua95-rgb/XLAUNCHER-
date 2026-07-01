package com.xl.launcher.xy.ai.components

data class CrashAnalysisResult(
    val stackTrace: String,
    val errorLine: String,
    val cause: String
)

class CrashAnalyzer {
    fun parse(crashLog: String): CrashAnalysisResult {
        val lines = crashLog.split("\n")
        val errorLine = lines.firstOrNull { it.contains("Exception") || it.contains("Error") } ?: ""
        val cause = extractCause(errorLine)
        
        return CrashAnalysisResult(
            stackTrace = crashLog,
            errorLine = errorLine,
            cause = cause
        )
    }

    private fun extractCause(errorLine: String): String {
        return when {
            errorLine.contains("OutOfMemoryError") -> "Insufficient Memory"
            errorLine.contains("ClassNotFoundException") -> "Missing Library"
            errorLine.contains("FileNotFoundException") -> "Missing Asset"
            errorLine.contains("NoSuchMethodError") -> "Mod Conflict"
            else -> "Unknown Error"
        }
    }
}
