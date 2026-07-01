package com.xl.launcher.xy.ai.components

class FixRecommendationEngine {
    fun generateFix(classification: CrashClassification): String {
        return when (classification.category) {
            "MEMORY" -> "Automatically clearing cache and reducing memory footprint..."
            "COMPATIBILITY" -> "Attempting to resolve mod conflicts..."
            "ASSET" -> "Downloading missing assets..."
            else -> "Please contact support for manual assistance."
        }
    }
}
