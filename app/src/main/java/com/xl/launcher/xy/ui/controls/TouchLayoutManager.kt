package com.xl.launcher.xy.ui.controls

data class ControlConfig(
    val buttonId: String,
    val x: Float,
    val y: Float,
    val width: Float,
    val height: Float,
    val opacity: Float
)

class TouchLayoutManager {
    private val layouts = mutableMapOf<String, List<ControlConfig>>()
    private var currentLayout = "default"

    fun saveLayout(name: String, controls: List<ControlConfig>) {
        layouts[name] = controls
    }

    fun loadLayout(name: String): List<ControlConfig>? {
        return layouts[name]
    }

    fun setActiveLayout(name: String) {
        currentLayout = name
    }

    fun getActiveLayout(): List<ControlConfig>? {
        return layouts[currentLayout]
    }
}
