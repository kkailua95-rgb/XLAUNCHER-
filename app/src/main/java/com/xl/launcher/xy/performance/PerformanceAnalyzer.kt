package com.xl.launcher.xy.performance

/**
 * Profiles frame render timings and processing delays
 */
class PerformanceAnalyzer {
    private val frameTimings = mutableListOf<Long>()
    private var fps = 60

    fun recordFrameTime(timeMs: Long) {
        frameTimings.add(timeMs)
        calculateFPS()
    }

    private fun calculateFPS() {
        if (frameTimings.isNotEmpty()) {
            val avgTime = frameTimings.average()
            fps = (1000 / avgTime).toInt().coerceIn(0, 120)
        }
    }

    fun getAverageFPS(): Int = fps
    fun getFrameTimings(): List<Long> = frameTimings.takeLast(100)
}
