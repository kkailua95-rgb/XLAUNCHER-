package com.xl.launcher.xy.performance

/**
 * Monitors device temperatures to scale down Minecraft render distance safely
 */
class ThermalGuard {
    private var currentTemp = 35f
    private var maxSafeTemp = 45f
    private var renderDistance = 16

    fun updateTemperature(temp: Float) {
        currentTemp = temp
        adjustRenderDistance()
    }

    private fun adjustRenderDistance() {
        renderDistance = when {
            currentTemp > maxSafeTemp -> 4
            currentTemp > maxSafeTemp - 5 -> 8
            currentTemp > maxSafeTemp - 10 -> 12
            else -> 16
        }
    }

    fun getRenderDistance(): Int = renderDistance
    fun getCurrentTemp(): Float = currentTemp
}
