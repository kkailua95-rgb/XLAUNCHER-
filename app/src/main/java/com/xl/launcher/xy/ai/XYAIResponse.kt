package com.xl.launcher.xy.ai

data class XYAIResponse(
    val errorType: String,
    val explanation: String,
    val solutions: List<String>,
    val autoFix: String,
    val timestamp: Long = System.currentTimeMillis()
)
