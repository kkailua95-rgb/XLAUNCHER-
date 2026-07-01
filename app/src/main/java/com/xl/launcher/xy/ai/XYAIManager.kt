package com.xl.launcher.xy.ai

import com.xl.launcher.xy.ai.components.*

/**
 * Orchestrator for all AI subsystems
 * Manages crash analysis, mod recommendations, and diagnostic repairs
 */
class XYAIManager {
    private val aiProvider = XYAIProvider()
    private val crashAnalyzer = CrashAnalyzer()
    private val crashClassifier = CrashClassifier()
    private val knowledgeBase = CrashKnowledgeBase()
    private val fixEngine = FixRecommendationEngine()
    private val modAdvisor = ModAdvisor()
    private val modpackBuilder = ModpackBuilder()
    private val context = XYAIContext()

    fun analyzeCrashLog(crashLog: String): XYAIResponse {
        val analysis = crashAnalyzer.parse(crashLog)
        val classification = crashClassifier.classify(analysis)
        val solutions = knowledgeBase.findSolutions(classification)
        return XYAIResponse(
            errorType = classification.errorType,
            explanation = classification.explanation,
            solutions = solutions,
            autoFix = fixEngine.generateFix(classification)
        )
    }

    fun recommendMods(playstyle: String): List<String> {
        return modAdvisor.recommend(playstyle, context.getStabilityMetrics())
    }

    fun buildModpack(description: String): String {
        return modpackBuilder.build(description)
    }

    fun updateContext(logs: String, specs: Map<String, String>, profile: String) {
        context.updateGameLogs(logs)
        context.updateSystemSpecs(specs)
        context.updateProfile(profile)
    }
}
