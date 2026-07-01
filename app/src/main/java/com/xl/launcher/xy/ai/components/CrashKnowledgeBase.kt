package com.xl.launcher.xy.ai.components

class CrashKnowledgeBase {
    private val solutions = mapOf(
        "MEMORY" to listOf(
            "Allocate more RAM in settings (Max: 8GB)",
            "Disable resource-heavy mods",
            "Close background applications"
        ),
        "COMPATIBILITY" to listOf(
            "Update conflicting mods",
            "Check mod versions against game version",
            "Remove incompatible mod"
        ),
        "ASSET" to listOf(
            "Reinstall the game",
            "Verify game file integrity",
            "Download missing resources"
        )
    )

    fun findSolutions(classification: CrashClassification): List<String> {
        return solutions[classification.category] ?: listOf("No solutions available")
    }
}
