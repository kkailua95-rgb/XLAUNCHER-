package com.xl.launcher.xy.ai

/**
 * State tracking for game logs, system specifications, and profiles
 */
class XYAIContext {
    private var gameLogs = ""
    private var systemSpecs = mutableMapOf<String, String>()
    private var activeProfile = ""
    private var stabilityMetrics = mutableMapOf<String, Float>()

    fun updateGameLogs(logs: String) {
        gameLogs = logs
    }

    fun updateSystemSpecs(specs: Map<String, String>) {
        systemSpecs.putAll(specs)
    }

    fun updateProfile(profile: String) {
        activeProfile = profile
    }

    fun addStabilityMetric(name: String, value: Float) {
        stabilityMetrics[name] = value
    }

    fun getGameLogs(): String = gameLogs
    fun getSystemSpecs(): Map<String, String> = systemSpecs
    fun getActiveProfile(): String = activeProfile
    fun getStabilityMetrics(): Map<String, Float> = stabilityMetrics
}
